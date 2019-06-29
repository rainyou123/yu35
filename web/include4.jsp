<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/20
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is include4 page
<jsp:include page="include3.jsp"></jsp:include>
<%--相当于内部转发--%>
<jsp:forward page="include2.jsp"></jsp:forward>
</body>
</html>
