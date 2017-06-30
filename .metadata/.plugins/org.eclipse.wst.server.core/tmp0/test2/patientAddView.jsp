<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page contentType="text/html;charset=utf-8"  errorPage=""%>
<%request.setCharacterEncoding("utf-8");%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>病人信息管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form method="post" action="patientAddDeal.jsp"><br>
     id：<input type="text" name="id"><br>
     doctorid：    <input type="text" name="doctorid"><br>
     office：    <input type="text" name="office"><br>
     balance：    <input type="text" name="balance"><br>
     <input type="submit" value="提交"/><br>
     </form><br>
  </body>
</html>
