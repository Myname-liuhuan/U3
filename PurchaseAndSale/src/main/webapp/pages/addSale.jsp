<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuhuan
  Date: 2019/11/6
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售页面</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <h1>添加销售:</h1>
    <form action="${pageContext.request.contextPath}/add.lh" method="post" onsubmit="return checkForm()">
    <!--隐藏域存储字段-->
        <input type="hidden" name="totalPrice" id="totalPrice" />
        <input type="hidden" name="saleDate" id="saleDate" />
        <input type="hidden" name="userId" id="userId" />
        <table cellpadding="10">
        <tr>
            <td>商品名称:</td>
            <td>
                <select name="productId" id="productId">
                    <option value="">=请选择=</option>
                    <c:forEach items="${productList}" var="product">
                        <option value="${product.id}">
                                ${product.productName}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
            <!--隐藏标签实现提示库存数量-->
            <input type="hidden" class="productQuantity" value="0"/>
            <c:forEach items="${productList}" var="product2">
                <input type="hidden" class="productQuantity" value="${product2.quantity}"/>
            </c:forEach>
        <tr>
            <td>出售单价:</td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td>出售数量:</td>
            <td><input type="text" name="quantity" id="quantity" placeholder=""></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
        </table>
    </form>
</div>
</body>
<script>
    var s=0;
    function checkForm() {
        //先做非空验证
        if ($("#price").val()==''){
            alert("出售单价不能为空");
            return false;
        }else{
            var m = /^\d+(?=\.?\d+$|$)/;
            if (!m.test($("#price").val())){
                alert("请给“出售单价”输入一个正数");
                return false;
            }

        }

        if ($("#quantity").val()==''){
            alert("出售数量不能为空");
            return false;
        }else{
            console.log(s,typeof s);
            var m = /^[0-9]+$/;
            if (!m.test($("#quantity").val())){
                alert("请给”出售数量“输入一个整数");
                return false;
            }else if(Number($("#quantity").val()) > s){
                alert("库存不足");
                return false;
            }
        }

        //将隐藏标签给值
        $("#totalPrice").val(Number($("#price").val())*Number($("#quantity").val()));
        $("#saleDate").val(formatDate(new Date()));
        $("#userId").val("${users.id}");
        return true;
    }

    //给select标签添加监听事件
    $("#productId").change(function () {
        //$("#productId").get(0)表示获取对应的js对象 ，然后js对象中有selectedIndex的属性可以获取到当前选中项
        //$(".productQuantity").get(index-1)表示获取数组中指定项(标签)，得到的为js标签对像，所以使用innerText
        //返回的index从0开始， 得到的class数组的下标也是0开始
        var index = $("#productId").get(0).selectedIndex;
        var quantity;
        if (index==0){
            quantity='';
            s=0;
        }else{
            quantity =$(".productQuantity").get(index).value;
            s = Number(quantity);
            quantity ="当前库存:" + quantity;
        }

        $("#quantity").attr("placeholder",quantity);
    });


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
