package com.yt.sm.frame.hygl.vo;

import java.io.Serializable;
/**
 * 用户 实体类
 * 数据库表：CH_USER
 * @author Administrator
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 2162377640765088030L;
	private Integer id;//主键
	private String username;//用户名
	private String password;//密码
	private String personId;//个人或团体会员id
	private String groupId;//团体会员id
	private String isAdmin;//是否管理员：1是2否
	private String isGroup;//是否团体会员：1是2否
	public User() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getIsGroup() {
		return isGroup;
	}
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
	
}
