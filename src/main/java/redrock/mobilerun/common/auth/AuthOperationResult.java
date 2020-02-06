package redrock.mobilerun.common.auth;


import lombok.Data;
import redrock.mobilerun.common.OperationResult;

/**
 * @author kuangjunlin
 */
@Data
public class AuthOperationResult extends OperationResult {
    private final boolean passAuth;
}
