package redrock.mobilerun.server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import redrock.mobilerun.util.JsonUtil;

import java.nio.charset.Charset;

/**
 *
 * @author jack
 * @date 2018/5/4
 * 编码
 */
public abstract class AbstractHttpJsonEncoder<T> extends MessageToMessageEncoder<T> {
    public final static Charset charset = Charset.forName("utf-8");
    /**
     * 对象转换为bytebuf
     * @param context
     * @param body
     */
    protected ByteBuf encode (ChannelHandlerContext context, Object body){
        String str = JsonUtil.toJson(body);
        ByteBuf byteBuf = Unpooled.copiedBuffer(str,charset);
        return byteBuf;
    }
}
