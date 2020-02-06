package redrock.mobilerun.common.auth;

import lombok.Data;
import lombok.extern.java.Log;
import redrock.mobilerun.common.Operation;
import redrock.mobilerun.common.OperationResult;

/**
 * @author kuangjunlin
 */
@Data
@Log
public class AuthOperation extends Operation {
    private final String username;
    private final String password;
    @Override
    public OperationResult execute() {
        System.out.println("验证用户权限");
        if ("admin".equals(this.username)) {
            AuthOperationResult orderResponse = new AuthOperationResult(true);
            return orderResponse;
        }
        return new AuthOperationResult(false);
    }
}
