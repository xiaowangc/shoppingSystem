
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            margin: auto;
            border: 2px solid #000;
            width: 50%;
            height: 50%;
        }
        td{
            text-align: center;

            border: 1px solid #000;
        }

    </style>
</head>
<body>
    <table>
        <tr>
            <th>商品名称</th><th>商品价格</th><th>商品数量</th>
        </tr>

        <c:forEach var="goods" items="${sessionScope.shoppingCar}">
            <tr>
                <td>${goods.key.getGoodsName()}</td>
                <td>${goods.key.getPrice()}</td>
                <td>${goods.value}</td>
            </tr>

        </c:forEach>
        <tfoot>
            <td colspan="3">总计：${requestScope.payment}</td>
        </tfoot>
    </table>

    <hr>
    本次购物您共消费金额为：${requestScope.payment}<br>
    请输入支付金额：<input type="text" name="payment" value=""><br>
    <input type="button" id="btn" value="确定支付">
</body>
</html>
