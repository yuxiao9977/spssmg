ttzhuce = {};
ttzhuce.register=function(){
	//alert("123456");
	if(ttzhuce.checkUsername()==false){
		return;
	};
	if($("#sqdwmc").val()==null||$("#sqdwmc").val()==''){
		common.alert("申请单位名称不能为空！");
		return;
	}
	if($("#pwd").val()==null||$("#pwd").val()==''){
		common.alert("密码不能为空！");
		return ;
	}
	if($("#password").val()==null||$("#password").val()==''){
		common.alert("确认密码不能为空！");
		return;
	}
	if($("#pwd").val()!=$("#password").val()){
		common.alert("两次密码不一致！");
		return;
	}
	
	if($("#file").val()==null||$("#file").val()==''){
		common.alert("请上传文件！");
		return;
	}
	$("#formSub").ajaxSubmit({
		url : path + "/upload.jsp?fileType=image",
	    success : function(d){
	    	var data = eval("("+d+")");
	    	//alert("****"+data.error);
			//alert(data.fn);
			//alert(data.url);
	    	if(data.error==0){
	    		var $btn = $("#myButton").button('loading');
				$.ajax({
					 type:"POST",
					 url:path+"/dlzc/addGroup.action",
					 data:{'user.username':$("#username").val(),'user.password':$("#password").val(),'attach.fileName':data.fn,'attach.url':data.url,'attach.style':'group','group.sqdwmc':$("#sqdwmc").val(),'group.dwfr':$("#dwfr").val(),'group.chxhlsxm':$("#chxhlsxm").val(),'group.dwrs':$("#dwrs").val(),'group.jsrys':$("#jsrys").val(),'group.gjzcrs':$("#gjzcrs").val(),'group.zjzcrs':$("#zjzcrs").val(),'group.dwxz':$("#dwxz").val(),'group.dwdz':$("#dwdz").val(),'group.yb':$("#yb").val(),'group.lxrxm':$("#lxrxm").val(),'group.lxdh':$("#lxdh").val(),'group.cz':$("#cz").val(),'group.em':$("#em").val(),'group.chzzjb':$("#chzzjb").val(),'group.bh':$("#bh").val(),'group.ywfw':$("#ywfw").val(),'group.dwcbw':$("#dwcbw").val(),'group.sqtthy':$("#sqtthy").val(),'group.rhsj':$("#rhsj").val(),'group.dwfzr':$("#dwfzr").val(),'group.sqdw':$("#sqdw").val(),'group.xhspyj':$("#xhspyj").val(),'group.xhAuditdate':$("#xhAuditdate").val(),'group.tbdate':$("#tbdate").val(),'group.bz':$("#bz").val()},
					 async:true,
					 dataType: 'json',
					 success:function(data2){
						if(data2.result=="success"){
							common.alert("注册成功！");
							//window.location.href=path+"/jsp/login.jsp";
							 $("#myButton").button('reset');
							setTimeout("window.location.href=path+'/jsp/login.jsp'", 2000);
							//flag=true;
						};
					 }
				 });
	    	}else{
	    		common.alert(data.message);
	    	}
	   }
	});
};
ttzhuce.checkUsername=function(){
	if($("#username").val()==null||$("#username").val()==''){
		common.alert("用户名不能为空！");
		return  false;
	}if($("#username").val()!=null||$("#username").val()!=''){
		 $.ajax({
			 type:"POST",
			 url:path+"/dlzc/checkUser.action",
			 data:{'user.username':$("#username").val()},
			 async:false,
			 dataType: 'json',
			 success:function(data2){
				if(data2.result=="repate"){
					common.alert("用户名已存在！");
					//window.location.href=path+"/jsp/login.jsp";
					flag= false;
				}else{
					flag= true;
				}
			 }
		 });
			return flag;
	}
};
ttzhuce.down=function(){
	$.ajax({
		 type:"POST",
		 url:path+"/attach/getOneAttach.action",
		 data:{'attach.id':'2'},
		 async:true,
		 dataType: 'json',
		 success:function(data){
			 window.location.href=path+"/download.jsp?file="+data.fileName+"&url="+data.url;
		 }
	 });
};
$(function(){
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
	$( "#rhsj" ).datetimepicker({
		lang:"ch",           //语言选择中文
		format:"Y-m-d",      //格式化日期
		timepicker:false,    //关闭时间选项
	});
});
