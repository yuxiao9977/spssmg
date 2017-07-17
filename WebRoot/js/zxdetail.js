var zxdetail = {};
//初始化
zxdetail.init = function() {
	zxdetail.initcd();
	zxdetail.initzw();
};
//初始化菜单
zxdetail.initcd = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getMenuByPid.action",
		data:{},
		async:true,
		dataType:'json',
		success:function(data) {
			var list = '<a href="javascript:" class="list-group-item active" style="font-weight:bold">'
				+'<span class="glyphicon glyphicon-menu-hamburger"></span> 学会目录</a>';
			for (var i = 0; i < data.length; i++) {
				if (data[i].treeId == treeid) {
					list += '<a onclick="zxdetail.refresh('+data[i].treeId+')" href="javascript:" class="list-group-item list-group-item-info" style="padding-left:55px"><span class="glyphicon glyphicon-hand-right"></span> '+data[i].text+'</a>';
					$("#cdol").html('<li><a href="'+path+'"><span class="glyphicon glyphicon-home"></span> 首页</a></li>'+
					'<li><a onclick="zxdetail.refresh('+treeid+')" href="javascript:">'+data[i].text+'</a></li><li class="active">正文</li>');
				} else {
					list += '<a onclick="zxdetail.refresh('+data[i].treeId+')" href="javascript:" class="list-group-item" style="padding-left:45px">'+data[i].text+'</a>';
				}
			}
			$("#cdgroup").html(list);
		}
	});
};
//重定向刷新页面
zxdetail.refresh = function(tid) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByPage.action",
		data:{lx:tid,page:1,rows:10,zt:"1",btmc:""},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			if (d.total == 1) {
				zxdetail.ckxq(tid, data[0].id);
			} else {
				location.href = path + "/jsp/zxlist.jsp?treeid=" + tid;
			}
		}
	});
};
//初始化正文
zxdetail.initzw = function() {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxById.action",
		data:{id:zxid},
		async:true,
		dataType:'json',
		success:function(data) {
			$("#btDiv").html(data.btmc);
			var fbsj = String(data.fbsj).substring(0, 16);
			$("#fbtDiv").html("发布单位："+data.fbdw+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间："+fbsj);
			$("#zwDiv").html(data.zxnr);
		}
	});
};
//查看资讯详情
zxdetail.ckxq = function(tid, zxid) {
	location.href = path + "/jsp/zxdetail.jsp?treeid=" + tid + "&zxid=" + zxid;
};