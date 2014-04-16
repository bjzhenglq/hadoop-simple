package com.sunshine.hadoop.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBizalbe extends VersionedProtocol {
	public static final long VERSION = 12345L;

	public abstract String hello(String name);

}