<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/3
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <h1>用户信息管理系统</h1>
    <form action="${pageContext.request.contextPath}/main.lh" method="post" id="mainForm">
        <input type="hidden" name="pageNum" id="pageNum">
        姓名:<input type="text" name="name" size="5" value="${back.name}">
        工资:<input type="text" name="minWage" size="5" value="${back.minWage}">
         - <input type="text" name="maxWage" size="5" value="${back.maxWage}">
        入职日期:<input type="date" name="startTime" value="${back.startTime}">
         - <input type="date" name="endTime" value="${back.endTime}">
        部门:<select name="deptId">
                <option value="">--请选择--</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.did}" <c:if test="${dept.did==back.deptId}">SELECTED</c:if> >
                            ${dept.dName}
                    </option>
                </c:forEach>
            </select>
        <input type="submit" value="查询">
        <input type="button" value="新增员工" id="add">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>入职日期</td>
                <td>工资</td>
                <td>部门名称</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pageInfo.list}" var="emp">
                <tr>
                    <td>${emp.eid}</td>
                    <td>${emp.eName}</td>
                    <td>${emp.eSex}</td>
                    <td><fmt:formatDate value="${emp.eStartTime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                    <td>${emp.ePay}</td>
                    <td>${emp.dept.dName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/oneLine.lh?eid=${emp.eid}">修改</a>
                        <a href="${pageContext.request.contextPath}/delete.lh?eid=${emp.eid}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <!--分页-->
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td><a href="javascript:toPage(1)">首页</a></td>
            <td><a href="javascript:toPage(${pageInfo.pageNum -1})">上一页</a></td>
            <td>
                <c:forEach begin="1" end="${pageInfo.pages}" var="index" step="1">
                    <a href="javascript:toPage(${index})">${index}</a>
                </c:forEach>
            </td>
            <td><a href="javascript:toPage(${pageInfo.pageNum + 1})">下一页</a></td>
            <td><a href="javascript:toPage(${pageInfo.pages})">尾页</a></td>
            <td>
                跳转到第<input type="number" size="5" id="pageTarget" value="${pageInfo.pageNum}">页
                <input type="button" value="GO" id="pageBtn">
            </td>
        </tr>
    </table>
</div>
</body>
<script>
    //对操作的监听
    $("#add").click(function () {
       location.href="${pageContext.request.contextPath}/pages/insert.jsp";
    });
</script>
<script>
    //分页
    function toPage(page){
        $("#pageNum").val(page);
        $("#mainForm").submit();
    }

    $("#pageBtn").click(function () {
        toPage($("#pageTarget").val());
    });
</script>
<script>
    //增删改是否成功的提示,当el表达式值不存在即null时 不会被解析到前台页面，即无法再js中做判断，但是可以在el表达式中做判断
    if (${update!=null}){
        var update = "${update}";
        // console.log(update,typeof update);
        switch (update) {
            case "insert":
                alert("插入成功");
                break;
            case "update":
                alert("修改成功");
                break;
            case "delete":
                alert("删除成功");
                break;
            default:
                alert("操作失败");
                break
        }
    }
</script>
</html>
