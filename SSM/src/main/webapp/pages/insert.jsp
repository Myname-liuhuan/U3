<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/4
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入用户数据</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/insert.lh" method="post">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="eName"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="eSex" value="男" checked>男
                    <input type="radio" name="eSex" value="女">女
                </td>
            </tr>
            <tr>
                <td>工资:</td>
                <td><input type="text" name="ePay"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td>
                    <select name="did">
                        <option value="">--请选择--</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.did}">${dept.dName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>入职日期:</td>
                <td><input type="date" name="eStartTime"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script>
    //表单验证

</script>
</html>
