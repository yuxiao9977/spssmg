<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePage.jsp"%>
    	<title>友情链接列表</title>
    	<script type="text/javascript" src="<%=path%>/js/yqljlb.js"></script>
    	<style type="text/css">
    	</style>
    	<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    		var pid = "<%=pid%>";
    	</script>
	</head>
	<body style="overflow-x:hidden;overflow-y:auto;margin-right:5px;margin-left:5px" onload="zxfblb.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
		<div style="margin-top:40px">
			<table id="zxList"></table>
		</div>
		
		<div id="ljgl" class="easyui-dialog" style="width:500px;height:260px;" data-options="closed:'true'">
			<div style="padding-left:40px;padding-top:30px">
		    	<input id="mcinput" class="easyui-textbox" data-options="width:400,label:'链接名称',labelPosition:'top'">
		    </div>
		    <div style="padding-left:40px;padding-top:10px">
		    	<input id="ljinput" class="easyui-textbox" data-options="width:400,label:'链接地址',labelPosition:'top'">
			</div>
			<div id="tipdiv" style="padding-left:40px;padding-top:5px;color:#ff0000"></div>
		</div>
		
	</body>
</html>