package com.app.transaction.common.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
public class FileUploadAction extends BaseAction {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String type;// 文件类型标志位
	private String contentType;
	private File file;
	private String fileName;

	/**
	 * 上传文件
	 */
	public void uploadFile() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			ActionContext ac = ActionContext.getContext();
			ServletContext sc = (ServletContext) ac
					.get(ServletActionContext.SERVLET_CONTEXT);
			String savePath = sc.getRealPath("/");
			
			if("mp3".equals(type)){
				savePath = savePath + "/uploadfile/mp3/";
			}else if("pic".equals(type)){
				savePath = savePath + "/uploadfile/pic/";
			}else{
				savePath = savePath + "/uploadfile/photo/";
			}
			
			String filename_date = sdf.format(new Date());
			File dirfile = new File(savePath);
			// 如果不存在则创建
			if (!dirfile.exists()) {
				dirfile.mkdir();
			}
			// 获取文件名
			MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
			fileName = wrapper.getFileNames("file")[0];
			File tempfile = new File(savePath+ filename_date+ fileName.substring(fileName.lastIndexOf("."),fileName.length()).toLowerCase());
			// 复制文件
			FileUtils.copyFile(file, tempfile);
			HttpServletRequest request = ServletActionContext.getRequest();
			// 图片文件名
			String picFilename = filename_date+ fileName.substring(fileName.lastIndexOf("."),fileName.length()).toLowerCase();
			String url = "" + request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
			if("mp3".equals(type)){
				url = url + "/uploadfile/mp3/" + picFilename;
			}else if("pic".equals(type)){
				url = url + "/uploadfile/pic/" + picFilename;
			}else{
				url = url + "/uploadfile/photo/" + picFilename;
			}
		
			//System.out.println(url);
			//System.out.println(type);
			//System.out.println(contentType);
			// 返回图片访问URL，Ajax可以异步获取。
			r = url;
		} catch (Exception e) {
			r = "error"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			out.flush();
			out.close();
		}
	}

	public String getFileContentType() {
		return contentType;
	}
	public void setFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
