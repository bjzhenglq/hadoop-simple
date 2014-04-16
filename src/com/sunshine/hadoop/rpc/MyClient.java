package com.sunshine.hadoop.rpc;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * �ͻ���
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
		// ����һ���ͻ��˴������������ͨ��
		MyBizalbe proxy = (MyBizalbe) RPC.waitForProxy(MyBizalbe.class,
				MyBizalbe.VERSION, new InetSocketAddress(
						MyServer.SERVER_ADDRESS, MyServer.SERVER_PORT),
				new Configuration());

		System.out.println("�ͻ�����ʾ���Ϊ��" + proxy.hello("hadoop"));
		RPC.stopProxy(proxy);
	}
}
