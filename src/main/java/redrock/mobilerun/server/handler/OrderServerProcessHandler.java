package redrock.mobilerun.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import redrock.mobilerun.common.Operation;
import redrock.mobilerun.common.OperationResult;
import redrock.mobilerun.common.RequestMessage;
import redrock.mobilerun.common.ResponseMessage;


/**
 * @author kuangjunlin
 */
@Slf4j
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        //模拟buffer不被释放时Netty检测内存泄漏
        //设置Netty内存泄漏级别：-Dio.netty.leakDetection.level=PARANOID
        ByteBuf buffer = ctx.alloc().buffer();

        Operation operation = requestMessage.getMessageBody();
        OperationResult operationResult = operation.execute();

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());
        responseMessage.setMessageBody(operationResult);

        // 如果buf满了，丢掉数据，防止OOM
        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
            ctx.writeAndFlush(responseMessage);
        } else {
            log.error("message dropped");
        }
    }


}
