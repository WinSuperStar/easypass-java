package com.joshua.easypass.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieHelper {
	
	protected final static Logger logger = LoggerFactory.getLogger(CookieHelper.class);
	
	private CookieHelper() {}

	/**
	 * 按名称获取cookie
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || StringUtils.isBlank(name)) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}

		return null;
	}

	/**
	 * 清除cookie
	 * 
	 * @param request
	 * @param response
	 * @param string
	 */
	public static void removeCookie(HttpServletResponse response, String name, String path, String domain) {

		Cookie cookie = new Cookie(name, null);

		if (path != null) {
			cookie.setPath(path);
		}

		if (domain != null) {
			cookie.setDomain(domain);
		}

		cookie.setMaxAge(-1000);
		response.addCookie(cookie);
	}
	
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = getCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> getCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	public static void setCookie(HttpServletResponse response,HttpServletRequest request,String name,String value){
		setCookie(response,request, name,value, -1);
	}	
	
	public static void setCookie(HttpServletResponse response,HttpServletRequest request,String name,String value,int maxAge){
		setCookie(response,request, name,value, maxAge, null,null);
	}

	public static void setCookie(HttpServletResponse response,HttpServletRequest request, String name, String value, int maxAge, String path, String domain){
		setCookie(response,request, name,value, -1, path,domain,false,0,false);
	}
	
	public static void setCookie(HttpServletResponse response,HttpServletRequest request, String name, String value, int maxAge, String path, String domain, boolean secure , int version, boolean isHttpOnly){
	    try{
	    	if(StringUtils.isBlank(domain)) {
	    		domain = new URL(request.getRequestURL().toString()).getHost();
	    		domain = domain.substring(domain.indexOf("."));
	    	}
	    	logger.info("maxAge:"+maxAge+",domain:"+domain);
			Cookie cookie = new Cookie(name,value);
			if(StringUtils.isBlank(path)) {
				path = "/";
			}
		    cookie.setPath(path);
		    cookie.setDomain(domain);
		    cookie.setMaxAge(maxAge);
		    cookie.setSecure(secure);
		    cookie.setHttpOnly(isHttpOnly);
		    cookie.setVersion(version);
		    response.addCookie(cookie);
	    }catch (Exception e) {
			e.getStackTrace();
			logger.error("系统出错",e);
		}
	}
}
