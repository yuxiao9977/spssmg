package com.yt.sm.frame.hygl.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yt.sm.frame.hygl.dao.HyglDao;
import com.yt.sm.frame.hygl.service.HyglService;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;
import com.yt.sm.frame.xsjl.vo.LwglVo;

public class HyglServiceImpl implements HyglService {
	private Logger logger = Logger.getLogger(HyglServiceImpl.class);
	private HyglDao hyglDao;

	public HyglDao getHyglDao() {
		return hyglDao;
	}

	public void setHyglDao(HyglDao hyglDao) {
		this.hyglDao = hyglDao;
	}

	@Override
	public int addPerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		return hyglDao.addPerson(map);
	}

	@Override
	public int updatePerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", person.getId());
		map.put("xm", person.getXm());
		map.put("xb", person.getXb());
		map.put("csrq", person.getCsrq());
		map.put("jg", person.getJg());
		map.put("mz", person.getMz());
		map.put("dp", person.getDp());
		map.put("whcd", person.getWhcd());
		map.put("jszc", person.getJszc());
		map.put("zy", person.getZy());
		map.put("zc", person.getZc());
		map.put("wysp", person.getWysp());
		map.put("xcsgz", person.getXcsgz());
		map.put("gzdw", person.getGzdw());
		map.put("zw", person.getZw());
		map.put("txdz", person.getTxdz());
		map.put("dh", person.getDh());
		map.put("hsrh", person.getHsrh());
		map.put("bhzw", person.getBhzw());
		map.put("xl", person.getXl());
		map.put("byxx", person.getByxx());
		map.put("xw", person.getXw());
		map.put("gzjl", person.getGzjl());
		map.put("kycg", person.getKycg());
		map.put("gzjl", person.getGzjl());
		map.put("xhspyj", person.getXhspyj());
		map.put("bz", person.getBz());
		map.put("grhyzsbh", person.getGrhyzsbh());
			if( person.getAuditStatus().equals("待审核")){
				map.put("auditStatus", "1");
			}
			if( person.getAuditStatus().equals("已通过")){
				map.put("auditStatus", "2");
			}
			if( person.getAuditStatus().equals("未通过")){
				map.put("auditStatus", "3");
			}
		map.put("auditDate", person.getAuditDate());
		map.put("xhAuditdate", person.getXhAuditdate());
		map.put("tbdate", person.getTbdate());
		return hyglDao.updatePerson(map);
	}

	@Override
	public List<Menu> findAdminMenu(Menu menu,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		if(user.getIsAdmin().equals("2")){
			map.put("flag", user.getIsAdmin());
		}else{
			map.put("flag", "");
		}
		return hyglDao.findAdminMenu(map);
	}

	@Override
	public int checkOldPwd(User user,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user1=(User) session.getAttribute("user");
		int i=-1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user1.getId());
		User user2= hyglDao.getOneUser(map);
		//判断user中的原始密码和user2中在数据库查出来的是否一致
		if(user2.getPassword().equals(user.getPassword())){
			i=1;
		}
		return i;
	}

	@Override
	public User getOneUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		return hyglDao.getOneUser(map);
	}

	@Override
	public int savePwd(User user,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user1=(User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user1.getId());
		map.put("password", user.getPassword());
		return hyglDao.savePwd(map);
	}

	@Override
	public Person getPersonInfo(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", person.getId());
		return hyglDao.getPersonInfo(map);
	}

	@Override
	public Group getGroupInfo(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", group.getId());
		return hyglDao.getGroupInfo(map);
	}

	@Override
	public int updateGroup(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", group.getId());
		map.put("sqdwmc", group.getSqdwmc());
		map.put("dwfr", group.getDwfr());
		map.put("chxhlsxm", group.getChxhlsxm());
		map.put("dwrs", group.getDwrs());
		map.put("jsrys", group.getJsrys());
		map.put("gjzcrs", group.getGjzcrs());
		map.put("zjzcrs", group.getZjzcrs());
		map.put("dwxz", group.getDwxz());
		map.put("dwdz", group.getDwdz());
		map.put("yb", group.getYb());
		map.put("lxrxm", group.getLxrxm());
		map.put("lxdh", group.getLxdh());
		map.put("cz", group.getCz());
		map.put("em", group.getEm());
		map.put("chzzjb", group.getChzzjb());
		map.put("bh", group.getBh());
		map.put("ywfw", group.getYwfw());
		map.put("dwcbw", group.getDwcbw());
		map.put("sqtthy", group.getSqtthy());
		map.put("rhsj", group.getRhsj());
		map.put("dwfzr", group.getDwfzr());
		map.put("sqdw", group.getSqdw());
		map.put("xhspyj", group.getXhspyj());
		map.put("bz", group.getBz());
		map.put("tthyzsbh", group.getTthyzsbh());
			if( group.getAuditStatus().equals("待审核")){
				map.put("auditStatus", "1");
			}
			if( group.getAuditStatus().equals("已通过")){
				map.put("auditStatus", "2");
			}
			if( group.getAuditStatus().equals("未通过")){
				map.put("auditStatus", "3");
			}
		map.put("auditDate", group.getAuditDate());
		map.put("xhAuditdate", group.getXhAuditdate());
		map.put("tbdate", group.getTbdate());
		return hyglDao.updateGroup(map);
	}

	@Override
	public Map<String, Object> findPersonList(Map<String, Object> map,Person person) {
		if(StringUtils.isNotBlank(person.getXm())){
			map.put("xm", person.getXm());
		}
		if(StringUtils.isNotBlank(person.getBhzw())){
			map.put("bhzw", person.getBhzw());
		}
		if(StringUtils.isNotBlank(person.getAuditStatus())){
			map.put("auditStatus", person.getAuditStatus());
		}
		if(StringUtils.isNotBlank(person.getGzdw())){
			map.put("gzdw", person.getGzdw());
		}
		int total=hyglDao.getPersonTotal(map);
		List<Person> list= hyglDao.findPersonList(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}

	@Override
	public int delPerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", person.getId());
		return hyglDao.delPerson(map);
	}

	@Override
	public Map<String, Object> findGroupList(Map<String, Object> map,
			Group group) {
		int total=hyglDao.getGroupTotal(map);
		if(StringUtils.isNotBlank(group.getSqdwmc())){
			map.put("sqdwmc", group.getSqdwmc());
		}
		if(StringUtils.isNotBlank(group.getDwfr())){
			map.put("dwfr", group.getDwfr());
		}
		if(StringUtils.isNotBlank(group.getLxrxm())){
			map.put("lxrxm", group.getLxrxm());
		}
		if(StringUtils.isNotBlank(group.getAuditStatus())){
			map.put("auditStatus", group.getAuditStatus());
		}
		List<Group> list= hyglDao.findGroupList(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}

	@Override
	public int delGroup(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", group.getId());
		return hyglDao.delGroup(map);
	}

	@Override
	public int updatePerson2(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", person.getId());
		map.put("xm", person.getXm());
		map.put("xb", person.getXb());
		map.put("csrq", person.getCsrq());
		map.put("jg", person.getJg());
		map.put("mz", person.getMz());
		map.put("dp", person.getDp());
		map.put("whcd", person.getWhcd());
		map.put("jszc", person.getJszc());
		map.put("zy", person.getZy());
		map.put("zc", person.getZc());
		map.put("wysp", person.getWysp());
		map.put("xcsgz", person.getXcsgz());
		map.put("gzdw", person.getGzdw());
		map.put("zw", person.getZw());
		map.put("txdz", person.getTxdz());
		map.put("dh", person.getDh());
		map.put("hsrh", person.getHsrh());
		map.put("bhzw", person.getBhzw());
		map.put("xl", person.getXl());
		map.put("byxx", person.getByxx());
		map.put("xw", person.getXw());
		map.put("gzjl", person.getGzjl());
		map.put("kycg", person.getKycg());
		map.put("gzjl", person.getGzjl());
		map.put("xhspyj", person.getXhspyj());
		map.put("bz", person.getBz());
		map.put("xhAuditdate", person.getXhAuditdate());
		map.put("tbdate", person.getTbdate());
		//证书编号
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", "");
		int maxMum=hyglDao.getPersonMax(map);
		map.put("grhyzsbh",maxMum+1);
		map.put("auditStatus", person.getAuditStatus());
		map.put("auditDate", person.getAuditDate());
		Date date=new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formater.format(date);
		map.put("auditDate", now);
		return hyglDao.updatePerson(map);
	}

	@Override
	public int updateGroup2(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", group.getId());
		map.put("sqdwmc", group.getSqdwmc());
		map.put("dwfr", group.getDwfr());
		map.put("chxhlsxm", group.getChxhlsxm());
		map.put("dwrs", group.getDwrs());
		map.put("jsrys", group.getJsrys());
		map.put("gjzcrs", group.getGjzcrs());
		map.put("zjzcrs", group.getZjzcrs());
		map.put("dwxz", group.getDwxz());
		map.put("dwdz", group.getDwdz());
		map.put("yb", group.getYb());
		map.put("lxrxm", group.getLxrxm());
		map.put("lxdh", group.getLxdh());
		map.put("cz", group.getCz());
		map.put("em", group.getEm());
		map.put("chzzjb", group.getChzzjb());
		map.put("bh", group.getBh());
		map.put("ywfw", group.getYwfw());
		map.put("dwcbw", group.getDwcbw());
		if( group.getSqtthy().equals("一般会员单位")){
			map.put("sqtthy", "1");
		}
		if( group.getSqtthy().equals("理事会员单位")){
			map.put("sqtthy", "2");
		}
		if( group.getSqtthy().equals("常务理事会员单位")){
			map.put("sqtthy", "3");
		}
		map.put("rhsj", group.getRhsj());
		map.put("dwfzr", group.getDwfzr());
		map.put("sqdw", group.getSqdw());
		map.put("xhspyj", group.getXhspyj());
		map.put("bz", group.getBz());
		map.put("xhAuditdate", group.getXhAuditdate());
		map.put("tbdate", group.getTbdate());
		//证书编号
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", "");
		int maxMum=hyglDao.getGroupMax(map);
		map.put("tthyzsbh",maxMum+1);
		
		map.put("auditStatus",group.getAuditStatus());
		Date date=new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formater.format(date);
		map.put("auditDate", now);
		return hyglDao.updateGroup(map);
	}

}
