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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.utils.tool.ResourceReader;

/**
 * 图片上传Action
 * 
 * @author chenhong 2012.06.29
 * @version 1.0
 */
public class ImageUploadAction extends BaseAction {
	private static final long serialVersionUID = -7914395488136167452L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private File file; // 普通上传
	private File imgFile; // 编辑器上传
	private String fileUrl; //文件路径上传
	private String filePath; 

	/**
	 * 上传图片方法
	 */
	public void uploadImage() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String remote_path = null;
			String typeFlag = request.getParameter("flag");
			String idFlag=request.getParameter("id");
			
			// 上传品牌logo
			if (typeFlag != null && typeFlag.equals("logo")) {           
				remote_path = ResourceReader.readValue("remote_upload_logo_image");
			}
			// 上传产品图片
			else if (typeFlag != null && typeFlag.equals("product")) { 
				remote_path = ResourceReader.readValue("remote_upload_product_image");
			} 
			// 上传审核图片
			else if (typeFlag != null && typeFlag.equals("auditor")) { 
				remote_path = ResourceReader.readValue("remote_upload_auditor_image");
			} 
			else {
				return;
			}

			// 创建URL对象
			URL remote_url = new URL(remote_path+"?id="+idFlag);
			HttpURLConnection conn = (HttpURLConnection) remote_url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-type", "multipart/form-data");
			conn.setRequestProperty("charset", "utf-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(100000);
			conn.setConnectTimeout(100000);

			// 将图片转换成字节流，并传给远程URL
			FileInputStream inFile = new FileInputStream(this.file);
			int img_size = inFile.available();
			byte[] buffer = new byte[1024];
			byte[] result = new byte[img_size];
			int count = 0;
			int rbyte = 0;
			while (count < img_size) {
				rbyte = inFile.read(buffer);
				for (int i = 0; i < rbyte; i++) {
					result[count + i] = buffer[i];
				}
				count += rbyte;
			}
			OutputStream os = conn.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(result);
			dos.flush();
			os.close();

			// 等待返回远程处理结果
			BufferedReader in = new BufferedReader(new InputStreamReader(conn
					.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			in.close();

			// 返回图片访问URL，Ajax可以异步获取。
			r = sb.toString();
		} catch (Exception e) {
			r = "error"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 上传图片方法-文件地址传入
	 */
	public String uploadImageFromPath() {
		try {
			File file=new File(filePath);
			
			//判断图片类型,选择不同的远程方法
			HttpServletRequest request=ServletActionContext.getRequest();
			String remote_path=null;
			String flag=request.getParameter("flag");
			if(flag!=null && flag.equals("logo")){ //上传logo
				remote_path=ResourceReader.readValue("remote_upload_logo_image");
			}else if(flag!=null && flag.equals("product")){//上传产品图片
				remote_path=ResourceReader.readValue("remote_upload_product_image");
			}else if(flag!=null && flag.equals("news")){//上传新闻图片
				remote_path=ResourceReader.readValue("remote_upload_news_image");
			}else if(flag!=null && flag.equals("ad")){//上传广告图片
				remote_path=ResourceReader.readValue("remote_upload_ad_image");
			}else{
				return NONE;
			}
			// 创建URL对象
			URL remote_url = new URL(remote_path);
			HttpURLConnection conn = (HttpURLConnection) remote_url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-type", "multipart/form-data");
			conn.setRequestProperty("charset", "utf-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(100000);
			conn.setConnectTimeout(100000);

			// 将图片转换成字节流，并传给远程URL
			FileInputStream inFile = new FileInputStream(file);
			int img_size = inFile.available();
			byte[] buffer = new byte[1024];
			byte[] result = new byte[img_size];
			int count = 0;
			int rbyte = 0;
			while (count < img_size) {
				rbyte = inFile.read(buffer);
				for (int i = 0; i < rbyte; i++) {
					result[count + i] = buffer[i];
				}
				count += rbyte;
			}
			OutputStream os = conn.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(result);
			dos.flush();
			os.close();

			// 等待返回远程处理结果
			BufferedReader in = new BufferedReader(new InputStreamReader(conn
					.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			in.close();
			
			fileUrl=sb.toString();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return SUCCESS;

	}

	/**
	 * 编辑器上传图片方法
	 */
	public void kissyUploadImage() {
		PrintWriter out = this.getWriter();
		String r = "";
		try {
			// 判断图片类型,选择不同的远程方法
			HttpServletRequest request = ServletActionContext.getRequest();
			String remote_path = null;
			String flag = request.getParameter("flag");
			if (flag != null && flag.equals("logo")) { // 上传ogo
				remote_path = ResourceReader
						.readValue("remote_upload_logo_image");
			} else if (flag != null && flag.equals("product")) {
				remote_path = ResourceReader
						.readValue("remote_upload_product_image");
			} else {
				return;
			}

			// 创建URL对象
			URL remote_url = new URL(remote_path);
			HttpURLConnection conn = (HttpURLConnection) remote_url
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-type", "multipart/form-data");
			conn.setRequestProperty("charset", "utf-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(100000);
			conn.setConnectTimeout(100000);

			// 将图片转换成字节流，并传给远程URL
			FileInputStream inFile = new FileInputStream(this.imgFile);
			int img_size = inFile.available();
			byte[] buffer = new byte[1024];
			byte[] result = new byte[img_size];
			int count = 0;
			int rbyte = 0;
			while (count < img_size) {
				rbyte = inFile.read(buffer);
				for (int i = 0; i < rbyte; i++) {
					result[count + i] = buffer[i];
				}
				count += rbyte;
			}
			OutputStream os = conn.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(result);
			dos.flush();
			os.close();

			// 等待返回远程处理结果
			BufferedReader in = new BufferedReader(new InputStreamReader(conn
					.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			in.close();

			// 返回图片访问URL，Ajax可以异步获取。
			r = sb.toString();
		} catch (Exception e) {
			r = "error"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			out.print(r);
			out.flush();
			out.close();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
