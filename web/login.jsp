<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
</head>
<body>
<div height="50px" weight="300px"><%=request.getAttribute("info")==null?"":request.getAttribute("info") %></div>
<form action="loginServlet" method="post" accept-charset="UTF-8">
    用户名：<input name="username" type="text" placeholder="请输入用户名"/><br/>
    密码：<input name="password" type="text" placeholder="请输入密码"/><br/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>