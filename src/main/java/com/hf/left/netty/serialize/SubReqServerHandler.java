package com.hf.left.netty.serialize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/21 11:42
 * @version: 1.0
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        SubscribeReq subscribeReq = (SubscribeReq)msg;
        if ("huangfu".equals(subscribeReq.getUserName())){
            System.out.println("Server accept client subscribe req : [" + subscribeReq.getSubReqID() + "]");
            ctx.writeAndFlush(new SubscribeResp(subscribeReq.getSubReqID()));
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
