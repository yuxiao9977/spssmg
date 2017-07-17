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
    	<script type="text/javascript" src="<%=path%>/js/zxfblb.js"></script>
    	<style type="text/css">
    		.tab1 {
				border-collapse: collapse;
			}
			.tab1 td {
				padding:0px 4px;
			}
			select {
				height:25px;
			}
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
			<div class="easyui-panel" style="overflow:hidden;width:100%;height:47px;padding:10px;margin-bottom:10px">
				<table class="tab1">
					<tr>
						<td>标题</td><td style="padding-right:30px"><input id="btmcinput" style="height:25px"/></td>
						<td>发布状态</td>
						<td style="padding-right:30px">
							<select id="fbztselect" >
								<option value="">全部</option>
								<option value="0">未发布</option>
								<option value="1">发布中</option>
							</select>
						</td>
						<td>
							<a href="javascript:" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="zxfblb.search()">查询</a>
						</td>
					</tr>
				</table>
			</div>
			<table id="zxList"></table>
		</div>
		
	</body>
</html>