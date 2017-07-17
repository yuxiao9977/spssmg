package com.yt.sm.frame.xtgl.vo;

import java.io.Serializable;

public class XwtpVO implements Serializable {
	
	private static final long serialVersionUID = 4364780757647531227L;
	
	private String id;//ID
	private String tpmc;//图片名称
	private String tpms;//图片描述
	private String tplj;//图片路径
	private String url;//图片链接
	private String cjsj;//创建时间
	private String cjr;//创建人
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTpms() {
		return tpms;
	}
	public void setTpms(String tpms) {
		this.tpms = tpms;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getTpmc() {
		return tpmc;
	}
	public void setTpmc(String tpmc) {
		this.tpmc = tpmc;
	}
	
}
