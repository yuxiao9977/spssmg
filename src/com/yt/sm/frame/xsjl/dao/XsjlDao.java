package com.yt.sm.frame.xsjl.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yt.sm.frame.xsjl.vo.LwglVo;
public interface XsjlDao {

	int addLwglVo(Map<String, Object> map);

	List<LwglVo> findLwglVoList(Map<String, Object> map);

	int getLwglVoTotal(Map<String, Object> map, HttpServletRequest request);

	int delLwgl(Map<String, Object> map);

	int pubLwgl(Map<String, Object> map);

	LwglVo getOneLwgl(Map<String, Object> map);

	int updateLwglVo(Map<String, Object> map);

	int getLwglVoTotal2(Map<String, Object> map, HttpServletRequest request);

	List<LwglVo> findLwglVoList2(Map<String, Object> map);

	int updateLwglVo2(Map<String, Object> map);

	int cancelPubLwgl(Map<String, Object> map);

	List<LwglVo> findLwglVoList3(Map<String, Object> map);

	int cancelAuditLwgl(Map<String, Object> map);

	int getfrontXsjlTotal(Map<String, Object> map);

	List<LwglVo> frontXsjlList(Map<String, Object> map);

}
