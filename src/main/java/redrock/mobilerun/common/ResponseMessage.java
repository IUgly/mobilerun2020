package redrock.mobilerun.common;

/**
 * @author kuangjunlin
 */
public class ResponseMessage extends Message <OperationResult>{
    @Override
    public Class getMessageBodyDecodeClass(String uri) {
        return OperationType.fromUri(uri).getOperationResultClazz();
    }
}