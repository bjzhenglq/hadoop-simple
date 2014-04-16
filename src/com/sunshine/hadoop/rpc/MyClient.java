package com.sunshine.hadoop.rpc;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * 客户端
 * 
 * @author Administrator
 * 
 */
public class MyClient {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 构造一个客户端代理对象，与服务端通信
		MyBizalbe proxy = (MyBizalbe) RPC.waitForProxy(MyBizalbe.class,
				MyBizalbe.VERSION, new InetSocketAddress(
						MyServer.SERVER_ADDRESS, MyServer.SERVER_PORT),
				new Configuration());

		System.out.println("客户端显示结果为：" + proxy.hello("hadoop"));
		RPC.stopProxy(proxy);
	}
}
