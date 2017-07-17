var zxlist = {};
var currentPage = 1;
//初始化
zxlist.init = function() {
	zxlist.initcd();
	zxlist.initList(currentPage);
};
//初始化菜单
zxlist.initcd = function() {
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
					list += '<a onclick="zxlist.refresh('+data[i].treeId+')" href="javascript:" class="list-group-item list-group-item-info" style="padding-left:55px"><span class="glyphicon glyphicon-hand-right"></span> '+data[i].text+'</a>';
					$("#cdol").html('<li><a href="'+path+'"><span class="glyphicon glyphicon-home"></span> 首页</a></li>'+
					'<li><a onclick="zxlist.refresh('+treeid+')" href="javascript:">'+data[i].text+'</a></li>');
				} else {
					list += '<a onclick="zxlist.refresh('+data[i].treeId+')" href="javascript:" class="list-group-item" style="padding-left:45px">'+data[i].text+'</a>';
				}
			}
			$("#cdgroup").html(list);
		}
	});
};
//重定向刷新页面
zxlist.refresh = function(tid) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByPage.action",
		data:{lx:tid,page:1,rows:10,zt:"1",btmc:""},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			if (d.total == 1) {
				zxlist.ckxq(tid, data[0].id);
			} else {
				location.href = path + "/jsp/zxlist.jsp?treeid=" + tid;
			}
		}
	});
};
//初始化列表
zxlist.initList = function(page) {
	currentPage = page;
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByPage.action",
		data:{lx:treeid,page:page,rows:10,zt:"1",btmc:""},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			var tr = '';
			for (var i = 0; i < data.length; i++) {
				var sj = String(data[i].fbsj).substring(0, 10).replace(/-/g, "/");
				tr += '<tr onclick="zxlist.ckxq('+treeid+','+data[i].id+')"><td><span class="glyphicon glyphicon-menu-right"></span> ' + data[i].btmc + '</td><td width="88px" style="color:#999">'+sj+'</td></tr>';
			}
			$("#zxTab").html(tr);
		}
	});
};
//上一页
zxlist.syy = function() {
	if (currentPage > 1) {
		currentPage--;
		zxlist.initList(currentPage);
	}
};
//下一页
zxlist.xyy = function() {
	currentPage++;
	zxlist.initList(currentPage);
};
//查看资讯详情
zxlist.ckxq = function(tid, zxid) {
	location.href = path + "/jsp/zxdetail.jsp?treeid=" + tid + "&zxid=" + zxid;
};