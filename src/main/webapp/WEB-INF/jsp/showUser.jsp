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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<c:if test="${ ! empty userList}">
    <c:forEach var="user" items="${userList}">

<c:if test="${fn:contains(aaaa, 999)}">
<p>Found test string<p>
    </c:if>
<c:if test="${fn:contains(aaaa, 99977)}">
<p>Found test string<p>
    </c:if>

    //相当于判断用户权限
        <c:forEach var="item" items="${aaaa}">
            <c:if test="${item==0}">
                <c:if test="${user.isDelete == item}">
                    000000
                </c:if>
            </c:if>
            <c:if test="${item==999}">
                <c:if test="${user.isDelete == 0}">
                    1111111
                </c:if>
            </c:if>
        </c:forEach>

        <c:if test="${user.userName eq 'apple' }">AAAA  </c:if>
        <c:choose>
            <c:when test="${user.userName eq 'apple' }">
                <input type="checkbox" checked="checked">
            </c:when>
            <c:otherwise>
                <input type="checkbox" >
            </c:otherwise>
        </c:choose>
        Name：${user.userName} &nbsp;&nbsp;Phone：${user.userPhone} &nbsp;&nbsp;Email：${user.userEmail} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>


<c:if test="${empty userList}">
    NO DATA
</c:if>
</body>
</html>
