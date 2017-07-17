<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User"%>
<%@ page import="java.util.Calendar"%>
<%
if (request.getServerName().contains("schoolmate")) {
	response.sendRedirect("http://www.sdpssmg.org");
}
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
    			width:1100px;margin:0px auto;background:#fff;
    		}
    		.a1 {
    			color:#fff;text-decoration: none;
    		}
    		.a1:hover{
    			color:#fff;text-decoration: underline;
    		}
    		.a1:FOCUS{
    			color:#fff;text-decoration: underline;
    		}
    		.yqtab {
    			width:1080px;margin-top:10px;
    		}
    		.yqtab td {
    			background:#e9e9e9;text-align:center;padding:5px;width:180px;
    		}
    		.letter-short {
				width:270px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;
			}
    	</style>
	</head>
	<body style="background:#eaeaea" onload="index.init()">
		<div class="mycontainer">
			<%@ include file="head.jsp"%>
	      	<!-- 第一行  -->
	      	<div style="overflow:hidden;height:300px;margin-top:10px">
		      	<div class="col-xs-8" style="padding:0px">
		      		<!-- 图片轮播 -->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<ol id="lbol" class="carousel-indicators"></ol>
						<div id="lbdiv" class="carousel-inner" role="listbox"></div>
						<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						</a>
					</div>
					<!-- 图片轮播 结束-->
		      	</div>
		      	<div class="col-xs-4" style="padding-right:0px;padding-left:10px;height:300px">
		      		<div class="bpanel bpanel-primary">
						<div class="bpanel-heading" style="background:url('<%=path%>/images/xbtl.jpg')">
						<span class="glyphicon glyphicon-bell"></span> 通知公告</div>
						<div class="bpanel-body" style="height:257px;padding:0px;font-size:12px" id="tzggPanel">
						</div>
					</div>
		      	</div>
	      	</div>
	      	<!-- 第一行结束 -->
	      	
	      	<!-- 第二行 -->
	      	<div style="overflow:hidden;height:300px;margin-top:10px">
		      	<div class="col-xs-4" style="padding-left:0px;padding-right:10px">
		      		<div class="bpanel bpanel-primary">
					  <div class="bpanel-heading" style="background:url('<%=path%>/images/xbtl.jpg')">
					  <span class="glyphicon glyphicon-stats"></span> 学会动态</div>
					  <div class="bpanel-body" style="height:257px;padding:0px;font-size:12px" id="xhdtPanel">
					  </div>
					</div>
		      	</div>
		      	<div class="col-xs-4" style="padding-left:0px;padding-right:0px">
		      		<div class="bpanel bpanel-primary">
					  <div class="bpanel-heading" style="background:url('<%=path%>/images/xbtl.jpg')">
					  <span class="glyphicon glyphicon-th"></span> 行业新闻</div>
					  <div class="bpanel-body" style="height:257px;padding:0px;font-size:12px" id="hyxwPanel">
					  </div>
					</div>
		      	</div>
		      	<div class="col-xs-4" style="padding-left:10px;padding-right:0px">
		      		<div class="bpanel bpanel-primary">
					  <div class="bpanel-heading" style="background:url('<%=path%>/images/xbtl.jpg')">
					  <span class="glyphicon glyphicon-th-list"></span> 政策法规</div>
					  <div class="bpanel-body" style="height:257px;padding:0px;font-size:12px" id="zcfgPanel">
					  </div>
					</div>
		      	</div>
			</div>
			<!-- 第二行结束 -->
			
			<!-- 友情链接 -->
			<div style="margin:10px;margin-bottom:20px;">
				<span style="color:#336699;font-weight:bold">友情链接</span>
				<table class="yqtab" id="yqljTab"></table>
			</div>
			<!-- 友情链接结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>