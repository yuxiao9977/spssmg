<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User"%>
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
  		<script type="text/javascript" src="<%=path%>/js/grzhuce.js"></script>
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
									<a href="#" onclick="index.hydl();"  class="a1">会员登录</a> |<a href="#" id="zhuce"  class="a1"> 申请入会</a>
								<%
								}else{
								%>
									欢迎您<a href="#" onclick="index.houtai();"   class="a1"><%out.print(user.getUsername());%></a> |<a href="#" onclick="index.tuichu();" class="a1"> 退出</a>
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
			</div>
			
	        <nav class="navbar navbar-blue" style="margin:0px;background:url('<%=path%>/images/btl.jpg')">
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
	      <%@ include file="head.jsp"%>
		<div class="" style="margin-left: 430px;margin-top: 50px;">
				<h1 style="color: blue;font-weight: bold;">个人会员注册</h1>
		</div>
		<div class="" style="margin-left: 150px;margin-top: 10px;">
				<a style="font-weight: bold;" id="down" href="#" onclick="grzhuce.down();" >下载个人会员word模板</a>
		</div>
		<form id="formSub" action="" method="post" enctype="multipart/form-data" >
		<div class="bpanel bpanel-success clearbj"
			style="border:none;margin-left: 30px;">
			<div class="bpanel-body">
				<div class="container-fluid">
					<!-- 第一行 -->
					<div class="row">
					<div class="col-xs-1">
					</div>
						<div class="col-xs-5" >
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:40px;">用户名</span> <input id="username"
									type="text" style="width: 250px;"  class="form-control">
							</div>
							
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:55px;">密码</span> <input id="pwd"
									type="password" style="width: 250px;" class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">出生日期</span> <input id="csrq"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:55px;">民族</span> <input id="mz"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">文化程度</span> <input id="whcd"
									type="text" style="width: 250px;" class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:55px;">专业</span> <input id="zy"
									type="text" style="width: 250px;" class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">外语水平</span> <input id="wysp"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">工作单位</span> <input id="gzdw"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:55px;">学位</span> <input id="xw"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">何时入本会</span> <input id="hsrh"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:55px;">学历</span> <input id="xl"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">毕业学校</span> <input id="byxx"
									type="text" style="width: 250px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-5">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:40px;">姓名</span> <input id="xm"
									type="text" style="width: 250px;" class="form-control">
							</div>
							
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" >确认密码</span> <input id="password"
									type="password" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px" >
								<span class="input-group-addon" style="padding-right:40px;">性别</span>
								 <select id="xb" style="width: 250px;" class="form-control">
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">籍贯</span> <input id="jg"
									type="text" style="width: 250px;" class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">党派</span> <input id="dp"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">技术职称</span> <input id="jszc"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">专长</span> <input id="zc"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">从事工作</span> <input id="xcsgz"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">职务</span> <input id="zw"
									type="text" style="width: 250px;" class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">电话</span>
								 <input id="dh"type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">本会职务</span> <input id="bhzw"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">通讯地址</span> <input id="txdz"
									type="text" style="width: 250px;" class="form-control">
							</div>
						</div>
						 <div class="col-xs-1" style="">
						</div>
					</div>
					<!-- <div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:28px;">通讯地址</span> <input id="txdz"
									type="text" style="width:81%" class="form-control">
							</div>
						</div>
					</div> -->
					 <div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:28px;">工作简历</span>
								<textarea id="gzjl" rows="6" style="width:81%"
									class="form-control"></textarea>
							</div>

						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">科研成果学术活动<br />
								<br />参加其他学术团体情况</span>
								<textarea id="kycg" rows="6" style="width:79%"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">学会审批意见</span>
								<textarea id="xhspyj" rows="6" style="width:80%"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:70px;">备注</span>
								<textarea id="bz" rows="3" style="width:80%"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-5">
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">学会审批时间</span> <input id="xhAuditdate"
									type="text" style="width: 250px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-5">
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">填表时间</span> <input id="tbdate"
									type="text" style="width: 280px;" class="form-control">
							</div>
						</div>
						 <div class="col-xs-1" style="">
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 70px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">上传文件</span>
								 <input id="file" type="file" name="file" style="width: 280px;" class="form-control">
							</div>
							<div style="color:#ff0000;padding-top:5px;">文件格式：gif,jpg,jpeg,png,bmp;&nbsp;&nbsp;&nbsp;文件大小：30M以内</div>
						</div>
						
					</div>
					<!-- 第一行 -->
				</div>
				<!-- container-fluid -->
			</div>
			<!-- panel-body -->
		</div>
		<!-- panel panel-default -->
		<div class="" style="margin-left: 470px;margin-top: 10px;margin-bottom: 50px;">
			<button type="button" id="myButton" onclick="grzhuce.register();" data-loading-text="提交中..." class="btn btn-primary" autocomplete="off">
  				注册
			</button>
		</div>
		</form>
		<!-- 友情链接结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>