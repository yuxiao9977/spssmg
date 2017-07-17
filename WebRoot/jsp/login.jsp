<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
Calendar c = Calendar.getInstance();
int currentYear = c.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePageFront.jsp"%>
  		<script type="text/javascript" src="<%=path%>/js/index.js"></script>
    	<title>山东省测绘地理信息学会欢迎您</title>
    	<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/yxbootstrap.css">
    	<style type="text/css">
    		.mycontainer {
    			width:1100px;margin:0px auto;background:#fff
    		}
    		.a1 {
    			color:#fff;text-decoration: none;
    		}
    		.a1:hover{
    			color:#fff;text-decoration: underline;
    		}
    		.yqtab {
    			width:100%;margin-top:10px;
    		}
    		.yqtab td {
    			background:#e9e9e9;text-align:center;padding:5px;width:1px
    		}
    	</style>
	</head>
	<body style="background:#eaeaea">
		<div class="mycontainer">
		<%@ include file="./head.jsp"%>
			<%-- <div style="height:140px;background:url('<%=path%>/images/logol.jpg');">
				<div class="col-xs-6" style="padding-left:20px;height:80px;line-height:80px">
				</div>
				<div class="col-xs-6">
					<table style="float:right;margin-top:15px">
						<tr>
							<td style="text-align:right;font-family:'微软雅黑';color:#fff;font-weight:bold;font-size:13px;">
								<%
								User user=(User)session.getAttribute("user");
								if(user==null){
								%>
									<a href="#" id="hydl"  class="a1">会员登录</a> |<a href="<%=path%>/jsp/fuzhu2.jsp"   class="a1"> 申请入会</a>
								<%
								}else{
								%>
									欢迎您<a href="#" onclick="index.houtai();"   class="a1"><%out.print(user.getUsername());%></a> |<a href="#" onclick="index.tuichu();"   class="a1"> 退出</a>
								<%
								}
								 %>
							</td>
						</tr>
						<!-- 
						<tr>
							<td>
								<input class="easyui-searchbox" style="width:198px" 
								data-options="prompt:''"/>
							</td>
						</tr>
						-->
					</table>
				</div>
			</div> --%>
			
	        <%-- <nav class="navbar navbar-blue" style="margin:0px;background:url('<%=path%>/images/btl.jpg')">
	        	<div class="container-fluid" style="padding-left:0px;">
		        	<ul class="nav navbar-nav">
		            	<li class="active"><a href="#">首页</a></li>
		            	<li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">学会概要 <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				            <li><a href="#">学会简介</a></li>
				            <li><a href="#">学会领导</a></li>
				            <li><a href="#">学会章程</a></li>
				            <li><a href="#">理事名单</a></li>
				          </ul>
				        </li>
		            	<li><a href="#">通知公告</a></li>
		            	<li><a href="#">学会动态</a></li>
		            	<li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">学术交流 <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				            <li><a href="#">学术论文</a></li>
				            <li><a href="#">论文投稿</a></li>
				          </ul>
				        </li>
		            	<li><a href="#">行业新闻</a></li>
		            	<li><a href="#">联系我们</a></li>
		        	</ul>
	        	</div>
	      	</nav> --%>
	      	<div class="container" style="width: 40%;margin-left: 330px;margin-bottom: 100px;margin-top: 30px;">
		        <h4 class="form-signin-heading" style="font-weight: bold;">会员登录</h4>
		        <input style="border:none;height:0px"/>
		        <input type="text" id="username" class="form-control" placeholder="用户名" autocomplete="off">
		        <input style="border:none;height:0px"/>
		        <input type="password" id="password" class="form-control" placeholder="密码" autocomplete="off">
		        <br>
		        <button class="btn btn-lg btn-primary btn-block" onclick="index.login()">登录</button>
    		</div>
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>