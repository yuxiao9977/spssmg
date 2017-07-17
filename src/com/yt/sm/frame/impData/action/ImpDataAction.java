package com.yt.sm.frame.impData.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.hygl.service.HyglService;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.impData.service.ImpDataService;
import com.yt.sm.frame.util.ImpUtil;
import com.yt.sm.frame.util.expUtil;

public class ImpDataAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private ImpDataService impDataService;
	private HyglService hyglService;
	protected Object jsonData;
	private Person person=new Person();
	private Group group=new Group();
	private String arr;
	public void expPerson(){
		//JSONObject jo = new JSONObject();
		String[] str=arr.split(",");
		List<Person> personList=new ArrayList<Person>();
		for (int i = 0; i < str.length; i++) {
			person.setId(Integer.parseInt(str[i]));
			Person person1=hyglService.getPersonInfo(person);
			personList.add(person1);
		}
		try {
			XSSFWorkbook wb = expUtil.exportPerson(personList);    
			response.setContentType("application/vnd.ms-excel"); 
			String fileName="个人会员信息.xlsx";
			//解决下载乱码问题
			String loadName=new String(fileName.getBytes("UTF-8"), "iso8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+loadName);    
			OutputStream ouputStream = response.getOutputStream();    
			wb.write(ouputStream);    
			ouputStream.flush();    
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void expAllPerson(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auditStatus", "2");
		List<Person> personList=impDataService.findPersonList(map);
		try {
			XSSFWorkbook wb = expUtil.exportPerson(personList);    
			response.setContentType("application/vnd.ms-excel"); 
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
			String now = formater.format(new Date());
			String fileName="个人会员信息"+now+".xlsx";
			//解决下载乱码问题
			String loadName=new String(fileName.getBytes("UTF-8"), "iso8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+loadName);    
			OutputStream ouputStream = response.getOutputStream();    
			wb.write(ouputStream);    
			ouputStream.flush();    
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void expAllGroup(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auditStatus", "2");
		List<Group> groupList=impDataService.findGroupList(map);
		try {
			XSSFWorkbook wb = expUtil.exportGroup(groupList);    
			response.setContentType("application/vnd.ms-excel");
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
			String now = formater.format(new Date());
			String fileName="团体会员信息"+now+".xlsx";
			//解决下载乱码问题
			String loadName=new String(fileName.getBytes("UTF-8"), "iso8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+loadName);    
			OutputStream ouputStream = response.getOutputStream();    
			wb.write(ouputStream);    
			ouputStream.flush();    
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public String impPersonExcel(){
		JSONObject jo = new JSONObject();
		InputStream fis =null;
		try {
			File file=new File("E://档案//个人会员");
			File[] files=file.listFiles();
			//绝对路径
			String absolutePath = file.getAbsolutePath();
			for(int i=0;i<files.length;i++){
				File file1 = new File(file.getAbsolutePath()+"//"+files[i].getName());
				//获得文件格式
				String fileType=files[i].getName().substring(files[i].getName().lastIndexOf(".")+1, files[i].getName().length());
				// 输入流
				 fis = new FileInputStream(file1);  
				//POI:得到解析Excel的实体集合  
				List<Person> infos = ImpUtil.importPerson(fis,fileType);
				//遍历解析Excel的实体集合  
				for(Person info:infos) { 
					impDataService.addPerson(info);  
				} 
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭流 
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.jsonData = jo;
		jo.put("result", "success");
		return SUCCESS;
	}
	public String impGroupExcel(){
		JSONObject jo = new JSONObject();
		try {
			File file=new File("E://档案//会员单位");
			File[] files=file.listFiles();
			//绝对路径
			String absolutePath = file.getAbsolutePath();
			for(int i=0;i<files.length;i++){
				File file1 = new File(file.getAbsolutePath()+"//"+files[i].getName());
				//获得文件格式
				String fileType=files[i].getName().substring(files[i].getName().lastIndexOf(".")+1, files[i].getName().length());
				// 输入流
				InputStream fis = new FileInputStream(file1);  
				//POI:得到解析Excel的实体集合  
				List<Group> infos = ImpUtil.importGroup(fis,fileType);
				//遍历解析Excel的实体集合  
				for(Group info:infos) {  
					impDataService.addGroup(info);  
				}  
				//关闭流  
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.jsonData = jo;
		jo.put("result", "success");
		return SUCCESS;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public ImpDataService getImpDataService() {
		return impDataService;
	}
	public void setImpDataService(ImpDataService impDataService) {
		this.impDataService = impDataService;
	}
	public Object getJsonData() {
		return jsonData;
	}
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public HyglService getHyglService() {
		return hyglService;
	}
	public void setHyglService(HyglService hyglService) {
		this.hyglService = hyglService;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	
}
