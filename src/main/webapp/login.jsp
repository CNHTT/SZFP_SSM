<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!--<&#45;&#45;-->
  <!--Created by IntelliJ IDEA.-->
  <!--User: 戴尔-->
  <!--Date: 2017/7/13-->
  <!--Time: 14:53-->
  <!--To change this template use File | Settings | File Templates.-->
<!--&ndash;&gt;-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="static/css/animate-custom.css">
    <link rel="stylesheet"  type="text/css" href="static/css/login.css">
    <link rel="stylesheet"  type="text/css" href="static/css/style.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#tosingin").click(function () {
                $.ajax({
                    type:"get",
                    dataType:"json",
                    url:"${pageContext.request.contextPath}/singin",
                    data:$("#signInForm").serialize(),
                    success:function (data) {


                        var code = data.code;
                        if (code == -1){
                            $("#loginerror").html(data.msg);
                        }

                        window.setTimeout(function () {
                            $("#loginerror").html("");
                        },2000)
                    },
                    error:function (request) {

                    }}
                )
            });
            $('#signInForm')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        username: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'The username is required and can\'t be empty'
                                },
                                stringLength: {
                                    min: 6,
                                    max: 30,
                                    message: 'The username must be more than 6 and less than 30 characters long'
                                },
                                /*remote: {
                                 url: 'remote.php',
                                 message: 'The username is not available'
                                 },*/
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: 'The username can only consist of alphabetical, number, dot and underscore'
                                }
                            }
                        },
                        email: {
                            validators: {
                                notEmpty: {
                                    message: 'The email address is required and can\'t be empty'
                                },
                                emailAddress: {
                                    message: 'The input is not a valid email address'
                                }
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message: 'The password is required and can\'t be empty'
                                }
                            }
                        }
                    }
                })
        });
    </script>
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
                    <form id="signInForm">
                        <h1>Log in</h1>

                        <p>
                            <label for="username" class="uname" data-icon="u" > Your email or username </label>
                            <input id="username" name="username" type="text" placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" type="password" placeholder="eg. X8df!90EO" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <p class="login button">
                            <input id="tosingin" type="button" value="Login" />
                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister" class="to_register">Join us</a><div id="loginerror"></div>
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


<%--<script type="text/javascript"  src="static/js/login.js"></script>--%>
</body>
</html>
