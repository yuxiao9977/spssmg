package com.yt.sm.frame.xtgl.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.xtgl.dao.XtDao;
import com.yt.sm.frame.xtgl.vo.UserVO;
import com.yt.sm.frame.xtgl.vo.XwtpVO;
import com.yt.sm.frame.xtgl.vo.ZxfbVO;

/**
 * 用户个性化数据DAO
 * @author yh.chen
 * 
 */
public class XtDaoImpl implements XtDao {
	private Logger logger = Logger.getLogger(XtDaoImpl.class);
	
	protected SqlSessionTemplate sqlTemplate;

	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}

	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}

	@Override
	public List<UserVO> getUserList(String userid, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("password", password);
		List<UserVO> list = sqlTemplate.selectList("xyMapper.getLoginUser", map);
		return list;
	}

	@Override
	public List<Menu> getMenuByIds(String treeid, String pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("treeid", treeid);
		map.put("pid", pid);
		return sqlTemplate.selectList("xtglMapper.getMenuByIds", map);
	}

	@Override
	public void addZx(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.addZx", map);
	}

	@Override
	public List<ZxfbVO> getZxByLx(String lx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lx", lx);
		return sqlTemplate.selectList("xtglMapper.getZxByLx", map);
	}

	@Override
	public void updZx(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.updZx", map);
	}

	@Override
	public List<ZxfbVO> getZxByPage(Map<String, Object> map) {
		return sqlTemplate.selectList("xtglMapper.getZxByPage", map);
	}

	@Override
	public int getZxTotal(Map<String, Object> map) {
		return sqlTemplate.selectOne("xtglMapper.getZxTotal", map);
	}

	@Override
	public ZxfbVO getZxById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return sqlTemplate.selectOne("xtglMapper.getZxById", map);
	}

	@Override
	public void updZxZt(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.updZxZt", map);
	}

	@Override
	public void delZxById(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.delZxById", map);
	}

	@Override
	public List<XwtpVO> getXwtpList() {
		return sqlTemplate.selectList("xtglMapper.getXwtpList");
	}

	@Override
	public void addXwtp(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.addXwtp", map);
	}

	@Override
	public void updXwtp(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.updXwtp", map);
	}

	@Override
	public void delXwtp(Map<String, Object> map) {
		sqlTemplate.selectOne("xtglMapper.delXwtp", map);
	}

	@Override
	public List<ZxfbVO> getYqljList() {
		return sqlTemplate.selectList("xtglMapper.getYqljList");
	}

	@Override
	public List<Menu> getMenuByPid() {
		return sqlTemplate.selectList("xtglMapper.getMenuByPid");
	}

}
