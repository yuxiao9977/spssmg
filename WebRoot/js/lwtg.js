var lwtg={};
/*var editor=null;
KindEditor.ready(function(K){
	 editor=K.create('#kindcontent',{
		 allowFileManager : true,
		 cssPath:path+"/kindeditor/themes/qq/qq.css",
		 filterMode:true,
		 themeType:"common",
		 uploadJson: path+"/kindeditor/jsp/upload_json.jsp",
		 fileManagerJson:path+"/kindeditor/jsp/file_manager_json.jsp"
	});
});*/
lwtg.init=function(){
	lwtg.initBtDh();
};
//标题导航
lwtg.initBtDh = function() {
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
lwtg.addLwgl=function(){
	var lwtm=$("#lwtm").val();
	var lwzz=$("#lwzz").val();
	var zzdw=$("#zzdw").val();
	var file=$("#file").val();
	var lwnr=$("#lwnr").val();
	var fbsj=$("#fbsj").val();
	//alert(lwtm+"@@"+lwzz+"%%"+zzdw+"##"+lwnr+"**"+fbsj+"^^^"+file);
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
	if($("#lwnr").val()==""||$("#lwnr").val()==null){
		common.alert("论文摘要不能为空！！");
		return false;
	}
	$("#formSub").ajaxSubmit({
		url : path + "/upload.jsp?fileType=lw",
		type: "post",
	    success : function(d){
	    	var data = eval("("+d+")");
				//(data.fn);
				//alert(data.url);
	    	if(data.error==0){
	    		$.ajax({
					 type:"POST",
					 url:path+"/xsjl/addLwglVo.action",
					 data:{'attach.fileName':data.fn,'attach.url':data.url,'attach.style':'lwglVo','lwglVo.lwtm':lwtm,'lwglVo.lwzz':lwzz,'lwglVo.zzdw':zzdw,'lwglVo.lwnr':lwnr},
					 async:true,
					 dataType: 'json',
					 success:function(data2){
						if(data2.result=="success"){
							common.alert("保存成功！");
						};
					 }
				 });
	    	}else{
	    		common.alert(data.message);
	    	}
	    }
	});
};

$(function(){
	$( "#fbsj" ).datetimepicker({
		 lang:"ch",           //语言选择中文
	     format:"Y-m-d",      //格式化日期
	     timepicker:false,    //关闭时间选项
		});
});