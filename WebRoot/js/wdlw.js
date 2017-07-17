wdlw={};
var editor=null;
KindEditor.ready(function(K){
	 editor=K.create('#kindcontent',{
		allowFileManager:true
	});
});
wdlw.init=function(){
	wdlw.initdatagrid();
	wdlw.initBtDh();
};
//标题导航
wdlw.initBtDh = function() {
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
wdlw.initdatagrid=function(){
	$('#lwglList').datagrid().datagrid('getPager');
	wdlw.initInfo();;
};
wdlw.initInfo=function(){
	$('#lwglList').datagrid({
		url:path+"/xsjl/findLwglVoList.action",
		method:"post",
		striped:true,
		pagination:true,
		title:"论文列表",
		//width:"720px",
		//height:"345px",
		rownumbers:true,
		 pageSize: 10,
		loadMsg:"数据加载中...",
		columns:[[
		        {field:'ck',checkbox:true},
		        {field:'id',title:'主键',width:90,align:'center',hidden:true},
		        {field:'lwtm',title:'论文题目',width:200,align:'center'},
		        {field:'lwzz',title:'论文作者',width:100,align:'center'},
		        {field:'zzdw',title:'作者单位',width:200,align:'center'},
		        {field:'auditstatus',title:'审核状态',width:80,align:'center',formatter:function(value, rowData, rowIndex){
		        		if(value=="1"){
		        			return "待审核";
		        		}else if(value=="2"){
		        			return "已通过";
		        		}else if(value=="3"){
		        			return "未通过";
		        		}
		        	}
		        },
		        {field:'pub',title:'发布状态',width:80,align:'center',formatter:function(value, rowData, rowIndex){
	        		if(value=="1"){
	        			return "已发布";
	        		}else if(value=="2"){
	        			return "未发布";
	        		}
	        	}}
		]],
		toolbar:[
			         {
			        	 text:'条件查询',
			        	 iconCls:'icon-search',
			        	 handler:function(){
			        		 var lwtm=$("#lwtm").val();
			        		 $('#lwglList').datagrid('load',{
			        			 "lwglVo.lwtm":lwtm
			        			}); 
			        	 }
			         },
			         '-',
			         {
			        	 text:'查看',
			        	 iconCls:'icon-yt-information',
			        	 handler:function(){
			        		 var rows = $('#lwglList').datagrid('getSelections');
			        			if (rows.length != 1) {
			        				common.alert('请选择一条信息查看！');return;
			        			}
			        			window.location.href=path+"/jsp/lwglCkDetail.jsp?id="+rows[0].id+"&treeid=20&pid=4";
			        	 }
			         },
			         '-',
			         {
			        	 text:'修改',
			        	 iconCls:'icon-yt-update',
			        	 handler:function(){
			        		 var rows = $('#lwglList').datagrid('getSelections');
			        		 if (rows.length != 1) {
			        			 common.alert('请选择一条信息编辑！');return;
			        		 }else{
			        			 if(rows[0].auditstatus=="2"){
			        				 common.alert('审核已通过的论文不能修改！');return;
			        			 }
			        		 }
			        		 window.location.href=path+"/jsp/lwglDetail.jsp?id="+rows[0].id+"&treeid=20&pid=4";
			        	 }
			         },
			        
			         '-',
			         {
			        	 text:'删除论文',
			        	 iconCls:'icon-yt-delete',
			        	 handler:function(){
			        		 var rows = $('#lwglList').datagrid('getSelections');
			        			if (rows.length == 0) {
			        				common.alert('请选择删除信息！');return;
			        			}
			        			var arr = [];
			        			for (var i = 0; i < rows.length; i++) {
			        				if(rows[i].auditstatus=="2"){
			        					common.alert('审核已通过的论文不能删除！');return;
			        				}else{
			        					arr.push(rows[i].id);
			        				}
			        			}
			        			common.confirm("确认删除信息？", wdlw.delLwgl, arr);
			        	 }
			         },
		         ]
	});
};

wdlw.delLwgl = function(arr){
	$.ajax({
		type:"POST",
		url:path+"/xsjl/delLwgl.action",
		data:{'arr':arr.toString()},
		async:true,
		dataType: 'json',
		success:function(data){
			if(data.result=="success"){
				common.alert('删除成功！');
				$('#lwglList').datagrid("reload");
			}
		}
	});
};