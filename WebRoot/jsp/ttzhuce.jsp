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
  		<script type="text/javascript" src="<%=path%>/js/ttzhuce.js"></script>
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
		<div class="" style="margin-left: 430px;margin-top: 30px;">
				<h1 style="color: blue;font-weight: bold;">团体会员注册</h1>
		</div>
		<div class="" style="margin-left: 120px;margin-top: 20px;">
			<a style="font-weight: bold;" id="down" href="#" onclick="ttzhuce.down();" >下载团体会员word模板</a>
		</div>
		<form id="formSub" action="" method="post" enctype="multipart/form-data" >
		<div class="bpanel bpanel-success clearbj"
			style="border:none;">
			<div class="bpanel-body">
				<div class="container-fluid" style="">
					<!-- 第一行 -->
					<div class="row">
						<div class="col-xs-1"></div>
						<div class="col-xs-5" style="">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:55px;">用户名</span> <input id="username"
									type="text" style="width: 250px;"  class="form-control">
							</div>
							
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:68px;">密码</span> <input id="pwd"
									type="password" style="width: 250px;" class="form-control">
							</div>
							

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">单位性质</span>
								<select id="dwxz" style="width: 250px;" class="form-control">
									<option value="1">事业</option>
									<option value="2">学校</option>
									<option value="3">社会团体</option>
									<option value="4">企业</option>
									<option value="5">部队</option>
								</select>
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">单位人数</span>
								<input id="dwrs" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">高级职称人数</span> <input
									id="gjzcrs" type="text" style="width: 250px;"
									class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">单位地址</span>
								<input id="dwdz" type="text" style="width: 250px;"
									class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:25px;">联系人姓名</span>
								<input id="lxrxm" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:68px;">传真</span>
								<input id="cz" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">测绘资质级别</span> <input id="chzzjb"
									style="width: 250px;" type="text" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:68px;">编号</span>
								<input id="bh" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:25px;">单位负责人</span>
								<input id="dwfzr" type="text" style="width: 250px;"
									class="form-control">
							</div>
						</div>
						<div class="col-xs-5">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:70px;">申请单位名称</span> <input id="sqdwmc"
									type="text" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon"  style="padding-right:98px;">确认密码</span> <input id="password"
									type="password" style="width: 250px;" class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">单位法人（或负责人）</span> <input
									id="dwfr" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">测绘学会理事姓名</span>
								<input id="chxhlsxm" type="text" style="width: 250px;"
									class="form-control">
							</div>

							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:40px;">其中：科技人员数</span>
								<input id="jsrys" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:68px;">中级职称人数</span>
								<input id="zjzcrs" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:125px;">邮编</span>
								<input id="yb" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:98px;">联系电话</span>
								<input id="lxdh" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:108px;">E-MAIL</span>
								<input id="em" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:98px;">入会时间</span>
								<input id="rhsj" type="text" style="width: 250px;"
									class="form-control">
							</div>
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon" style="padding-right:98px;">申请单位</span>
								<input id="sqdw" type="text" style="width: 250px;"
									class="form-control">
							</div>
						</div>
						<div class="col-xs-1"></div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:40px;">业务范围</span>
								<textarea id="ywfw" rows="6" style="width:90%"
									class="form-control"></textarea>
							</div>

						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:25px;">单位出版物</span>
								<textarea id="dwcbw" rows="1" style="width:90%"
									class="form-control"></textarea>

							</div>

						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">申请团体会员</span> <select id="sqtthy"
									style="width: 170px;" class="form-control">
									<option value="1">一般会员单位</option>
									<option value="2">理事会员单位</option>
									<option value="3">常务理事会员单位</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">学会审批意见</span>
								<textarea id="xhspyj" rows="6" style="width:90%"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon" style="padding-right:70px;">备注</span>
								<textarea id="bz" rows="3" style="width:90%"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-5">
							<div class="input-group" style="margin-top:5px">
								<span class="input-group-addon">学会审批时间</span> <input id="xhAuditdate"
									type="text" style="width: 250px;" class="form-control">
							</div>
						</div>
						<div class="col-xs-5">
							<div class="input-group" style="margin-top:5px;margin-left: 30px;">
								<span class="input-group-addon">填表时间</span> <input id="tbdate"
									type="text" style="width: 350px;" class="form-control">
							</div>
						</div>
						 <div class="col-xs-1" style="">
						</div>
					</div>
					<div class="row" style="margin-top:5px;margin-left: 75px;">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">上传文件</span> <input id="file"
									type="file" name="file" style="width:280px;" class="form-control">
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
			<button type="button" id="myButton" onclick="ttzhuce.register();" data-loading-text="提交中..." class="btn btn-primary" autocomplete="off">
  				注册
			</button>
		</div>
		</form>
	<!-- 个人信息面板 -->
		<!-- 友情链接结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>