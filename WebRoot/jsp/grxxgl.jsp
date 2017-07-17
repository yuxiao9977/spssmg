<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>个人信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/grxxgl.js"></script>
<style type="text/css">
* {
	font-size: 12px;
}
/* #div1{
	position:fixed;z-index:2;left:125px;top:420px;
} */
</style>
<script type="text/javascript">
    var treeid = "<%=treeid%>";
    var pid = "<%=pid%>";

</script>
</head>
<body onload="grxxgl.init()">
		<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<!-- 个人信息面板 -->
	<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 45px;">
		<div class="bpanel-body">
			<div class="container-fluid">
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon">个人证书编号</span>
							<input id="grhyzsbh" type="text" style="width:100%" readonly="readonly"  class="form-control"/>
						</div>
					</div>
				</div>
				<!-- 第一行 -->
				<div class="row">
					<div class="col-xs-6">
					<input id="id" type="hidden"   class="form-control">
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:67px;">姓名</span>
							<input id="xm" type="text"  class="form-control">
						</div>
											
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">出生日期</span>
							<input id="csrq" type="text" class="form-control" >
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:67px;">民族</span>
							<input id="mz" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">文化程度</span>
							<input id="whcd" type="text" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:67px;">专业</span>
							<input id="zy" type="text" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">外语水平</span>
							<input id="wysp" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">工作单位</span>
							<input id="gzdw" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:66px;">学位</span>
							<input id="xw" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:26px;">何时入本会</span>
							<input id="hsrh" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:67px;">学历</span>
							<input id="xl" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">通讯地址</span>
							<input id="txdz" type="text" class="form-control">
						</div>
					</div>
					<div class="col-xs-6" style="margin-top:5px">
						<div class="input-group" >
							<span class="input-group-addon" style="padding-right:28px;">用户名</span>
								<input id="username" readonly="readonly" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px" >
							<span class="input-group-addon" style="padding-right:40px;">性别</span>
							<select id="xb" class="form-control">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">籍贯</span>
							<input id="jg" type="text" class="form-control">
						</div>

						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">党派</span>
							<input id="dp" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">技术职称</span>
							<input id="jszc" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">专长</span>
							<input id="zc" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">从事工作</span>
							<input id="xcsgz" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">职务</span>
							<input id="zw" type="text" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">电话</span>
							<input id="dh" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">本会职务</span>
							<input id="bhzw" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">毕业学校</span>
							<input id="byxx" type="text" class="form-control">
						</div>
					</div>
				</div>
				<!-- <div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">通讯地址</span>
							<input id="txdz" type="text" style="width:100%" class="form-control">
						</div>
					</div>
				</div> -->
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:40px;">工作简历</span>
							<textarea id="gzjl" rows="6" style="width:100%" class="form-control"></textarea>
						</div>
				
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon">科研成果学术活动<br/><br/>参加其他学术团体情况</span>
							<textarea id="kycg" rows="6" style="width:100%" class="form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-6">
						<div class="input-group">
							<input id="auditStatus" type="hidden"  class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group">
							<input id="auditDate" type="hidden"  class="form-control">
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<textarea id="xhspyj" rows="6"  style="width:100%;display: none;" readonly="readonly" class="form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<textarea id="bz" rows="3" style="width:100%;display: none;" readonly="readonly" class="form-control"></textarea>
						</div>
					</div>
				</div>
				
				<!-- 第一行 -->
			</div><!-- container-fluid -->
		</div><!-- panel-body -->
	</div><!-- panel panel-default -->
	<!-- 个人信息面板 -->
	<!-- 重置密码弹出 结束 -->
	<div id="div1" style="height:35px;line-height:35px;width:100%;">
		<div style="float:left;width:50%;text-align:right;font-size:12px;padding-right:10px">
			<button id="updatepwd" class="btn btn-lg btn-success" style="font-weight:bold" >更改密码</button>
			<button id="updatePerson" class="btn btn-lg btn-success" style="font-weight:bold">保存修改</button>
		</div>
	</div>
	<!-- 重置密码弹出 -->
	<div class="modal fade" id="xgmmModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document" style="width:400px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="label btn-success">原始密码</label> <input 
							type="password" onmousedown="removeCss('xgmmmsg')" onblur="checkOldPwd()"  class="form-control" id="ysmm" />
					</div>
					<div class="form-group">
						<label class="label btn-success">新密码</label> <input
							type="password" class="form-control" onmousedown="removeCss('xgmmmsg')" onblur="checkNewPwd()" id="srmm" />
					</div>
					<div class="form-group">
						<label class="label btn-success">确认密码</label> <input
							type="password" class="form-control" onmousedown="removeCss('xgmmmsg')" onblur="checkConfirmPwd()" id="qrmm" />
					</div>
					<div style="color:#ff0000;height:20px" id="xgmmmsg"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="savepwd" type="button" class="btn btn-primary">确认</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>