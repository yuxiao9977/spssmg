grxxgl={};
grxxgl.init=function(){
	grxxgl.initInfo();
	grxxgl.initBtDh();
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
grxxgl.initInfo=function(){
	 var url = location.href; 
     var str = url.substring(url.indexOf("?")+1,url.length).split("&"); 
     var st=str[0].split("=");
     var id=st[1];
	$.ajax({
		type:"POST",
		url:path+"/hygl/getPersonInfo.action",
		data:{'person.id':id},
		async:true,
		dataType: 'json',
		success:function(data){
			$("#id").val(data.id);
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
			/*if(data.auditStatus=="1"){
				$('#auditStatus').val("待审核");
			}else if (data.auditStatus=="2"){
				$('#auditStatus').val("已通过");
			}else if (data.auditStatus=="3"){
				$('#auditStatus').val("未通过");
			}*/
			$('#auditStatus').val(data.auditStatus);
			$('#auditDate').val(data.auditDate);
			$('#xhspyj').val(data.xhspyj);
			$('#bz').val(data.bz);
			$('#grhyzsbh').val(data.grhyzsbh);
			$('#xhAuditdate').val(data.xhAuditdate);
			$('#tbdate').val(data.tbdate);
		}
	});
	$.ajax({
		type:"POST",
		url:path+"/dlzc/getOneUser2.action",
		data:{'user.personId':id},
		async:true,
		dataType: 'json',
		success:function(data){
			$("#userid").val(data.id);
			$("#username").val(data.username);
			$("#password").val(data.password);
		}
	});
};
$(function(){
	$("#updatePerson").click(function(){
		if($("#password").val()==null||$("#password").val()==""){
			common.alert("密码不能为空！");
			return ;
		}
		if($("#auditStatus").val()==null||$("#auditStatus").val()==""){
			common.alert("审核状态不能为空！");
			return ;
		}
		var auditStatus="";
		if($("#auditStatus").val()=="2"){
			auditStatus+="已通过";
		}else if ($("#auditStatus").val()=="3"){
			auditStatus+="未通过";
		}
			$.ajax({
				type:"POST",
				url:path+"/hygl/updatePerson.action",
				data:{'user.id':$("#userid").val(),'user.username':$("#username").val(),'user.password':$("#password").val(),'person.id':$("#id").val(),'person.xm':$("#xm").val(),'person.xb':$("#xb").val(),'person.csrq':$("#csrq").val(),'person.jg':$("#jg").val(),'person.mz':$("#mz").val(),'person.dp':$("#dp").val(),'person.whcd':$("#whcd").val(),'person.jszc':$("#jszc").val(),'person.zy':$("#zy").val(),'person.zc':$("#zc").val(),'person.wysp':$("#wysp").val(),'person.xcsgz':$("#xcsgz").val(),'person.gzdw':$("#gzdw").val(),'person.zw':$("#zw").val(),'person.txdz':$("#txdz").val(),'person.dh':$("#dh").val(),'person.hsrh':$("#hsrh").val(),'person.bhzw':$("#bhzw").val(),'person.xl':$("#xl").val(),'person.byxx':$("#byxx").val(),'person.xw':$("#xw").val(),'person.gzjl':$("#gzjl").val(),'person.kycg':$("#kycg").val(),'person.xhspyj':$("#xhspyj").val(),'person.bz':$("#bz").val(),'person.grhyzsbh':$("#grhyzsbh").val(),'person.auditStatus':auditStatus,'person.auditDate':$("#auditDate").val(),'person.xhAuditdate':$("#xhAuditdate").val(),'person.tbdate':$("#tbdate").val(),},
				async:true,
				dataType: 'json',
				success:function(data){
					if(data.result=="success"){
						common.alert("更新成功！");
						grxxgl.initInfo();
						//setTimeout("window.location.href=path+'/jsp/hyxxgl.jsp'", 2000);
					}
				}
			});
	});
	$( "#csrq" ).datetimepicker({
		 lang:"ch",           //语言选择中文
	     format:"Y-m-d",      //格式化日期
	     timepicker:false,    //关闭时间选项
		});
	$( "#xhAuditdate" ).datetimepicker({
		lang:"ch",           //语言选择中文
		format:"Y-m-d",      //格式化日期
		timepicker:false,    //关闭时间选项
	});
	$( "#tbdate" ).datetimepicker({
		lang:"ch",           //语言选择中文
		format:"Y-m-d",      //格式化日期
		timepicker:false,    //关闭时间选项
	});
	$( "#hsrh" ).datetimepicker({
		lang:"ch",           //语言选择中文
		format:"Y-m-d",      //格式化日期
		timepicker:false,    //关闭时间选项
	});
});