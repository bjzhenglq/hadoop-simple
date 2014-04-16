package com.sunshine.hadoop.hdfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * ͨ��hadoop��api�����ļ��С��ϴ������ء�ɾ���ļ�
 * 
 * @author Administrator
 * 
 */
public class FileOPTWSHadoopAPI {

	/**
	 * hdfs��Э�飬sunshine��hadoop������������9000�Ƿ���hadoop�Ķ˿ں�
	 */
	public static String HDFS_PATH = "hdfs://sunshine:9000";
	public static String DIR_PATH = "/d2000";
	public static String FILE_PATH = "/d2000/f2000";

	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystem.get(new URI(HDFS_PATH),
				new Configuration());

		// �����ļ���
		createPath(fileSystem);
		// �ϴ��ļ�
		uploadFile(fileSystem);
		// // �����ļ�
		downLoadFile(fileSystem);
		// ɾ���ļ�
		deleteFile(fileSystem);
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param fileSystem
	 * @throws IOException
	 */
	private static void deleteFile(FileSystem fileSystem) throws IOException {
		fileSystem.delete(new Path(FILE_PATH), true);
	}

	/**
	 * �����ļ�
	 * 
	 * @param fileSystem
	 * @throws IOException
	 */
	private static void downLoadFile(FileSystem fileSystem) throws IOException {
		FSDataInputStream in = fileSystem.open(new Path(FILE_PATH));
		IOUtils.copyBytes(in, System.out, 1024, true);
	}

	/**
	 * �ϴ��ļ�
	 * 
	 * @param fileSystem
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void uploadFile(FileSystem fileSystem) throws IOException,
			FileNotFoundException {
		FSDataOutputStream out = fileSystem.create(new Path(FILE_PATH));
		IOUtils.copyBytes(new FileInputStream("c:/tmuninst.ini"), out, 1024,
				true);
	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param fileSystem
	 * @throws IOException
	 */
	private static void createPath(FileSystem fileSystem) throws IOException {
		fileSystem.mkdirs(new Path(DIR_PATH));
	}
}
