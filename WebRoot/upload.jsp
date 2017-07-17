<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.json.simple.*" %>
<%

/**
 * KindEditor JSP
 * 
 * 本JSP程序是演示程序，建议不要直接在实际项目中使用。
 * 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
 * 
 */

String fileType = request.getParameter("fileType");
//System.out.println("--------------------->:"+fileType);

//文件保存目录路径
String savePath = pageContext.getServletContext().getRealPath("/") + "upload/";
//文件保存目录URL
String saveUrl  = request.getContextPath() + "/upload/";

//System.out.println(savePath);
//System.out.println(saveUrl);
String fn = "";//原文件名

//定义允许上传的文件扩展名
HashMap<String, String> extMap = new HashMap<String, String>();
extMap.put("image", "gif,jpg,jpeg,png,bmp");//图片
extMap.put("lw", "doc,docx,pdf,txt");//论文

//最大文件大小
long maxSize = 31000000;

response.setContentType("text/html;charset=UTF-8");

FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setHeaderEncoding("UTF-8");
List items = upload.parseRequest(request);
Iterator itr = items.iterator();
while (itr.hasNext()) {
	FileItem item = (FileItem) itr.next();
	String fileName = item.getName();
	long fileSize = item.getSize();
	if (!item.isFormField()) {
		//检查文件大小
		if(item.getSize() > maxSize) {
			out.println(getError("上传文件大小超过限制。最大30M"));
			return;
		}
		fn = fileName.substring(fileName.lastIndexOf("/") + 1);
		//检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!Arrays.<String>asList(extMap.get(fileType).split(",")).contains(fileExt)) {
			out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(fileType) + "格式。"));
			return;
		}

		String newFileName = UUID.randomUUID().toString() + "." + fileExt;
		try{
			File uploadedFile = new File(savePath, newFileName);
			item.write(uploadedFile);
		}catch(Exception e){
			out.println(getError("上传文件失败。"));
			return;
		}

		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("message", "上传成功");
		obj.put("url", "/upload/" + newFileName);
		obj.put("fn", fn);//原文件名
		out.println(obj.toJSONString());
	}
}
%>
<%!
private String getError(String message) {
	JSONObject obj = new JSONObject();
	obj.put("error", 1);
	obj.put("message", message);
	return obj.toJSONString();
}
%>