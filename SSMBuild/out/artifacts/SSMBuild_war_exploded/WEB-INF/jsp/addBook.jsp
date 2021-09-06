<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lkx-rog
  Date: 8/4/21
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>

    </div>
    <form action="${pageContext.request.contextPath}/addBook" method="post">
        <div class="form-group">
            <label for="bkname">书籍名称：</label>
            <input type="text" name="bookName" class="for-control" id="bkname" required>
        </div>
        <div class="form-group">
            <label for="bkcount">书籍数量：</label>
            <input type="text" name="bookCounts" class="for-control" id="bkcount" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情：</label>
            <input type="text" name="detail" class="for-control" id="detail">
        </div>
        <div class="form-group">
            <input type="submit" class="for-control" value="添加">
        </div>
    </form>

</div>
</body>
</html>
