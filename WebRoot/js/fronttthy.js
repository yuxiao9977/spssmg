var fronttthy = {};
var currentPage = 1;
//初始化
fronttthy.init = function() {
	//fronttthy.initcd();
	fronttthy.initList(currentPage);
};
//初始化菜单
/*fronttthy.initcd = function() {
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
					list += '<a href="'+path+'/jsp/fronttthy.jsp?treeid='+data[i].treeId+'" class="list-group-item list-group-item-info" style="padding-left:55px"><span class="glyphicon glyphicon-hand-right"></span> '+data[i].text+'</a>';
					$("#cdol").html('<li><a href="'+path+'"><span class="glyphicon glyphicon-home"></span> 首页</a></li>'+
					'<li><a href="'+path+'/jsp/fronttthy.jsp?treeid='+treeid+'">'+data[i].text+'</a></li>');
				} else {
					list += '<a href="'+path+'/jsp/fronttthy.jsp?treeid='+data[i].treeId+'" class="list-group-item" style="padding-left:45px">'+data[i].text+'</a>';
				}
			}
			$("#cdgroup").html(list);
		}
	});
};*/
//初始化列表
fronttthy.initList = function(page) {
	currentPage = page;
	$.ajax({
		type:"POST",
		url:path+"/hygl/frontGroupList.action",
		data:{page:page,rows:10,'group.sqdwmc':$("#sqdwmc").val(),'group.lxrxm':$("#lxrxm").val(),},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			/*if (d.total == 1) {
				fronttthy.ckxq(data[0].id);
				return;
			}*/
			var tr = '<tr><td><span class="glyphicon" style="font-size:16px;font-weight: bold;margin-left:10px; "> 申请单位名称</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">单位地址</span> '+'</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">联系人姓名</span> '+'</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">测绘资质级别</span> '+'</td><td width="88px" style="font-size:16px;font-weight: bold;">'+'入会时间'+'</td></tr>';
			for (var i = 0; i < data.length; i++) {
				tr += '<tr><td><span class="glyphicon "></span> ' + data[i].sqdwmc +'</td><td><span class="glyphicon "></span> ' + data[i].dwdz+'</td><td><span class="glyphicon "></span> ' + data[i].lxrxm+ '</td><td><span class="glyphicon "></span> ' + data[i].chzzjb+ '</td><td width="88px" style="">'+data[i].rhsj+'</td></tr>';
			}
			$("#zxTab").html(tr);
		}
	});
};
//上一页
fronttthy.syy = function() {
	if (currentPage > 1) {
		currentPage--;
		fronttthy.initList(currentPage);
	}
};
//下一页
fronttthy.xyy = function() {
	currentPage++;
	fronttthy.initList(currentPage);
};
