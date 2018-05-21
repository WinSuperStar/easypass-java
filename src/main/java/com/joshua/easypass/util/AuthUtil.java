package com.joshua.easypass.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.joshua.easypass.entity.Authlist;

public class AuthUtil {

	public static boolean hasAuthByAuthUrl(List<Authlist> authList,String servletPath){
		if (authList != null && !authList.isEmpty()) {
			Pattern pattern = null;
			for(Authlist auth:authList) {
				if(StringUtils.isNotBlank(auth.getAuthUrl())){
					pattern = Pattern.compile(auth.getAuthUrl());
					Matcher matcher = pattern.matcher(servletPath);
					if(matcher.matches()) {
						return true;
					}
				}
				continue;
			} 
			
		} 
		return false;
	}
	
	
	public static boolean hasAuthByAuthData(List<Authlist> authList,String authData){
		if (authList != null && !authList.isEmpty()) {
			for(Authlist auth:authList) {
				if(StringUtils.isNotBlank(auth.getAuthData())){
					if(auth.getAuthData().equalsIgnoreCase(authData)){
						return true;
					}else {
						continue;
					}
				}
			} 
			
		} 
		return false;
	}
	

}