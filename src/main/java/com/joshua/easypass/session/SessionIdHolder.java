package com.joshua.easypass.session;

import java.util.concurrent.ConcurrentHashMap;

public class SessionIdHolder {
	
	private SessionIdHolder() {}
	
	private static final ConcurrentHashMap<String, String> sessionIdHolder = new ConcurrentHashMap<String, String>();

	public static void put(String userId,String sessionId) {
		sessionIdHolder.put(userId, sessionId);
	}
	
	public static String get(String userId) {
		return sessionIdHolder.get(userId);
	}
	
	public static String reomve(String userId) {
		return sessionIdHolder.remove(userId);
	}
}
