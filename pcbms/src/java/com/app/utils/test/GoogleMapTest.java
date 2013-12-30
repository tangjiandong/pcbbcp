package com.app.utils.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.app.utils.util.MapUtil;

public class GoogleMapTest {

	/**
	 * @param args
	 *
	 * @author 汤建东
	 * @throws Exception 
	 * @date 2013-8-23 上午10:18:03
	 * 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i=0;i<1;i++){
			// String[] sip=		MapUtil.getGoogleMapLngAndLat("上海上海市肇嘉浜路1111号美罗城东侧");
			 //MapUtil.getGoogleMapLngAndLat("上海虹口区西江湾路388号虹口凯德龙之梦购物中心B幢1楼(近虹口体育场)");

			 
			 
			 //System.out.println(sip[0]);
			// System.out.println(sip[1]);
		}
		
	
		 
	}
	
	/**
     * 根据地址返回经纬度
     * @param addr
     * @return 返回经纬度数据, latLng[0]经度,latLng[1]维度
     */
    public static String[] getCoordinate(String addr) {
        String[] latLng = new String[2];
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        ;
        String output = "json"; // xml  json csv
        //密钥可以随便写一个key=abc
        String key = "ABQIAAAAevysxt9O5lBUCrSalm80MxQx8gmx0K-_Fjj4Tf8bNXH3BBSxZRRmI_CuZM2zQyuXEpG_uxt-aqPr-A";
        String url = "http://maps.google.com/maps/geo?q=" + address + "&output=" + output + "&key=" + key;
        URL googleMapURL = null;
        URLConnection httpsConn = null;
        // 进行转码
        try {
            googleMapURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            httpsConn = (URLConnection)googleMapURL.openConnection();
            if (httpsConn != null) {
                InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(insr);
                String data = null;
                StringBuffer  xml=new StringBuffer("");
                
              while ((data = br.readLine()) != null)
              {
            	  xml.append(data);
              }
              System.out.println(xml);
                
//                if ((data = br.readLine()) != null) {
////                	
//               	System.out.println(data);
////                    String[] retList = data.split(",");
////                  
////                      String latitude = retList[2]; String longitude =
////                      retList[3];
////                      
////                      System.out.println("纬度"+ latitude);
////                      System.out.println("经度"+ longitude);
////                    
////                    if (retList.length > 2 && ("200".equals(retList[0]))) {
////                        latLng[0] = retList[2];
////                        latLng[1] = retList[3];
////                    }
//                }
                insr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latLng;
    }


}
