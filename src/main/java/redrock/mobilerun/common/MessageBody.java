package redrock.mobilerun.common;

import lombok.Data;

/**
 * @author kuangjunlin
 */
@Data
public abstract class MessageBody <T>{
    private int status;
    private String info;
    private T data;
}
