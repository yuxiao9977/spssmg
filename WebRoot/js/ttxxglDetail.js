ttxxgl={};
ttxxgl.init=function(){
	ttxxgl.initInfo();
	ttxxgl.initBtDh(); 
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
ttxxgl.initInfo=function(){
	 var url = location.href; 
     var str = url.substring(url.indexOf("?")+1,url.length).split("&"); 
     var st=str[0].split("=");
     var id=st[1];
     //alert("88888");
	$.ajax({
		type:"POST",
		url:path+"/hygl/getGroupInfo.action",
		data:{'group.id':id},
		async:true,
		dataType: 'json',
		success:function(data){
			$("#id").val(data.id);
			$("#sqdwmc").val(data.sqdwmc);
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
			/*if(data.auditStatus=="1"){
				$('#auditStatus').val("待审核");
			}else if (data.auditStatus=="2"){
				$('#auditStatus').val("已通过");
			}else if (data.auditStatus=="3"){
				$('#auditStatus').val("未通过");
			}*/
			$('#auditStatus').val(data.auditStatus);
			$('#auditDate').val(data.auditDate);
			$("#xhspyj").val(data.xhspyj);
			$("#bz").val(data.bz);
			$("#tthyzsbh").val(data.tthyzsbh);
			$("#xhAuditdate").val(data.xhAuditdate);
			$("#tbdate").val(data.tbdate);
		}
	});
	$.ajax({
		type:"POST",
		url:path+"/dlzc/getOneUser2.action",
		data:{'user.groupId':id},
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
	$("#saveGroup").click(function(){
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
			url:path+"/hygl/updateGroup.action",
			data:{'user.id':$("#userid").val(),'user.username':$("#username").val(),'user.password':$("#password").val(),'group.id':$("#id").val(),'group.sqdwmc':$("#sqdwmc").val(),'group.dwfr':$("#dwfr").val(),'group.chxhlsxm':$("#chxhlsxm").val(),'group.dwrs':$("#dwrs").val(),'group.jsrys':$("#jsrys").val(),'group.gjzcrs':$("#gjzcrs").val(),'group.zjzcrs':$("#zjzcrs").val(),'group.dwxz':$("#dwxz").val(),'group.dwdz':$("#dwdz").val(),'group.yb':$("#yb").val(),'group.lxrxm':$("#lxrxm").val(),'group.lxdh':$("#lxdh").val(),'group.cz':$("#cz").val(),'group.em':$("#em").val(),'group.chzzjb':$("#chzzjb").val(),'group.bh':$("#bh").val(),'group.ywfw':$("#ywfw").val(),'group.dwcbw':$("#dwcbw").val(),'group.sqtthy':$("#sqtthy").val(),'group.rhsj':$("#rhsj").val(),'group.dwfzr':$("#dwfzr").val(),'group.sqdw':$("#sqdw").val(),'group.auditStatus':auditStatus,'group.auditDate':$("#auditDate").val(),'group.xhspyj':$("#xhspyj").val(),'group.bz':$("#bz").val(),'group.tthyzsbh':$("#tthyzsbh").val(),'group.xhAuditdate':$("#xhAuditdate").val(),'group.tbdate':$("#tbdate").val(),},
			async:true,
			dataType: 'json',
			success:function(data){
				//alert(data.result);
				if(data.result=="success"){
					common.alert("更新成功！");
					ttxxgl.initInfo();//重新初始化
					//setTimeout("window.location.href=path+'/jsp/hyxxgl.jsp'", 2000);
				}
			}
		});
});
	
});