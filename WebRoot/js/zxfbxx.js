var zxfbxx = {};
//初始化
zxfbxx.init = function() {
	zxfbxx.initBtDh();
	zxfbxx.getZxByLxOne();
};
//标题导航
zxfbxx.initBtDh = function() {
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
//清空表单
zxfbxx.clearForm = function() {
	var forms = $(".form-control");
	for (var i = 0; i < forms.length; i++) {
		$(forms[i]).val("");
	}
	$("#fbdwinput").val("山东测绘学会");
	editor.html("");
};
//查询资讯By类型一条数据
zxfbxx.getZxByLxOne = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByLx.action",
		data:{lx:treeid},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.length > 0) {
				$("#ztinput").val(data[0].btmc);
				$("#fbdwinput").val(data[0].fbdw);
				$("#fbsjinput").val(data[0].fbsj.substr(0,16));
				editor.html(data[0].zxnr);
				flag = "upd";
				id = data[0].id;
			} else {
				flag = "add";
			}
		}
	});
};
//保存或添加资讯
zxfbxx.saveZx = function() {
	if (flag == "add") {
		zxfbxx.addZx();
	} else {
		zxfbxx.updZx();
	}
};
//添加资讯
zxfbxx.addZx = function() {
	var btmc = $("#ztinput").val();
	var fbdw = $("#fbdwinput").val();
	var fbsj = $("#fbsjinput").val();
	var zxnr = editor.html();
	if (btmc == "" || fbdw == "" || fbsj == "" || zxnr == "") {
		common.alert("信息录入不完整");
		return;
	}
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/addZx.action",
		data:{btmc:btmc,fbdw:fbdw,fbsj:fbsj,zxnr:zxnr,lx:treeid,zt:"1"},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				location.href = path + "/jsp/zxfbxx.jsp?treeid=" + treeid + "&pid=" + pid;
			}
		}
	});
};
//更新资讯
zxfbxx.updZx = function() {
	var btmc = $("#ztinput").val();
	var fbdw = $("#fbdwinput").val();
	var fbsj = $("#fbsjinput").val();
	var zxnr = editor.html();
	if (btmc == "" || fbdw == "" || fbsj == "" || zxnr == "") {
		common.alert("信息录入不完整");
		return;
	}
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/updZx.action",
		data:{btmc:btmc,fbdw:fbdw,fbsj:fbsj,zxnr:zxnr,id:id},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				location.href = path + "/jsp/zxfbxx.jsp?treeid=" + treeid + "&pid=" + pid;
			}
		}
	});
};