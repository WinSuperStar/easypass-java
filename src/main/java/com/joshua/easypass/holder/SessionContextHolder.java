package com.joshua.easypass.holder;

import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;

import com.joshua.easypass.encap.CurrentUserSessionStorage;

public class SessionContextHolder {

	private static final ThreadLocal<CurrentUserSessionStorage> currentUserSessionStorageHolder = new NamedThreadLocal<>("current user session storage");
	
	
	public static void resetCurrentUserSessionStorage() {
		currentUserSessionStorageHolder.remove();
	}
	
	public static void setCurrentUserSessionStorage(CurrentUserSessionStorage currentUserSessionStorage) {
		currentUserSessionStorageHolder.set(currentUserSessionStorage);
	}
	
	@Nullable
	public static CurrentUserSessionStorage getCurrentUserSessionStorage() {
		CurrentUserSessionStorage currentUserSessionStorage = currentUserSessionStorageHolder.get();
		if (currentUserSessionStorage == null) {
			currentUserSessionStorage = new CurrentUserSessionStorage();
		}
		return currentUserSessionStorage;
	}
	
	public static CurrentUserSessionStorage currentUserSessionStorage() {
		CurrentUserSessionStorage currentUserSessionStorage = getCurrentUserSessionStorage();
		return currentUserSessionStorage;
	}
}
