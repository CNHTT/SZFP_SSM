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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ORDER SUCCESS</title>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>

<input   type="text" disabled="disabled" value="<%=request.getAttribute("no")%>" id="orderNo"><div id="show"></div>
<script>
    var socket;

  $(function () {
        socket = new WebSocket(encodeURI("ws://39.108.61.105:7777"));

        var  a = $('#orderNo').val();
            socket.onopen =  function () {
                // 发送一个初始化消息
                socket.send(JSON.stringify({
                    type: 3,
                    data:a
                }))
            };

            socket.onmessage =function (message) {  {
                $("#show").html(message)
                console.log('message', message)
            }

            // 监听Socket的关闭
            socket.onclose = function(event) {
                console.log('Client notified socket has closed', event);
            };

        }
    })

</script>
</body>

</html>
