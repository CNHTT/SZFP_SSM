<%--
  Created by IntelliJ IDEA.
  User: CT
  Date: 2017/8/20
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String path =request.getContextPath();
%>
<html>
<head>
    <title>ORDER SUCCESS</title>
</head>
<body>

<div id="orderNo">
<%=request.getAttribute("no")%>
</div>
</body>

<script src="<%=path%>/static/js/jquery-1.9.0.min.js"></script>
<script>
    var  websocket= ""
    var ajaxPageNum = 1;
    var last_health;
    var health_timeout = 10;
    var tDates = [], tData = [];
    var rightIndex;


</script>
</html>
