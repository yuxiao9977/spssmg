var zxfblb = {};
var id = "";
//初始化
zxfblb.init = function() {
	zxfblb.initBtDh();
	zxfblb.initList();
};
//标题导航
zxfblb.initBtDh = function() {
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
//初始化列表
zxfblb.initList = function() {
	 $('#zxList').datagrid({
		 url:path+"/xtgl/xt/getZxByPage.action",
		 method:"post",
		 striped:true,
		 pagination:true,
		 singleSelect:true,
		 width:"100%",
		 queryParams:{lx:treeid},
		 rownumbers:true,
		 loadMsg:"数据加载中...",
		 columns:[[
		     {field:'id',checkbox:true},
		     {field:'btmc',title:'标题',width:600,align:'left'},
		     {field:'fbsj',title:'发布时间',width:120,align:'left',formatter:function(value, rowData, rowIndex){
		    	 return value.substr(0, 16);
		     }},
		     {field:'fbdw',title:'发布单位',width:140,align:'left'},
		     {field:'zt',title:'发布状态',width:80,align:'center',formatter:function(value, rowData, rowIndex){
		    	 if (value == 0) {
		    		 return "<img src='"+path+"/images/icons/delete.png'/>";
		    	 } else {
		    		 return "<img src='"+path+"/images/icons/accept.png'/>";
		    	 }
		     }}
		 ]],
		 toolbar: [{
			 text: '添加', 
	            iconCls: 'icon-add',
	            handler: function() {
	            	location.href = path + "/jsp/zxfbxx2.jsp?treeid=" + treeid + "&pid=" + pid + "&flag=add";
	            }
		 },'-',{
			 text: '编辑', 
	            iconCls: 'ch-icon-edit',
	            handler: function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	location.href = path + "/jsp/zxfbxx2.jsp?treeid=" + treeid + "&pid=" + pid + "&flag=upd&id=" + rows[0].id;
	            }
		 },'-',{
			 text: '发布', 
	            iconCls: 'ch-icon-ok', 
	            handler: function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	zxfblb.modZt(rows[0].id, 1);
	            }
		 },'-',{
			 text: '取消发布', 
	            iconCls: 'ch-icon-cancel', 
	            handler: function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	zxfblb.modZt(rows[0].id, 0);
	            }
		 },'-',{
			 text:'删除', 
	            iconCls:'ch-icon-delete', 
	            handler:function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	common.confirm("确定要删除吗?", zxfblb.deleteZx, rows[0].id);
	            }
		 }]
	 });
};
//查询
zxfblb.search = function() {
	var btmc = $.trim($("#btmcinput").val());
	var zt = $.trim($("#fbztselect").val());
	$('#zxList').datagrid('reload',{
		lx:treeid,btmc:btmc,zt:zt,pageNumber:1
	});
};
//修改状态
zxfblb.modZt = function(id, zt) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/updZxZt.action",
		data:{id:id,zt:zt},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				$('#zxList').datagrid('reload',{
					lx:treeid,btmc:$.trim($("#btmcinput").val()),
					zt:$.trim($("#fbztselect").val())
				});
			}
		}
	});
};
//删除资讯
zxfblb.deleteZx = function(id) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/delZxById.action",
		data:{id:id},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				$('#zxList').datagrid('reload',{
					lx:treeid,btmc:$.trim($("#btmcinput").val()),
					zt:$.trim($("#fbztselect").val())
				});
			}
		}
	});
};