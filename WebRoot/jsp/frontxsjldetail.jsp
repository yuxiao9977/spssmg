<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User" import="com.yt.sm.frame.hygl.vo.Person" import="com.yt.sm.frame.hygl.vo.Group"%>
<%@ page import="java.util.Calendar"%>
<%
String path2 = request.getContextPath();
User user2=(User)session.getAttribute("user");
if(user2==null){
	response.sendRedirect(path2+"/jsp/login.jsp");
} 
String treeid = request.getParameter("treeid");
Calendar c = Calendar.getInstance();
int currentYear = c.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePageFront.jsp"%>
  		<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/yxbootstrap.css">
  		<script type="text/javascript" src="<%=path%>/js/frontxsjldetail.js"></script>
    	<title>山东省测绘地理信息学会欢迎您</title>
    	<style type="text/css">
    		.mycontainer {
    			width:1100px;margin:0px auto;background:#fff;
    		}
    		.a1 {
    			color:#fff;text-decoration: none;
    		}
    		.a1:hover{
    			color:#fff;text-decoration: underline;
    		}
    		.a1:FOCUS{
    			color:#fff;text-decoration: underline;
    		}
    	</style>
    	<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    	</script>
	</head>
	<body style="background:#eaeaea" onload="frontxsjldetail.init()">
		<div class="mycontainer">
			<%@ include file="head.jsp"%>
			<input type="hidden" id="id">
	      	<!-- 第一行  -->
	      	<div style="overflow:auto;margin-top:10px">
		      	 <!-- <div class="col-xs-2" style="padding-left:10px;padding-right:0px">
		      		<div  id="cdgroup">
		      		<a><span class="glyphicon glyphicon-home"></span>首页</a>
		      		<a  style="">/学术论文</a>
		      		</div>
		      	</div>  -->
		      	<div class="col-xs-12" style="padding-left:20px;margin-top: 10px;margin-bottom: 90px;">
		      		<div  id="cdgroup" style="margin-bottom: 10px;">
		      		<a href="<%=request.getContextPath()%>/jsp/index.jsp"><span class="glyphicon glyphicon-home"></span>首页</a>
		      		<a href="<%=request.getContextPath()%>/jsp/frontxsjl.jsp">/学术论文</a>/正文
		      		</div>
		      		<div id="btDiv" style="font-weight:bold;font-size:25px;text-align:center"></div>
		      		<div id="fbtDiv" style="font-size:12px;text-align:center;color:#999"></div>
		      		<div id="lwnr" style="font-size:16px;text-align:center;margin-top: 20px;margin-left: -800px;"></div>
		      		<div style="text-align:center;font-weight: bold;font-size:20px;margin-top: 10px;" >
							<a onclick="frontxsjldetail.down()">点击下载全篇论文</a>
					</div>
		      	</div>
	      	</div>
	      	<!-- 第一行结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>