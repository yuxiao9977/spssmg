package com.yt.sm.frame.xsjl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.attach.service.AttachService;
import com.yt.sm.frame.attach.vo.Attach;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.xsjl.service.XsjlService;
import com.yt.sm.frame.xsjl.vo.LwglVo;

public class XsjlAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware{
	private static final long serialVersionUID = 5783515570229825371L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private int page;
	private int rows;
	private XsjlService xsjlService;
	private AttachService attachService ;
	private Attach attach=new Attach();
	private LwglVo lwglVo=new LwglVo();
	protected Object jsonData;
	private String arr;
	public String addLwglVo(){
		JSONObject jo = new JSONObject();
		int i=xsjlService.addLwglVo(lwglVo,request);
		if(i>0){
			List<LwglVo> list=xsjlService.findLwglVoList3();
			attach.setRelationId(list.get(list.size()-1).getId().toString());
			int k=attachService.addAttach(attach);
			if(k>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updateLwglVo2(){
		JSONObject jo = new JSONObject();
		int i=xsjlService.updateLwglVo2(lwglVo);
		if(i>0){
			if(StringUtils.isNotBlank(attach.getRelationId())){
				int k=attachService.updateAttach(attach);
				if(k>0){
					jo.put("result", "success");
				}
			}else{
				jo.put("result", "success");
			}
			
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String updateLwglVo(){
		JSONObject jo = new JSONObject();
		int i=xsjlService.updateLwglVo(lwglVo);
		if(i>0){
			jo.put("result", "success");
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String findLwglVoList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", startRow());
		map.put("rows", rows);
		if(StringUtils.isNotBlank(lwglVo.getLwtm())){
			map.put("lwtm", lwglVo.getLwtm());
		}
		this.jsonData=xsjlService.findLwglVoList(lwglVo,map,request);
		return SUCCESS;
	}
	public String frontXsjlList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", startRow());
		map.put("rows", rows);
		map.put("pub", "1");
		this.jsonData=xsjlService.frontXsjlList(map);
		return SUCCESS;
	}
	public String findLwglVoList2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", startRow());
		map.put("rows", rows);
		if(StringUtils.isNotBlank(request.getParameter("flag1"))&&request.getParameter("flag1").equals("2")){
			map.put("flag1", "2");//通过传递的flag进行论文查询
		}
		if(StringUtils.isNotBlank(request.getParameter("flag2"))&&request.getParameter("flag2").equals("13")){
			map.put("flag2", "2");//通过传递的flag进行论文审批查询
		}
		if(StringUtils.isNotBlank(lwglVo.getLwtm())){
			map.put("lwtm", lwglVo.getLwtm());
		}
		this.jsonData=xsjlService.findLwglVoList2(lwglVo,map,request);
		return SUCCESS;
	}
	public String delLwgl(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			LwglVo lwglVo=new  LwglVo();
			lwglVo.setId(Integer.valueOf(str[i]));
			int j = xsjlService.delLwgl(lwglVo);
			//删除附件表的关联信息
			attach.setRelationId(str[i]);
			attach.setStyle("lwglVo");
			int m=attachService.deleteAttach(attach);
			if(j>0&&m>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String pubLwgl(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			LwglVo lwglVo=new  LwglVo();
			lwglVo.setId(Integer.valueOf(str[i]));
			int j = xsjlService.pubLwgl(lwglVo);
			if(j>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String cancelAuditLwgl(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			LwglVo lwglVo=new  LwglVo();
			lwglVo.setId(Integer.valueOf(str[i]));
			int j = xsjlService.cancelAuditLwgl(lwglVo);
			if(j>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String cancelPubLwgl(){
		String[] str=arr.split(","); 
		JSONObject jo = new JSONObject();
		for (int i = 0; i < str.length; i++) {
			LwglVo lwglVo=new  LwglVo();
			lwglVo.setId(Integer.valueOf(str[i]));
			int j = xsjlService.cancelPubLwgl(lwglVo);
			if(j>0){
				jo.put("result", "success");
			}
		}
		this.jsonData=jo;
		return SUCCESS;
	}
	public String getOneLwgl(){
		this.jsonData=xsjlService.getOneLwgl(lwglVo);
		return SUCCESS;
	}
	public Object getJsonData() {
		return jsonData;
	}
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}
	public XsjlService getXsjlService() {
		return xsjlService;
	}
	public void setXsjlService(XsjlService xsjlService) {
		this.xsjlService = xsjlService;
	}
	public LwglVo getLwglVo() {
		return lwglVo;
	}
	public void setLwglVo(LwglVo lwglVo) {
		this.lwglVo = lwglVo;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		// page=Integer.toString((Integer.parseInt(page)-1)*(Integer.parseInt(rows)));
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	private int startRow() {
		return (this.page - 1) * this.rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
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
	
}
