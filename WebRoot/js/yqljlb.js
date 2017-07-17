var zxfblb = {};
var id = "";
var fbsj = "";
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
		 pageSize:50,
		 loadMsg:"数据加载中...",
		 columns:[[
		     {field:'id',checkbox:true},
		     {field:'btmc',title:'名称',width:200,align:'left'},
		     {field:'zxnr',title:'链接地址',width:750,align:'left'}
		 ]],
		 toolbar: [{
			 text:'添加', 
	            iconCls:'icon-add',
	            handler:function() {
	            	$("#ljgl").dialog({
	            		title:"添加链接",
	            		iconCls:"icon-add",
	            		buttons:[{
	            			text:'保存',
	            			iconCls:'icon-save',
	            		    handler:function() {
	            		    	zxfblb.addZx();
	            		    }
	            		}]
	            	});
	            	$("#ljgl").dialog("open");
	            	$("#mcinput").textbox("setValue", "");
	            	$("#ljinput").textbox("setValue", "");
	            	$("#tipdiv").html("");
	            }
		 },'-',{
			 text: '编辑', 
	            iconCls: 'ch-icon-edit',
	            handler: function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	$("#ljgl").dialog({
	            		title:"编辑链接",
	            		iconCls:"icon-edit",
	            		buttons:[{
	            			text:'保存',
	            			iconCls:'icon-save',
	            		    handler:function() {
	            		    	zxfblb.updZx();
	            		    }
	            		}]
	            	});
	            	$("#ljgl").dialog("open");
	            	$("#mcinput").textbox("setValue", rows[0].btmc);
	            	$("#ljinput").textbox("setValue", rows[0].zxnr);
	            	$("#tipdiv").html("");
	            	id = rows[0].id;
	            	fbsj = rows[0].fbsj;
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
//修改资讯
zxfblb.updZx = function() {
	var mc = $.trim($("#mcinput").textbox("getValue"));
	var dz = $.trim($("#ljinput").textbox("getValue"));
	if (mc == "" || dz == "") {
		$("#tipdiv").html("信息录入不完整");
		return;
	}
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/updZx.action",
		data:{id:id,btmc:mc,zxnr:dz,fbdw:"山东测绘学会",fbsj:fbsj},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				$('#zxList').datagrid('reload');
				$("#ljgl").dialog("close");
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
				$('#zxList').datagrid('reload');
			}
		}
	});
};
//添加链接
zxfblb.addZx = function() {
	var mc = $.trim($("#mcinput").textbox("getValue"));
	var dz = $.trim($("#ljinput").textbox("getValue"));
	if (mc == "" || dz == "") {
		$("#tipdiv").html("信息录入不完整");
		return;
	}
	var date = new Date();
	var sj = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + 
			date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/addZx.action",
		data:{btmc:mc,zxnr:dz,fbdw:"山东测绘学会",fbsj:sj,lx:treeid,zt:"1"},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				$('#zxList').datagrid('reload');
				$("#ljgl").dialog("close");
			}
		}
	});
};