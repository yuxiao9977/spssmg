<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
  		<%@ include file="../includePage.jsp"%>
    	<title>友情链接列表</title>
    	<script type="text/javascript" src="<%=path%>/jquery/jquery.form.js"></script>
    	<script type="text/javascript" src="<%=path%>/js/tplb.js"></script>
    	<style type="text/css">
    	</style>
    	<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    		var pid = "<%=pid%>";
    	</script>
	</head>
	<body style="overflow-x:hidden;overflow-y:auto;margin-right:5px;margin-left:5px" onload="zxfblb.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
		<div style="margin-top:40px">
			<table id="zxList"></table>
		</div>
		
		<div id="tpgladd" class="easyui-dialog" title="添加图片" style="width:500px;height:370px;" data-options="closed:'true',buttons:[{
   			text:'上传',
   			iconCls:'icon-add',
   		    handler:function() {
   		    	zxfblb.addZx();
   		    }
   		}]">
			<div style="padding-left:40px;padding:30px">
				<form id="theForm" enctype="multipart/form-data">
				  	<input id="file1" class="easyui-filebox" name="file" data-options="label:'选择图片',buttonText:'浏览...',buttonIcon:'ch-icon-picture'" style="width:400px"/>
				  	<div style="padding-left:80px;color:#0000ff">
				  		格式gif,jpg,jpeg,png,bmp&nbsp;&nbsp;不超过30M&nbsp;&nbsp;尺寸733*300像素
				  	</div>
				  	<br/>
				  	<input id="tpurl" class="easyui-textbox" data-options="label:'链接地址'" style="width:400px"/><br/><br/>
				  	<input id="tpms" class="easyui-textbox" data-options="multiline:'true',height:80,label:'图片描述'" style="width:400px"/><br/><br/>
			  	</form>
			  	<div id="addtip" style="color:#ff0000"></div>
		  	</div>
		</div>
		
		<div id="tpgledit" class="easyui-dialog" title="修改图片" style="width:500px;height:300px;" data-options="closed:'true',buttons:[{
 			text:'保存',
 			iconCls:'icon-save',
 		    handler:function() {
 		    	zxfblb.updZx();
 		    }
 		}]">
			<div style="padding-left:40px;padding:30px">
			  	<input id="tpurlupd" class="easyui-textbox" data-options="label:'链接地址'" style="width:400px"/><br/><br/>
			  	<input id="tpmsupd" class="easyui-textbox" data-options="multiline:'true',height:80,label:'图片描述'" style="width:400px"/><br/><br/>
		  		<div id="updtip" style="color:#ff0000"></div>
		  	</div>
		</div>
		
	</body>
</html>