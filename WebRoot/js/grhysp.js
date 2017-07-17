grhysp={};
grhysp.init=function(){
	grhysp.initInfo();
	grhysp.initBtDh();
};
//标题导航
grhysp.initBtDh = function() {
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
grhysp.initInfo=function(){
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
			$("#xb").val(data.xb);
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
			$('#xhAuditdate').val(data.xhAuditdate);
			$('#tbdate').val(data.tbdate);
		}
	});
};
grhysp.down=function(){
	$.ajax({
		 type:"POST",
		 url:path+"/attach/findAttach.action",
		 data:{'attach.relationId':$("#id").val(),'attach.style':'person'},
		 async:true,
		 dataType: 'json',
		 success:function(data){
			 if(data==null){
				 common.alert("该会员未上传附件");
			 }else{
			 window.location.href=path+"/download.jsp?file="+data.fileName+"&url="+data.url;
			 }
		 }
	 });
};
$(function(){
	$("#updatePerson").click(function(){
		if($("#auditStatus").val()==null||$("#auditStatus").val()==""){
			common.alert("请选择审核状态！");
			return;
		}
			$.ajax({
				type:"POST",
				url:path+"/hygl/updatePerson2.action",
				data:{'person.id':$("#id").val(),'person.xm':$("#xm").val(),'person.xb':$("#xb").val(),'person.csrq':$("#csrq").val(),'person.jg':$("#jg").val(),'person.mz':$("#mz").val(),'person.dp':$("#dp").val(),'person.whcd':$("#whcd").val(),'person.jszc':$("#jszc").val(),'person.zy':$("#zy").val(),'person.zc':$("#zc").val(),'person.wysp':$("#wysp").val(),'person.xcsgz':$("#xcsgz").val(),'person.gzdw':$("#gzdw").val(),'person.zw':$("#zw").val(),'person.txdz':$("#txdz").val(),'person.dh':$("#dh").val(),'person.hsrh':$("#hsrh").val(),'person.bhzw':$("#bhzw").val(),'person.xl':$("#xl").val(),'person.byxx':$("#byxx").val(),'person.xw':$("#xw").val(),'person.gzjl':$("#gzjl").val(),'person.kycg':$("#kycg").val(),'person.xhspyj':$("#xhspyj").val(),'person.bz':$("#bz").val(),'person.grhyzsbh':$("#grhyzsbh").val(),'person.auditStatus':$("#auditStatus").val(),'person.xhAuditdate':$("#xhAuditdate").val(),'person.tbdate':$("#tbdate").val(),},
				async:true,
				dataType: 'json',
				success:function(data){
					if(data.result=="success"){
						common.alert("审核成功！");
						//setTimeout("window.location.href=path+'/jsp/hyxxgl.jsp'", 2000);
						grhysp.initInfo();
					}
				}
			});
	});
});