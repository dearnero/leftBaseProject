package com.hf.left.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/7 09:06
 * @version: 1.0
 */
public class TimeClient {

    public void connect(int port, String host) throws InterruptedException {

        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            Bootstrap handler = bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new TimeClientHandler());
                }
            });
            ChannelFuture channelFuture = handler.connect(host, port).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            nioEventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        try {
            new TimeClient().connect(9999, "127.0.0.1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
