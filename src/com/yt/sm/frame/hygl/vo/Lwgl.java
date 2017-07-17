package com.yt.sm.frame.hygl.vo;

import java.io.Serializable;

/**
 * 论文实体类
 * 数据库表：CH_LWGL
 * @author Administrator
 *
 */
public class Lwgl  implements Serializable{
	private static final long serialVersionUID = -3347939059810114529L;
	private Integer id;
	private String lwzz;//论文作者
	private String lwtm;//论文题目
	private String fbsj;//发布时间
	private String zzdw;//作者单位
	private String lwnr;//论文内容
	private String pub;//发布状态:发布状态：1发布2取消发布
	private String auditStatus;//审核状态：1待审核2已通过3未通过
	private String auditDate;//审核时间
	private String auditIdea;//审核意见
	public Lwgl() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLwzz() {
		return lwzz;
	}
	public void setLwzz(String lwzz) {
		this.lwzz = lwzz;
	}
	public String getLwtm() {
		return lwtm;
	}
	public void setLwtm(String lwtm) {
		this.lwtm = lwtm;
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
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditIdea() {
		return auditIdea;
	}
	public void setAuditIdea(String auditIdea) {
		this.auditIdea = auditIdea;
	}
	
}
