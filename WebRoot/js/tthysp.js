tthysp={};
tthysp.init=function(){
	tthysp.initInfo();
	tthysp.initBtDh(); 
};
//标题导航
tthysp.initBtDh = function() {
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
tthysp.initInfo=function(){
	 var url = location.href; 
     var str = url.substring(url.indexOf("?")+1,url.length).split("&"); 
     var st=str[0].split("=");
     var id=st[1];
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
			//$("#dwxz").val(data.dwxz);
			if(data.dwxz=="1"){
				$("#dwxz").val("事业");
			}else if(data.dwxz=="2"){
				$("#dwxz").val("学校");
			}else if(data.dwxz=="3"){
				$("#dwxz").val("社会团体");
			}else if(data.dwxz=="4"){
				$("#dwxz").val("企业");
			}else if(data.dwxz=="5"){
				$("#dwxz").val("部队");
			}
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
			//$("#sqtthy").val(data.sqtthy);
			//var sqtthys=document.getElementsByName("sqtthy");
			if(data.sqtthy=="1"){
				$("#sqtthy").val("一般会员单位");
			}else if(data.sqtthy=="2"){
				$("#sqtthy").val("理事会员单位");
			}else if(data.sqtthy=="3"){
				$("#sqtthy").val("常务理事会员单位");
			}
			$("#rhsj").val(data.rhsj);
			$("#dwfzr").val(data.dwfzr);
			$("#sqdw").val(data.sqdw);
			$("#xhspyj").val(data.xhspyj);
			$("#bz").val(data.bz);
			$("#tthyzsbh").val(data.tthyzsbh);
			$("#xhAuditdate").val(data.xhAuditdate);
			$("#tbdate").val(data.tbdate);
		}
	});
};
tthysp.down=function(){
	$.ajax({
		 type:"POST",
		 url:path+"/attach/findAttach.action",
		 data:{'attach.relationId':$("#id").val(),'attach.style':'group'},
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
	$("#saveGroup").click(function(){
		var dwxz="";
		if($("#dwxz").val()=="事业"){
			dwxz+="1";
		}else if($("#dwxz").val()=="学校"){
			dwxz+="2";
		}else if($("#dwxz").val()=="社会团体"){
			dwxz+="3";
		}else if($("#dwxz").val()=="企业"){
			dwxz+="4";
		}else if($("#dwxz").val()=="部队"){
				dwxz+="5";
		}
		if($("#auditStatus").val()==null||$("#auditStatus").val()==""){
			common.alert("请选择审核状态！");
			return;
		}
		$.ajax({
			type:"POST",
			url:path+"/hygl/updateGroup2.action",
			data:{'group.id':$("#id").val(),'group.sqdwmc':$("#sqdwmc").val(),'group.dwfr':$("#dwfr").val(),'group.chxhlsxm':$("#chxhlsxm").val(),'group.dwrs':$("#dwrs").val(),'group.jsrys':$("#jsrys").val(),'group.gjzcrs':$("#gjzcrs").val(),'group.zjzcrs':$("#zjzcrs").val(),'group.dwxz':dwxz,'group.dwdz':$("#dwdz").val(),'group.yb':$("#yb").val(),'group.lxrxm':$("#lxrxm").val(),'group.lxdh':$("#lxdh").val(),'group.cz':$("#cz").val(),'group.em':$("#em").val(),'group.chzzjb':$("#chzzjb").val(),'group.bh':$("#bh").val(),'group.ywfw':$("#ywfw").val(),'group.dwcbw':$("#dwcbw").val(),'group.sqtthy':$("#sqtthy").val(),'group.rhsj':$("#rhsj").val(),'group.dwfzr':$("#dwfzr").val(),'group.sqdw':$("#sqdw").val(),'group.auditStatus':$("#auditStatus").val(),'group.xhspyj':$("#xhspyj").val(),'group.bz':$("#bz").val(),'group.tthyzsbh':$("#tthyzsbh").val(),'group.xhAuditdate':$("#xhAuditdate").val(),'group.tbdate':$("#tbdate").val(),},
			async:true,
			dataType: 'json',
			success:function(data){
				//alert(data.result);
				if(data.result=="success"){
					common.alert("审核成功！");
					//setTimeout("window.location.href=path+'/jsp/hyxxgl.jsp'", 2000);
					tthysp.initInfo();//重新初始化
				}
			}
		});
});
	
});