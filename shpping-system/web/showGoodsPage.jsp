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
<%--    当点击继续购物按钮后，session会保存已选中的商品--%>
    <script>
            window.onload = function () {
                var buttons = document.getElementsByClassName("button");
                for(var i = 0; i < buttons.length; i++){
                    buttons[i].onclick = function () {
                        var form = document.getElementById("form");
                        var hidden = document.getElementById("hidden");
                        hidden.value = this.value;
                        form.submit();//提交请求
                    }
            }
        }
    </script>
</head>
<body>
    <form action="saveGoods" id="form" method="post">
        <input id="hidden" type="hidden" name="flag" value="">
        <table>
            <thead>
            <tr>
                <th></th><th>商品名称</th><th>商品价格</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="goods" items="${requestScope.goods}">
                <tr>
                    <td><input type="checkbox" name="goodsId" value="${goods.getGoodsId()}"></td>
                    <td>${goods.getGoodsName()}</td>
                    <td>${goods.getPrice()}</td>
                </tr>
            </c:forEach>

            </tbody>
            <tfoot>
            <tr>
                <td colspan="3">
<%--结算清单、继续购物都要把当前页的已勾选商品保存起来--%>
                    <input type="button" class="button" value="结算清单">
                    <input type="button" class="button" value="继续购物">
                </td>
            </tr>
            </tfoot>

        </table>


    </form>
</body>
</html>
