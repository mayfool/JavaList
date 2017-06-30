<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="utf-8"%>
<%@page contentType="text/html;charset=utf-8" language="java" errorPage=""%>
<%request.setCharacterEncoding("utf-8");%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String  id = request.getParameter("id");
String  name= request.getParameter("name");
String  age= request.getParameter("age");
String  sex= request.getParameter("sex");
String  doctorid= request.getParameter("doctorid");
String  roomin= request.getParameter("roomin");
String  office= request.getParameter("office");
String  balance= request.getParameter("balance");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "hd951113");



String sql = "insert into patient values (?, ?,?,?,?,?,null,?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, id);
ps.setString(2, name);
ps.setString(3,age);
ps.setString(4,sex);
ps.setString(5,doctorid);
ps.setString(6,roomin);
ps.setString(7,balance);
ps.executeUpdate();
ps.close();
conn.close();

response.sendRedirect("testLogin.jsp");
%>

