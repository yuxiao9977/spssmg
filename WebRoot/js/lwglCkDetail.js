lwglDetail={};
lwglDetail.init=function(){
	lwglDetail.initInfo();
	lwglDetail.initBtDh();
};
//标题导航
lwglDetail.initBtDh = function() {
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
lwglDetail.initInfo=function(){
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
				$("#userId").val(data.userId);
				$('#lwtm').val(data.lwtm);
				$('#lwzz').val(data.lwzz);
				$('#lwnr').val(data.lwnr);
				$('#zzdw').val(data.zzdw);
				if(data.pub=="1"){
					$('#pub').val("已发布");
				}else if(data.pub=="2"){
					$('#pub').val("未发布");
				}
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
      $.ajax({
    	  type:"POST",
    	  url:path+"/attach/getOneAttach.action",
    	  data:{'attach.relationId':id,'attach.style':'lwglVo'},
    	  async:true,
    	  dataType: 'json',
    	  success:function(data){
    		  $('#filename').val(data.fileName);
    	  }
      });
  };
var editor=null;
KindEditor.ready(function(K){
	 editor=K.create('#kindcontent',{
		 allowFileManager : true,
		 cssPath:path+"/kindeditor/themes/qq/qq.css",
		 filterMode:true,
		 themeType:"common",
		 uploadJson: path+"/kindeditor/jsp/upload_json.jsp",
		 fileManagerJson:path+"/kindeditor/jsp/file_manager_json.jsp"
	});
});
$(function(){
	$("#back").click(function(){
		 window.history.back();
	});
	$( "#fbsj" ).datetimepicker({
		 lang:"ch",           //语言选择中文
	     format:"Y-m-d",      //格式化日期
	     timepicker:false,    //关闭时间选项
		});
	$("#updateLwgl").click(function(){
		//alert("7777777777");
		var lwnr=editor.html();
		if($("#lwtm").val()==""||$("#lwtm").val()==null){
			common.alert("论文题目不能为空！！");
			return false;
		}
		if($("#lwzz").val()==""||$("#lwzz").val()==null){
			common.alert("论文作者不能为空！！");
			return false;
		}
		if($("#zzdw").val()==""||$("#zzdw").val()==null){
			common.alert("作者单位不能为空！！");
			return false;
		}
		if($("#file").val()==""||$("#file").val()==null){
			common.alert("上传文件不能为空！！");
			return false;
		}
		if(lwnr==""||lwnr==null){
			common.alert("论文内容不能为空！！");
			return false;
		}
		$("#formSub").ajaxSubmit({
			url : path + "/upload.jsp?fileType=lw",
		    success : function(d){
		    	var data = eval("("+d+")");
				//alert(data.fn+"***"+$("#id").val());
				$.ajax({
					type:"POST",
					url:path+"/xsjl/updateLwglVo2.action",
					data:{'attach.relationId':$("#id").val(),'attach.style':'lwglVo','attach.fileName':data.fn,'attach.url':data.url,'lwglVo.id':$("#id").val(),'lwglVo.lwtm':$("#lwtm").val(),'lwglVo.lwzz':$("#lwzz").val(),'lwglVo.zzdw':$("#zzdw").val(),'lwglVo.fbsj':$("#fbsj").val(),},
					async:true,
					dataType: 'json',
					success:function(data){
						//alert(data.result);
						if(data.result=="success"){
							common.alert("更新成功！");
							 //window.location.reload();
						}
					}
				});
		    }
		});
		
	});
});
