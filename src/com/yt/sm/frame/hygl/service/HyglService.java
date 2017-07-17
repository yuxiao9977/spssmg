package com.yt.sm.frame.hygl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public interface HyglService {
	/**
	 * 增加个人
	 */
	int addPerson(Person person);
	/**
	 * 修改个人
	 */
	int updatePerson(Person person);
	/**
	 * 查找管理员菜单
	 * @param request 
	 * @param map
	 * @return
	 */
	List<Menu> findAdminMenu(Menu menu, HttpServletRequest request);
	/**
	 * 验证原始密码是否正确
	 * @param user
	 * @return
	 */
	int checkOldPwd(User user,HttpServletRequest request);
	/**
	 * 获得一个用户
	 * @param user
	 * @return
	 */
	User getOneUser(User user);
	/**
	 * 修改用户密码
	 * @param user
	 * @return
	 */
	int savePwd(User user,HttpServletRequest request);
	/**
	 * 获得用户的个人会员信息
	 * @param user
	 * @return
	 */
	Person getPersonInfo(Person person);
	/**
	 * 获得用户的团体会员信息
	 * @param user
	 * @return
	 */
	Group getGroupInfo(Group group);
	/**
	 * 更新团体会员信息
	 * @param group
	 * @return
	 */
	int updateGroup(Group group);
	/**
	 * 
	 * @param person
	 * @return
	 */
	Map<String, Object> findPersonList(Map<String, Object> map,Person person);
	/**
	 * 删除个人会员
	 * @param person
	 * @return
	 */
	int delPerson(Person person);
	/**
	 * 查询团体会员列表
	 * @param map
	 * @param group
	 * @return
	 */
	Map<String, Object> findGroupList(Map<String, Object> map, Group group);
	/**
	 * 删除团体会员
	 * @param group
	 * @return
	 */
	int delGroup(Group group);
	/**
	 * 审核个人信息
	 * @param person
	 * @return
	 */
	int updatePerson2(Person person);
	/**
	 * 审核团体会员
	 * @param group
	 * @return
	 */
	int updateGroup2(Group group);
}
