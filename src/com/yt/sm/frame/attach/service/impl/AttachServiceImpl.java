package com.yt.sm.frame.attach.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yt.sm.frame.attach.dao.AttachDao;
import com.yt.sm.frame.attach.service.AttachService;
import com.yt.sm.frame.attach.vo.Attach;

public class AttachServiceImpl implements AttachService {
	private Logger logger = Logger.getLogger(AttachServiceImpl.class);
	private AttachDao attachDao;
	public AttachDao getAttachDao() {
		return attachDao;
	}
	public void setAttachDao(AttachDao attachDao) {
		this.attachDao = attachDao;
	}
	@Override
	public int addAttach(Attach attach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("relationId", attach.getRelationId());
		map.put("style", attach.getStyle());
		map.put("fileName", attach.getFileName());
		map.put("url", attach.getUrl());
		return attachDao.addAttach(map);
	}
	@Override
	public Attach getOneAttach(Attach attach) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(attach.getId()!=null&&!attach.getId().equals("")){
			map.put("id", attach.getId());
		}
		if(StringUtils.isNotBlank(attach.getRelationId())){
			map.put("relationId", attach.getRelationId());
		}
		if(StringUtils.isNotBlank(attach.getStyle())){
			map.put("style", attach.getStyle());
		}
		
		return attachDao.getOneAttach(map);
	}
	@Override
	public Attach findAttach(Attach attach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("relationId", attach.getRelationId());
		map.put("style", attach.getStyle());
		return attachDao.findAttach(map);
	}
	@Override
	public int updateAttach(Attach attach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("relationId", attach.getRelationId());
		map.put("style", attach.getStyle());
		map.put("fileName", attach.getFileName());
		map.put("url", attach.getUrl());
		return attachDao.updateAttach(map);
	}
	@Override
	public int deleteAttach(Attach attach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("relationId", attach.getRelationId());
		map.put("style", attach.getStyle());
		return attachDao.deleteAttach(map);
	}
	
}
