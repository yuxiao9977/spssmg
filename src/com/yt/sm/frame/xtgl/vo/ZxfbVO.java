package com.yt.sm.frame.xtgl.vo;

import java.io.Serializable;

public class ZxfbVO implements Serializable {
	
	private static final long serialVersionUID = 4364780757647531227L;
	
	private String id;//ID
	private String btmc;//标题名称
	private String zxnr;//资讯内容
	private String fbdw;//发布单位
	private String fbsj;//发布时间
	private String cjsj;//创建时间
	private String cjr;//创建人
	private String lx;//类型
	private String zt;//状态 0未发布 1已发布
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBtmc() {
		return btmc;
	}
	public void setBtmc(String btmc) {
		this.btmc = btmc;
	}
	public String getZxnr() {
		return zxnr;
	}
	public void setZxnr(String zxnr) {
		this.zxnr = zxnr;
	}
	public String getFbdw() {
		return fbdw;
	}
	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	
}
