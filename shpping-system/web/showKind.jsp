
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        window.onload = function () {
            var select = document.getElementById("selectKind");
            // 当下拉列表某一选项被选中时，触发onchange事件
            select.onchange = function () {
                window.location.href = "selectGoods?kindId=" + this.value;
            }
        }

    </script>
</head>
<body>
<select id="selectKind" name="kid">
    <option >==请选择==</option>
    <c:forEach var="kind" items="${requestScope.kindList}">
        <option value="${kind.getKindId()}">${kind.getKindName()}</option>
    </c:forEach>
</select>
</body>
</html>
