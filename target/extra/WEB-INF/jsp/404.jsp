<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path =request.getContextPath();
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE= edge">
    <title>404 Page by FreeHTML5.co</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(
        hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
        </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="<%=path%>/static/css/style.css">
</head>
<body>
<%
    request.setAttribute("layout","mian.js");
%>
<div class="error_page">
    <div class="error_logo">
        <img src="<%=path%>/static/images/404.png" />
        <p> <a  href="<%=path%>/login">Go back to Home</a></p>
    </div>
</div>
</body>
</html>