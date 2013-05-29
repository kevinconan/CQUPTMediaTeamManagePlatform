package cqupt.mt2013.cmtmp.model;

import javax.management.loading.PrivateClassLoader;

/**
 * 
 * @author 廖渝瀚
 * @version 1.0
 * 用户javaBean
 */
public class UserBean {
	private int USER_ID;
	private String USER_PASSWORD;
	private int USER_PERMISSION;
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public int getUSER_PERMISSION() {
		return USER_PERMISSION;
	}
	public void setUSER_PERMISSION(int uSER_PERMISSION) {
		USER_PERMISSION = uSER_PERMISSION;
	}
	
		
}
