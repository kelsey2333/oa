<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 9:05
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
    <title>查看详细界面</title>
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

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-condensed table-bordered">
                <tbody>
                <tr class="success">
                    <td>申请人编号</td>
                    <td>${details.applyerId}</td>
                    <td>申请人</td>
                    <td>${details.applyerName}</td>
                </tr>
                <tr class="warning">
                    <td>申请时间</td>
                    <td><fmt:formatDate value="${details.applyerTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
                    <td>资产名称</td>
                    <td>${details.propertyName}</td>
                </tr>
                <tr class="success">
                    <td>资产单价</td>
                    <td>${details.unitPrice}</td>
                    <td>资产数量</td>
                    <td>${details.number}</td>
                </tr>
                <tr >
                    <td rowspan="2">申请事由</td>
                    <td rowspan="2" colspan="4"><textarea class="form-control" rows="2" readonly="readonly">${details.reason}</textarea></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${base}/property/approval/handle.do">
                <table class="table table-condensed table-bordered">
                    <tbody>
                    <tr class="success">
                        <td>记录编号</td>
                        <td><input name="applyId" type="hidden" value="${details.id}"></td>
                        <td>审批人编号</td>
                        <td><input type="hidden" name="approvalId" value="${loginUser.id}"></td>
                    </tr>
                    <tr class="warning">
                        <td>审批结果</td>
                        <td>
                            <input type="radio" name="result" value="1">同意
                            <input type="radio" name="result" value="2">不同意
                        </td>
                        <td>审批意见</td>
                        <td><input type="text" name="advice" value=""></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="submit" value="提交审批">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
