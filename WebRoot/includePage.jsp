<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User"%>
<%
StringBuffer pathBuffer = new StringBuffer("").append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());
String path = pathBuffer.toString();
 User user=(User)session.getAttribute("user");
if(user==null){
response.sendRedirect(path+"/jsp/login.jsp");
//request.getRequestDispatcher(path+"/jsp/login.jsp").forward(request, response);
} 
%>
<meta charset="utf-8">
<!-- 
<meta name="viewport" content="width=device-width, initial-scale=1">
 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!-- jquery 1.11.3 -->
<script type="text/javascript" src="<%=path%>/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/jquery/jquery.form.js"></script>
<!-- datetime -->
<link rel="stylesheet" type="text/css" href="<%=path%>/jquery/jquery.datetimepicker.css">
<script type="text/javascript" src="<%=path%>/jquery/jquery.datetimepicker.js"></script>
<!-- bootstrap3.3.5 本地 -->
<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/mybootstrap.css">
<script type="text/javascript" src="<%=path%>/bootstrap/js/mybootstrap.js"></script>
<!-- 兼容IE8 -->
<script type="text/javascript" src="<%=path%>/bootstrap/js/response.min.js"></script>
<script type="text/javascript" src="<%=path%>/bootstrap/js/html5.min.js"></script>
<!-- kindeditor -->
<link rel="stylesheet" type="text/css" href="<%=path%>/kindeditor/themes/default/default.css">
<script type="text/javascript" src="<%=path%>/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="<%=path%>/kindeditor/zh-CN.js"></script>
<!-- easyui1.4.4 -->
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui1.5/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui1.5/themes/icon.css">
<script type="text/javascript" src="<%=path%>/easyui1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/easyui1.5/locale/easyui-lang-zh_CN.js"></script>
<link rel="Shortcut Icon" type="image/x-icon" href="<%=path%>/images/sdchlogo16.png">
<style type="text/css">
	.ch-icon-ok{
		background:url('<%=path%>/images/icons/accept.png') no-repeat center center;
	}
	.ch-icon-edit{
		background:url('<%=path%>/images/icons/note_edit.png') no-repeat center center;
	}
	.ch-icon-cancel{
		background:url('<%=path%>/images/icons/delete.png') no-repeat center center;
	}
	.ch-icon-delete{
		background:url('<%=path%>/images/icons/no.png') no-repeat center center;
	}
	.ch-icon-delete{
		background:url('<%=path%>/images/icons/no.png') no-repeat center center;
	}
	.ch-icon-upload{
		background:url('<%=path%>/images/icons/arrow_up.png') no-repeat center center;
	}
	.ch-icon-picture{
		background:url('<%=path%>/images/icons/picture.png') no-repeat center center;
	}
	
</style>
<!-- 全局 JS -->
<script type="text/javascript">
	var path = "<%=path%>";
	var common = {};
	common.alert = function(message) {
		$.messager.alert('信息', message);
	};
	common.confirm = function(message, callback, prame){
		$.messager.confirm('消息', message, function(r){
			if (r) {
				if (prame == null) {
					callback();
				} else {
					callback(prame);
				}
			};
		});
	};
</script>
<style type="text/css">
	.icon-yt-logo16 {
		background:url('<%=path%>/images/logo16.png') no-repeat center center;
	}
	.icon-yt-logo32 {
		background:url('<%=path%>/images/logo32.png') no-repeat center center;
	}
	.icon-yt-user {
		background:url('<%=path%>/images/icons/user.png') no-repeat center center;
	}
	.icon-yt-lock {
		background:url('<%=path%>/images/icons/lock.png') no-repeat center center;
	}
	.icon-yt-book{
		background:url('<%=path%>/images/icons/book.png') no-repeat center center;
	}
	.icon-yt-bookopen{
		background:url('<%=path%>/images/icons/book_open.png') no-repeat center center;
	}
	.icon-yt-add{
		background:url('<%=path%>/images/icons/add.png') no-repeat center center;
	}
	.icon-yt-delete{
		background:url('<%=path%>/images/icons/cancel.png') no-repeat center center;
	}
	.icon-yt-cancel{
		background:url('<%=path%>/images/icons/delete.png') no-repeat center center;
	}
	.icon-yt-refresh{
		background:url('<%=path%>/images/icons/arrow_refresh.png') no-repeat center center;
	}
	.icon-yt-information{
		background:url('<%=path%>/images/icons/information.png') no-repeat center center;
	}
	.icon-yt-impdata{
		background:url('<%=path%>/images/icons/database_go.png') no-repeat center center;
	}
	.icon-yt-adddata{
		background:url('<%=path%>/images/icons/database_add.png') no-repeat center center;
	}
	.icon-yt-update{
		background:url('<%=path%>/images/icons/calendar_edit.png') no-repeat center center;
	}
	.icon-yt-audit{
		background:url('<%=path%>/images/icons/stop.png') no-repeat center center;
	}
	.icon-yt-excel{
		background:url('<%=path%>/images/icons/execlicon.gif') no-repeat center center;
	}
</style>