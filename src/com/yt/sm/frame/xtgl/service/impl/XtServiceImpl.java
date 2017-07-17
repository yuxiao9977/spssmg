package com.yt.sm.frame.xtgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.xtgl.dao.XtDao;
import com.yt.sm.frame.xtgl.service.XtService;
import com.yt.sm.frame.xtgl.vo.UserVO;
import com.yt.sm.frame.xtgl.vo.XwtpVO;
import com.yt.sm.frame.xtgl.vo.ZxfbVO;

public class XtServiceImpl implements XtService {
	private Logger logger = Logger.getLogger(XtServiceImpl.class);
	
	private XtDao xtDao;

	public XtDao getXtDao() {
		return xtDao;
	}

	public void setXtDao(XtDao xtDao) {
		this.xtDao = xtDao;
	}

	@Override
	public List<UserVO> getUserList(String userid, String password) {
		return xtDao.getUserList(userid, password);
	}

	@Override
	public List<Menu> getMenuByIds(String treeid, String pid) {
		return xtDao.getMenuByIds(treeid, pid);
	}

	@Override
	public void addZx(Map<String, Object> map) {
		xtDao.addZx(map);
	}

	@Override
	public List<ZxfbVO> getZxByLx(String lx) {
		return xtDao.getZxByLx(lx);
	}

	@Override
	public void updZx(Map<String, Object> map) {
		xtDao.updZx(map);
	}

	@Override
	public Map<String, Object> getZxByPage(Map<String, Object> map) {
		List<ZxfbVO> list = xtDao.getZxByPage(map);
		int total = xtDao.getZxTotal(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}

	@Override
	public ZxfbVO getZxById(String id) {
		return xtDao.getZxById(id);
	}

	@Override
	public void updZxZt(Map<String, Object> map) {
		xtDao.updZxZt(map);
	}

	@Override
	public void delZxById(Map<String, Object> map) {
		xtDao.delZxById(map);
	}

	@Override
	public List<XwtpVO> getXwtpList() {
		return xtDao.getXwtpList();
	}

	@Override
	public void addXwtp(Map<String, Object> map) {
		xtDao.addXwtp(map);
	}

	@Override
	public void updXwtp(Map<String, Object> map) {
		xtDao.updXwtp(map);
	}

	@Override
	public void delXwtp(Map<String, Object> map) {
		xtDao.delXwtp(map);
	}

	@Override
	public List<ZxfbVO> getYqljList() {
		return xtDao.getYqljList();
	}

	@Override
	public List<Menu> getMenuByPid() {
		return xtDao.getMenuByPid();
	}

	@Override
	public int getZxTotal(Map<String, Object> map) {
		return xtDao.getZxTotal(map);
	}

}
