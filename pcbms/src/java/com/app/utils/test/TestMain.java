package com.app.utils.test;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.utils.util.DateUtil;

public class TestMain {

	/**
	 * @param args
	 *
	 * @author 汤建东
	 * @date 2013-7-3 下午2:56:44
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M-d");
		for(int i=0;i<=15;i++){
			System.out.println(simpleDateFormat.format(DateUtil.addDateByStep(new Date(), i-15))+"---"+i);
		}
		StringBuffer dsb=new StringBuffer("");
	
		for(int i=1;i<=15;i++){
			//dlist.add(simpleDateFormat.format(DateUtil.addDateByStep(new Date(), i-15)));
			if(i !=15){
				dsb.append("'"+simpleDateFormat.format(DateUtil.addDateByStep(new Date(), i-15))+"',");
			}else{
				dsb.append("'"+simpleDateFormat.format(DateUtil.addDateByStep(new Date(), i-15))+"'");
			}
		}
		
		//System.out.println(dsb.toString());
			
		System.out.println("多个地标时，地标间用空格分开".equals("多个地标时，地标间用空格分开"));
	}

}
