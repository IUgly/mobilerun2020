package redrock.mobilerun.common.keepalive;

import lombok.Data;
import redrock.mobilerun.common.OperationResult;

@Data
public class KeepAliveOperationResult extends OperationResult {
    private final long time;
}
