var frontxsjl = {};
var currentPage = 1;
//初始化
frontxsjl.init = function() {
	frontxsjl.initList(currentPage);
};
//初始化菜单
/*frontxsjl.initcd = function() {
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
					list += '<a href="'+path+'/jsp/frontxsjl.jsp?treeid='+data[i].treeId+'" class="list-group-item list-group-item-info" style="padding-left:55px"><span class="glyphicon glyphicon-hand-right"></span> '+data[i].text+'</a>';
					$("#cdol").html('<li><a href="'+path+'"><span class="glyphicon glyphicon-home"></span> 首页</a></li>'+
					'<li><a href="'+path+'/jsp/frontxsjl.jsp?treeid='+treeid+'">'+data[i].text+'</a></li>');
				} else {
					list += '<a href="'+path+'/jsp/frontxsjl.jsp?treeid='+data[i].treeId+'" class="list-group-item" style="padding-left:45px">'+data[i].text+'</a>';
				}
			}
			$("#cdgroup").html(list);
		}
	});
};*/
//初始化列表
frontxsjl.initList = function(page) {
	currentPage = page;
	$.ajax({
		type:"POST",
		url:path+"/xsjl/frontXsjlList.action",
		data:{page:page,rows:10},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			/*if (d.total == 1) {
				frontxsjl.ckxq(data[0].id);
				return;
			}*/
			var tr = '<tr><td><span class="glyphicon" style="font-size:16px;font-weight: bold;margin-left:10px; "> 论文题目</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold; ">论文作者</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">作者单位</span> '+ '</td><td width="100px" style="font-size:16px;font-weight: bold;">'+'发布时间'+'</td></tr>';
			for (var i = 0; i < data.length; i++) {
				var sj = String(data[i].fbsj).substring(0, 10).replace(/-/g, "/");
				tr += '<tr onclick="frontxsjl.ckxq('+data[i].id+')"><td><span class="glyphicon glyphicon-menu-right"></span> ' + data[i].lwtm + '</td><td><span class="glyphicon "></span> ' + data[i].lwzz + '</td><td><span class="glyphicon "></span> ' + data[i].zzdw + '</td><td width="100px" style="">'+sj+'</td></tr>';
			}
			$("#zxTab").html(tr);
		}
	});
};
//上一页
frontxsjl.syy = function() {
	if (currentPage > 1) {
		currentPage--;
		frontxsjl.initList(currentPage);
	}
};
//下一页
frontxsjl.xyy = function() {
	currentPage++;
	frontxsjl.initList(currentPage);
};
//查看资讯详情
frontxsjl.ckxq = function(id) {
	location.href = path + "/jsp/frontxsjldetail.jsp?id=" +id;
};