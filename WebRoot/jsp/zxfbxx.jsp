<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePage.jsp"%>
    	<title>资讯发布列表</title>
    	<script type="text/javascript" src="<%=path%>/js/zxfbxx.js"></script>
    	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery/jquery.datetimepicker.css">
    	<script type="text/javascript" src="<%=path%>/jquery/jquery.datetimepicker.js"></script>
    	<style type="text/css">
    	</style>
    	<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    		var pid = "<%=pid%>";
    		var flag = "";//更新或添加
			var id = "";
    		var editor = null;
    		KindEditor.ready(function(K) {
    			editor = K.create('#kindcontent', {
					allowFileManager : true,
					cssPath:"<%=path%>/kindeditor/themes/qq/qq.css",
					filterMode:true,
					themeType:"common",
					uploadJson:"<%=path%>/kindeditor/jsp/upload_json.jsp",
					fileManagerJson:"<%=path%>/kindeditor/jsp/file_manager_json.jsp"
				});
				
				$('#fbsjinput').datetimepicker({
					//formatTime:'H:i',
					//formatDate:'Y',
					lang:'ch',
					format:'Y-m-d H:i',
					step:1
				});
				
    		});
    	</script>
	</head>
	<body style="overflow-x:hidden;overflow-y:auto;margin-right:5px;margin-left:5px" onload="zxfbxx.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
		
		<div class="input-group" style="margin-top:40px">
		  <span class="input-group-addon" style="padding-right:40px">标题</span>
		  <input class="form-control" id="ztinput"/>
		</div>
		
		<div class="row" style="margin-top:5px">
	       	<div class="col-xs-5" style="padding-right:8px;">
	       		<div class="input-group">
				  <span class="input-group-addon">发布单位</span>
				  <input id="fbdwinput" class="form-control" value="山东测绘学会"/>
				</div>
	       	</div>
	     	<div class="col-xs-5" style="padding-left:8px;">
	     		<div class="input-group" style="width:100%">
				  <span class="input-group-addon">发布时间</span>
				  <input id="fbsjinput" readonly class="form-control"/>
				</div>
	     	</div>
	     	<div class="col-xs-2" style="padding-left:0px;text-align:right">
	     		<button class="btn btn-primary" onclick="zxfbxx.saveZx()">
	     			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 保存
	     		</button>
	     		<button class="btn btn-danger" onclick="zxfbxx.clearForm()">
	     			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 清空
	     		</button>
	     	</div>
   		</div>
   		
   		<div style="margin-top:5px">
			<textarea id="kindcontent" style="width:100%;height:450px;visibility:hidden;"></textarea>
		</div>
		
	</body>
</html>