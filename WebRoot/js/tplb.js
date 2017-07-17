var zxfblb = {};
var id = "";
var filePath = "";
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
		 url:path+"/xtgl/xt/getXwtpList.action",
		 method:"post",
		 striped:true,
		 singleSelect:true,
		 nowrap:false,
		 width:"100%",
		 queryParams:{},
		 rownumbers:true,
		 pageSize:50,
		 loadMsg:"数据加载中...",
		 columns:[[
		     {field:'id',checkbox:true},
		     {field:'tpmc',title:'图片名称',width:100,align:'left'},
		     {field:'tpms',title:'图片描述',width:400,align:'left'},
		     {field:'url',title:'链接地址',width:200,align:'left'},
		     {field:'tplj',title:'缩略图',width:250,align:'center',formatter:function(value, rowData, rowIndex){
		    	 return "<a href='"+path+value+"' target='_blank'><img src='"+path+value+"' width='200px' height='80px'/></a>";
		     }}
		 ]],
		 toolbar: [{
			 text:'添加', 
	            iconCls:'icon-add',
	            handler:function() {
	            	$("#tpgladd").dialog("open");
	            	$("#file1").textbox("setValue", "");
	            	$("#tpurl").textbox("setValue", "#");
	            	$("#tpms").textbox("setValue", "");
	            	$("#addtip").html("");
	            }
		 },'-',{
			 text: '编辑', 
	            iconCls: 'ch-icon-edit',
	            handler: function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	$("#tpgledit").dialog("open");
	            	$("#tpurlupd").textbox("setValue", rows[0].url);
	            	$("#tpmsupd").textbox("setValue", rows[0].tpms);
	            	$("#updtip").html("");
	            	id = rows[0].id;
	            }
		 },'-',{
			 text:'删除', 
	            iconCls:'ch-icon-delete', 
	            handler:function() {
	            	var rows = $('#zxList').datagrid('getSelections');
	            	if (rows.length != 1) {
	            		common.alert("请至少选择一条数据");return;
	            	}
	            	filePath = rows[0].tplj;
	            	common.confirm("确定要删除吗?", zxfblb.deleteZx, rows[0].id);
	            }
		 }]
	 });
};
//修改资讯
zxfblb.updZx = function() {
	var url = $.trim($("#tpurlupd").textbox("getValue"));
	var ms = $.trim($("#tpmsupd").textbox("getValue"));
	if (ms == "" || url == "") {
		$("#updtip").html("信息录入不完整");
		return;
	}
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/updXwtp.action",
		data:{id:id,tpms:ms,url:url},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				$('#zxList').datagrid('reload');
				$("#tpgledit").dialog("close");
			}
		}
	});
};
//删除资讯
zxfblb.deleteZx = function(id) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/delXwtp.action",
		data:{id:id,filePath:filePath},
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
	var url = $.trim($("#tpurl").textbox("getValue"));
	var ms = $.trim($("#tpms").textbox("getValue"));
	var file = $.trim($("#file1").filebox("getValue"));
	if (ms == "" || url == "" || file == "") {
		$("#addtip").html("信息录入不完整");
		return;
	}
	$("#theForm").ajaxSubmit({
		url : path + "/upload.jsp?fileType=image",
	    type: "post",
	    success : function(dataStr){
	    	var d = eval("(" + dataStr + ")");
	    	if (d.error == 0) {
	    		$.ajax({
	    			type:"POST",
	    			url:path+"/xtgl/xt/addXwtp.action",
	    			data:{tpmc:d.fn,tpms:ms,tplj:d.url,url:url},
	    			async:true,
	    			dataType:'json',
	    			success:function(data) {
	    				if (data.result == "success") {
	    					$('#zxList').datagrid('reload');
	    					$("#tpgladd").dialog("close");
	    				}
	    			}
	    		});
	    	} else {
	    		$("#addtip").html(d.message);
	    	}
	   }
	});
};