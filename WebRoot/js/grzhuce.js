grzhuce = {};
grzhuce.register=function(){
	if(grzhuce.checkUsername()==false){
		return  ;
	};
	if($("#xm").val()==null||$("#xm").val()==''){
		common.alert("姓名不能为空！");
		return  ;
	}
	if($("#pwd").val()==null||$("#pwd").val()==''){
		common.alert("密码不能为空！");
		return  ;
	}
	if($("#password").val()==null||$("#password").val()==''){
		common.alert("确认密码不能为空！");
		return  ;
	}
	if($("#pwd").val()!=$("#password").val()){
		common.alert("两次密码不一致！");
		return  ;
	}
	
	if($("#file").val()==null||$("#file").val()==''){
		common.alert("请上传文件！");
		return  false;
	}
	$("#formSub").ajaxSubmit({
		url : path + "/upload.jsp?fileType=image",
	    success : function(d){
	    	var data = eval("("+d+")");
			//alert(data.fn);
	    	if(data.error==0){
	    		 var $btn = $("#myButton").button('loading');
				 $.ajax({
					 type:"POST",
					 url:path+"/dlzc/addPerson.action",
					 data:{'user.username':$("#username").val(),'user.password':$("#password").val(),'person.xm':$("#xm").val(),'person.xb':$("#xb").val(),'person.csrq':$("#csrq").val(),'person.jg':$("#jg").val(),'person.mz':$("#mz").val(),'person.dp':$("#dp").val(),'person.whcd':$("#whcd").val(),'person.jszc':$("#jszc").val(),'person.zy':$("#zy").val(),'person.zc':$("#zc").val(),'person.wysp':$("#wysp").val(),'person.xcsgz':$("#xcsgz").val(),'person.gzdw':$("#gzdw").val(),'person.zw':$("#zw").val(),'person.txdz':$("#txdz").val(),'person.dh':$("#dh").val(),'person.hsrh':$("#hsrh").val(),'person.bhzw':$("#bhzw").val(),'person.xl':$("#xl").val(),'person.byxx':$("#byxx").val(),'person.xw':$("#xw").val(),'person.gzjl':$("#gzjl").val(),'person.kycg':$("#kycg").val(),'attach.fileName':data.fn,'attach.url':data.url,'attach.style':'person','person.xhspyj':$("#xhspyj").val(),'person.xhAuditdate':$("#xhAuditdate").val(),'person.tbdate':$("#tbdate").val(),'person.bz':$("#bz").val()},
					 async:true,
					 dataType: 'json',
					 success:function(data2){
						if(data2.result=="success"){
							common.alert("注册成功！");
							 $("#myButton").button('reset');
							//window.location.href=path+"/jsp/login.jsp";
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
grzhuce.checkUsername=function(){
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
grzhuce.down=function(){
	//alert("878778");
	$.ajax({
		 type:"POST",
		 url:path+"/attach/getOneAttach.action",
		 data:{'attach.id':'1'},
		 async:true,
		 dataType: 'json',
		 success:function(data){
			 window.location.href=path+"/download.jsp?file="+data.fileName+"&url="+data.url;
		 }
	 });
};
$(function(){
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