package com.yt.sm.frame.hygl.action;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.attach.service.AttachService;
import com.yt.sm.frame.attach.vo.Attach;
import com.yt.sm.frame.dlzc.service.DlzcService;
import com.yt.sm.frame.hygl.service.HyglService;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;
import com.yt.sm.frame.util.expUtil;
import com.yt.sm.frame.xsjl.vo.LwglVo;

public class HyglAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware {
	private static final long serialVersionUID = 7257434861776978627L;
	private Logger logger = Logger.getLogger(HyglAction.class);
	private HyglService hyglService;
	private AttachService attachService ;
	private DlzcService dlzcService;
	private Attach attach=new Attach();
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private User user=new User();
	private Person person=new Person();
	private Group group=new Group();
	private String flag;
	private int page;
	private int rows;
	private String arr;
	protected Object jsonData;
	private Menu menu=new Menu();

	public String frontGroupList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page",  startRow());
		map.put("rows", rows);
		map.put("flag1", "2");
		this.jsonData = hyglService.findGroupList(map, group);
		return SUCCESS;
	}
	public String frontPersonList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page",  startRow());
		map.put("rows", rows);
		map.put("flag1", "2");
		this.jsonData=hyglService.findPersonList(map, person);
		return SUCCESS;
	}
	public String findAdminMenu(){
		this.jsonData=hyglService.findAdminMenu(menu,request);
		return SUCCESS;
	}
	public String getUserInfo(){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		if(user.getIsGroup().equals("2")){
			Person person=new Person();
			person.setId(Integer.parseInt(user.getPersonId()));
			this.jsonData=hyglService.getPersonInfo(person);
		}else if(user.getIsGroup().equals("1")){
			Group group=new Group();
			group.setId(Integer.parseInt(user.getGroupId()));
			this.jsonData=hyglService.getGroupInfo(group);
		}
		
		return SUCCESS;
	}
	public String getPersonInfo(){
		this.jsonData=hyglService.getPersonInfo(person);
		return SUCCESS;
	}
	public String getGroupInfo(){
		this.jsonData=hyglService.getGroupInfo(group);
		return SUCCESS;
	}
	public String checkOldPwd(){
		JSONObject jo = new JSONObject();
		int i=hyglService.checkOldPwd(user,request);
		if(i<0){
			jo.put("result", "error");
		}else{
			jo.put("result", "success");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updatePerson(){
		JSONObject jo = new JSONObject();
		int i=hyglService.updatePerson(person);
		if("会员自己修改".equals(flag)){
			if(i>0){
				jo.put("result", "success");
			}else{
				jo.put("result", "error");
			}
		}else{
			int j=dlzcService.updateUser(user);
			if(i>0&&j>0){
				jo.put("result", "success");
			}else{
				jo.put("result", "error");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updatePerson2(){
		JSONObject jo = new JSONObject();
		int i=hyglService.updatePerson2(person);
		if(i<0){
			jo.put("result", "error");
		}else{
			jo.put("result", "success");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updateGroup(){
		JSONObject jo = new JSONObject();
		int i=hyglService.updateGroup(group);
		if("会员自己修改".equals(flag)){
			if(i>0){
				jo.put("result", "success");
			}else{
				jo.put("result", "error");
			}
		}else{
			int j=dlzcService.updateUser(user);
			if(i>0&&j>0){
				jo.put("result", "success");
			}else{
				jo.put("result", "error");
			}
		}
		
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updateGroup2(){
		JSONObject jo = new JSONObject();
		int i=hyglService.updateGroup2(group);
		if(i<0){
			jo.put("result", "error");
		}else{
			jo.put("result", "success");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String savePwd(){
		JSONObject jo = new JSONObject();
		int i=hyglService.savePwd(user,request);
		if(i>0){
			jo.put("result", "success");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String findPersonList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page",  startRow());
		map.put("rows", rows);
		if(StringUtils.isNotBlank(request.getParameter("flag1"))&&request.getParameter("flag1").equals("2")){
			map.put("flag1", "2");//通过传递的flag进行会员查询
		}
		if(StringUtils.isNotBlank(request.getParameter("flag2"))&&request.getParameter("flag2").equals("13")){
			map.put("flag2", "2");//通过传递的flag进行会员审批查询
		}
		this.jsonData=hyglService.findPersonList(map,person);
		return SUCCESS;
	}
	public String findGroupList(){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(request.getParameter("flag1"))&&request.getParameter("flag1").equals("2")){
			map.put("flag1", "2");
		}
		if(StringUtils.isNotBlank(request.getParameter("flag2"))&&request.getParameter("flag2").equals("13")){
			map.put("flag2", "2");
		}
		map.put("page",  startRow());
		map.put("rows", rows);
		this.jsonData=hyglService.findGroupList(map,group);
		return SUCCESS;
	}
	public String delPerson(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			user.setPersonId(str[i]);
			User user1=dlzcService.getOneUser2(user);
			person.setId(Integer.valueOf(str[i]));
			if(user1.getIsAdmin().equals("1")){//判断是否为管理员，是管理员不能删除
				Person person1=hyglService.getPersonInfo(person);
				jo.put("result", "admin");
				jo.put("xm", person1.getXm());
				break;
			}else{
				int j = hyglService.delPerson(person);
				//删除用户表的关联信息
				user.setGroupId("");
				int k=dlzcService.deleteUser(user);
				//删除附件表的关联信息
				attach.setRelationId(str[i]);
				attach.setStyle("person");
				Attach attach1=attachService.getOneAttach(attach);
				//判断该会员有没有附件
				if(attach1!=null){
					int m=attachService.deleteAttach(attach);
					if(j>0&&k>0&&m>0){
						jo.put("result", "success");
					}
				}else{
					if(j>0&&k>0){
						jo.put("result", "success");
					}
				}
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String delGroup(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			user.setGroupId(str[i]);
			User user1=dlzcService.getOneUser2(user);
			group.setId(Integer.valueOf(str[i]));
			if(user1.getIsAdmin().equals("1")){//判断是否为管理员，是管理员不能删除
				Group group1=hyglService.getGroupInfo(group);
				jo.put("result", "admin");
				jo.put("sqdwmc", group1.getSqdwmc());
				break;
			}else{
				int j = hyglService.delGroup(group);
				//删除用户表的关联信息
				user.setPersonId("");
				int k=dlzcService.deleteUser(user);
				//删除附件表的关联信息
				attach.setRelationId(str[i]);
				attach.setStyle("group");
				Attach attach1=attachService.getOneAttach(attach);
				//判断该会员有没有附件
				if(attach1!=null){
					int m=attachService.deleteAttach(attach);
					if(j>0&&k>0&&m>0){
						jo.put("result", "success");
					}
				}else{
					if(j>0&&k>0){
						jo.put("result", "success");
					}
				}
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	private int startRow() {
		return (this.page - 1) * this.rows;
	}
	public Object getJsonData() {
		return jsonData;
	}
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}
	public HyglService getHyglService() {
		return hyglService;
	}
	public void setHyglService(HyglService hyglService) {
		this.hyglService = hyglService;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
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
	public DlzcService getDlzcService() {
		return dlzcService;
	}
	public void setDlzcService(DlzcService dlzcService) {
		this.dlzcService = dlzcService;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
