package com.joshua.easypass.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.holder.SessionContextHolder;

public class SessionInterceptor implements HandlerInterceptor {
	
	public final static Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		CurrentUserSessionStorage currentUserSessionStorage = SessionContextHolder.getCurrentUserSessionStorage();
		if(currentUserSessionStorage!=null&&currentUserSessionStorage.getUserId()!=null&&currentUserSessionStorage.getUserId()!=0) {
			logger.debug("currentUserSessionStorage:"+currentUserSessionStorage);
			return true;
		}
		logger.error("session过期，请重新登陆,currentUserSessionStorage:"+currentUserSessionStorage);
		response.sendRedirect("/");
		return false;
	}
}
