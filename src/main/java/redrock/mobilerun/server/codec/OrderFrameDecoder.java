package redrock.mobilerun.server.codec;


import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.http.HttpRequestDecoder;

/**
 * @author kuangjunlin
 */
public class OrderFrameDecoder extends HttpRequestDecoder {
    public OrderFrameDecoder() {
    }
}
