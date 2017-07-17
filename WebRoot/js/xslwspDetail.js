xslwspDetail={};
xslwspDetail.init=function(){
	xslwspDetail.initInfo();
	xslwspDetail.initBtDh();
};
//标题导航
xslwspDetail.initBtDh = function() {
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
xslwspDetail.initInfo=function(){
	  var url = location.href; 
      var str = url.substring(url.indexOf("?")+1,url.length).split("&"); 
      var st=str[0].split("=");
      var id=st[1];
      $.ajax({
			type:"POST",
			url:path+"/xsjl/getOneLwgl.action",
			data:{'lwglVo.id':id},
			async:true,
			dataType: 'json',
			success:function(data){
				//alert(data.lwtm);
				$("#id").val(data.id);
				$('#userId').val(data.userId);
				$('#lwtm').val(data.lwtm);
				$('#lwzz').val(data.lwzz);
				$('#zzdw').val(data.zzdw);
				if(data.pub=="1"){
					$('#pub').val("已发布");
				}else if(data.pub=="2"){
					$('#pub').val("未发布");
				}
				//editor.html(data.lwnr);
				$('#lwnr').val(data.lwnr);
				$('#fbsj').val(data.fbsj);
				if(data.pub=="1"){
					$('#auditstatus').val("待审核");
				}else if(data.pub=="2"){
					$('#auditstatus').val("已通过");
				}else if(data.pub=="3"){
					$('#auditstatus').val("未通过");
				}
				
				$('#auditdate').val(data.auditdate);
				$('#auditidea').val(data.auditidea);
			}
		});
  };
 xslwspDetail.down=function(){
		$.ajax({
			 type:"POST",
			 url:path+"/attach/findAttach.action",
			 data:{'attach.relationId':$("#id").val(),'attach.style':'lwglVo'},
			 async:true,
			 dataType: 'json',
			 success:function(data){
				// alert(data.fileName+"***"+data.url);
				 window.location.href=path+"/download.jsp?file="+data.fileName+"&url="+data.url;
			 }
		 });
	};
/*var editor=null;
KindEditor.ready(function(K){
	 editor=K.create('#kindcontent',{
		allowFileManager:true
	});
});*/
  $(function(){
		$("#addLwgl").click(function(){
			if($("#auditstatus").val()==null||$("#auditstatus").val()==""){
				common.alert("请选择审核状态！");
				return;
			}
			$.ajax({
				type:"POST",
				url:path+"/xsjl/updateLwglVo.action",
				data:{'lwglVo.id':$("#id").val(),'lwglVo.userId':$("#userId").val(),'lwglVo.lwtm':$("#lwtm").val(),'lwglVo.lwzz':$("#lwzz").val(),'lwglVo.zzdw':$("#zzdw").val(),'lwglVo.lwnr':$("#lwnr").val(),'lwglVo.auditstatus':$("#auditstatus").val(),'lwglVo.auditidea':$("#auditidea").val(),},
				async:true,
				dataType: 'json',
				success:function(data){
					//alert(data.result);
					if(data.result=="success"){
						common.alert("审核成功！");
						//setTimeout("window.location.href=path+'/jsp/xslw.jsp'", 2000);
					}
				}
			});
		});
	});
