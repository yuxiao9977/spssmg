<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>学术论文审批</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/xslwspDetail.js"></script>
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
<body onload="xslwspDetail.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 40px;">
		<div class="bpanel-body">
			<div class="container-fluid" style="">
				<!-- 第一行 -->
				<div class="row">
					<div class="col-xs-12">
					<input id="id" type="hidden">
					<input id="userId" type="hidden">
						<div class="input-group" >
							<span class="input-group-addon">论文题目</span>
							<input id="lwtm" type="text" readonly="readonly"   class="form-control">
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 5px;">
					<div class="col-xs-12">
						<div class="input-group" >
							<span class="input-group-addon" >论文摘要</span>
							<textarea id="lwnr" rows="3" style="width:100%" readonly="readonly" class="form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 5px;">
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon" style="margin-top: 5px;">论文作者</span>
							<input id="lwzz" type="text" readonly="readonly"   class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon" style="margin-top: 5px;">作者单位</span>
							<input id="zzdw" type="text"  readonly="readonly"   class="form-control">
						</div>
					</div>
				</div>
				<!-- <div class="row" style="margin-top: 5px;">
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon">发布状态</span>
							<input id="pub" type="text" readonly="readonly"   class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon">发布时间</span>
							<input id="fbsj" type="text" readonly="readonly"   class="form-control">
						</div>
					</div>
				</div> -->
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" style="margin-top: 10px;" >
							<a class="btn btn-lg btn-success" onclick="xslwspDetail.down()"  id="down"  >下载论文</a>
						</div>
					</div>
				</div>
				<!-- 第一行 -->
			</div><!-- container-fluid -->
		</div><!-- panel-body -->
	</div><!-- panel panel-default -->
	<div class="bpanel bpanel-success clearbj" style="border:none">
		<div class="bpanel-heading clearbj" style="padding-left:10px;padding-top:5px;">
			<h5>审核信息</h5>
		</div>
		<div class="bpanel-body">
			<div class="container-fluid" style="">
				<!-- 第一行 -->
				
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" >
							<span class="input-group-addon">审核状态</span>
							<select id="auditstatus" style="width: 100px;"class="form-control">
									<option value="2" >通过</option>
									<option value="3">不通过</option>
							</select>
						</div>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" >
							<span class="input-group-addon">审核意见</span>
							<textarea id="auditidea" rows="3" style="width:100%" class="form-control"></textarea>
						</div>
					</div>
				</div>
				
			</div><!-- container-fluid -->
		</div><!-- panel-body -->
	</div><!-- panel panel-default -->
	 <div style="height:30px;line-height:35px;width:100%;">
		<div style="float:left;width:50%;text-align:right;font-size:12px;padding-right:10px">
			<button id="addLwgl" class="btn btn-lg btn-success" style="font-weight:bold">保存</button>
			<button  onclick="javascript:window.location.href=path+'/jsp/xslw.jsp?treeid=23&pid=4'" class="btn btn-lg btn-success" style="font-weight:bold">返回</button>
		</div>
	</div> 
</body>
</html>