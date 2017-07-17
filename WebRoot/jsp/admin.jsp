<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User" import="com.yt.sm.frame.hygl.vo.Person" import="com.yt.sm.frame.hygl.vo.Group"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePage.jsp"%>
    	<title>山东省测绘学会管理平台</title>
    	<script type="text/javascript" src="<%=path%>/js/admin.js"></script>
    	<style type="text/css">
    	.a1 {
    			color:#fff;text-decoration: none;
    		}
    	</style>
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#dhcd").css("height",$(window).height()-83);
    			$("#contentFrame").css("height",$(window).height()-83);
    		});
    	</script>
	</head>
	<body style="overflow:hidden;" onload="admin.init()">
		<nav class="navbar navbar-inverse navbar-fixed-top" style="height:81px;background:#47a3d4;">
			<div class="col-xs-6" style="padding-left:0px">
				<img src="<%=path%>/images/logobj2.jpg"/>
			</div>
			<div class="col-xs-6" style="text-align:right;padding-top:10px;font-family:'微软雅黑';
			color:#fff;font-weight:bold;font-size:13px;">
								<%
								User user1=(User)session.getAttribute("user");
								Person person1=(Person)session.getAttribute("person");
								Group group1=(Group)session.getAttribute("group");
								if(user1!=null){
								%>
								<a href="#" onclick="admin.shouye();"   class="a1">首页|</a>
								<%
								if(person1!=null){
								out.print("您好,"+person1.getXm());
								}
								if(group1!=null){
								out.print("您好,"+group1.getSqdwmc());
								}
								%>
								<a href="#" onclick="admin.tuichu();"   class="a1">|退出</a>
								<%
								}
								%>
								
			</div>
		</nav>
		
   		<div class="row" style="margin-top:83px;">
	       	<div id="dhcd" class="col-xs-3" style="overflow:auto;height:300px;padding-right:0px">
	       	</div>
	     	<div class="col-xs-9" style="padding-left:0px;">
	     		<iframe src="<%=path %>/jsp/fuzhu.jsp" id="contentFrame" name="contentFrame" style="border:none" width="100%"></iframe>
	     	</div>
   		</div>
		
	</body>
</html>