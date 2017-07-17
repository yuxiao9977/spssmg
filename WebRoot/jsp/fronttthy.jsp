<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
String treeid = request.getParameter("treeid");
Calendar c = Calendar.getInstance();
int currentYear = c.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePageFront.jsp"%>
  		<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/yxbootstrap.css">
  		<script type="text/javascript" src="<%=path%>/js/fronttthy.js"></script>
    	<title>山东省测绘地理信息学会欢迎您</title>
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
    	</style>
    	<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    	</script>
	</head>
	<body style="background:#eaeaea" onload="fronttthy.init()">
		<div class="mycontainer">
			<%@ include file="head.jsp"%>
	      	<!-- 第一行  -->
	      	<div style="overflow:auto;margin-top:10px">
		      	 <!-- <div class="col-xs-2" style="padding-left:10px;padding-right:0px">
		      		<div  id="cdgroup">
		      		<a><span class="glyphicon glyphicon-home"></span>首页</a>
		      		<a  style="">/学术论文</a>
		      		</div>
		      	</div>  -->
		      	<div class="col-xs-12" style="padding-left:20px;margin-top:10px;">
		      		<div  id="cdgroup" style="margin-bottom: 10px;">
		      		<a href="<%=request.getContextPath()%>/jsp/index.jsp"><span class="glyphicon glyphicon-home"></span>首页</a>
		      		<a href="<%=request.getContextPath()%>/jsp/fronttthy.jsp">/团体会员</a>
		      		</div>
		      		<div style="margin-left: 120px;margin-bottom: 20px;">
		      			<table>
		      				<tr>
		      					<td>
		      						<div class="input-group" style="margin-left: 50px;">
 									 <span class="input-group-addon" id="basic-addon1">申请单位名称</span>
 									 <input type="text" id="sqdwmc" class="form-control"  aria-describedby="basic-addon1">
									</div>
		      					</td>
		      					<td >
		      						<div class="input-group" style="margin-left: 30px;">
 									 <span class="input-group-addon" id="basic-addon1">联系人姓名</span>
 									 <input type="text" id="lxrxm" class="form-control" aria-describedby="basic-addon1">
									</div>
		      					</td>
		      					<!-- <td>
		      						<div class="input-group" style="margin-left: 30px;">
 									 <span class="input-group-addon" id="basic-addon1">本会职务</span>
 									 <input type="text" id="bhzw" class="form-control" aria-describedby="basic-addon1">
									</div>
		      					</td> -->
		      					<td>
		      						<div style="margin-left: 30px;">
		      						<button type="button" onclick="fronttthy.init();" class="btn btn-success">查询</button>
		      						</div>
		      					</td>
		      				</tr>
		      			</table>
		      		</div>
		      		<table id="zxTab" class="table table-hover" style="cursor:pointer">
		      		</table>
		      		<nav>
					  <ul class="pager" style="font-size:12px;">
					    <li class="previous"><a href="javascript:" onclick="fronttthy.syy()">上一页</a></li>
    					<li class="next"><a href="javascript:" onclick="fronttthy.xyy()">下一页 </a></li>
					  </ul>
					</nav>
		      	</div>
	      	</div>
	      	<!-- 第一行结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2000 - <%=currentYear%> 山东省测绘地理信息学会 All Rights Reserved.<br/>
				技术支持 山东易图信息技术有限公司
			</div>
	    </div>
	</body>
</html>