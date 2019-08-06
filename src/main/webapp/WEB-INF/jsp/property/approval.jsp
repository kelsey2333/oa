<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
pageContext.setAttribute("base",request.getContextPath());
%>
<html>
<head>
    <title>审批页面</title>
</head>
<style>
    .msg {
        width: 100%;
        background-color: antiquewhite;
        text-align: center;
        color: red;
    }
</style>
<!-- Bootstrap -->
<link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${base}/static/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">


<body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="nav nav-pills">
                        <!-- 循环输出所有顶级菜单 -->
                        <c:forEach items="${topMenus}" var="top">
                            <c:choose>
                                <c:when test="${top.menuName == 'OA审批'}">
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
                                <c:when test="${subMenu.menuName == '资产审批'}">
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
            </div>
        </div>
    </div>
</div>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>申请编号</th>
                    <th>申请人</th>
                    <th>申请时间</th>
                    <th>查看详细</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applies}" var="apply">
                    <tr>
                        <td>${apply.applyerId}</td>
                        <td>${apply.applyerName}</td>
                        <td><fmt:formatDate value="${apply.applyerTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                        <td><button type="button" class="btn btn-default btn-warning" onclick="location.href = '${base}/property/approval/detail/${apply.id}'">查看详细</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</body>
</html>
