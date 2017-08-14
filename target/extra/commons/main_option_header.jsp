<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.extra.model.User" %>
<%@ page import="com.extra.utils.GsonUtils" %>
<%@ page import="com.extra.utils.SessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/7/24
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String  path = request.getContextPath();
    User user = new GsonUtils().fromJson((String) request.getSession().getAttribute(SessionUtils.SESSION_ADMIN_USER),User.class);
    int option = (int) request.getAttribute(SessionUtils.OPTION_ID);
%>
<header class="main-header">
    <!-- Logo -->
    <a class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>A</b>LT</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="../../static/images/user_160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><%=user.getUserName()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="../../static/images/user_160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                <a id="username">Extra - Web Developer</a>
                                <small id="createTime"><%=user.getCreateTime()%></small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <%--<li class="user-body">--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Followers</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Sales</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Friends</a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <!-- /.row -->
                        <%--</li>--%>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profile</a>
                            </div>
                            <div class="pull-right">
                                <a href="<%=path%>/singout" class="btn btn-default btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li>
                    <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../../static/images/user_160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%=user.getUserName()%></p>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>

            <li>
                <a href="<%=path%>/admin/main">
                    <i class="fa fa-dashboard"></i> <span>Home</span>
                    <span class="pull-right-container">
              <small class="label pull-right bg-green">chart</small>
            </span>
                </a>
            </li>


            <li>
                <a href="<%=path%>/admin/list">
                    <i class="fa fa-th"></i> <span>Widgets</span>
                    <span class="pull-right-container">
              <small class="label pull-right bg-green">new</small>
            </span>
                </a>
            </li>

            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i>
                    <span>Option</span>
                    <span class="pull-right-container">
              <span class="label label-primary pull-right">10</span>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li
                    <c:if test="${OPTION_ID ==1}">
                            class="active"
                    </c:if>>
                        <a href="<c:url value="/admin/option">
                            <c:param name="option" value="1"/></c:url>">
                            <i class="fa fa-circle-o"></i>
                            Mllhar</a>
                    </li>

                    <li
                            <c:if test="${OPTION_ID ==2}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="2"/> </c:url>">
                            <i class="fa fa-circle-o"></i>
                            Centena</a>
                    </li>

                    <li
                            <c:if test="${OPTION_ID ==3}">
                                class="active"
                            </c:if>>
                        <a  href="<c:url value="/admin/option"><c:param name="option" value="3"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Dezena</a></li>

                    <li
                            <c:if test="${OPTION_ID ==4}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="4"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Mllhar 1/5</a></li>
                    <li
                            <c:if test="${OPTION_ID ==5}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="5"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Centena 1/5</a></li>
                    <li
                            <c:if test="${OPTION_ID ==6}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="6"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Dezena 1/5</a></li>
                    <li
                            <c:if test="${OPTION_ID ==7}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="7"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Terno Dezena</a></li>
                    <li
                            <c:if test="${OPTION_ID ==8}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="8"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Duque de Dezena</a></li>
                    <li
                            <c:if test="${OPTION_ID ==9}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="9"/> </c:url>">
                            <i class="fa fa-circle-o"></i> Grupo</a></li>
                    <li
                            <c:if test="${OPTION_ID ==10}">
                                class="active"
                            </c:if>>
                        <a href="<c:url value="/admin/option"><c:param name="option" value="10"/> </c:url>">
                            <i class="fa fa-circle-o"></i> SurpresInha</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

