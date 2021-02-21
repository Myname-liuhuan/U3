<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/3
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadServlet/upload.s" method="post" enctype="multipart/form-data">
    上传文件: <input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
