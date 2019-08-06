<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8 0008
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String base = request.getContextPath();
    request.setAttribute("base", base);
%>
<html>
<head>
    <title>添加角色页面</title>
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
        <legend>新增角色</legend>
        <form action="${base}/role/add.do" method="post">
            <input type="text" name="roleName" placeholder="roleName"><br>
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
