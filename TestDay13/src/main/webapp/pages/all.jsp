<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/5
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>企业工单列表</title>
</head>
<body>
<div align="center">
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td>工单编号</td>
            <td>项目名称</td>
            <td>执行人</td>
            <td>任务描述</td>
            <td>级别</td>
            <td>创建时间</td>
        </tr>
        <c:forEach items="${workOrderList}" var="workOrder">
            <tr>
                <td>${workOrder.id}</td>
                <td>${workOrder.project.projectName}</td>
                <td>${workOrder.executor}</td>
                <td>${workOrder.description}</td>
                <td>${workOrder.orderLevel}</td>
                <td><fmt:formatDate value="${workOrder.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
