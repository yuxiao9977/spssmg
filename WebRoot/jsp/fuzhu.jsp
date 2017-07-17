<%@ page language="java" pageEncoding="UTF-8" import="com.yt.sm.frame.hygl.vo.User"%>
 <% String path = request.getContextPath();
 	User user=(User)session.getAttribute("user");
 	//out.print("&&&&&&&&"+user.getIsGroup()+user.getIsAdmin());
	 if(user.getIsGroup().equals("2")){//个人非管理员登录
		response.sendRedirect(path+"/jsp/grxxgl.jsp?treeid=5&pid=1") ;
	}else if(user.getIsGroup().equals("1")){//团体非管理员
		response.sendRedirect(path+"/jsp/ttxxgl.jsp?treeid=5&pid=1") ;
	} 
   %>