package com.ys;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.ServerSocketChannel;

public class TestServerInitializer extends ChannelInitializer<ServerSocketChannel> {

    @Override
    protected void initChannel(ServerSocketChannel ch) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.initChannel");
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new FirstServerHandler());
        pipeline.addLast(new TwoServerHandler());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.handlerAdded");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.handlerRemoved");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelUnregistered");
        ctx.fireChannelUnregistered();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelActive");
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelInactive");
        ctx.fireChannelInactive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelRead");
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelReadComplete");
        ctx.fireChannelReadComplete();
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass() + " TestServerInitializer.channelWritabilityChanged");
        ctx.fireChannelWritabilityChanged();
    }

}
