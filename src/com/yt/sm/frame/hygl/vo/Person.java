package com.yt.sm.frame.hygl.vo;

import java.io.Serializable;

/**
 * 个人实体类
 * 数据库表：CH_PERSON
 * @author Administrator
 *
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 484428109196707708L;
	private Integer id;//主键
	private String xm;//姓名
	private String xb;//性别	
	private String csrq;//出生日期
	private String jg;//籍贯
	private String mz;//民族
	private String dp;//党派
	private String whcd;//文化程度
	private String jszc;//技术职称
	private String zy;//专业
	private String zc;//专长
	private String wysp;//外语水平
	private String xcsgz;//现从事工作
	private String gzdw;//工作单位
	private String zw;//职务
	private String txdz;//通讯地址
	private String dh;//电话
	private String hsrh;//何时入本会
	private String bhzw;//本会职务
	private String xl;//学历
	private String byxx;//毕业学校
	private String xw;//学位
	private String gzjl;//工作简历
	private String kycg;//科研成果学术活动参加其他学术团体情况
	private String xhspyj;//学会审批意见
	private String bz;//备注
	private String grhyzsbh;//个人会员证书编号
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
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getJszc() {
		return jszc;
	}
	public void setJszc(String jszc) {
		this.jszc = jszc;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getWysp() {
		return wysp;
	}
	public void setWysp(String wysp) {
		this.wysp = wysp;
	}
	public String getXcsgz() {
		return xcsgz;
	}
	public void setXcsgz(String xcsgz) {
		this.xcsgz = xcsgz;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getTxdz() {
		return txdz;
	}
	public void setTxdz(String txdz) {
		this.txdz = txdz;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getHsrh() {
		return hsrh;
	}
	public void setHsrh(String hsrh) {
		this.hsrh = hsrh;
	}
	public String getBhzw() {
		return bhzw;
	}
	public void setBhzw(String bhzw) {
		this.bhzw = bhzw;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getByxx() {
		return byxx;
	}
	public void setByxx(String byxx) {
		this.byxx = byxx;
	}
	public String getXw() {
		return xw;
	}
	public void setXw(String xw) {
		this.xw = xw;
	}
	public String getGzjl() {
		return gzjl;
	}
	public void setGzjl(String gzjl) {
		this.gzjl = gzjl;
	}
	public String getKycg() {
		return kycg;
	}
	public void setKycg(String kycg) {
		this.kycg = kycg;
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
	public String getGrhyzsbh() {
		return grhyzsbh;
	}
	public void setGrhyzsbh(String grhyzsbh) {
		this.grhyzsbh = grhyzsbh;
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
