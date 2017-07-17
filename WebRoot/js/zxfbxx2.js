var zxfbxx = {};
//初始化2
zxfbxx.init = function() {
	zxfbxx.initBtDh();
	if (flag == "upd") {
		zxfbxx.getZxById();
	}
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
//查询资讯ById
zxfbxx.getZxById = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxById.action",
		data:{id:id},
		async:true,
		dataType:'json',
		success:function(data) {
			$("#ztinput").val(data.btmc);
			$("#fbdwinput").val(data.fbdw);
			$("#fbsjinput").val(data.fbsj.substr(0,16));
			editor.html(data.zxnr);
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
		data:{btmc:btmc,fbdw:fbdw,fbsj:fbsj,zxnr:zxnr,lx:treeid,zt:"0"},
		async:true,
		dataType:'json',
		success:function(data) {
			if (data.result == "success") {
				location.href = path + "/jsp/zxfblb.jsp?treeid=" + treeid + "&pid=" + pid;
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
				location.href = path + "/jsp/zxfblb.jsp?treeid=" + treeid + "&pid=" + pid;
			}
		}
	});
};
//返回
zxfbxx.goback = function() {
	location.href = path + "/jsp/zxfblb.jsp?treeid=" + treeid + "&pid=" + pid;
};
