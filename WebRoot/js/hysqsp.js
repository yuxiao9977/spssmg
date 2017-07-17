hysqsp={};
hysqsp.init=function(){
	hysqsp.initdatagrid();
};
hysqsp.initdatagrid=function(){
	hysqsp.initInfo();
	hysqsp.initBtDh();
};
//标题导航
hysqsp.initBtDh = function() {
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
hysqsp.initInfo=function(){
	$('#personList').datagrid({
		url:path+"/hygl/findPersonList.action?flag2=13",
		method:"post",
		striped:true,
		pagination:true,
		title:"个人会员列表",
		//width:"790px",
		//height:"345px",
		rownumbers:true,
		pageSize: 10,
		loadMsg:"数据加载中...",
		columns:[[
		        {field:'ck',checkbox:true},
		        {field:'id',title:'主键',width:90,align:'center',hidden:true},
		        {field:'xm',title:'姓名',width:60,align:'center'},
		        {field:'xb',title:'性别',width:40,align:'center'},
		        {field:'jg',title:'籍贯',width:150,align:'center'},
		        {field:'gzdw',title:'工作单位',width:200,align:'center'},
		        {field:'hsrh',title:'入会时间',width:80,align:'center'},
		        {field:'bhzw',title:'本会职务',width:70,align:'center'},
		        {field:'auditStatus',title:'审核状态',width:80,align:'center',formatter:function(value, rowData, rowIndex){
		        	if(value=="1"){
		        			return "待审核";
		        		}else if(value=="2"){
		        			return "已通过";
		        		}else if(value=="3"){
		        			return "未通过";
		        		}
		        	}
		        },
		        {field:'tbdate',title:'填表日期',width:80,align:'center'},
		        {field:'zcsj',title:'注册时间',width:160,align:'center'}
		]],
		toolbar:[
			         {
			        	 text:'查询',
			        	 iconCls:'icon-search',
			        	 handler:function(){
			        		 var xm=$("#xm").val();
			        		 var bhzw=$("#bhzw").val();
			        		 var auditStatus=$("#auditStatus").val();
			        		 //alert(auditStatus);
			        		 $('#personList').datagrid('load',{
			        			 "person.xm":xm, "person.bhzw":bhzw, "person.auditStatus":auditStatus
			        			}); 
			        	 }
			         },
			         '-',
			         {
			        	 text:'审批',
			        	 iconCls:'icon-yt-add',
			        	 handler:function(){
			        		 var rows = $('#personList').datagrid('getSelections');
			        		 
			        			if (rows.length != 1) {
			        				common.alert('请选择一条信息查看！');return;
			        			}
			        			window.location.href=path+"/jsp/grhysp.jsp?id="+rows[0].id+"&treeid=7&pid=1";
			        	 }
			         },
			         '-',
			         {
			        	 text:'删除会员',
			        	 iconCls:'icon-yt-delete',
			        	 handler:function(){
			        		 var rows = $('#personList').datagrid('getSelections');
			        			if (rows.length == 0) {
			        				common.alert('请选择删除信息！');return;
			        			}
			        			var arr = [];
			        			for (var i = 0; i < rows.length; i++) {
			        				arr.push(rows[i].id);
			        			}
			        			common.confirm("确认删除信息？", hysqsp.delPerson, arr);
			        	 }
			         },
		         ]
	});
	$('#groupList').datagrid({
		url:path+"/hygl/findGroupList.action?flag2=13",
		method:"post",
		striped:true,
		pagination:true,
		title:"团体会员列表",
		width:"950px",
		//height:"345px",
		rownumbers:true,
		pageSize: 10,
		loadMsg:"数据加载中...",
		columns:[[
		        {field:'ck',checkbox:true},
		        {field:'id',title:'主键',width:90,align:'center',hidden:true},
		        {field:'sqdwmc',title:'申请单位名称',width:150,align:'center'},
		        {field:'dwfr',title:'单位法人（或负责人）',width:150,align:'center'},
		        {field:'dwxz',title:'单位性质',width:80,align:'center',formatter:function(value, rowData, rowIndex){
			        	if(value=="1"){
		        			return "事业";
		        		}else if(value=="2"){
		        			return "学校";
		        		}else if(value=="3"){
		        			return "社会团体";
		        		}else if(value=="4"){
		        			return "企业";
		        		}else if(value=="5"){
		        			return "部队";
		        		}
	        		}
		        },
		        {field:'lxrxm',title:'联系人姓名',width:80,align:'center'},
		        {field:'lxdh',title:'联系电话',width:100,align:'center'},
		        {field:'auditStatus',title:'审核状态',width:80,align:'center',formatter:function(value, rowData, rowIndex){
		        	if(value=="1"){
		        			return "待审核";
		        		}else if(value=="2"){
		        			return "已通过";
		        		}else if(value=="3"){
		        			return "未通过";
		        		}
		        	}
		        },
		        {field:'tbdate',title:'填表日期',width:80,align:'center'},
		        {field:'zcsj',title:'注册时间',width:160,align:'center'}
		]],
		toolbar:[
			         {
			        	 text:'查询',
			        	 iconCls:'icon-search',
			        	 handler:function(){
			        		 var sqdwmc=$("#sqdwmc").val();
			        		 var dwfr=$("#dwfr").val();
			        		 var lxrxm=$("#lxrxm").val();
			        		 var auditStatus=$("#auditStatus2").val();
			        		 //alert(auditStatus);
			        		 $('#groupList').datagrid('load',{
			        			 "group.sqdwmc":sqdwmc, "group.dwfr":dwfr, "group.lxrxm":lxrxm,"group.auditStatus":auditStatus
			        			}); 
			        	 }
			         },
			         '-',
			         {
			        	 text:'审批',
			        	 iconCls:'icon-yt-add',
			        	 handler:function(){
			        		 var rows = $('#groupList').datagrid('getSelections');
			        		 
			        			if (rows.length != 1) {
			        				common.alert('请选择一条信息查看！');return;
			        			}
			        			window.location.href=path+"/jsp/tthysp.jsp?id="+rows[0].id+"&treeid=7&pid=1";
			        	 }
			         },
			         '-',
			         {
			        	 text:'删除会员',
			        	 iconCls:'icon-yt-delete',
			        	 handler:function(){
			        		 var rows = $('#groupList').datagrid('getSelections');
			        			if (rows.length == 0) {
			        				common.alert('请选择删除信息！');return;
			        			}
			        			
			        			var arr = [];
			        			for (var i = 0; i < rows.length; i++) {
			        				arr.push(rows[i].id);
			        			}
			        			common.confirm("确认删除信息？", hysqsp.delGroup, arr);
			        	 }
			         },
		         ]
	});
};
hysqsp.delGroup = function(arr){
	//alert(arr);
	$.ajax({
		type:"POST",
		url:path+"/hygl/delGroup.action",
		data:{'arr':arr.toString()},
		async:true,
		dataType: 'json',
		success:function(data){
			if(data.result=="success"){
				common.alert('删除成功！');
				$('#groupList').datagrid("reload");
			}
		}
	});
};
hysqsp.delPerson = function(arr){
	$.ajax({
		type:"POST",
		url:path+"/hygl/delPerson.action",
		data:{'arr':arr.toString()},
		async:true,
		dataType: 'json',
		success:function(data){
			if(data.result=="success"){
				common.alert('删除成功！');
				$('#personList').datagrid("reload");
			}
		}
	});
};
$(function(){
	$('a[data-toggle="tab"]').on('shown.bs.tab',function(e){
		var activeTab=$(e.target).text();
		switch(activeTab){
		case '个人会员审批':
			$('#personList').datagrid("reload");
			break;
		case '团体会员审批':
			$('#groupList').datagrid("reload");
			break;
		}
	});	
});