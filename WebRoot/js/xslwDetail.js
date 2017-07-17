xslwDetail={};
xslwDetail.init=function(){
	xslwDetail.initInfo();
	xslwDetail.initBtDh();
};
//标题导航
xslwDetail.initBtDh = function() {
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
xslwDetail.initInfo=function(){
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
				$("#id").val(data.id);
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
				if(data.auditstatus=="1"){
					$('#auditstatus').val("待审核");
				}else if(data.auditstatus=="2"){
					$('#auditstatus').val("已通过");
				}else if(data.auditstatus=="3"){
					$('#auditstatus').val("未通过");
				}
				
				$('#auditdate').val(data.auditdate);
				$('#auditidea').val(data.auditidea);
			}
		});
  };
  xslwDetail.down=function(){
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
$(function(){
	$("#back").click(function(){
		 window.history.back();
	});
});
var editor=null;
KindEditor.ready(function(K){
	 editor=K.create('#kindcontent',{
		allowFileManager:true
	});
});

