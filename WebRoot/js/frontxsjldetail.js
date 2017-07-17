frontxsjldetail={};
frontxsjldetail.init=function(){
	frontxsjldetail.initInfo();
	frontxsjldetail.initBtDh();
};
frontxsjldetail.initInfo=function(){
	 var url = location.href; 
     var str = url.substring(url.indexOf("?")+1,url.length); 
     var st=str.split("=");
     var id=st[1];
      $.ajax({
			type:"POST",
			url:path+"/xsjl/getOneLwgl.action",
			data:{'lwglVo.id':id},
			async:true,
			dataType: 'json',
			success:function(data){
				$('#id').val(data.id);
				$('#btDiv').html(data.lwtm);
				$('#fbtDiv').html("论文作者："+data.lwzz+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者单位："+data.zzdw+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间："+data.fbsj);
				$('#lwnr').html("论文摘要："+data.lwnr);
			}
		});
  };
  frontxsjldetail.down=function(){
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

