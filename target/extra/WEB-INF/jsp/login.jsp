<%@ page import="com.extra.utils.DataUtils" %>
<%@ page import="com.extra.model.response.ResponseObj" %>
<%@ page import="com.extra.utils.GsonUtils" %>
<%@ page import="com.sun.org.apache.regexp.internal.RE" %>
<!--<&#45;&#45;-->
  <!--Created by IntelliJ IDEA.-->
  <!--User: 戴尔-->
  <!--Date: 2017/7/13-->
  <!--Time: 14:53-->
  <!--To change this template use File | Settings | File Templates.-->
<!--&ndash;&gt;-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path =request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String result ="";
    if (!DataUtils.isEmpty(request.getAttribute("error"))){
        String re = (String) request.getAttribute("error");
        ResponseObj obj = new GsonUtils().fromJson(re, ResponseObj.class);
        result= obj.getMsg();
    }
%>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="/favicon.ico">

    <style>
        .loginHint{
            height:20px;
            line-height:20px;
            font-size:14px;
            color:red;
            margin-top:5px;margin-bottom:5px;
            text-align:center;
            font-family:"Hiragino Sans GB", "Microsoft Yahei";
            border:1px solid #eee;border-radius:3px;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/static/css/animate-custom.css">
    <link rel="stylesheet"  type="text/css" href="<%=path%>/static/css/login.css">
    <link rel="stylesheet"  type="text/css" href="<%=path%>/static/css/style.css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/login.js"></script>
    <title>SING IN</title>
</head>
<body>
<div class="container">

    <header>

        <nav class="codrops-login">
            <span><strong>Welcome To The Background Data Management System</strong></span>
        </nav>
    </header>
    <section>
        <div id="container_login" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="<%=basePath%>singin.action" METHOD="post" autocomplete="on">
                        <h1>Log in</h1>

                        <div class="loginHint" id="loginHint"><%=result%></div>
                        <p>
                            <label for="username" class="uname" data-icon="u" > Your email or username </label>
                            <input id="username" name="username" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" type="text" placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password"  required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  type="password" placeholder="eg. X8df!90EO" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Login" />
                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister" class="to_register">Join us</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form  action="#" autocomplete="on">
                        <h1> Sign up </h1>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                            <input id="usernamesignup" name="usernamesignup" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" type="text" placeholder="mysuperusername690" />
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                            <input id="emailsignup" name="emailsignup" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" type="email" placeholder="mysupermail@mail.com"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                            <input id="passwordsignup" name="passwordsignup"   required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm"  required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Sign up"/>
                        </p>
                        <p class="change_link">
                            Already a member ?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>


</body>
</html>
