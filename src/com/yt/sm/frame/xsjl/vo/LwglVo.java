package com.yt.sm.frame.xsjl.vo;

import java.io.Serializable;
/**
 * 论文管理实体类
 * 数据库表：ch_lwgl
 * @author Administrator
 *
 */
public class LwglVo implements Serializable {
	private static final long serialVersionUID = -1380333743665996645L;
	private Integer id;//主键
	private String userId;//用户id
	private String lwtm;//论文题目
	private String lwzz;//论文作者
	private String fbsj;//论文发布时间
	private String cjsj;//论文创建时间
	private String zzdw;//作者单位
	private String lwnr;//论文简介
	private String pub;//发布状态：1发布2未发布
	private String auditstatus;//审核状态：1待审核2已通过3未通过
	private String auditdate;//审核时间
	private String auditidea;//审核意见
	public LwglVo() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLwtm() {
		return lwtm;
	}
	public void setLwtm(String lwtm) {
		this.lwtm = lwtm;
	}
	public String getLwzz() {
		return lwzz;
	}
	public void setLwzz(String lwzz) {
		this.lwzz = lwzz;
	}
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	public String getZzdw() {
		return zzdw;
	}
	public void setZzdw(String zzdw) {
		this.zzdw = zzdw;
	}
	public String getLwnr() {
		return lwnr;
	}
	public void setLwnr(String lwnr) {
		this.lwnr = lwnr;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(String auditstatus) {
		this.auditstatus = auditstatus;
	}
	public String getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(String auditdate) {
		this.auditdate = auditdate;
	}
	public String getAuditidea() {
		return auditidea;
	}
	public void setAuditidea(String auditidea) {
		this.auditidea = auditidea;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	
}
