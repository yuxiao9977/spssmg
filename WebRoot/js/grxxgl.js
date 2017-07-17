grxxgl={};
grxxgl.init=function(){
	grxxgl.initInfo();
	grxxgl.initBtDh(); 
};
grxxgl.initInfo=function(){
	$.ajax({
		type:"POST",
		url:path+"/hygl/getUserInfo.action",
		data:{},
		async:true,
		dataType: 'json',
		success:function(data){
			$("#id").val(data.id);
			$("#username").val(data.username);
			$("#xm").val(data.xm);
			$('#csrq').val(data.csrq);
			$('#mz').val(data.mz);
			$('#whcd').val(data.whcd);
			$('#zy').val(data.zy);
			$('#wysp').val(data.wysp);
			$('#gzdw').val(data.gzdw);
			$('#txdz').val(data.txdz);
			$('#gzdw').val(data.gzdw);
			$('#hsrh').val(data.hsrh);
			$('#xl').val(data.xl);
			$('#xw').val(data.xw);
			$('#xb').val(data.xb);
			$('#jg').val(data.jg);
			$('#dp').val(data.dp);
			$('#jg').val(data.jg);
			$('#jszc').val(data.jszc);
			$('#zc').val(data.zc);
			$('#xcsgz').val(data.xcsgz);
			$('#zw').val(data.zw);
			$('#dh').val(data.dh);
			$('#bhzw').val(data.bhzw);
			$('#byxx').val(data.byxx);
			$('#gzjl').val(data.gzjl);
			$('#kycg').val(data.kycg);
			$('#xhspyj').val(data.xhspyj);
			$('#bz').val(data.bz);
			$('#grhyzsbh').val(data.grhyzsbh);
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
grxxgl.initBtDh = function() {
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
		$( "#csrq" ).datetimepicker({
			 lang:"ch",           //语言选择中文
		     format:"Y-m-d",      //格式化日期
		     timepicker:false,    //关闭时间选项
			});
		$( "#hsrh" ).datetimepicker({
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
	$("#savepwd").click(function(){
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
	$("#updatePerson").click(function(){
		if($("#xm").val()==null||$("#xm").val()==""){
			common.alert("姓名不能为空！");
			return false;
		}
		//alert($("#auditStatus").val());
			$.ajax({
				type:"POST",
				url:path+"/hygl/updatePerson.action",
				data:{'flag':'会员自己修改','person.id':$("#id").val(),'person.xm':$("#xm").val(),'person.xb':$("#xb").val(),'person.csrq':$("#csrq").val(),'person.jg':$("#jg").val(),'person.mz':$("#mz").val(),'person.dp':$("#dp").val(),'person.whcd':$("#whcd").val(),'person.jszc':$("#jszc").val(),'person.zy':$("#zy").val(),'person.zc':$("#zc").val(),'person.wysp':$("#wysp").val(),'person.xcsgz':$("#xcsgz").val(),'person.gzdw':$("#gzdw").val(),'person.zw':$("#zw").val(),'person.txdz':$("#txdz").val(),'person.dh':$("#dh").val(),'person.hsrh':$("#hsrh").val(),'person.bhzw':$("#bhzw").val(),'person.xl':$("#xl").val(),'person.byxx':$("#byxx").val(),'person.xw':$("#xw").val(),'person.gzjl':$("#gzjl").val(),'person.kycg':$("#kycg").val(),'person.grhyzsbh':$("#grhyzsbh").val(),'person.bz':$("#bz").val(),'person.xhspyj':$("#xhspyj").val(),'person.auditStatus':$("#auditStatus").val(),'person.auditDate':$("#auditDate").val()},
				async:true,
				dataType: 'json',
				success:function(data){
					if(data.result=="success"){
						common.alert("修改成功！");
						grxxgl.initInfo();
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
				//alert(data.result);
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