<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9 0009
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String base = request.getContextPath();
    request.setAttribute("base", base);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>请假申请页面</title>
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
</head>
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
                                <c:when test="${subMenu.menuName == '资产申请'}">
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

                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <span class="label label-warning">基本信息</span>
                            <form action="${base}/property/purchase/handle.do" method="post">
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>申请人</td>
                                        <td class="warning"><input type="text" name="applyerName" value=""></td>
                                    </tr>
                                    <tr>
                                        <td>申请人id</td>
                                        <td class="warning"><input type="text" name="applyerId" value=""></td>
                                    </tr>
                                    <tr>
                                        <td style="">申请时间</td>
                                        <td class="warning">
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class='col-sm-6'>
                                                        <div class="form-group">
                                                            <label>选择日期+时间：</label>
                                                            <!--指定 date标记-->
                                                            <div class='input-group date' id='datetimepicker2'><input name="applyerTime" type='text' class="form-control" />
                                                                <span class="input-group-addon">
                                             <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>采购事由</td>
                                        <td class="warning"><textarea name="reason" rows="2" cols="3" class="form-control"></textarea></td>
                                    </tr>
                                    </tbody>

                                </table> <span class="label label-info">资产详情</span>
                                <table class="table table-bordered">
                                    <thead>
                                    <tr >
                                        <th>资产名称</th>
                                        <th>数量</th>
                                        <th>单价</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="success">
                                        <td><input type="text" name="propertyName" value="" class="form-control"></td>
                                        <td><input type="text" name="number" value="" class="form-control"></td>
                                        <td><input type="text" name="unitPrice" value="" class="form-control"></td>
                                    </tr>
                                    </tbody>
                                </table> <button type="submit" class="btn btn-default">提交</button>
                            </form>
                        </div>
                    </div>
                </div>


<script src="${base}/static/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${base}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${base}/static/bootstrap/moment-with-locales.js"></script>
<script src="${base}/static/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script>

    $(function () {
        $('#datetimepicker3').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });
    });
</script>
</body>
</html>
