package redrock.mobilerun.common;

import com.google.gson.JsonObject;
import redrock.mobilerun.util.JsonUtil;

/**
 * @author kuangjunlin
 */
public class RequestMessage extends Message<Operation> {
    public RequestMessage() {
    }

    @Override
    public Class getMessageBodyDecodeClass(String uri) {
        return OperationType.fromUri(uri).getOperationClazz();
    }

    public RequestMessage (Long streamId, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setStreamId(streamId);
        messageHeader.setUri(OperationType.fromOperation(operation).getUri());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }
}
