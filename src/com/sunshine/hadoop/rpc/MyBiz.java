package com.sunshine.hadoop.rpc;

import java.io.IOException;

public class MyBiz implements MyBizalbe {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunshine.hadoop.rpc.MyBizalbe#hello()
	 */
	@Override
	public String hello(String name) {
		return "hello " + name;
	}

	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		return MyBizalbe.VERSION;
	}

}
