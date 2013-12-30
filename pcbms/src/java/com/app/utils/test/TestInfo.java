package com.app.utils.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInfo {

	/**
	 * @param args
	 *
	 * @author 汤建东
	 * @date 2013-7-2 上午11:24:15
	 * 
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat dateformat1=new SimpleDateFormat("HH.mm");
		System.out.print(dateformat1.format(new Date()).length());

	}

}
