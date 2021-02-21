<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/5
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加项目信息界面</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/addOut.lh" method="post" onsubmit="return check()">
        <input type="hidden" name="projectId" value="${projectId}">
        <input type="hidden" name="createDate" value="" id="createDate">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <td colspan="2"><h1>添加工单</h1></td>
            </tr>
            <tr>
                <td>执行人(*)</td>
                <td><input type="text" name="executor" id="executor"></td>
            </tr>
            <tr>
                <td>任务描述(*)</td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>级别</td>
                <td>
                    <select name="orderLevel" id="orderLevel">
                        <c:forEach begin="1" end="3" step="1" var="i">
                            <option value="${i}">${i}级</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
<script>
    function check() {
        if ($("#executor").val()==''){
            alert("执行人不能为空");
            return false;
        }

        if ($("#description").val()==''){
            alert("任务描述不能为空");
            return false;
        }

        $("#createDate").val(formatDate(new Date()));

        return true;
    }

    function formatDate(date) {
        var myyear = date.getFullYear();
        var mymonth = date.getMonth() + 1;
        var myweekday = date.getDate();

        if (mymonth < 10) {
            mymonth = "0" + mymonth;
        }
        if (myweekday < 10) {
            myweekday = "0" + myweekday;
        }
        return (myyear + "-" + mymonth + "-" + myweekday);
    }
</script>
</html>
