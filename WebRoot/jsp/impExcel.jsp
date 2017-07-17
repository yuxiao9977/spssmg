<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User"%>
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
    	<script type="text/javascript">
    	function impPerson(){
    		$.ajax({
			type:"POST",
			url:path+"/impData/impPersonExcel.action",
			data:{},
			async:true,
			dataType: 'json',
			success:function(data){
				
			}
			});
    	}
    	function impGroup(){
    		$.ajax({
			type:"POST",
			url:path+"/impData/impGroupExcel.action",
			data:{},
			async:true,
			dataType: 'json',
			success:function(data){
				
			}
			});
    	}
    	</script>
	</head>
	<body style="background:#eaeaea">
		<div class="mycontainer">
		<%@ include file="head.jsp"%>
		<div class="" style="margin-left: 400px;margin-top: 50px;margin-bottom: 100px;">
			<p class="lead" style="margin-left: 65px;">数据导入</p>
			<p>
				<a class="btn btn-lg btn-success" onclick="impPerson()" role="button">个人会员数据</a>
				<a class="btn btn-lg btn-success" onclick="impGroup()" role="button">团体会员数据</a>
			</p>
		</div>
		<!-- 友情链接结束 -->
			<div style="text-align:center;background:#f1f1f1;margin:0px 10px;padding:15px;font-size:12px">
				Copyright © 2016 山东省测绘地理信息学会 All Rights Reserved.<br/>
				版权所有 山东省济南市历城区二环东路3989号（250000）
			</div>
	    </div>
	</body>
</html>