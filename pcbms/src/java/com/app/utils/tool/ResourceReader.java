package com.app.utils.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工具类_读取配置文件属性值
 * 
 * @author chenhong 2012.06.25
 * @version 1.0
 */
public class ResourceReader {
	// 资源文件路径
	private static String SYSTEM_PROPERTIES_PATH = "//parameter.properties";

	/**
	 * 读取配置文件属性值
	 * 
	 * @param key
	 *            键值
	 * @return 返回值
	 */
	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			String propertiesPath = ResourceReader.class.getClassLoader()
					.getResource(SYSTEM_PROPERTIES_PATH).getPath();
			InputStream ins = new BufferedInputStream(new FileInputStream(
					propertiesPath));
			props.load(ins);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
