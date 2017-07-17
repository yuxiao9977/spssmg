<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>论文投稿</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/lwtg.js"></script>
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
<body onload="lwtg.init();">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<!-- 个人信息面板 -->
	<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 40px;">
		<div class="bpanel-body">
			<div class="container-fluid" style="">
				<!-- 第一行 -->
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" >
							<span class="input-group-addon">论文题目</span>
							<input id="lwtm" type="text"   class="form-control">
						</div>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" >
							<span class="input-group-addon">论文摘要</span>
							<textarea id="lwnr" rows="6"  style="width:100%;"  class="form-control"></textarea>
						</div>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon">论文作者</span>
							<input id="lwzz" type="text"  class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon">作者单位</span>
							<input id="zzdw" type="text"   class="form-control">
						</div>
					</div>
					<!-- <div class="col-xs-4">
						<div class="input-group" >
							<span class="input-group-addon">发布时间</span>
							<input id="fbsj" type="text"   class="form-control">
						</div>
					</div> -->
				</div>
				<br/>
				<form id="formSub"  method="post" enctype="multipart/form-data" >
				<div class="row">
					<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">上传文件</span>
								 <input id="file" type="file" name="file" style="width: 250px;" class="form-control">
							</div>
							<div style="color:#ff0000;padding-top:5px;">文件格式：doc,docx,pdf,txt;&nbsp;&nbsp;&nbsp;文件大小：30M以内</div>
					</div>
				</div>
				</form>
				<!-- 第一行 -->
			</div><!-- container-fluid -->
		</div><!-- panel-body -->
	</div><!-- panel panel-default -->
	<div style="height:30px;line-height:35px;width:100%;">
		<div style="float:left;width:50%;text-align:right;font-size:12px;padding-right:10px">
			<button onclick="lwtg.addLwgl()" class="btn btn-lg btn-success" style="font-weight:bold">保存论文</button>
		</div>
	</div>
</body>
</html>