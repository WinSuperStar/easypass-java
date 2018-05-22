package com.joshua.easypass.config.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.entity.Authlist;
import com.joshua.easypass.session.SessionIdHolder;
import com.joshua.easypass.util.AuthUtil;

@WebFilter(urlPatterns = "/*", filterName = "sessionFilter")
public class SessionFilter implements Filter {

	
	private static final String  NO_AUTHORITY_PAGE = "/#/home/tip";
	
	private static final String  INDEX_PAGE = "/#index";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String servletPath = request.getServletPath();
		if (servletPath.endsWith("/login") || servletPath.endsWith("/logout")
			||servletPath.endsWith("permission")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			CurrentUserSessionStorage currentUserSessionStorage = (CurrentUserSessionStorage) request.getSession().getAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY);
			if (currentUserSessionStorage != null&&currentUserSessionStorage.getUserId()!=null&&currentUserSessionStorage.getUserId()!=0) {
				// 重新设值session
				request.getSession().setAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY,currentUserSessionStorage);
				String currentVisitSessionId = request.getSession().getId();
				String currentVisitUserId =  String.valueOf(currentUserSessionStorage.getUserId());
				String loginSessionId = SessionIdHolder.get(currentVisitUserId);
				if(StringUtils.isNotBlank(loginSessionId)&&loginSessionId.equals(currentVisitSessionId)) {
					List<Authlist> authList = currentUserSessionStorage.getAuthList();
					boolean flag =AuthUtil.hasAuthByAuthUrl(authList, servletPath);
					if(flag){
						filterChain.doFilter(servletRequest, servletResponse);
					}else{
						response.sendRedirect(NO_AUTHORITY_PAGE);
						return;
					}
				}else {
					response.sendRedirect(INDEX_PAGE);
					return;
				}
			} else {
				response.sendRedirect(INDEX_PAGE);
				return;
			}
		}
	}

	@Override
	public void destroy() {

	}
}
