<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="includePage.jsp"%>
    <title>登录</title>
	<style type="text/css">
	</style>
  	<script type="text/javascript">
  	 function checkUser() {
  	 	$.ajax({
			type:"POST",
			url:path+"/xtgl/xt/checkLogin.action",
			data:{userid:$("#userid").val(),password:$("#password").val()},
			async:true,
			dataType:"json",
			success:function(data) {
				if (data.result == "success") {
					alert("登录成功");
				} else {
					alert("登录失败");
				}
			}
		});
  	 }
  	 $(document).ready(function() {
  	 	$("#pdiv").css({
  	 		"margin-left":($(window).width() - 500) * 0.5,
  	 		"margin-top":10
  	 	});
  	 });
  	</script>
  </head>
  <body onload="init()">
  	<div id="pdiv">
  		<div class="easyui-panel" title="易图运维管理 -- 用户登录" data-options="iconCls:'icon-yt-logo16'"
  			style="width:460px;height:160px;text-align:center;padding-top:20px">
  			<div style="height:25px">
  				<input class="easyui-textbox" id="userid" style="width:330px"
  					data-options="prompt:'输入用户名',iconCls:'icon-yt-user',iconAlign:'left'">
  			</div>
  			<div style="height:25px">
  				<input class="easyui-textbox" type="password" id="password" style="width:330px"
  					data-options="prompt:'输入密码',iconCls:'icon-yt-lock',iconAlign:'left'">
  			</div>
  			<a href="#" style="width:330px;font-weight:bold" class="easyui-linkbutton" onclick="checkUser()">登录</a>
  		</div>
  	</div>
  </body>
</html>
