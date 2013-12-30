package info.czol.grabage.read;

import java.io.IOException;
import java.lang.Character.UnicodeBlock;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.RefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class TestLogin {
	
	public static void login() throws Exception{
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3);
        webClient.setThrowExceptionOnScriptError(false);
        webClient.setRefreshHandler(new RefreshHandler() {
                        public void handleRefresh(Page page, URL url, int arg) throws IOException {
                                System.out.println("handleRefresh");
                        }
 
            });
        
        final HtmlPage page1 = webClient.getPage("http://wap.ulpos.com/login!index.do");            
 
        final HtmlForm form =(HtmlForm)  page1.getElementById("UserLoginForm");
 
        final HtmlTextInput textFieldName = form.getInputByName("username");        
        HtmlPasswordInput textFieldPass = (HtmlPasswordInput) form.getInputByName("password");
        final HtmlSubmitInput button =(HtmlSubmitInput) form.getInputByValue("登录");   
   
 
        textFieldName.setValueAttribute("测试商户");
        textFieldPass.setValueAttribute("123456");
        
        final HtmlPage page2 = button.click();
        final String pageAsXml = page2.asXml();
        System.out.println(pageAsXml);

	}
	
	public static void release() throws Exception{
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.setThrowExceptionOnScriptError(false);
		webClient.setCssEnabled(true);
		webClient.setJavaScriptEnabled(true);
		String chkUrl = "http://yourdomain/check.php";
		String sedUrl = "http://yourdomain/send.php";
		URL url = new URL(chkUrl);

		WebRequestSettings reqSet = new WebRequestSettings(url, HttpMethod.POST);
		reqSet.setCharset("UTF-8");//TODO:转换返回的charset
		List reqParam = new ArrayList();
		//保障房应只租不售
		reqParam.add(new NameValuePair("username", "abc"));
		reqParam.add(new NameValuePair("password", "123"));
		
		
		reqParam.add(new NameValuePair("classid", "1"));
		reqParam.add(new NameValuePair("title","测试测试"));
		//reqParam.add(new NameValuePair("newstext","测试测试测试"));

		reqSet.setRequestParameters(reqParam);

		HtmlPage mypage = (HtmlPage) webClient.getPage(reqSet);
		String manStr = mypage.asText();
		System.out.println(manStr);
		
		WebRequestSettings reqSet1 = new WebRequestSettings(url, HttpMethod.POST);
		reqSet1.setCharset("UTF-8");//TODO:转换返回的charset
		List reqParam1 = new ArrayList();
		//保障房应只租不售
		reqParam1.add(new NameValuePair("username", "abc"));
		reqParam1.add(new NameValuePair("password", "123"));
		
		
		reqParam1.add(new NameValuePair("classid", "2"));
		reqParam1.add(new NameValuePair("title","测试测试"));
		//reqParam.add(new NameValuePair("newstext","测试测试测试"));

		reqSet1.setRequestParameters(reqParam1);
		webClient.closeAllWindows();
		webClient.notifyAll();
		HtmlPage mypage1 = (HtmlPage) webClient.getPage(reqSet);
		
		String manStr1 = mypage1.asText();
		System.out.println(manStr1);
		
		System.out.println(mypage.asXml());
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		login();
	}
}
