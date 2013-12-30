//package com.app.utils.constant;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//public class Base64 {
//	private static String key = "0000333322221111";
//
//	/**
//	 * 根据自定义key获取生成的密钥字符串
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public static SecretKey getKey() throws Exception {
//		char[] ss = Base64.key.toCharArray();
//		String sss = "";
//		for (int i = 0; i < ss.length; i = i + 2) {
//			sss = sss + ss[i];
//		}
//		SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
//		DESKeySpec ks = new DESKeySpec(sss.substring(0, 8).getBytes());
//		SecretKey kd = kf.generateSecret(ks);
//		return kd;
//	}
//
//	/**
//	 * 加密
//	 * 
//	 * @param input
//	 *            需要加密的字符串
//	 * @return
//	 */
//	public static String encode(String input) {
//		String base64 = "";
//		try {
//			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, getKey());
//			byte[] inputBytes = input.getBytes("UTF8");
//			byte[] outputBytes = cipher.doFinal(inputBytes);
//			BASE64Encoder encoder = new BASE64Encoder();
//			base64 = encoder.encode(outputBytes);
//		} catch (Exception e) {
//			base64 = e.getMessage();
//		}
//		return base64;
//	}
//
//	/**
//	 * 解密
//	 * 
//	 * @param input
//	 *            需要解密的字符串(加密后的字符串)
//	 * @return
//	 */
//	public static String decode(String input) {
//		String result = null;
//		try {
//			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//			cipher.init(Cipher.DECRYPT_MODE, getKey());
//			BASE64Decoder decoder = new BASE64Decoder();
//			byte[] raw = decoder.decodeBuffer(input);
//			byte[] stringBytes = cipher.doFinal(raw);
//			result = new String(stringBytes, "UTF8");
//		} catch (Exception e) {
//			result = e.getMessage();
//		}
//		return result;
//	}
//
//	public static void main(String[] args) {
//		try {
//			String input = "哈哈哈";
//			System.out.println("加密后：" + Base64.encode(input));
//			System.out.println("解密后：" + Base64.decode(Base64.encode(input)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
