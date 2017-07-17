package com.yt.sm.frame.xsjl.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yt.sm.frame.hygl.vo.User;
import com.yt.sm.frame.xsjl.dao.XsjlDao;
import com.yt.sm.frame.xsjl.service.XsjlService;
import com.yt.sm.frame.xsjl.vo.LwglVo;

public class XsjlServiceImpl implements XsjlService{
	private Logger logger = Logger.getLogger(XsjlServiceImpl.class);
	private XsjlDao xsjlDao;

	public XsjlDao getXsjlDao() {
		return xsjlDao;
	}

	public void setXsjlDao(XsjlDao xsjlDao) {
		this.xsjlDao = xsjlDao;
	}

	@Override
	public int addLwglVo(LwglVo lwglVo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		map.put("lwtm", lwglVo.getLwtm());
		map.put("lwzz", lwglVo.getLwzz());
		map.put("zzdw", lwglVo.getZzdw());
		map.put("lwnr", lwglVo.getLwnr());
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formater.format(new Date());
		map.put("cjsj", now);
		map.put("pub", "2");
		map.put("auditstatus", "1");
		return xsjlDao.addLwglVo(map);
	}
	@Override
	public int updateLwglVo(LwglVo lwglVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		map.put("userId", lwglVo.getUserId());
		map.put("lwtm", lwglVo.getLwtm());
		map.put("lwzz", lwglVo.getLwzz());
		map.put("zzdw", lwglVo.getZzdw());
		map.put("lwnr", lwglVo.getLwnr());
		/*map.put("fbsj", lwglVo.getFbsj());
		if(lwglVo.getPub().equals("已发布")){
			map.put("pub", "1");
		}else if(lwglVo.getPub().equals("未发布")){
			map.put("pub", "2");
		}*/
		map.put("auditstatus", lwglVo.getAuditstatus());
		Date date=new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formater.format(date);
		map.put("auditdate", now);
		map.put("auditidea", lwglVo.getAuditidea());
		return xsjlDao.updateLwglVo(map);
	}
	@Override
	public Map<String, Object> findLwglVoList(LwglVo lwglVo,
			Map<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		map.put("userId", user.getId());
		int total = xsjlDao.getLwglVoTotal(map, request);
		List<LwglVo> list = xsjlDao.findLwglVoList(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}
	
	@Override
	public int delLwgl(LwglVo lwglVo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		return xsjlDao.delLwgl(map);
	}

	@Override
	public int pubLwgl(LwglVo lwglVo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		map.put("pub", "1");
		Date date=new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String now = formater.format(date);
		map.put("fbsj", now);
		return xsjlDao.pubLwgl(map);
	}

	@Override
	public LwglVo getOneLwgl(LwglVo lwglVo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		return xsjlDao.getOneLwgl(map);
	}

	@Override
	public Map<String, Object> findLwglVoList2(LwglVo lwglVo,
		Map<String, Object> map, HttpServletRequest request) {
		int total = xsjlDao.getLwglVoTotal2(map, request);
		List<LwglVo> list = xsjlDao.findLwglVoList2(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}

	@Override
	public int updateLwglVo2(LwglVo lwglVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		map.put("lwtm", lwglVo.getLwtm());
		map.put("lwzz", lwglVo.getLwzz());
		map.put("zzdw", lwglVo.getZzdw());
		map.put("lwnr", lwglVo.getLwnr());
	/*	map.put("fbsj", lwglVo.getFbsj());*/
		return xsjlDao.updateLwglVo2(map);
	}

	@Override
	public int cancelPubLwgl(LwglVo lwglVo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		map.put("pub", "2");
		map.put("fbsj", "");
		return xsjlDao.cancelPubLwgl(map);
	}

	@Override
	public List<LwglVo> findLwglVoList3() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", "");
		return xsjlDao.findLwglVoList3(map);
	}

	@Override
	public int cancelAuditLwgl(LwglVo lwglVo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", lwglVo.getId());
		map.put("auditstatus", "1");
		return xsjlDao.cancelAuditLwgl(map);
	}

	@Override
	public Map<String, Object> frontXsjlList(Map<String, Object> map) {
		int total = xsjlDao.getfrontXsjlTotal(map);
		List<LwglVo> list = xsjlDao.frontXsjlList(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", list);
		m.put("total", total);
		return m;
	}

	
}
