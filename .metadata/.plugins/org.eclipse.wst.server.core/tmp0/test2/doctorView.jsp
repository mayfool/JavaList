<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台欢迎页</title>
	
</head>
<body marginwidth="0" marginheight="0">
  <%    
     System.out.println("haoleme");
     System.out.print(request.getParameter("uname"));
         %>
	<div class="container">
		<div class="">您当前的位置：<a href="">管理首页</a>><a href="">病人管理</a></a></div>
		<div class="public-content">
			<div class="">
				<h3>我的病人管理</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width:10%">ID</th>
						<th style="width:10%">姓名</th>
						<th style="width:10%">账户余额</th>
						<th style="width:10%">截止时间</th>
						<th style="width:10%">科室</th>
						<th style="width:30%">诊断单</th>
					</tr>
					<tr>
						<td>4</td>
						<td>张三</td>
						<td>4555</td>						
						<td>2016-6-3</td>	
						<td>外科</td>						
						<td>
							<div class="">
								<a href="testlogin.jsp">诊断</a>
								<a href="">检查</a>
								<a href="">转科</a>
							</div>
						</td>
					</tr>
				</table>
				<div class="page">
					<form action="" method="get">
					共<span>1</span>个病人
						<a href="">首页</a>
						<a href="">上一页</a>
						<a href="">下一页</a>
						第<span style="color:red;font-weight:600">1</span>页
						共<span style="color:red;font-weight:600">1</span>页
						<input type="text" class="page-input">
						<input type="submit" class="page-btn" value="跳转">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>