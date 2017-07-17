package com.yt.sm.frame.xtgl.dao;

import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.xtgl.vo.UserVO;
import com.yt.sm.frame.xtgl.vo.XwtpVO;
import com.yt.sm.frame.xtgl.vo.ZxfbVO;

public interface XtDao {
	
	/**
	 * 查询用户
	 */
	public List<UserVO> getUserList(String userid, String password);
	
	/**
	 * 查询菜单名称ById
	 * @param id
	 * @return
	 */
	public List<Menu> getMenuByIds(String treeid, String pid);
	
	/**
	 * 添加资讯
	 * @param id
	 * @return
	 */
	public void addZx(Map<String, Object> map);
	
	/**
	 * 更新资讯
	 * @param id
	 * @return
	 */
	public void updZx(Map<String, Object> map);
	
	/**
	 * 查询资讯By类型
	 * @param id
	 * @return
	 */
	public List<ZxfbVO> getZxByLx(String lx);
	
	/**
	 * 查询资讯分页
	 * @param id
	 * @return
	 */
	public List<ZxfbVO> getZxByPage(Map<String, Object> map);
	
	/**
	 * 查询资讯分页统计
	 * @param id
	 * @return
	 */
	public int getZxTotal(Map<String, Object> map);
	
	/**
	 * 查询资讯ById
	 * @param id
	 * @return
	 */
	public ZxfbVO getZxById(String id);
	
	/**
	 * 更新资讯状态
	 * @param id
	 * @return
	 */
	public void updZxZt(Map<String, Object> map);
	
	/**
	 * 删除资讯
	 * @param id
	 * @return
	 */
	public void delZxById(Map<String, Object> map);
	
	/**
	 * 查询新闻图片
	 * @param id
	 * @return
	 */
	public List<XwtpVO> getXwtpList();
	
	/**
	 * 添加新闻图片
	 * @param id
	 * @return
	 */
	public void addXwtp(Map<String, Object> map);
	
	/**
	 * 修改新闻图片
	 * @param id
	 * @return
	 */
	public void updXwtp(Map<String, Object> map);
	
	/**
	 * 删除新闻图片
	 * @param id
	 * @return
	 */
	public void delXwtp(Map<String, Object> map);
	
	/**
	 * 查询友情链接
	 * @param id
	 * @return
	 */
	public List<ZxfbVO> getYqljList();
	
	/**
	 * 查询菜单ByPid
	 * @param pid
	 * @return
	 */
	public List<Menu> getMenuByPid();
	
}