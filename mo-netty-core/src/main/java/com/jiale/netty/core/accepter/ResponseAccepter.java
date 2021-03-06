package com.jiale.netty.core.accepter;

import com.jiale.netty.core.common.IocContainer;
import com.jiale.netty.core.listener.MsgListener;
import com.jiale.netty.core.model.ResponseDTO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * @author mojiale66@163.com
 * @date 2018年9月27日
 * @description 响应消息接收器
 */
public class ResponseAccepter extends SimpleChannelInboundHandler<ResponseDTO>{

	private MsgListener msgListener = IocContainer.getMsgListener("msgListener");
	
	
	/**
	 * 请求回调，每一次接收到请求数据均会回调该方法
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ResponseDTO msg) throws Exception {
		
		if(msgListener != null){
			msgListener.onMsgRead(ctx, msg);
		}
		
	}
	
	
	/**
	 * 建立连接时回调方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		if(msgListener != null){
			msgListener.onChannelConnected(ctx);
		}
		
		super.channelActive(ctx);
	}
	
	
	
	/**
	 * 断开连接时回调方法
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		if(msgListener != null){
			msgListener.onChannelDisconnect(ctx);
		}
		
		super.channelInactive(ctx);
	}
	
	
	/**
	 * 抛出异常时回调方法
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
		// 异常处理
		if(msgListener != null){
			msgListener.onExceptionCaught(ctx, cause);
		}
	}

}
