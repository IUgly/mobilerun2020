package redrock.mobilerun.common.keepalive;

import lombok.Data;
import redrock.mobilerun.common.Operation;
import redrock.mobilerun.common.OperationResult;

/**
 * @author kuangjunlin
 */
@Data
public class KeepAliveOperation extends Operation {
    private long time;

    public KeepAliveOperation() {
        this.time = System.nanoTime();
    }



    @Override
    public OperationResult execute() {
        KeepAliveOperationResult orderResponse = new KeepAliveOperationResult(time);
        return orderResponse;
    }
}
