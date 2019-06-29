<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/22
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function fn1() {
            $.get()
        }
        <%--function fn1() {--%>
            <%--$.get(${pageContext.request.contextPath}"/jQueryAjax" ,{"name":"zhangsan"}, function (data) {--%>
                <%--alert(data.name);--%>
            <%--} , "json");--%>
        <%--}--%>
        <%--function fn2() {--%>
            <%--$.post(${pageContext.request.contextPath}"/jQueryAjax" ,{"name":"zhangsan"}, function (data) {--%>
                <%--alert(data.name);--%>
            <%--} , "json");--%>
        <%--}--%>
        <%--function fn3() {--%>
            <%--$.ajax({--%>
                <%--url:${pageContext.request.contextPath}"/jQueryAjax",--%>
                <%--data:{"name":"wangwu"},--%>
                <%--type:"POST",--%>
                <%--success:function (data) {--%>
                    <%--alert(data.name);--%>
                <%--},--%>
                <%--dataType:"json",--%>
                <%--async:true--%>
            <%--});--%>
        <%--}--%>
    </script>
</head>
<body>
<input value="get异步请求方式" onclick="fn1()" type="button"/>
<input value="post异步请求方式" onclick="fn2()" type="button"/>
<input value="ajax异步请求方式" onclick="fn3()" type="button"/>
<%--getwriter.writer() 目前必须这样才能取回到ajax的方法里 应为是ajax访问的所以不往页面里写东西--%>

</body>
</html>
