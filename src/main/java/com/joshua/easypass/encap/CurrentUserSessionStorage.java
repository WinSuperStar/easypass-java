package com.joshua.easypass.encap;

import java.io.Serializable;
import java.util.List;

import com.joshua.easypass.entity.Authlist;
import com.joshua.easypass.entity.User;

public class CurrentUserSessionStorage implements Serializable{

	private static final long serialVersionUID = -4212191182922495720L;
	
	public static final String CURRENT_USER_SESSION_STORE_KEY = "currentUserSessionStore";

	private Long userId;
	
	private String userName;
	
	private String nickName;
	
	private String userEmail;
	
	private String gender;
	
	private String phone;
	
	private Integer roleId;
	
	private List<Authlist> authList;
	
	private Authlist[] allAuthList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static CurrentUserSessionStorage fromUser(User user ,List<Authlist> authList,Authlist[]  allAuthList) {
		CurrentUserSessionStorage currentUserSessionStore = new CurrentUserSessionStorage();
		currentUserSessionStore.setUserId(Long.valueOf(user.getUserid()));
		currentUserSessionStore.setUserName(user.getUsername());
		currentUserSessionStore.setPhone(user.getPhone());
		currentUserSessionStore.setRoleId(user.getRoleid());
		currentUserSessionStore.setAuthList(authList);
		currentUserSessionStore.setAllAuthList(allAuthList);;
		return currentUserSessionStore;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public List<Authlist> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Authlist> authList) {
		this.authList = authList;
	}


	public Authlist[] getAllAuthList() {
		return allAuthList;
	}

	public void setAllAuthList(Authlist[] allAuthList) {
		this.allAuthList = allAuthList;
	}

	@Override
	public String toString() {
		return "CurrentUserSessionStorage [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName
				+ ", userEmail=" + userEmail + ", gender=" + gender + ", phone=" + phone + ", roleId=" + roleId +"  ]";
	}
}
