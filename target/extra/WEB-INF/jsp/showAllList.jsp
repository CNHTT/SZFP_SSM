<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/7/14
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path =request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>DATA MANAGEMENT</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Support Admin</title>
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="<%=path%>/static/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME CSS -->
    <link href="<%=path%>/static/css/font-awesome.min.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="<%=path%>/static/css/list.css" rel="stylesheet" />
    <!-- Google	Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css' />
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link rel="stylesheet"  type="text/css" href="<%=path%>/static/css/list.css">
</head>
<body>
<%--<div class="world">--%>
    <%----%>
<%--</div>--%>

<div id="head">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4">

                <div class="cube" tabindex="0">
                    <div class="cube__front"></div>
                    <div class="cube__back"></div>
                    <div class="cube__left"></div>
                    <div class="cube__right"></div>
                    <div class="cube__top"></div>
                    <div class="cube__bottom"></div>
                </div>


            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 text-center" >
                <h1>Welcome :</h1>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 text-right " >
                <h4><span>Call:</span> +0755-86276295</h4>
                <h4><span>E-mail:</span> cnhttt@163.com</h4>
            </div>

        </div>
    </div>
</div>
<section id="main">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-9 col-sm-9 ">

                <h3>All User List <span class="label label-danger"> New : 9</span></h3>
                <div class="hr-div"> <hr /></div>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>USER ID</th>
                            <th>TYPE</th>
                            <th>USERNAME</th>
                            <th>EMAIL ID</th>
                            <th>REGISTERED</th>
                            <th>RESET</th>

                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td>#109</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-danger">New</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-info">demo@gmail.com</span></td>
                            <td>2nd July 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#110</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-danger">New</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-success">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#111</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-danger">New</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-danger">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#112</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-danger">New</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-info">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#113</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-danger">New</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-warning">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#114</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-danger">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#115</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-success">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#116</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-danger">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#117</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-warning">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#118</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-info">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#119</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-danger">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#120</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-success">demo@gmail.com</span></td>
                            <td>30th June 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        <tr>
                            <td>#121</td>
                            <td> <i class="fa fa-user" ></i> <span class="label label-success">Old</span></td>
                            <td>Dummy Username</td>
                            <td><span class="label label-warning">demo@gmail.com</span></td>
                            <td>12 May 2014</td>
                            <td><a href="#" class="label label-default">Password </a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <ul class="pagination">
                    <li class="disabled"><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3">
                <div class="alert alert-danger text-center">
                    <h3>Import Information</h3>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Nulla pretium lectus vel justo iaculis blandit.
                </div>
            </div>

        </div>
    </div>
</section>
<!--  Jquery Core Script -->
<script src="<%=path%>/static/js/jquery-1.9.0.min.js"></script>
<!--  Core Bootstrap Script -->
<script src="<%=path%>/static/js/bootstrap.js"></script>


</body>
</html>
