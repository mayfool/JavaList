<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "hd951113");

String sqlQuery = "select count(*) from doctor where id = ?";
PreparedStatement psQuery = conn.prepareStatement(sqlQuery);
psQuery.setString(1, username);
ResultSet rs = psQuery.executeQuery();
rs.next();
int count = rs.getInt(1);
if(count > 0) {
	response.sendRedirect("registerFail.jsp");
	psQuery.close();
	conn.close();
	return;
}

String sql = "insert into doctor values (?, null,null,?,null)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ps.executeUpdate();
ps.close();
conn.close();

response.sendRedirect("registerSuccess.jsp");
%>

