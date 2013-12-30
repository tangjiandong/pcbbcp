package com.app.transaction.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.app.utils.tool.ResourceReader;
import com.app.utils.util.DateUtil;

/**
 * @Class: UploadCommonAction.java
 * @Description: 文件上传Action
 * @Author：caiqf
 * @Date：2013-8-19
 */
@SuppressWarnings("all")
public class NewUploadAction extends BaseAction {
	
	private File file; // 普通上传
	private String fileName; // 文件名
	private String flag; // 文件类型


	/**
	 * 上传图片
	 */
	public void uploadImage() {
		PrintWriter out = this.getWriter();
		
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) this.getRequest();
		fileName = wrapper.getFileNames("file")[0];
		String r = "";
		try {
			if (null == this.file || null == this.fileName) {
				r = "error";
				return;
			}
			if (null == this.flag || "".equals(this.flag)) {
				r = "error";
				return;
			}

			String path = ResourceReader.readValue("UPLOAD_PICTURE_PATH"); // 图片物理根路径
			String outPath = ResourceReader.readValue("UPLOAD_PICTURE_URL"); // 图片服务器URL

			// 上传文件方法
			r = this.uploadCommon(path, outPath);

			// 响应客户端
			this.getResponse().setContentType("text/html");
			this.getResponse().setCharacterEncoding("utf-8");
		} catch (Exception e) {
			r = "error";
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 上传视频
	 */
	public void uploadVideo() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			if (null == this.file || null == this.fileName) {
				r = "error";
				return;
			}
			if (null == this.flag || "".equals(this.flag)) {
				r = "error";
				return;
			}

			String path = ResourceReader.readValue("UPLOAD_VIDEO_PATH"); // 图片物理根路径
			String outPath = ResourceReader.readValue("UPLOAD_VIDEO_URL"); // 图片服务器URL

			// 上传文件方法
			r = this.uploadCommon(path, outPath);

			// 响应客户端
			this.getResponse().setContentType("text/html");
			this.getResponse().setCharacterEncoding("utf-8");
		} catch (Exception e) {
			r = "error";
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 上传语音
	 */
	public void uploadVoice() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			if (null == this.file || null == this.fileName) {
				r = "error";
				return;
			}
			if (null == this.flag || "".equals(this.flag)) {
				r = "error";
				return;
			}

			String path = ResourceReader.readValue("UPLOAD_VOICE_PATH"); // 图片物理根路径
			String outPath = ResourceReader.readValue("UPLOAD_VOICE_URL"); // 图片服务器URL

			// 上传文件方法
			r = this.uploadCommon(path, outPath);

			// 响应客户端
			this.getResponse().setContentType("text/html");
			this.getResponse().setCharacterEncoding("utf-8");
		} catch (Exception e) {
			r = "error";
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 上传电子文档
	 */
	public void uploadDocument() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			
			
			
			
			if (null == this.file || null == this.fileName) {
				r = "error";
				return;
			}
			if (null == this.flag || "".equals(this.flag)) {
				r = "error";
				return;
			}

			String path = ResourceReader.readValue("UPLOAD_DOCUMENT_PATH"); // 图片物理根路径
			String outPath = ResourceReader.readValue("UPLOAD_DOCUMENT_URL"); // 图片服务器URL

			// 上传文件方法
			r = this.uploadCommon(path, outPath);

			// 响应客户端
			this.getResponse().setContentType("text/html");
			this.getResponse().setCharacterEncoding("utf-8");
		} catch (Exception e) {
			r = "error";
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * @Author：caiqf
	 * @Description：上传文件公共处理方法
	 * @Date：2013-12-5 上午9:24:48
	 * @Return：String
	 */
	public String uploadCommon(String path, String outPath) {
		String r = "";
		try {
			// 获取扩展名
			String extName = "";
			if (this.fileName.lastIndexOf(".") >= 0) {
				extName = this.fileName.substring(this.fileName
						.lastIndexOf("."));
			}

			// 生成文件名称
			String imgName = new SimpleDateFormat("yyyyMMdd_HHmmss")
					.format(new Date()) + new Random().nextInt(100) + extName;
		String userid="1";
			// 生成文件夹：用户编号+时间（相对路径）
			String midPath = null != userid && !"".equals(userid) ? userid
					+ "/"
					: "" + DateUtil.date2String(new Date(), "yyyyMMdd") + "/";

			// 图片物理路径=WEB物理路径+相对路径+文件名
			String filePath = path + midPath + imgName;

			// 完整的图片访问URL
			String imgUrl = outPath + midPath + imgName;

			// 取HTTP请求流,将其写成图片文件
			FileInputStream inFile = new FileInputStream(this.file);
			double fileSize = inFile.available() / 1024; // 单位KB
			File f_img = new File(path + midPath);
			if (!f_img.exists()) {
				f_img.mkdirs();
			}
			FileOutputStream outFile = new FileOutputStream(filePath);
			byte[] buffer = new byte[1024];
			int i = 0;
			while ((i = inFile.read(buffer)) != -1) {
				outFile.write(buffer, 0, i);
			}
			outFile.flush();
			outFile.close();
			inFile.close();

			r = "[{\"imgUrl\":\"" + imgUrl + "\",\"fileSize\":\"" + fileSize
					+ "\",\"fileName\":\"" + imgName + "\"}]";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return r;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}
