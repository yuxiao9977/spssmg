package com.yt.sm.frame.xsjl.dao.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.hygl.vo.User;
import com.yt.sm.frame.xsjl.dao.XsjlDao;
import com.yt.sm.frame.xsjl.vo.LwglVo;

public class XsjlDaoImpl implements XsjlDao  {
	private Logger logger = Logger.getLogger(XsjlDaoImpl.class);
	protected SqlSessionTemplate sqlTemplate;

	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}

	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}

	@Override
	public int addLwglVo(Map<String, Object> map) {
		return sqlTemplate.insert("xsjlMapper.addLwglVo", map);
	}

	@Override
	public List<LwglVo> findLwglVoList(Map<String, Object> map) {
		return sqlTemplate.selectList("xsjlMapper.findLwglVoList", map);
	}

	@Override
	public int getLwglVoTotal(Map<String, Object> map,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
			map.put("userId", user.getId());
		return sqlTemplate.selectOne("xsjlMapper.getLwglVoTotal", map);
	}

	@Override
	public int delLwgl(Map<String, Object> map) {
		return sqlTemplate.delete("xsjlMapper.delLwgl", map);
	}

	@Override
	public int pubLwgl(Map<String, Object> map) {
		return sqlTemplate.update("xsjlMapper.pubLwgl", map);
	}

	@Override
	public LwglVo getOneLwgl(Map<String, Object> map) {
		return sqlTemplate.selectOne("xsjlMapper.getOneLwgl", map);
	}

	@Override
	public int updateLwglVo(Map<String, Object> map) {
		return sqlTemplate.update("xsjlMapper.updateLwglVo", map);
	}

	@Override
	public int getLwglVoTotal2(Map<String, Object> map,
			HttpServletRequest request) {
		return sqlTemplate.selectOne("xsjlMapper.getLwglVoTotal2", map);
	}

	@Override
	public List<LwglVo> findLwglVoList2(Map<String, Object> map) {
		return sqlTemplate.selectList("xsjlMapper.findLwglVoList2", map);
	}

	@Override
	public int updateLwglVo2(Map<String, Object> map) {
		return sqlTemplate.update("xsjlMapper.updateLwglVo2", map);
	}

	@Override
	public int cancelPubLwgl(Map<String, Object> map) {
		return sqlTemplate.update("xsjlMapper.cancelPubLwgl", map);
	}

	@Override
	public List<LwglVo> findLwglVoList3(Map<String, Object> map) {
		return sqlTemplate.selectList("xsjlMapper.findLwglVoList3", map);
	}

	@Override
	public int cancelAuditLwgl(Map<String, Object> map) {
		return sqlTemplate.update("xsjlMapper.cancelAuditLwgl", map);
	}

	@Override
	public int getfrontXsjlTotal(Map<String, Object> map) {
		return sqlTemplate.selectOne("xsjlMapper.getfrontXsjlTotal", map);
	}

	@Override
	public List<LwglVo> frontXsjlList(Map<String, Object> map) {
		return sqlTemplate.selectList("xsjlMapper.frontXsjlList", map);
	}
	

}
