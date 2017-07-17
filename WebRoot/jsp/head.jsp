<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User" import="com.yt.sm.frame.hygl.vo.Person" import="com.yt.sm.frame.hygl.vo.Group"%>
 <style type="text/css">
.a1 {
	color: #fff;
	text-decoration: none;
}
</style>
 <script type="text/javascript">
function hydl(){
	window.location.href=path+"/jsp/login.jsp";
};
function houtai(){
window.location.href=path+"/jsp/admin.jsp";
}
function tuichu(){
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
}
function frontXsjl(){
	$.ajax({
		type:"POST",
		url:path+"/dlzc/frontXsjl.action",
		data:{},
		async:true,
		dataType: 'json',
		success:function(data){
			 if(data.result=="nologin"){
			 	$.messager.alert('信息', '登录后才可查看！');
				setTimeout("window.location.href=path+'/jsp/login.jsp'", 2000);
			}else if(data.result=="login"){
				window.location.href=path+'/jsp/frontxsjl.jsp';
			}
		}
	});
}

//重定向刷新页面
var refresh = function(tid) {
	$.ajax({
		type:"POST",
		url:path+"/xtgl/xt/getZxByPage.action",
		data:{lx:tid,page:1,rows:10,zt:"1",btmc:""},
		async:true,
		dataType:'json',
		success:function(d) {
			var data = d.rows;
			if (d.total == 1) {
				location.href = "<%=request.getContextPath()%>/jsp/zxdetail.jsp?treeid=" + tid + "&zxid=" + data[0].id;
			} else {
				location.href = "<%=request.getContextPath()%>/jsp/zxlist.jsp?treeid=" + tid;
			}
		}
	});
};
</script>
<div style="height:141px;width:1100px;background:url('<%=request.getContextPath()%>/images/logol.jpg');padding-top:15px;padding-right:15px;">
	<table align="right">
		<tr>
			<td style="text-align:right;font-family:'微软雅黑';color:#fff;font-weight:bold;font-size:13px;">
				<%
				User user=(User)session.getAttribute("user");
				Person person=(Person)session.getAttribute("person");
				Group group=(Group)session.getAttribute("group");
				if(user==null){
				%>
				<button onclick="hydl()" class="btn btn-default active" style="font-weight:bold">会员登录</button>
				<button onclick="window.open('<%=request.getContextPath()%>/jsp/fuzhu2.jsp')" class="btn btn-warning active" style="font-weight:bold">申请入会</button>
				<%
				}else{
					if(person!=null){
					%>
					欢迎您,<a href="#" onclick="houtai();" class="a1"><%out.print(person.getXm());%></a> | <a href="#" onclick="tuichu();" class="a1">退出</a>
					<%
					}
					if(group!=null){
					%>
					欢迎您,<a href="#" onclick="houtai();" class="a1"><%out.print(group.getSqdwmc());%></a> | <a href="#" onclick="tuichu();" class="a1">退出</a>
					<%
					}
				}
				%>
			</td>
		</tr>
	</table>
</div>

<nav class="navbar navbar-blue" style="margin:0px;background:url('<%=request.getContextPath()%>/images/btl.jpg') repeat-x">
 	<ul class="nav navbar-nav">
     	<li class="active"><a href="<%=request.getContextPath()%>/jsp/index.jsp">首页</a></li>
     	<li class="dropdown">
	     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">学会概要 <span class="caret"></span></a>
	     <ul class="dropdown-menu">
	       <li><a onclick="refresh(10)" href="javascript:">学会简介</a></li>
	       <li><a onclick="refresh(11)" href="javascript:">学会领导</a></li>
	       <li><a onclick="refresh(12)" href="javascript:">学会章程</a></li>
	       <li><a onclick="refresh(13)" href="javascript:">专家委员</a></li>
	     </ul>
	    </li>
     	<li class="dropdown">
	       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">新闻资讯 <span class="caret"></span></a>
	       <ul class="dropdown-menu">
	         <li><a onclick="refresh(15)" href="javascript:">通知公告</a></li>
	       	 <li><a onclick="refresh(16)" href="javascript:">学会动态</a></li>
	       	 <li><a onclick="refresh(17)" href="javascript:">行业新闻</a></li>
	       	 <li><a onclick="refresh(24)" href="javascript:">网上公示</a></li>
	       </ul>
	    </li>
       	<li class="dropdown">
       	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">学会会员 <span class="caret"></span></a>
       	<ul class="dropdown-menu">
       		<li><a href="javascript:" onclick="refresh(27)">个人会员信息</a></li>
	        <li><a href="javascript:" onclick="refresh(28)">团体会员信息</a></li>
	        <li><a href="<%=request.getContextPath()%>/jsp/frontgrhy.jsp" >个人会员</a></li>
	        <li><a href="<%=request.getContextPath()%>/jsp/fronttthy.jsp">团体会员</a></li>
       	</ul>
     	</li>
       	<li class="dropdown">
       	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">测绘科技 <span class="caret"></span></a>
       	<ul class="dropdown-menu">
         <li><a href="#" onclick="frontXsjl();">学术论文</a></li>
         <li><a onclick="refresh(26)" href="javascript:">科普知识</a></li>
       	</ul>
     	</li>
     	<li><a onclick="refresh(25)" href="javascript:">下载专区</a></li>
       	<li><a onclick="refresh(18)" href="javascript:">联系我们</a></li>
   	</ul>
</nav>