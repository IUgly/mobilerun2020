package redrock.mobilerun.common;

import lombok.Data;

/**
 * @author kuangjunlin
 */
@Data
public class MessageHeader {
    private String timestamp;
    private String signature;
    private String redrock;
    private String uri;
    private long streamId;
}
