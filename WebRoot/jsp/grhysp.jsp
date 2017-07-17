<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>个人会员审批</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/grhysp.js"></script>
<style type="text/css">
* {
	font-size: 12px;
}
</style>
<script type="text/javascript">
    		var treeid = "<%=treeid%>";
    		var pid = "<%=pid%>";
 </script>
</head>
<body onload="grhysp.init()">
	<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<!-- 个人信息面板 -->
	<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 40px;">
		<div class="bpanel-body">
			<div class="container-fluid" style="">
				<!-- 第一行 -->
				<div class="row">
					<div class="col-xs-6">
					<input id="id" type="hidden"   class="form-control">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:55px;">姓名</span>
							<input id="xm" type="text" readonly="readonly" class="form-control">
						</div>
											
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:28px;">出生日期</span>
							<input id="csrq" type="text" readonly="readonly" class="form-control" >
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:55px;">民族</span>
							<input id="mz" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:28px;">文化程度</span>
							<input id="whcd" type="text" readonly="readonly" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:55px;">专业</span>
							<input id="zy" type="text" readonly="readonly" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:28px;">外语水平</span>
							<input id="wysp" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:28px;">工作单位</span>
							<input id="gzdw" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:28px;">通讯地址</span>
							<input id="txdz" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">何时入本会</span>
							<input id="hsrh" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:55px;">学历</span>
							<input id="xl" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:55px;">学位</span>
							<input id="xw" type="text" readonly="readonly" class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group" >
							<span class="input-group-addon" style="padding-right:40px;">性别</span>
							<input id="xb" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">籍贯</span>
							<input id="jg" type="text" readonly="readonly" class="form-control">
						</div>

						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">党派</span>
							<input id="dp" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">技术职称</span>
							<input id="jszc" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">专长</span>
							<input id="zc" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" >从事工作</span>
							<input id="xcsgz" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">职务</span>
							<input id="zw" type="text" readonly="readonly" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">电话</span>
							<input id="dh" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">本会职务</span>
							<input id="bhzw" type="text" readonly="readonly" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">毕业学校</span>
							<input id="byxx" type="text" readonly="readonly" class="form-control">
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:28px;">工作简历</span>
							<textarea id="gzjl" rows="6" readonly="readonly" style="width:100%" class="form-control"></textarea>
						</div>
				
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon">科研成果学术活动<br/><br/>参加其他学术团体情况</span>
							<textarea id="kycg" rows="6" readonly="readonly" style="width:100%" class="form-control"></textarea>
						</div>
				
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group" style="margin-top: 10px;" >
							<a class="btn btn-lg btn-success" onclick="grhysp.down()"  id="down"  >下载会员申请文件</a>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-6">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:40px;">审核状态:</span>
							<select id="auditStatus" style="width: 100px;"
									class="form-control">
									<option value="2">通过</option>
									<option value="3">不通过</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group">
							<span class="input-group-addon" >学会审批时间</span>
							<input id="xhAuditdate" type="text" readonly="readonly" class="form-control">
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" >学会审批意见</span>
							<textarea id="xhspyj" rows="6" style="width:100%"  class="form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:70px;">备注</span>
							<textarea id="bz" rows="3" style="width:100%"  class="form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
						<!-- <div class="col-xs-6">
							<div class="input-group">
								<span class="input-group-addon" >管理员审核时间</span>
							<input id="auditDate" type="text" readonly="readonly" class="form-control">
							</div>
						</div> -->
					<div class="col-xs-6">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:40px;">填表时间</span>
							<input id="tbdate" type="text" style="width: 40%;" readonly="readonly" class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<!-- <span class="input-group-addon">个人证书编号</span> -->
							<textarea id="grhyzsbh" rows="1" style="width:100%;display: none;"  class="form-control"></textarea>
						</div>
					</div>
				</div>
				<!-- 第一行 -->
			</div><!-- container-fluid -->
		</div><!-- panel-body -->
	</div><!-- panel panel-default -->
	<!-- 个人信息面板 -->
	<!-- 重置密码弹出 结束 -->
	<div style="height:35px;line-height:35px;width:100%;">
		<div style="float:left;width:50%;text-align:right;font-size:12px;padding-right:10px">
			<button id="updatePerson" class="btn btn-lg btn-success" style="font-weight:bold">保存</button>
			<button  onclick="javascript:window.location.href=path+'/jsp/hysqsp.jsp?treeid=7&pid=1'" class="btn btn-lg btn-success" style="font-weight:bold">返回</button>
		</div>
	</div>
</body>
</html>