<%--
  Created by IntelliJ IDEA.
  User: lkx-rog
  Date: 8/5/21
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        function a(){
            $.post({
                url: "${pageContext.request.contextPath}/t3",
                data: {"name": $("#name").val()},
                success: function(data){
                    console.log(data);
                }
            })
        }

        function b(){
            $.post({
                url: "${pageContext.request.contextPath}/t3",
                data: {"password": $("#pwd").val()},
                success: function(data){
                    console.log(data);
                }
            })
        }
    </script>
</head>
<body>
<p>
    用户名：<input type="text" id="name" onblur="a()">
    <span id="userInfo"></span>
</p>
<p>
    密  码：<input type="text" id="pwd" onblur="b()">
    <span id="pwdInfo"></span>
</p>
</body>
</html>
