package com.yt.sm.frame.attach.service;

import javax.servlet.http.HttpServletRequest;

import com.yt.sm.frame.attach.vo.Attach;

public interface AttachService {
	/**
	 * 增加附件
	 * @param attach
	 * @return
	 */
	int addAttach(Attach attach);
	/**
	 * 获得一个附件
	 * @param attach
	 * @return
	 */
	Attach getOneAttach(Attach attach);
	/**
	 * 获得一个附件
	 * @param attach
	 * @return
	 */
	Attach findAttach(Attach attach);
	/**
	 * 更新附件
	 * @param attach
	 * @return
	 */
	int updateAttach(Attach attach);
	/**
	 * 删除附件
	 * @param attach
	 * @return
	 */
	int deleteAttach(Attach attach);
}
