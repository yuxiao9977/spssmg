<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String treeid = request.getParameter("treeid");
	String pid = request.getParameter("pid");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../includePage.jsp"%>
<title>团体信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/ttxxgl.js"></script>
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
<body onload="ttxxgl.init()">
	<nav class="navbar navbar-fixed-top" style="margin-left:5px;margin-right:5px;">
			<ol id="btol" class="breadcrumb" style="background:#e1e1e1;margin:0px"></ol>
		</nav>
	<!-- 个人信息面板 -->
	<div class="bpanel bpanel-success clearbj" style="border:none;margin-top: 45px;">
		<div class="bpanel-body">
			<div class="container-fluid" style="">
				<!-- 第一行 -->
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon">团体会员证书编号</span>
							<input id="tthyzsbh" style="width:100%" readonly="readonly" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6">
					<input id="id" type="hidden"  class="form-control">
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;" >申请单位名称</span>
							<input id="sqdwmc" type="text"  class="form-control">
						</div>
											
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:68px;" >单位性质</span>
							<select id="dwxz" class="form-control">
								<option value="1">事业</option>
								<option value="2">学校</option>
								<option value="3">社会团体</option>
								<option value="4">企业</option>
								<option value="5">部队</option>
							</select>
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:68px;" >单位人数</span>
							<input id="dwrs" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">高级职称人数</span>
							<input id="gjzcrs" type="text" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:68px;" >单位地址</span>
							<input id="dwdz" type="text" class="form-control">
						</div>
						
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:55px;" >联系人姓名</span>
							<input id="lxrxm" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:96px;" >传真</span>
							<input id="cz" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;">测绘资质级别</span>
							<input id="chzzjb" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:96px;" >编号</span>
							<input id="bh" type="text" class="form-control">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:110px;" >用户名</span>
							<input id="username" readonly="readonly" type="text"  class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon">单位法人（或负责人）</span>
							<input id="dwfr" type="text"  class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;" >测绘学会理事姓名</span>
							<input id="chxhlsxm" type="text" class="form-control">
						</div>

						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:40px;" >其中：科技人员数</span>
							<input id="jsrys" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:68px;" >中级职称人数</span>
							<input id="zjzcrs" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:125px;" >邮编</span>
							<input id="yb" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:98px;" >联系电话</span>
							<input id="lxdh" type="text" class="form-control">
						</div>
						<div class="input-group" style="margin-top:5px">
							<span class="input-group-addon" style="padding-right:110px;" >E-MAIL</span>
							<input id="em" type="text" class="form-control">
						</div>
						
						
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:68px;" >业务范围</span>
							<textarea id="ywfw" rows="6" style="width:100%" class="form-control"></textarea>
						</div>
				
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:55px;" >单位出版物</span>
							<textarea id="dwcbw" rows="1" style="width:100%" class="form-control"></textarea>
							
						</div>
				
					</div>
				</div>
				<div class="row" style="margin-top:5px">
					<div class="col-xs-6">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right:40px;">申请团体会员</span> <select id="sqtthy"
									style="width: 310px;" class="form-control">
									<option value="1">一般会员单位</option>
									<option value="2">理事会员单位</option>
									<option value="3">常务理事会员单位</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="input-group">
							<div class="input-group">
							<span class="input-group-addon" style="padding-right:110px;" >入会时间</span>
							<input id="rhsj" type="text" style="width: 270px" class="form-control">
						</div>
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
							<textarea id="xhspyj" rows="6" style="width:100%;display: none;" readonly="readonly" class="form-control"></textarea>
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
	<div style="height:35px;line-height:35px;width:100%;">
		<div style="float:left;width:50%;text-align:right;font-size:12px;padding-right:10px">
			<button id="updatepwd" class="btn btn-lg btn-success" style="font-weight:bold" >更改密码</button>
			<button id="saveGroup" class="btn btn-lg btn-success" style="font-weight:bold">保存修改</button>
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
					<button id="savepwd2" type="button" class="btn btn-primary">确认</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>