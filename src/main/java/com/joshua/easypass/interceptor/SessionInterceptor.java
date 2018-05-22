package com.joshua.easypass.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.holder.SessionContextHolder;
import com.joshua.easypass.session.SessionIdHolder;

public class SessionInterceptor implements HandlerInterceptor {
	
	public final static Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		CurrentUserSessionStorage currentUserSessionStorage = SessionContextHolder.getCurrentUserSessionStorage();
		if(currentUserSessionStorage!=null&&currentUserSessionStorage.getUserId()!=null&&currentUserSessionStorage.getUserId()!=0) {
			logger.debug("currentUserSessionStorage:"+currentUserSessionStorage);
			String currentVisitSessionId = request.getSession().getId();
			String currentVisitUserId =  String.valueOf(currentUserSessionStorage.getUserId());
			String loginSessionId = SessionIdHolder.get(currentVisitUserId);
			if(StringUtils.isNotBlank(loginSessionId)&&loginSessionId.equals(currentVisitSessionId)) {
				return true;
			}
			logger.error("session过期，请重新登陆,currentUserSessionStorage:"+currentUserSessionStorage);
			//request.getRequestDispatcher("http://local.carking001.com/#/index").forward(request, response);
			//throw new Exception("用户在其他客户端登陆");		
			return false;
			
		}
		logger.error("session过期，请重新登陆,currentUserSessionStorage:"+currentUserSessionStorage);
		//throw new Exception("session过期，请重新登陆");
		return false;
	}
}
