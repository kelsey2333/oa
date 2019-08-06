<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("base",request.getContextPath());
%>
<html>
<head>
    <title>登录页面</title>
    <style>
        .msg{
            width: 100%;
            text-align: center;
            background-color: lightpink;
            color: red;
        }
    </style>
    <%--bootstrap--%>
    <link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form action="${base}/checkLogin.do" method="post" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">username</label>
                            <div class="col-sm-10">
                                <input type="text" name="loginName" class="form-control" id="inputEmail3" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" name="password" class="form-control" id="inputPassword3" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">登录</button>
                            </div>
                        </div>
                        <p class="msg">${msg}</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${base}/static/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${base}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
