package com.yt.sm.frame.xtgl.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yt.sm.frame.hygl.vo.User;
import com.yt.sm.frame.xtgl.service.XtService;

public class XtAction extends ActionSupport implements ServletRequestAware, 
	ServletResponseAware,ServletContextAware {
	
	private static final long serialVersionUID = 8991806056890511810L;
	private Logger logger = Logger.getLogger(XtAction.class);
	
	private XtService xtService;
	protected Object jsonData;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext context;
	private String treeid;//树节点id
	private String pid;//父ID
	private String id;//ID
	private String btmc;//标题名称
	private String zxnr;//资讯内容
	private String fbdw;//发布单位
	private String fbsj;//发布时间
	private String lx;//类型
	private String zt;//状态
	
	private int page;//页数
	private int rows;//行数
	
	/**
	 * 查询菜单名称
	 * @return
	 */
	public String getMenuByIds() {
		this.jsonData = xtService.getMenuByIds(treeid, pid);
		return SUCCESS;
	}
	
	/**
	 * 添加资讯
	 * @return
	 */
	public String addZx() {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("btmc", btmc);
		map.put("zxnr", zxnr);
		map.put("fbdw", fbdw);
		map.put("fbsj", fbsj);
		map.put("lx", lx);
		map.put("zt", zt);
		map.put("cjr", user.getUsername());
		xtService.addZx(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 更新资讯
	 * @return
	 */
	public String updZx() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("btmc", btmc);
		map.put("zxnr", zxnr);
		map.put("fbdw", fbdw);
		map.put("fbsj", fbsj);
		map.put("id", id);
		xtService.updZx(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 更新资讯状态
	 * @return
	 */
	public String updZxZt() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zt", zt);
		map.put("id", id);
		xtService.updZxZt(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 删除资讯
	 * @return
	 */
	public String delZxById() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		xtService.delZxById(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 查询资讯By类型
	 * @return
	 */
	public String getZxByLx() {
		this.jsonData = xtService.getZxByLx(lx);
		return SUCCESS;
	}
	
	/**
	 * 查询资讯ById
	 * @return
	 */
	public String getZxById() {
		this.jsonData = xtService.getZxById(id);
		return SUCCESS;
	}
	
	/**
	 * 查询资讯分页
	 * @return
	 */
	public String getZxByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lx", lx);
		map.put("btmc", btmc);
		map.put("zt", zt);
		map.put("startRow", startRow());
		map.put("rows", rows);
		this.jsonData = xtService.getZxByPage(map);
		return SUCCESS;
	}
	
	/**
	 * 查询资讯总数
	 * @return
	 */
	public String getZxTotal() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lx", lx);
		map.put("btmc", btmc);
		map.put("zt", zt);
		JSONObject jo = new JSONObject();
		jo.put("total", xtService.getZxTotal(map));
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 查询新闻图片
	 * @return
	 */
	public String getXwtpList() {
		this.jsonData = xtService.getXwtpList();
		return SUCCESS;
	}
	
	/**
	 * 添加新闻图片
	 * @return
	 */
	public String addXwtp() {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tpmc", request.getParameter("tpmc"));
		map.put("tpms", request.getParameter("tpms"));
		map.put("tplj", request.getParameter("tplj"));
		map.put("url", request.getParameter("url"));
		map.put("cjr", user.getUsername());
		xtService.addXwtp(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 修改新闻图片
	 * @return
	 */
	public String updXwtp() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tpms", request.getParameter("tpms"));
		map.put("url", request.getParameter("url"));
		map.put("id", request.getParameter("id"));
		xtService.updXwtp(map);
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 删除新闻图片
	 * @return
	 */
	public String delXwtp() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", request.getParameter("id"));
		xtService.delXwtp(map);
		
		String filePath = request.getParameter("filePath").substring(1);
		String fullPath = this.context.getRealPath("/") + filePath;
		File file = new File(fullPath);
		if (file.exists()) {
			file.delete();
		}
		
		JSONObject jo = new JSONObject();
		jo.put("result", "success");
		this.jsonData = jo;
		return SUCCESS;
	}
	
	/**
	 * 查询友情链接
	 * @return
	 */
	public String getYqljList() {
		this.jsonData = xtService.getYqljList();
		return SUCCESS;
	}
	
	/**
	 * 查询菜单ByPid
	 * @return
	 */
	public String getMenuByPid() {
		this.jsonData = xtService.getMenuByPid();
		return SUCCESS;
	}
	
	public XtService getXtService() {
		return xtService;
	}
	public void setXtService(XtService xtService) {
		this.xtService = xtService;
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTreeid() {
		return treeid;
	}

	public void setTreeid(String treeid) {
		this.treeid = treeid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBtmc() {
		return btmc;
	}

	public void setBtmc(String btmc) {
		this.btmc = btmc;
	}

	public String getFbdw() {
		return fbdw;
	}

	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}

	public String getFbsj() {
		return fbsj;
	}

	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getZxnr() {
		return zxnr;
	}

	public void setZxnr(String zxnr) {
		this.zxnr = zxnr;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	private int startRow() {
		return (this.page - 1) * this.rows;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
}
