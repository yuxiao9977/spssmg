var index = {};
index.login = function() {
	$.ajax({
		type:"POST",
		url:path+"/dlzc/login.action",
		data:{'user.username':$("#username").val(),'user.password':$("#password").val()},
		async:true,
		dataType: 'json',
		success:function(data){
			//alert(data.result);
			if(data.result=="error"){
				common.alert("密码不正确！");
			}else if(data.result=="nouser"){
				common.alert("用户名不存在!");
			}else if(data.result=="onAudit"){
				common.alert("未审核，不能登录!");
			}else if(data.result=="Audit"){
				common.alert("审核不通过 <br/>"+data.idea);
			}else if(data.result=="success"){
				window.location.href=path+"/jsp/index.jsp";
			}
		}
	});
};
/*index.houtai=function(){
	window.location.href=path+"/jsp/admin.jsp";
};
index.hydl=function(){
	window.location.href=path+"/jsp/login.jsp";
};
index.tuichu=function(){
	$.ajax({
		type:"POST",
		url:path+"/dlzc/tuichu.action",
		data:{},
		async:true,
		dataType: 'json',
		success:function(data){
			 if(data.result=="success"){
				window.location.href=path+"/jsp/index.jsp";
			}
		}
	});
};*/
//初始化
index.init = function() {
	index.initTp();//初始化图片
	index.initYqlj();//初始化友情链接
	index.initzxxw("15", "tzggPanel");//通知公告
	index.initzxxw("16", "xhdtPanel");//学会动态
	index.initzxxw("17", "hyxwPanel");//行业新闻
	index.initzxxw("14", "zcfgPanel");//政策法规
};
//初始化图片
index.initTp = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getXwtpList.action",
		data:{},
		async:true,
		dataType:'json',
		success:function(data) {
			var ols = "";
			var divs = "";
			for (var i = 0; i < data.length; i++) {
				var url = data[i].url == "#" ? "#" : data[i].url;
				if (i == 0) {
					ols += '<li data-target="#carousel-example-generic" data-slide-to="'+i+'" class="active"></li>';
					divs += '<div class="item active"><a href="'+url+'"><img style="height:300px" src="'+path+data[i].tplj+'"/></a><div class="carousel-caption">'+data[i].tpms+'</div></div>';
				} else {
					ols += '<li data-target="#carousel-example-generic" data-slide-to="'+i+'"></li>';
					divs += '<div class="item"><a href="'+url+'"><img style="height:300px" src="'+path+data[i].tplj+'"/></a><div class="carousel-caption">'+data[i].tpms+'</div></div>';
				}
			}
			$("#lbol").html(ols);
			$("#lbdiv").html(divs);
		}
	});
};
//初始化友情链接
index.initYqlj = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getYqljList.action",
		data:{},
		async:true,
		dataType:'json',
		success:function(data) {
			var tr = "";
			for (var i = 0; i < data.length; i++) {
				if (i % 6 == 0) {
					tr += '<tr>';
				}
				tr += '<td><a href="'+data[i].zxnr+'" target="_blank">'+data[i].btmc+'</a></td>';
				if ((i+1) % 6 == 0) {
					tr += '</tr>';
				}
			}
			if (data.length % 6 != 0) {
				var cnt = 6 - (data.length % 6);
				for (var j = 0; j < cnt; j++) {
					tr += '<td></td>';
				}
				tr += '</tr>';
			}
			$("#yqljTab").html(tr);
		}
	});
};
//初始化资讯新闻
index.initzxxw = function(lx, panelId) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByPage.action",
		data:{lx:lx,page:1,rows:6,zt:"1",btmc:""},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			var tab = '<table class="table table-hover" style="cursor:pointer">';
			for (var i = 0; i < data.length; i++) {
				var sj = String(data[i].fbsj).substring(2, 10).replace(/-/g, "/");
				tab += '<tr onclick="index.ckxq('+lx+','+data[i].id+')"><td><div class="letter-short">' + data[i].btmc + '</div></td><td>'+sj+'</td></tr>';
			}
			tab += '<tr><td></td><td style="text-align:right"><span class="label label-warning" onclick="index.ckzxlist('+lx+')">more</span></td></tr></table>';
			$("#"+panelId).html(tab);
		}
	});
};
//查看资讯详情
index.ckxq = function(treeid, zxid) {
	location.href = path + "/jsp/zxdetail.jsp?treeid=" + treeid + "&zxid=" + zxid;
};
//查看资讯列表
index.ckzxlist = function(treeid) {
	location.href = path + "/jsp/zxlist.jsp?treeid=" + treeid;
};