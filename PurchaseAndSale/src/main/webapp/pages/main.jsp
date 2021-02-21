<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/6
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <style>
        p{
            margin-left: 30px;
        }
        div{
            width: 500px;
            height: 300px;
            margin: 20px 30px;
            padding: 30px;
        }
        iframe{
            border: 3px solid yellow;
        }
    </style>
</head>
<body>
<p>欢迎${users.realName}  <a href="">退出登录</a> </p>
<div>
    <table cellpadding="10">
        <tr>
            <td ><a href="addSale.jsp" target="right" >销售</a></td>
            <td rowspan="3"><iframe src="${pageContext.request.contextPath}/pages/welcome.html" name="right" width="600" height="400" scrolling="no"></iframe></td>
        </tr>
        <tr>
            <td nowrap="nowrap"><a href="${pageContext.request.contextPath}/query.lh" target="right">销售信息查询</a></td>
        </tr>
        <tr>
            <td><a href="selectProduct.jsp" target="right">查看库存</a></td>
        </tr>
    </table>
</div>
</body>
<script>
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
