/*
 * 文件名:CharacterEncodingFilter.java
 * 作者：caiqifan
 * 完成日期：2010-11-29
 * 维护人员：
 * 维护日期：
 * 维护原因：
 * 当前版本：1.0
 * 前继版本：1.0
 */

package com.app.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ClassUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Class: CharacterEncodingFilter Description: 拦截器字符编码
 * 
 * @author caiqifan
 * @version 10.0, 2010-11-29
 * @since JDK1.6
 */
public class CharacterEncodingFilter extends OncePerRequestFilter {
	private final static boolean responseSetCharacterEncodingAvailable = ClassUtils
			.hasMethod(HttpServletResponse.class, "setCharacterEncoding",
					new Class[] { String.class });

	private String encoding;

	private boolean forceEncoding = false;

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}

	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (this.encoding != null
				&& request.getRequestURL().indexOf("/validatecode") < 0
				&& (this.forceEncoding || request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding && responseSetCharacterEncodingAvailable) {
				response.setCharacterEncoding(this.encoding);
			}
		}
		filterChain.doFilter(request, response);
	}
}
