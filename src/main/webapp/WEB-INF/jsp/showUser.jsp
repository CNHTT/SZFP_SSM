<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/7/12
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<c:if test="${ ! empty userList}">
    <c:forEach var="user" items="${userList}">
        Name：${user.userName} &nbsp;&nbsp;Phone：${user.userPhone} &nbsp;&nbsp;Email：${user.userEmail} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
<c:if test="${empty userList}">
    NO DATA
</c:if>
</body>
</html>
