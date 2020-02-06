package redrock.mobilerun.common;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.Data;
import redrock.mobilerun.util.IdUtil;
import redrock.mobilerun.util.JsonUtil;

import java.nio.charset.Charset;

/**
 * @author kuangjunlin
 */
@Data
public abstract class Message <T extends MessageBody> {
    private MessageHeader messageHeader;
    private T messageBody;

    public T getMessageBody() { return messageBody; }

    public void encode (ByteBuf byteBuf) {
        byteBuf.writeBytes(messageHeader.getSignature().getBytes());
        byteBuf.writeBytes(messageHeader.getTimestamp().getBytes());
        byteBuf.writeBytes(JsonUtil.toJson(messageBody).getBytes());
    }

    /**
     * 通过uri获得对应的操作类
     * @param uri
     * @return
     */
    public abstract Class<T> getMessageBodyDecodeClass (String uri);

    public void decode (FullHttpRequest msg) {
        HttpHeaders httpHeaders = msg.headers();
        String signature = httpHeaders.get("signature");
        String timestamp = httpHeaders.get("timestamp");
        String redrock = httpHeaders.get("redrock");
        String uri = msg.uri();

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setSignature(signature);
        messageHeader.setTimestamp(timestamp);
        messageHeader.setRedrock(redrock);
        messageHeader.setUri(uri);
        messageHeader.setStreamId(IdUtil.nextId());
        this.messageHeader = messageHeader;

        Class<T> bodyClazz = getMessageBodyDecodeClass(uri);
        String body = msg.content().toString(Charset.forName("UTF-8"));
        System.out.println(body);
        this.messageBody = JsonUtil.fromJson(body, bodyClazz);
    }
}
