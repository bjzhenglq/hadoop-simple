package com.sunshine.hadoop.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * remote procedure call,远程过程调用
 * 
 * @author Administrator
 * 
 */
public class MyServer {

	public static final String SERVER_ADDRESS = "localhost";
	public static final int SERVER_PORT = 12345;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Server server = RPC.getServer(new MyBiz(), SERVER_ADDRESS, SERVER_PORT,
				new Configuration());
		server.start();
	}
}
