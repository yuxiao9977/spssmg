package com.yt.sm.frame.impData.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.impData.dao.ImpDataDao;
import com.yt.sm.frame.impData.service.ImpDataService;

public class ImpDataServiceImpl implements ImpDataService {
	private ImpDataDao impDataDao;

	public ImpDataDao getImpDataDao() {
		return impDataDao;
	}

	public void setImpDataDao(ImpDataDao impDataDao) {
		this.impDataDao = impDataDao;
	}

	@Override
	public int addPerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xm", person.getXm());
		map.put("xb", person.getXb());
		map.put("csrq", person.getCsrq());
		map.put("jg", person.getJg());
		map.put("mz", person.getMz());
		map.put("dp", person.getDp());
		map.put("whcd", person.getWhcd());
		map.put("jszc", person.getJszc());
		map.put("zy", person.getZy());
		map.put("zc", person.getZc());
		map.put("wysp", person.getWysp());
		map.put("xcsgz", person.getXcsgz());
		map.put("gzdw", person.getGzdw());
		map.put("zw", person.getZw());
		map.put("txdz", person.getTxdz());
		map.put("dh", person.getDh());
		map.put("hsrh", person.getHsrh());
		map.put("bhzw", person.getBhzw());
		map.put("xl", person.getXl());
		map.put("byxx", person.getByxx());
		map.put("xw", person.getXw());
		map.put("kycg", person.getKycg());
		map.put("gzjl", person.getGzjl());
		map.put("auditStatus", "1");
		//会员证书编号
		List<Person> list = impDataDao.findPersonList(map);
		if(list.size()==0){
			map.put("grhyzsbh", "3700001");
		}else{
			String num=list.get(list.size()-1).getGrhyzsbh();
			Integer newNUM=	(Integer.parseInt(num)+1);
			map.put("grhyzsbh", newNUM.toString());
		}
		return impDataDao.addPerson(map);
	}

	@Override
	public List<Person> findPersonList(Map<String, Object> map) {
		return impDataDao.findPersonList(map);
	}

	@Override
	public int addGroup(Group group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sqdwmc", group.getSqdwmc());
		map.put("dwfr", group.getDwfr());
		map.put("chxhlsxm", group.getChxhlsxm());
		map.put("dwrs", group.getDwrs());
		map.put("jsrys", group.getJsrys());
		map.put("gjzcrs", group.getGjzcrs());
		map.put("zjzcrs", group.getZjzcrs());
		map.put("dwdz", group.getDwdz());
		map.put("yb", group.getYb());
		map.put("lxrxm", group.getLxrxm());
		map.put("lxdh", group.getLxdh());
		map.put("cz", group.getCz());
		map.put("em", group.getEm());
		map.put("chzzjb", group.getChzzjb());
		map.put("bh", group.getBh());
		map.put("ywfw", group.getYwfw());
		map.put("dwcbw", group.getDwcbw());
		map.put("rhsj", group.getRhsj());
		map.put("auditStatus", "1");
		//会员证书编号
		List<Group> list = impDataDao.findGroupList(map);
		if(list.size()==0){
			map.put("tthyzsbh", "3700001");
		}else{
			String num=list.get(list.size()-1).getTthyzsbh();
			Integer newNUM=	(Integer.parseInt(num)+1);
			map.put("tthyzsbh", newNUM.toString());
		}
		return impDataDao.addGroup(map);
	}

	@Override
	public List<Group> findGroupList(Map<String, Object> map) {
		return impDataDao.findGroupList(map);
	}
	
}
