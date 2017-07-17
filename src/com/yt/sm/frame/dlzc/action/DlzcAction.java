package com.yt.sm.frame.dlzc.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.attach.service.AttachService;
import com.yt.sm.frame.attach.vo.Attach;
import com.yt.sm.frame.dlzc.service.DlzcService;
import com.yt.sm.frame.hygl.service.HyglService;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public class DlzcAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware{
	private static final long serialVersionUID = -4250030792630051329L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private AttachService attachService ;
	private Attach attach;
	protected Object jsonData;
	private User user;
	private Person person;
	private Group group;
	private DlzcService dlzcService;
	private HyglService hyglService;
	public String login(){
		 JSONObject jo = new JSONObject();
		HttpSession session = request.getSession();
		List<User> userList=dlzcService.getUserByname(user);
		if(userList.size()==0){
			jo.put("result", "nouser");
		}else{
			if(userList.get(0).getPersonId()!=null&&!userList.get(0).getPersonId().equals("")){
				Person person=new Person();
				person.setId(Integer.parseInt(userList.get(0).getPersonId()));
				Person person1=hyglService.getPersonInfo(person);
				if(person1.getAuditStatus().equals("1")){
					jo.put("result", "onAudit");
				}else if(person1.getAuditStatus().equals("3")){
					jo.put("result", "Audit");
					if(StringUtils.isNotBlank( person1.getXhspyj())){
						jo.put("idea", person1.getXhspyj());
					}else{
						jo.put("idea", "");
					}
					jo.put("idea", person1.getXhspyj());
				}else{
					if(userList.get(0).getPassword().equals(user.getPassword())){
						jo.put("result", "success");
						session.setAttribute("user", userList.get(0));
						session.setAttribute("person", person1);
					}else if(!userList.get(0).getPassword().equals(user.getPassword())){
						jo.put("result", "error");
					}
				}
			}
			if(userList.get(0).getGroupId()!=null&&!userList.get(0).getGroupId().equals("")){
				Group group=new Group();
				group.setId(Integer.parseInt(userList.get(0).getGroupId()));
				Group group1=hyglService.getGroupInfo(group);
				if(group1.getAuditStatus().equals("1")){
					jo.put("result", "onAudit");
				}else if(group1.getAuditStatus().equals("3")){
					jo.put("result", "Audit");
					if(StringUtils.isNotBlank( group1.getXhspyj())){
						jo.put("idea", group1.getXhspyj());
					}else{
						jo.put("idea", "");
					}
				}else{
					if(userList.get(0).getPassword().equals(user.getPassword())){
						jo.put("result", "success");
						session.setAttribute("user", userList.get(0));
						session.setAttribute("group", group1);
					}else if(!userList.get(0).getPassword().equals(user.getPassword())){
						jo.put("result", "error");
					}
				}
			}
			
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String tuichu(){
		JSONObject jo = new JSONObject();
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.setAttribute("person", null);
		session.setAttribute("group", null);
		jo.put("result", "success");
		this.jsonData=jo;
		return SUCCESS;
	}
	public String frontXsjl(){
		JSONObject jo = new JSONObject();
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null){
			jo.put("result", "nologin");
		}else{
			jo.put("result", "login");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String addPerson(){
		JSONObject jo = new JSONObject();
		int i=dlzcService.addPerson(person);
		if(i>0){
			List<Person> list=dlzcService.findPersonList();
			user.setPersonId(list.get(list.size()-1).getId().toString());
			user.setIsGroup("2");
			user.setIsAdmin("2");
			int j=dlzcService.addUser(user);
			attach.setRelationId(list.get(list.size()-1).getId().toString());
			int k=attachService.addAttach(attach);
			if(j>0&&k>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String addGroup(){
		JSONObject jo = new JSONObject();
		int i=dlzcService.addGroup(group);
		if(i>0){
			List<Group> list=dlzcService.findGroupList();
			user.setGroupId(list.get(list.size()-1).getId().toString());
			user.setIsGroup("1");
			user.setIsAdmin("2");
			int j=dlzcService.addUser(user);
			attach.setRelationId(list.get(list.size()-1).getId().toString());
			int k=attachService.addAttach(attach);
			if(j>0&&k>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String checkUser(){
		JSONObject jo = new JSONObject();
		List<User> list = dlzcService.getUserByname(user);
		if(list.size()>0){
			jo.put("result", "repate");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String getOneUser2(){
		this.jsonData = dlzcService.getOneUser2(user);
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
	public Object getJsonData() {
		return jsonData;
	}
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DlzcService getDlzcService() {
		return dlzcService;
	}
	public void setDlzcService(DlzcService dlzcService) {
		this.dlzcService = dlzcService;
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
	public AttachService getAttachService() {
		return attachService;
	}
	public void setAttachService(AttachService attachService) {
		this.attachService = attachService;
	}
	public Attach getAttach() {
		return attach;
	}
	public void setAttach(Attach attach) {
		this.attach = attach;
	}
	
}
