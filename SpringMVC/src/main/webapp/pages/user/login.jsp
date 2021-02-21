<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/10/31
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userServlet/back14.s" method="post">
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td>
                <input type="number" name="age"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
