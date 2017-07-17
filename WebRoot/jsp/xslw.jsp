<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>学术论文</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
	<script type="text/javascript" src="<%=path%>/js/admin.js"></script>
<script type="text/javascript" src="<%=path%>/js/xslw.js"></script>
<style type="text/css">
* {
	font-size: 12px;
}
</style>
<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    		var pid = "<%=pid%>";
 </script>
</head>
<body onload="xslw.init();">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
		<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 40px;">
			<div class="bpanel-body">
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon">论文题目</span>
							<input id="lwtm" style="width: 630px;" class="form-control">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="margin-left:10px;margin-right:10px">
			<div style="margin-top:8px">
				<table id="lwglList">
				</table>
			</div>
		</div>
</body>
</html>