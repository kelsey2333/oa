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
    <title>添加用户页面</title>
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
<div>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="nav nav-pills">
                        <!-- 循环输出所有顶级菜单 -->
                        <c:forEach items="${topMenus}" var="top">
                            <c:choose>
                                <c:when test="${top.menuName == 'OA申请'}">
                                    <%--获取OA管理菜单下的所有子菜单--%>
                                    <c:set var="subMenus" value="${top.subMenus}"/>
                                    <li class="active">
                                        <a href="${base}${top.menuLink}">${top.menuName}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="${base}${top.menuLink}">${top.menuName}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </ul>
                </div>
            </div>
            <hr>
            <div>
                <p class="msg">${msg}</p>
            </div>
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <div class="list-group">
                        <c:forEach items="${subMenus}" var="subMenu">
                            <c:choose>
                                <c:when test="${subMenu.menuName == '请假申请'}">
                                    <a href="${base}${subMenu.menuLink}" class="list-group-item active">
                                        <p class="list-group-item-text">
                                                ${subMenu.menuName}
                                        </p>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${base}${subMenu.menuLink}" class="list-group-item">
                                        <p class="list-group-item-text">
                                                ${subMenu.menuName}
                                        </p>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-9 column">
                    <h2 class="text-center">添加员工</h2>
                    <form action="${base}/user/add.do" method="post" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">username</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="userName" placeholder="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">loginname</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="loginName" placeholder="loginname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" placeholder="password"><br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">状态</label>
                            <div class="col-sm-10">
                                <select name="status" class="form-control">
                                    <option value="1">正常</option>
                                    <option value="0">禁用</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
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
