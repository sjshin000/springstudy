package com.ssj.springstudy.login.model;

public class Login {
	private String id;
	private String pwd;
	private boolean isLogin = false; 
	
	public boolean getIsLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin){
			this.isLogin = isLogin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
