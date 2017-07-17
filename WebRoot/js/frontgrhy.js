var frontgrhy = {};
var currentPage = 1;
//初始化
frontgrhy.init = function() {
	//frontgrhy.initcd();
	frontgrhy.initList(currentPage);
};
//初始化菜单
/*frontgrhy.initcd = function() {
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
					list += '<a href="'+path+'/jsp/frontgrhy.jsp?treeid='+data[i].treeId+'" class="list-group-item list-group-item-info" style="padding-left:55px"><span class="glyphicon glyphicon-hand-right"></span> '+data[i].text+'</a>';
					$("#cdol").html('<li><a href="'+path+'"><span class="glyphicon glyphicon-home"></span> 首页</a></li>'+
					'<li><a href="'+path+'/jsp/frontgrhy.jsp?treeid='+treeid+'">'+data[i].text+'</a></li>');
				} else {
					list += '<a href="'+path+'/jsp/frontgrhy.jsp?treeid='+data[i].treeId+'" class="list-group-item" style="padding-left:45px">'+data[i].text+'</a>';
				}
			}
			$("#cdgroup").html(list);
		}
	});
};*/
//初始化列表
frontgrhy.initList = function(page) {
	currentPage = page;
	$.ajax({
		type:"POST",
		url:path+"/hygl/frontPersonList.action",
		data:{page:page,rows:20,'person.xm':$("#xm").val(),'person.gzdw':$("#gzdw").val(),'person.bhzw':$("#bhzw").val(),},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			/*if (d.total == 1) {
				frontgrhy.ckxq(data[0].id);
				return;
			}*/
			var tr = '<tr><td><span class="glyphicon" style="font-size:16px;font-weight: bold;margin-left:10px; "> 姓名</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;margin-left:50px;;">性别</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;margin-left:100px;">工作单位</span> '+ '</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">现从事工作</span> '+'</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">技术职称</span> '+'</td><td><span class="glyphicon " style="font-size:16px;font-weight: bold;">本会职务</span> '+'</td><td width="88px" style="font-size:16px;font-weight: bold;">'+'入会时间'+'</td></tr>';
			for (var i = 0; i < data.length; i++) {
				tr += '<tr><td><span class="glyphicon "></span> ' + data[i].xm + '</td><td><span class="glyphicon" style="margin-left:50px;"></span> ' + data[i].xb + '</td><td><span class="glyphicon" style="margin-left:90px;"></span> ' + data[i].gzdw+'</td><td><span class="glyphicon "></span> ' + data[i].xcsgz+'</td><td><span class="glyphicon "></span> ' + data[i].jszc+ '</td><td><span class="glyphicon "></span> ' + data[i].bhzw+ '</td><td width="110px" ">'+data[i].hsrh+'</td></tr>';
			}
			$("#zxTab").html(tr);
		}
	});
};
//上一页
frontgrhy.syy = function() {
	if (currentPage > 1) {
		currentPage--;
		frontgrhy.initList(currentPage);
	}
};
//下一页
frontgrhy.xyy = function() {
	currentPage++;
	frontgrhy.initList(currentPage);
};
