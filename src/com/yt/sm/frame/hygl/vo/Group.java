package com.yt.sm.frame.hygl.vo;

import java.io.Serializable;
/**
 * 团体会员实体类
 * 数据库表：CH_GROUP
 * @author Administrator
 *
 */
public class Group implements Serializable {
	private static final long serialVersionUID = 2688092517964155303L;
	private Integer id;//主键
	private String sqdwmc;//申请单位名称
	private String dwfr;//单位法人（或负责人）
	private String chxhlsxm;//测绘学会理事姓名
	private String dwrs;//单位人数
	private String jsrys;//其中：科技人员数
	private String gjzcrs;//高级职称人数
	private String zjzcrs;//中级职称人数
	private String dwxz;//单位性质：1.事业2学校.3.社会团体4.企业5.部队
	private String dwdz;//单位地址
	private String yb;//邮编
	private String lxrxm;//联系人姓名
	private String lxdh;//联系电话
	private String cz;//传真
	private String em;//E-MAIL
	private String chzzjb;//测绘资质级别
	private String bh;//编号
	private String ywfw;//业务范围
	private String dwcbw;//单位出版物
	private String sqtthy;//申请团体会员1.一般会员单位2理事会员单位3常务理事会员单位
	private String rhsj;//入会时间
	private String dwfzr;//单位负责人
	private String sqdw;//申请单位
	private String xhspyj;//学会审批意见
	private String bz;//备注
	private String tthyzsbh;//团体会员证书编号
	private String auditStatus;//审核状态：1待审核2已通过3未通过
	private String auditDate;//管理员审核时间
	private String xhAuditdate;//学会审批时间
	private String tbdate;//填表时间
	private String username;//用户名
	private String zcsj;//注册时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSqdwmc() {
		return sqdwmc;
	}
	public void setSqdwmc(String sqdwmc) {
		this.sqdwmc = sqdwmc;
	}
	public String getDwfr() {
		return dwfr;
	}
	public void setDwfr(String dwfr) {
		this.dwfr = dwfr;
	}
	public String getChxhlsxm() {
		return chxhlsxm;
	}
	public void setChxhlsxm(String chxhlsxm) {
		this.chxhlsxm = chxhlsxm;
	}
	public String getDwrs() {
		return dwrs;
	}
	public void setDwrs(String dwrs) {
		this.dwrs = dwrs;
	}
	public String getJsrys() {
		return jsrys;
	}
	public void setJsrys(String jsrys) {
		this.jsrys = jsrys;
	}
	public String getGjzcrs() {
		return gjzcrs;
	}
	public void setGjzcrs(String gjzcrs) {
		this.gjzcrs = gjzcrs;
	}
	public String getZjzcrs() {
		return zjzcrs;
	}
	public void setZjzcrs(String zjzcrs) {
		this.zjzcrs = zjzcrs;
	}
	public String getDwxz() {
		return dwxz;
	}
	public void setDwxz(String dwxz) {
		this.dwxz = dwxz;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public String getLxrxm() {
		return lxrxm;
	}
	public void setLxrxm(String lxrxm) {
		this.lxrxm = lxrxm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	public String getChzzjb() {
		return chzzjb;
	}
	public void setChzzjb(String chzzjb) {
		this.chzzjb = chzzjb;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getYwfw() {
		return ywfw;
	}
	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}
	public String getDwcbw() {
		return dwcbw;
	}
	public void setDwcbw(String dwcbw) {
		this.dwcbw = dwcbw;
	}
	public String getSqtthy() {
		return sqtthy;
	}
	public void setSqtthy(String sqtthy) {
		this.sqtthy = sqtthy;
	}
	public String getRhsj() {
		return rhsj;
	}
	public void setRhsj(String rhsj) {
		this.rhsj = rhsj;
	}
	public String getDwfzr() {
		return dwfzr;
	}
	public void setDwfzr(String dwfzr) {
		this.dwfzr = dwfzr;
	}
	public String getSqdw() {
		return sqdw;
	}
	public void setSqdw(String sqdw) {
		this.sqdw = sqdw;
	}
	public String getXhspyj() {
		return xhspyj;
	}
	public void setXhspyj(String xhspyj) {
		this.xhspyj = xhspyj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getTthyzsbh() {
		return tthyzsbh;
	}
	public void setTthyzsbh(String tthyzsbh) {
		this.tthyzsbh = tthyzsbh;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getXhAuditdate() {
		return xhAuditdate;
	}
	public void setXhAuditdate(String xhAuditdate) {
		this.xhAuditdate = xhAuditdate;
	}
	public String getTbdate() {
		return tbdate;
	}
	public void setTbdate(String tbdate) {
		this.tbdate = tbdate;
	}
	public String getZcsj() {
		return zcsj;
	}
	public void setZcsj(String zcsj) {
		this.zcsj = zcsj;
	}
	
}
