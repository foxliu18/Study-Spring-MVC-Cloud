<%--
  Created by IntelliJ IDEA.
  User: lkx-rog
  Date: 8/5/21
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名：<input type="text" name="username" onblur="a()"/>
    密  码：<input type="text" name="pwd" onblur="b()"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
