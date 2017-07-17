package com.yt.sm.frame.attach.dao;

import java.util.Map;

import com.yt.sm.frame.attach.vo.Attach;

public interface AttachDao {

	int addAttach(Map<String, Object> map);

	Attach getOneAttach(Map<String, Object> map);

	Attach findAttach(Map<String, Object> map);

	int updateAttach(Map<String, Object> map);

	int deleteAttach(Map<String, Object> map);

}
