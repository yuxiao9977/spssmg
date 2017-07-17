ttxxgl={};
ttxxgl.init=function(){
	ttxxgl.initInfo();
	ttxxgl.initBtDh(); 
};
ttxxgl.initInfo=function(){
	$.ajax({
		type:"POST",
		url:path+"/hygl/getUserInfo.action",
		data:{},
		async:true,
		dataType: 'json',
		success:function(data){
			$("#id").val(data.id);
			$("#sqdwmc").val(data.sqdwmc);
			$("#username").val(data.username);
			$("#dwfr").val(data.dwfr);
			$("#chxhlsxm").val(data.chxhlsxm);
			$("#dwrs").val(data.dwrs);
			$("#jsrys").val(data.jsrys);
			$("#gjzcrs").val(data.gjzcrs);
			$("#zjzcrs").val(data.zjzcrs);
			$("#dwxz").val(data.dwxz);
			$("#dwdz").val(data.dwdz);
			$("#yb").val(data.yb);
			$("#lxrxm").val(data.lxrxm);
			$("#lxdh").val(data.lxdh);
			$("#cz").val(data.cz);
			$("#em").val(data.em);
			$("#chzzjb").val(data.chzzjb);
			$("#bh").val(data.bh);
			$("#ywfw").val(data.ywfw);
			$("#dwcbw").val(data.dwcbw);
			$("#sqtthy").val(data.sqtthy);
			$("#rhsj").val(data.rhsj);
			$("#dwfzr").val(data.dwfzr);
			$("#sqdw").val(data.sqdw);
			$("#xhspyj").val(data.xhspyj);
			$("#bz").val(data.bz);
			$("#tthyzsbh").val(data.tthyzsbh);
			$('#auditDate').val(data.auditDate);
			if(data.auditStatus=="1"){
				$('#auditStatus').val("待审核");
			}else if(data.auditStatus=="2"){
				$('#auditStatus').val("已通过");
			}else if(data.auditStatus=="3"){
				$('#auditStatus').val("未通过");
			}
		}
	});
};
//标题导航
ttxxgl.initBtDh = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getMenuByIds.action",
		data:{treeid:treeid,pid:pid},
		async:true,
		dataType: 'json',
		success:function(data) {
			var options = "";
			for (var i = 0; i < data.length; i++) {
				if (i == 0) {
					options += "<li style='font-size:14px'><span class='glyphicon glyphicon-th-large'></span> "+data[i].text+"</li>";
				} else {
					options += "<li style='font-size:14px'>"+data[i].text+"</li>";
				}
			}
			$("#btol").html(options);
		}
	});
};
$(function(){
	$( "#rhsj" ).datetimepicker({
		 lang:"ch",           //语言选择中文
	     format:"Y-m-d",      //格式化日期
	     timepicker:false,    //关闭时间选项
		});
	$("#updatepwd").click(function(){
		$("#ysmm").val("");
		$("#srmm").val("");
		$("#qrmm").val("");
		$("#xgmmModal").modal("show");
		
	});
	$("#savepwd2").click(function(){
		checkOldPwd();
		checkNewPwd();
		checkConfirmPwd();
		//alert(checkNewPwd()+"&&"+checkOldPwd()+"&&"+checkConfirmPwd());
		if(checkOldPwd()&&checkNewPwd()&&checkConfirmPwd()){
			var qrmm=$("#qrmm").val();
			//alert(qrmm);
			$.ajax({
				type:"POST",
				url:path+"/hygl/savePwd.action",
				data:{'user.password':qrmm},
				async:true,
				dataType: 'json',
				success:function(data){
					if(data.result=="success"){
						$("#xgmmmsg").html("密码修改成功!");
						$("#xgmmModal").modal("hide");
					}
				}
			});
		}
	});
	$("#saveGroup").click(function(){
		if($("#sqdwmc").val()==null||$("#sqdwmc").val()==""){
			common.alert("申请单位名称不能为空！");
			return false;
		}
		$.ajax({
			type:"POST",
			url:path+"/hygl/updateGroup.action",
			data:{'flag':'会员自己修改','group.id':$("#id").val(),'group.sqdwmc':$("#sqdwmc").val(),'group.dwfr':$("#dwfr").val(),'group.chxhlsxm':$("#chxhlsxm").val(),'group.dwrs':$("#dwrs").val(),'group.jsrys':$("#jsrys").val(),'group.gjzcrs':$("#gjzcrs").val(),'group.zjzcrs':$("#zjzcrs").val(),'group.dwxz':$("#dwxz").val(),'group.dwdz':$("#dwdz").val(),'group.yb':$("#yb").val(),'group.lxrxm':$("#lxrxm").val(),'group.lxdh':$("#lxdh").val(),'group.cz':$("#cz").val(),'group.em':$("#em").val(),'group.chzzjb':$("#chzzjb").val(),'group.bh':$("#bh").val(),'group.ywfw':$("#ywfw").val(),'group.dwcbw':$("#dwcbw").val(),'group.sqtthy':$("#sqtthy").val(),'group.rhsj':$("#rhsj").val(),'group.dwfzr':$("#dwfzr").val(),'group.sqdw':$("#sqdw").val(),'group.tthyzsbh':$("#tthyzsbh").val(),'group.rhsj':$("#rhsj").val(),'group.auditStatus':$("#auditStatus").val(),'group.auditDate':$("#auditDate").val(),'group.xhspyj':$("#xhspyj").val(),'group.bz':$("#bz").val()},
			async:true,
			dataType: 'json',
			success:function(data){
				//alert(data.result);
				if(data.result=="success"){
					common.alert("修改成功！");
					ttxxgl.initInfo();//重新初始化
				}
			}
		});
});
	
});
function checkOldPwd(){
	var ysmm=$("#ysmm").val();
	if(ysmm==""||ysmm==null){
		$("#xgmmmsg").html("原始密码不能为空!");
		return false;
	}else{
		$.ajax({
			type:"POST",
			url:path+"/hygl/checkOldPwd.action",
			data:{'user.password':ysmm},
			async:true,
			dataType: 'json',
			success:function(data){
				if(data.result=="error"){
					 $("#xgmmmsg").html("原始密码不正确!");
				}
			}
		});
		return true;
	}
}
function checkNewPwd(){
	var srmm=$("#srmm").val();
	if(srmm==""||srmm==null){
		$("#xgmmmsg").html("新密码不能为空!");
		return false;
	}else{
		 var reg=/^[0-9a-zA-Z]{6,}$/;
		 if(!reg.test(srmm)){
			 $("#xgmmmsg").html("密码必须由字母或数字组成的不少于6位字符组成!");
			 return false;
		 }
		 return true;
	}
}
function checkConfirmPwd(){
	var srmm=$("#srmm").val();
	var qrmm=$("#qrmm").val();
	if(qrmm==""||qrmm==null){
		$("#xgmmmsg").html("确认密码不能为空!");
		return false;
	}
	if(srmm!=null&&srmm!=''){
		if(srmm!=qrmm){
			$("#xgmmmsg").html("两次密码不一致!");
			return false;
		}
	}
	return true;
}
function removeCss(id){
	 $("#"+id).html("");
}