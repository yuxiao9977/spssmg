<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>会员信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/hyxxgl.js"></script>
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
<body onload="hyxxgl.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<!-- 切换标签 -->
	<div style="margin-top:40px;margin-left:10px;margin-right:10px">
		<ul class="nav nav-tabs">
			<li class="active">
				<a href="#grxxgl" data-toggle="tab">个人会员</a>
			</li>
			<li>
				<a href="#ttxxgl"  data-toggle="tab">团体会员</a>
			</li>
		</ul>
	</div>
	<!-- 切换标签 结束 -->
	<div  class="tab-content">
		<div id="grxxgl"  class="tab-pane fade in active" style="border:none">
				<p style="margin-top:10px;margin-left:15px;margin-right:20px">
				信息搜索：
				</p>
				<div class="bpanel-body">
					<div class="row" >
						<div class="col-xs-3" >
							<div class="input-group">
								<span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;名</span>
								<input id="xm" style="width: 160px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-3">
							<div class="input-group">
								<span class="input-group-addon">本会职务</span>
								<input id="bhzw" style="width: 150px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-3">
							<!-- <div class="input-group">
								<span class="input-group-addon">审核状态</span>
								<select id="auditStatus" class="form-control">
									<option value="">请选择</option>
									<option value="1">待审核</option>
									<option value="2">已通过</option>
									<option value="3">未通过</option>
								</select>
							</div> -->
						</div>
						<div class="col-xs-3">
						</div>
					</div>
				</div>
				<div style="margin-left:10px;margin-right:10px">
					<div style="margin-top:8px">
						<table id="personList">
						</table>
					</div>
				</div>
			</div>
			<div id="ttxxgl"  class="tab-pane fade " style="border:none">
				<p style="margin-top:10px;margin-left:15px;margin-right:20px">
				信息搜索：
				</p>
				<div class="bpanel-body">
					<div class="row" >
						<div class="col-xs-4" >
							<div class="input-group">
								<span class="input-group-addon">申请单位名称</span>
								<input id="sqdwmc" style="width: 160px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-4">
							<div class="input-group">
								<span class="input-group-addon">单位法人</span>
								<input id="dwfr" style="width: 150px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-4" >
						</div>
					</div>
					<br/>
					<div class="row" >
						<div class="col-xs-4">
							<div class="input-group">
								<span class="input-group-addon">联系人姓名</span>
								<input id="lxrxm" style="width: 175px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-4">
							<!-- <div class="input-group">
								<span class="input-group-addon">审核状态</span>
								<select id="auditStatus2" style="width: 150px;" class="form-control">
									<option value="">请选择</option>
									<option value="1">待审核</option>
									<option value="2">已通过</option>
									<option value="3">未通过</option>
								</select>
							</div> -->
						</div>
						<div class="col-xs-4">
						</div>
					</div>
				</div>
				<div style="margin-left:10px;margin-right:10px">
					<div style="margin-top:8px">
						<table id="groupList">
						</table>
					</div>
				</div>
			</div>
	</div>
</body>
</html>