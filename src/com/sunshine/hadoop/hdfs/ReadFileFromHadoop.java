package com.sunshine.hadoop.hdfs;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class ReadFileFromHadoop {

	private static String HDFS_PATH = "hfds://sunshine:9000/hello-hadoop";

	public static void main(String[] args) throws Exception {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		URL url = new URL(HDFS_PATH);
		InputStream in = url.openStream();

		IOUtils.copyBytes(in, System.out, 1024, true);
	}
}
