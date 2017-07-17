package com.yt.sm.frame.attach.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.attach.service.AttachService;
import com.yt.sm.frame.attach.vo.Attach;

public class AttachAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware {
	private static final long serialVersionUID = -1435900648319546372L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Object jsonData;
	private AttachService attachService ;
	private Attach attach=new Attach();
	public String getOneAttach(){
		this.jsonData=attachService.getOneAttach(attach);
		return SUCCESS;
	}
	public String findAttach(){
		this.jsonData=attachService.findAttach(attach);
		return SUCCESS;
	}
	public Object getJsonData() {
		return jsonData;
	}
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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
