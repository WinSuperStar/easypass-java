package com.joshua.easypass.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joshua.easypass.encap.CurrentUserSessionStorage;

@WebFilter(urlPatterns = "/*", filterName = "sessionFilter")
public class SessionFilter implements Filter {

	
	private static final String  NO_AUTHORITY_PAGE = "http://localhost:4200/#tip";
	
	private static final String  INDEX_PAGE = "http://localhost:4200/#index";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String servletPath = request.getServletPath();
		if (servletPath.endsWith("/login") || servletPath.endsWith("/logout")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			CurrentUserSessionStorage currentUserSessionStorage = (CurrentUserSessionStorage) request.getSession().getAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY);
			if (currentUserSessionStorage != null&&currentUserSessionStorage.getUserId()!=null&&currentUserSessionStorage.getUserId()!=0) {
				// 重新设值session
				request.getSession().setAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY,currentUserSessionStorage);
//				List<Authlist> authList = currentUserSessionStorage.getAuthList();
//				if (authList != null && !authList.isEmpty()) {
//					Pattern pattern = null;
//					for(Authlist auth:authList) {
//						pattern = Pattern.compile(auth.getAuthUrl());
//						Matcher matcher = pattern.matcher(servletPath);
//						if(matcher.matches()) {
//							filterChain.doFilter(servletRequest, servletResponse);
//						}else {
//							response.sendRedirect(NO_AUTHORITY_PAGE);
//						}
//					} 
//				} else {
//					response.sendRedirect(NO_AUTHORITY_PAGE);
//				}
				filterChain.doFilter(servletRequest, servletResponse);
			} else {
				response.sendRedirect(INDEX_PAGE);
			}
		}
	}

	@Override
	public void destroy() {

	}
}
