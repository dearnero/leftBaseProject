package com.hf.left.netty.serialize;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/21 11:01
 * @version: 1.0
 */
public class SubReqClient {

    public void connect(int port, String host) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap  = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
                        ch.pipeline().addLast(new ObjectEncoder());
                        ch.pipeline().addLast(new SubReqClientHander());
                    }
                });
        ChannelFuture f = bootstrap.connect(host, port).sync();
        f.channel().closeFuture().sync();
    }

    public class SubReqClientHander extends ChannelHandlerAdapter {

        public SubReqClientHander(){}

       public void channelActive(ChannelHandlerContext ctx){
            for (int i = 0; i< 10; i++){
                SubscribeReq subscribeReq = new SubscribeReq(i);
                subscribeReq.setUserName("huangfu");
                ctx.write(subscribeReq);
            }
            ctx.flush();
       }
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
            System.out.println("Receive server response:" + msg);
        }

        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
            cause.printStackTrace();
            ctx.close();
        }

    }

    public static void main(String[] args) throws Exception {
        new SubReqClient().connect(9099, "127.0.0.1");
    }

}
