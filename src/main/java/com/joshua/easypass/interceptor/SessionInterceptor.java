package com.joshua.easypass.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.holder.SessionContextHolder;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		CurrentUserSessionStorage currentUserSessionStorage = SessionContextHolder.getCurrentUserSessionStorage();
		if(currentUserSessionStorage!=null&&currentUserSessionStorage.getUserId()!=null&&currentUserSessionStorage.getUserId()!=0) {
			System.out.println("+++++++++++++++++++++++++++++++++currentUserSessionStorage:"+currentUserSessionStorage);
			return true;
		}
		response.sendRedirect("/");
		System.out.println("------------------------------currentUserSessionStorage:"+currentUserSessionStorage);
		return false;
	}
}
