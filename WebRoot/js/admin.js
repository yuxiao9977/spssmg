admin = {};
admin.td = null;
admin.init = function() {
	admin.initMenu();
};
admin.initMenu = function() {
	$.ajax({
		type:"POST",
		url: path + "/hygl/findAdminMenu.action",
		data: {},
		async: true,
		dataType: 'json',
		success: function(data) {
			$(data).each(function(index, obj) {
				if (obj.pid == "0") {
					$("#dhcd").append(
						"<div id="+obj.id+" class=\"list-group\" style=\"margin:0px;\">"+
						"<a href=\"#\" class=\"list-group-item list-group-item-info\" style='background:#47a3d4;color:#fff'><span class='glyphicon glyphicon-star'></span> "+obj.text+"</a>"
				  	);
					$(data).each(function(index,obj2){
						if (obj2.pid == obj.id) {
							$("#"+obj.id).append(
								"<a href=\""+path+obj2.url+"\" target=\"contentFrame\" onmouseover='admin.listover(this)' onmouseout='admin.listout(this)' onmouseup='admin.listup(this)' " +
								"class=\"list-group-item list-group-item-success\" " +
								"style='background:#f9f9f9;color:#000;padding-left:43px'>" +
								"<span class='glyphicon glyphicon-star-empty'></span> "+
								obj2.text+"</a>"
							);
						}
						
					});
					$("#dhcd").append("</div>");
				}
			});
		}
	});
};
admin.tuichu=function(){
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
};
admin.shouye=function(){
	window.location.href=path+"/jsp/index.jsp";
};
admin.listover = function(p) {
	if (p != admin.td) {
		p.style.background = "#e1e1e1";
	}
};
admin.listout = function(p) {
	if (p != admin.td) {
		p.style.background = "#f9f9f9";
	}
};
admin.listup = function(p) {
	if (admin.td != null) {
		admin.td.style.background = "#f9f9f9";
	}
	p.style.background = "#efc1dc";
	admin.td = p;
};