<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
String treeid = request.getParameter("treeid");
String zxid = request.getParameter("zxid");
Calendar c = Calendar.getInstance();
int currentYear = c.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePageFront.jsp"%>
  		<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/yxbootstrap.css">
  		<script type="text/javascript" src="<%=path%>/js/zxdetail.js"></script>
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
    		var zxid = "<%=zxid%>";
    	</script>
	</head>
	<body style="background:#eaeaea" onload="zxdetail.init()">
		<div class="mycontainer">
			<%@ include file="head.jsp"%>
	      	<!-- 第一行  -->
	      	<div style="overflow:auto;margin-top:10px">
		      	<div class="col-xs-2" style="padding-left:10px;padding-right:0px">
		      		<div class="list-group" id="cdgroup"></div>
		      	</div>
		      	<div class="col-xs-10" style="padding-right:10px;padding-left:10px">
		      		<ol class="breadcrumb" id="cdol"></ol>
		      		<div id="btDiv" style="font-weight:bold;font-size:25px;text-align:center"></div>
		      		<div id="fbtDiv" style="font-size:12px;text-align:center;color:#999"></div>
		      		<hr/>
		      		<div id="zwDiv"></div>
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