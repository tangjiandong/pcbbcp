package com.app.transaction.common.action;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Class: DownloadAction.java
 * @Description: 文件下载Action
 * @Author：lvm
 * @Date：2013-8-15
 */
public class DownloadAction extends BaseAction {
	private static final long serialVersionUID = -7687893505332784649L;

	private static String LOCATION_FILE_URL = "c://wankatemp/"; // 创建本地磁盘文件夹路径
	private String fileName; // 下载文件名称，输出到用户的下载对话框
	private String filePath; // 下载文件URL（绝对路径）

	public String execute() {
		return "success";
	}

	/**
	 * @Author：lvm
	 * @Description: 获取下载文件输入流
	 * @Date：2013-8-15 下午2:07:54
	 * @Return：InputStream
	 */
	public InputStream getInputStream() throws Exception {
		// 如果目录存在,先删除目录下的所有文件，反之则创建目录
		File ufile = new File(LOCATION_FILE_URL);
		boolean flag = false;
		if (ufile.exists() == true) {
			// 删除文件夹下的所有文件(包括子目录)
			File[] files = ufile.listFiles();
			for (int i = 0; i < files.length; i++) {
				// 删除子文件
				if (files[i].isFile()) {
					flag = deleteFile(files[i].getAbsolutePath());
					if (!flag)
						break;
				}
			}
		} else {
			ufile.mkdir();
		}

		// 从下载文件绝对路径中提取文件名，并进行编码转换，防止不能正确显示中文名
		if (this.filePath.lastIndexOf("/") > 0) {
			this.fileName = new String(this.filePath.substring(
					this.filePath.lastIndexOf("/") + 1, this.filePath.length())
					.getBytes("GB2312"), "ISO8859_1");
		} else if (this.filePath.lastIndexOf("\\") > 0) {
			this.fileName = new String(this.filePath
					.substring(this.filePath.lastIndexOf("\\") + 1,
							this.filePath.length()).getBytes("GB2312"),
					"ISO8859_1");
		}

		// 下载文件流
		File dfile = getFileFromBytes(this.filePath, LOCATION_FILE_URL
				+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
				+ ".temp");
		InputStream is = new FileInputStream(dfile); // 绝对路径下载
		return is;
	}

	/**
	 * @Author：lvm
	 * @Description: 把字节数组保存为一个文件
	 * @Date：2013-8-15 下午2:23:07
	 * @Return：File
	 */
	public File getFileFromBytes(String fileUrl, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(getUrlFileData(fileUrl));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					log.error(e1.getMessage(), e1);
				}
			}
		}
		return file;
	}

	/**
	 * @Author：lvm
	 * @Description: 获取链接地址文件的byte数据
	 * @Date：2013-8-15 下午2:20:35
	 * @Return：byte[]
	 */
	public byte[] getUrlFileData(String fileUrl) throws Exception {
		URL url = new URL(fileUrl);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.connect();
		InputStream cin = httpConn.getInputStream();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = cin.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		cin.close();
		byte[] fileData = outStream.toByteArray();
		outStream.close();
		return fileData;
	}

	/**
	 * @Author：lvm
	 * @Description: 删除文件
	 * @Date：2013-8-15 下午2:19:51
	 * @Return：boolean
	 */
	public boolean deleteFile(String sPath) {
		boolean flag = false;
		// 路径为文件且不为空则进行删除
		File file = new File(sPath);
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
