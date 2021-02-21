<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/5
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新界面</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/update.lh" method="post">
        <input type="hidden" name="eid" value="${emp.eid}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="eName" value="${emp.eName}"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="eSex" value="男" <c:if test="${emp.eSex=='男'}">checked</c:if>>男
                    <input type="radio" name="eSex" value="女" <c:if test="${emp.eSex=='女'}">checked</c:if>>女
                </td>
            </tr>
            <tr>
                <td>工资:</td>
                <td><input type="text" name="ePay" value="${emp.ePay}"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td>
                    <select name="did">
                        <option value="">--请选择--</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.did}" <c:if test="${dept.did==emp.did}">selected</c:if>>
                                    ${dept.dName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>入职日期:</td>
                <td><input type="date" name="eStartTime" value="<fmt:formatDate value='${emp.eStartTime}' pattern='yyyy-MM-dd'/>"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="修改">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
