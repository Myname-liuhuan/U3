<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询销售信息界面</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/query.lh" method="post" id="firstForm">
        <input type="hidden" name="pageNum" value="">
        <h1>销售信息查询</h1>
        <select name="orderBy">
            <option value="-1">默认</option>
            <option value="0">销售日期</option>
            <option value="1">单价</option>
        </select>
        <input type="submit" value="排序">
        <table cellspacing="0" cellpadding="10" border="1">
            <tr>
                <td>ID</td>
                <td>商品</td>
                <td>单价</td>
                <td>数量</td>
                <td>总价</td>
                <td>销售日期</td>
                <td>销售员</td>
            </tr>
            <c:forEach items="${pageInfo.list}" var="map" varStatus="status">
                <tr <c:if test="${status.index%2==0}">style="background-color: aqua" </c:if>>
                    <td>${map.id}</td>
                    <td>${map.productName}</td>
                    <td>${map.price}</td>
                    <td>${map.quantity}</td>
                    <td>${map.totalPrice}</td>
                    <td>${map.saleDate}</td>
                    <td>${map.realName}</td>
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
<script>
    function toPage(page) {
        $("#pageNum").val(page);
        $("#firstForm").submit();
    }
</script>
</body>
</html>
