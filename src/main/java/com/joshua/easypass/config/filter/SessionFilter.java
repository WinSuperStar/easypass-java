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
import org.springframework.context.annotation.DependsOn;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.entity.Authlist;
import com.joshua.easypass.holder.SpringContextHolder;
import com.joshua.easypass.service.AuthService;
import com.joshua.easypass.service.RoleService;

@WebFilter(urlPatterns = "/*", filterName = "sessionFilter")
public class SessionFilter implements Filter  {

    
    private AuthService authService=SpringContextHolder.getBean(AuthService.class);
	
    private RoleService roleService=SpringContextHolder.getBean(RoleService.class);;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse  servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;   
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if(request.getRequestURL().toString().equals("http://"+request.getServerName()+":"+request.getServerPort()+"/login")  
        ||request.getRequestURL().toString().equals("http://"+request.getServerName()+":"+request.getServerPort()+"/loginOut")){
        	filterChain.doFilter(servletRequest,servletResponse);
        }else{
		        CurrentUserSessionStorage currentUserSessionStorage = (CurrentUserSessionStorage)request.getSession().getAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY);    
		        if (currentUserSessionStorage != null) {    
		            //重新设值session  
		            request.getSession().setAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY, currentUserSessionStorage);
		            String authids=roleService.findAuthlist(currentUserSessionStorage.getRoleId().intValue());
		            List<Authlist>  authlist=null;
		            if(authids!=null&&StringUtils.isNotBlank(authids)){
		            	  authlist=authService.getAuthlist(authids);
		            }
		            if(authlist!=null&&authlist.size()>0){
		            	String requestUrl= request.getRequestURL().toString();
		            	if(authlist.contains(requestUrl)){
		            		 filterChain.doFilter(servletRequest,servletResponse);
		            	}else{
		            		//response.sendRedirect("http://"+request.getServerName()+":"+request.getServerPort()+"/login");
		            		response.sendRedirect("/");
		            	}
		            }else{
		            	//response.sendRedirect("http://"+request.getServerName()+":"+request.getServerPort()+"/login");
		            	response.sendRedirect("/");
		            }
		            
		            
		        }else{
		        	response.sendRedirect("/");
		        }
		       
        }
        
    }

    @Override
    public void destroy() {

    }
}
