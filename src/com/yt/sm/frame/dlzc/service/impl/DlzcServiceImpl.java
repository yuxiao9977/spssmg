package com.yt.sm.frame.dlzc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yt.sm.frame.dlzc.dao.DlzcDao;
import com.yt.sm.frame.dlzc.service.DlzcService;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public class DlzcServiceImpl implements DlzcService {
	private Logger logger = Logger.getLogger(DlzcServiceImpl.class);
	private DlzcDao dlzcDao;

	public DlzcDao getDlzcDao() {
		return dlzcDao;
	}

	public void setDlzcDao(DlzcDao dlzcDao) {
		this.dlzcDao = dlzcDao;
	}

	@Override
	public List<User> getUserByname(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		return dlzcDao.getUserByname(map);
	}

	@Override
	public int addPerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("kycg", person.getKycg());
		map.put("gzjl", person.getGzjl());
		map.put("xhspyj", person.getXhspyj());
		map.put("xhAuditdate", person.getXhAuditdate());
		map.put("tbdate", person.getTbdate());
		map.put("bz", person.getBz());
		map.put("auditStatus", "1");
		return dlzcDao.addPerson(map);
	}

	@Override
	public List<Person> findPersonList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "");
		return dlzcDao.findPersonList(map);
	}

	@Override
	public int addUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		map.put("personId", user.getPersonId());
		map.put("groupId", user.getGroupId());
		map.put("isAdmin", user.getIsAdmin());
		map.put("isGroup", user.getIsGroup());
		return dlzcDao.addUser(map);
	}

	@Override
	public int addGroup(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("xhAuditdate", group.getXhAuditdate());
		map.put("tbdate", group.getTbdate());
		map.put("auditStatus", "1");
		return dlzcDao.addGroup(map);
	}

	@Override
	public List<Group> findGroupList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "");
		return dlzcDao.findGroupList(map);
	}

	@Override
	public int deleteUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personId", user.getPersonId());
		map.put("groupId", user.getGroupId());
		return dlzcDao.deleteUser(map);
	}

	@Override
	public User getOneUser2(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personId", user.getPersonId());
		map.put("groupId", user.getGroupId());
		return dlzcDao.getOneUser2(map);
	}

	@Override
	public int updateUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		return dlzcDao.updateUser(map);
	}
	
}
