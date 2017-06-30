<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>

<html>
  <head>
    <title>病人管理</title>
  </head>
    <%    
     System.out.println("haoleme");
     System.out.print(request.getParameter("uname"));
         %>
  <%
	//装载MySQL5.5的JDBC驱动
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	//建立数据库连接
	String url ="jdbc:mysql://localhost:3306/javademo?user=root&password=hd951113&useUnicode=true&characterEncoding=utf-8";
	Connection conn= DriverManager.getConnection(url);
	//建立一个Statement对象，用于执行SQL语句
	Statement stat = conn.createStatement();
	ResultSet rs;
	 PreparedStatement pstmt = null; 
	//执行查询并得到查询结果
	//String sql = "select * from patient where id=?";
	  String sql = "select * from patient where doctorid=?";
      pstmt = conn.prepareStatement(sql);
      System.out.println("获取id"+request.getParameter("uname"));
   
     pstmt.setString(1, request.getParameter("uname"));
   
   // System.out.println( request.getParameter("id"));

    rs = pstmt.executeQuery();
	//rs = stat.executeQuery(sql);	
  %>   
  <body>
    <h2>病人管理</h2>
    <hr> 
	<table border="1" width="600">
		<tr bgcolor="#dddddd">
			<td align="center" width="80">病人id</td> 
			<td align="center">病人信息</td>
			<td align="center" width="100">修改信息</td>
		</tr>
		<%
		 String id;
		 id="love";
	
		   // doctorid=age;
		   
		    //balance=age;
			//将查询结果集中的记录输出到页面上
			while (rs.next()){
				//从当前记录中读取各字段的值
			
				out.println("<tr>");
				
				out.println("<td>");
				out.println("入院编号："+ rs.getString(1)+"<br>");
				out.println("</td>");
				out.println("<td>");
				out.println("姓名："+ rs.getString(2) +"<br>");
				out.println("年龄："+ rs.getString(3) +"<br>");
				out.println("性别："+ rs.getString(4) +"<br>");
				out.println("医生编号："+ rs.getString(5) +"<br>");
				out.println("住院时间："+ rs.getString(6) +"<br>");
				out.println("科室："+ rs.getString(7) +"<br>");
				out.println("账户："+ rs.getString(8) +"<br>");
				out.println("</td>");
				out.println("<td><a href='patientAddView.jsp'>更改病人信息</a></td>");
				out.println("</tr>");
			}
		%>		
	</table>
	<br>
	<a href="testLogin.jsp">登陆界面</a>  
	<a href="patientChangeView.jsp">增加病人</a>  
		       
  </body>
</html>
