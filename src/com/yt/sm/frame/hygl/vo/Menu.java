package com.yt.sm.frame.hygl.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 菜单实体类
 * 数据表：CH_MENU
 * @author Administrator
 *
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 8861089684458930226L;
	private Integer id;//主键
	private String treeId;//菜单Id
	private String text;//菜单名字
	private String pid;//父级ID
	private String url;//url
	private String flag;//管理员菜单标记：1管理员2个人3管理员和个人共有菜单
	private String lel;//菜单级别：1一级2二级3三级
	public Menu() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLel() {
		return lel;
	}
	public void setLel(String lel) {
		this.lel = lel;
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	
	
}
