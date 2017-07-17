package com.yt.sm.frame.xtgl.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
	
	private static final long serialVersionUID = 4364780757647531227L;
	
	private String userid;//ID
	private String username;//名称
	private String password;//密码
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
