package com.hellow.mvc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr()+"");	//protocol IP주소
		
		String uri = StringUtils.defaultString(req.getRequestURI());	// null이 들어와도 됨		uri는  url + urn
		String url = StringUtils.defaultString(req.getRequestURL().toString());	// 
		String queryString = StringUtils.defaultString(req.getQueryString());
		
		String referer = StringUtils.defaultString(req.getHeader("referer"));
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("/remoteAddr : ").append(remoteAddr)	// ip주소 ipv6
			.append("/uri : ").append(uri)	// context ~ endtag까지만
			.append("/url : ").append(url)	// location. 전체 다 나옴
			.append("/queryString : ").append(queryString)	// key = value(where = ?)
			.append("/referer : ").append(referer)	// 요청하기 전 페이지 주소(처음에는 null)
			.append("/agent : ").append(agent);	// 사용자의 접속 정보를 줘서 동작 환경을 보여준다.
		
		logger.info("[LOG FILTER] " + sb.toString() + "\n");
		
		chain.doFilter(req, response);	// doFilter가 두개면 두번나온다 !
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
