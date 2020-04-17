<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>


    ${requestScope.result}
    <form action="login" method="post">
        username:<input type="text" name="username" value=""><br>
        password:<input type="password" name="password" value=""><br>
        <input type="submit" name="" value="登录">
        <input type="button" id="register" value="注册">
    </form>
    <script>
        var button = document.getElementById("register");
        button.onclick = function () {
            window.location.href = "register.jsp";
        }
    </script>
</body>
</html>