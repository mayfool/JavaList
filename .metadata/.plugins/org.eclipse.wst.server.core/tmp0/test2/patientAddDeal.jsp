<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="utf-8"%>
<%@page contentType="text/html;charset=utf-8" language="java" errorPage=""%>
<%request.setCharacterEncoding("utf-8");%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String  id = request.getParameter("id");
String  doctorid= request.getParameter("doctorid");
String  office= request.getParameter("office");
String  balance= request.getParameter("balance");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "hd951113");



String sql = "update patient set doctorid='"+doctorid+"',office='"+office+"',balance='"+balance+"' where id='"+id+"'";
PreparedStatement ps = conn.prepareStatement(sql);
//ps.setString(1, doctorid);
//ps.setString(2, office);
//ps.setString(3,balance);
//ps.setString(2,id);

ps.executeUpdate();
ps.close();
conn.close();

response.sendRedirect("registerSuccess.jsp");
%>

