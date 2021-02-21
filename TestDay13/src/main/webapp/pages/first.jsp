<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/5
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择项目界面</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/addIn.lh">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <td colspan="3">
                    <h1>企业项目管理系统</h1>
                </td>
            </tr>
            <tr>
                <td>选择项目</td>
                <td>
                    <select name="projectId">
                        <c:forEach items="${projectList}" var="project">
                            <option value="${project.id}">
                                    ${project.projectName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="确定"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
