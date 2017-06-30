<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>


</head>

<body>
    <center>
        <h1>登陆操作!</h1>
    </center>
    <hr>
    <form action="testLoginCheck.jsp" method="post">
        <table border="1">
            <tr>
                <td colspan="2">用户登陆</td>

            </tr>
            <tr>
                <td>登陆 ID:</td>
                <td><input type="text" name="id">
                </td>
            </tr>

            <tr>
                <td>登陆密码:</td>
                <td><input type="password" name="password">
                </td>
            </tr>

            </tr>

            <tr>
                <td colspan="2"><input type="submit" value = "登陆!">
                <td colspan="2"><input type="reset" value = "重置!">
                </td>
            </tr>
        </table>

    </form>
    <a href="testRegister.jsp">注册</a>   
</body>
</html>