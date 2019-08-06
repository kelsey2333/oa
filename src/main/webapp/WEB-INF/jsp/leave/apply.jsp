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
                    <h2 class="text-center">请假申请</h2>
                    <form action="${base}/leave/apply/handle.do" method="post" class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">申请人</label>
                            <div class="col-sm-10">
                                <input type="hidden" value="${loginUser.id}" name="applyerId">
                                <input type="text" class="form-control" value="${loginUser.userName}" name="applyerName" placeholder="username" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">开始时间</label>
                            <div class="col-sm-10">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <label>选择日期+时间：</label>
                                            <!--指定 date标记-->
                                            <div class='input-group date' id='datetimepicker2'>
                                                <input name="startTime" type='text' class="form-control" />
                                                <span class="input-group-addon">
                                             <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">结束时间</label>
                            <div class="col-sm-10">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <label>选择日期+时间：</label>
                                            <!--指定 date标记-->
                                            <div class='input-group date' id='datetimepicker3'>
                                                <input name="endTime" type='text' class="form-control" />
                                                <span class="input-group-addon">
                                             <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">请假事由</label>
                            <div class="col-sm-10">
                                <textarea name="reason" cols="50" rows="5">

                                </textarea>
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
