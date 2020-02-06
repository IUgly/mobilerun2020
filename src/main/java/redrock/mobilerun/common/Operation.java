package redrock.mobilerun.common;

/**
 * @author kuangjunlin
 */
public abstract class Operation extends MessageBody{
    public abstract OperationResult execute();

    //public abstract OperationResult execute(MessageBody messageBody);
}
