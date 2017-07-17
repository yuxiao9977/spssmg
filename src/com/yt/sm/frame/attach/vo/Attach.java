package com.yt.sm.frame.attach.vo;

import java.io.Serializable;
/**
 * 附件实体类
 * 数据库表：CH_ATTACH
 * @author Administrator
 *
 */
public class Attach  implements Serializable{
	private static final long serialVersionUID = 1101938363774029641L;
	private Integer id;//主键
	private String relationId;//关联ID
	private String style;//分类
	private String fileName;//文件真名
	private String url;//文件物理名
	public Attach() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
