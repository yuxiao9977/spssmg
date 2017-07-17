package com.yt.sm.frame.xsjl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yt.sm.frame.xsjl.vo.LwglVo;

public interface XsjlService {
	/**
	 * 增加论文
	 * @param lwglVo
	 * @param request
	 * @return
	 */
	int addLwglVo(LwglVo lwglVo, HttpServletRequest request);
	/**
	 * 查找用户的论文列表
	 * @param lwglVo
	 * @param map
	 * @param request 
	 * @return
	 */
	Map<String, Object> findLwglVoList(LwglVo lwglVo, Map<String, Object> map, HttpServletRequest request);
	/**
	 * 删除论文
	 * @param lwglVo
	 * @return
	 */
	int delLwgl(LwglVo lwglVo);
	/**
	 * 发布论文
	 * @param lwglVo
	 * @return
	 */
	int pubLwgl(LwglVo lwglVo);
	/**
	 * 获得一条论文
	 * @param lwglVo
	 * @return
	 */
	LwglVo getOneLwgl(LwglVo lwglVo);
	/**
	 * 更新论文
	 * @param lwglVo
	 * @return
	 */
	int updateLwglVo(LwglVo lwglVo);
	/**
	 * 
	 * 查找所有论文
	 * @param lwglVo
	 * @param map
	 * @param request
	 * @return
	 */
	Map<String, Object> findLwglVoList2(LwglVo lwglVo, Map<String, Object> map,
			HttpServletRequest request);
	/**
	 * 更新论文
	 * @param lwglVo
	 * @return
	 */
	int updateLwglVo2(LwglVo lwglVo);
	/**
	 * 取消发布论文
	 * @param lwglVo
	 * @return
	 */
	int cancelPubLwgl(LwglVo lwglVo);
	/**
	 * 查询所有论文
	 * @return
	 */
	List<LwglVo> findLwglVoList3();
	/**
	 * 取消审核
	 * @param lwglVo
	 * @return
	 */
	int cancelAuditLwgl(LwglVo lwglVo);
	/**
	 * 前台查询论文
	 * @param lwglVo
	 * @return
	 */
	Map<String, Object> frontXsjlList(Map<String, Object> map);

}
