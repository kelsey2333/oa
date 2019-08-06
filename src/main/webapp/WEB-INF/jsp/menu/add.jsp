    <%--
      Created by IntelliJ IDEA.
      User: Administrator
      Date: 2019/7/8 0008
      Time: 9:53
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
        <title>添加菜单页面</title>
        <style>
        .msg {
        width: 100%;
        background-color: antiquewhite;
        text-align: center;
        color: red;
        }
        </style>
        </head>
        <body>
        <div>
        <p class="msg">${msg}</p>
        </div>
        <div>
        <fieldset>
        <legend>新增菜单</legend>
        <form action="${base}/menu/add.do" method="post">
        <select name="pid">
        <option value="-1">顶级菜单</option>
        <c:forEach items="${topMenus}" var="topMenu">
            <option value="${topMenu.id}">${topMenu.menuName}</option>
        </c:forEach>
        </select><br>
        <input type="text" name="menuName" placeholder="菜单名"><br>
        <input type="text" name="menuIcon" placeholder="菜单图标"><br>
        <input type="text" name="menuLink" placeholder="菜单链接"><br>
        <select name="status">
        <option value="1">正常</option>
        <option value="0">禁用</option>
        </select><br>
        <input type="submit" value="提交">
        </form>
        </fieldset>
        </div>
        </body>
        </html>
