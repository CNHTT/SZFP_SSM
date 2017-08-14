<%@ page import="com.extra.utils.SessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/7/24
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/commons/main_head.jsp"/>
    <title>AdminLTE 2 | Dashboard</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">


    <jsp:include page="/commons/main_option_header.jsp"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                GameItems
                <small><%=request.getAttribute(SessionUtils.GAME_NAME)%></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Game</a></li>
                <li class="active">Report</li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Game Item Data Table</h3>
                            <small id="showSize">
                                Showing 1 to 10 of 57 entries
                            </small>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-table-striped">
                                <thead>
                                <tr>
                                    <th>NUMBER</th>
                                    <th>OPER</th>
                                    <th>GAME NAME</th>
                                    <th>GAME</th>
                                    <th>SECO GAME</th>
                                    <th>GAME VALUE</th>
                                    <th>CreateTime</th>
                                </tr>
                                </thead>
                                <tbody id="tableBody">
                                <tr><th colspan ="7"><center>Loading.....</center></th></tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>NUMBER</th>
                                    <th>OPER</th>
                                    <th>GAME NAME</th>
                                    <th>GAME</th>
                                    <th>SECO GAME</th>
                                    <th>GAME VALUE</th>
                                    <th>CreateTime</th>
                                </tr>
                                </tfoot>
                            </table>
                            <section class="content-header">
                                <ul id="bottomTab"></ul>
                            </section>

                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
                <!-- /.col -->
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b>1.00
        </div>
        <strong>Copyright &copy; 2017-2017 <a >Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
            </div>
        </div>
    </aside>
</div>
<jsp:include page="/commons/main_data_end.jsp"/>

<script>
    var adminID = <%=session.getAttribute("id")%>;
    var pagesize =10;
    function displayPage(curtpage,tpage) {
        //分页
        var newoptions = {
            //当前页数
            currentPage: curtpage,
            //总页数
            totalPages:tpage,
            size: "normal",
            alignment: "center",
            bootstrapMajorVersion:3,
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "<<";
                    case "prev":
                        return "<";
                    case "next":
                        return ">";
                    case "last":
                        return ">>";
                    case "page":
                        return page;
                }
            },onPageClicked:function (e,originalEvent,type,page) {
                console.log("1    "+type+ "  " +page)
                buildTable(<%=session.getAttribute("id")%>,page,pagesize);//默认显示
            }
        };
        $("#bottomTab").bootstrapPaginator(newoptions);
    }


    /**
     * 生成表格
     * @param c
     * @param a
     * @param b
     */
    function buildTable(c, a, b) {
        var url = "/operator/itemGameList.mp"
        console.log('url', url)
        var reqParmes = {"adminID": adminID, "type":<%=request.getAttribute(SessionUtils.OPTION_ID)%>,'pageNumber': a, 'pageSize': b}
        $(function () {
            $.ajax({
                type: "post",
                url: url,
                data: reqParmes,
                async: true,
                dataType: "json",
                success: function (data) {
                    if (data.code == 1) {

                        /**
                         * 分页
                         */


                        var datalist = data.data.dataList;
                        $("#listSize").val(datalist.length);
                        $("#tableBody").empty();
                        if (datalist.length > 0) {
                            displayPage(data.data.pageNo, data.data.pages)
                            var id = 1;
                            $(datalist).each(function () {
                                var d = new Date(this.createTime);
                                var youWant = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
                                var userId = this.id;
                                var html =
                                    '<tr> ' +
                                    '<td>' + (id++) + '</td>' +
                                    '<td> <i class="fa fa-user" ></i> <span class="label label-danger">' + this.operatorName + '</span></td>' +
                                    '<td>' + this.gameName + '</td>' +
                                    '<td><span class="label label-info">' + this.itemGame + '</span></td>' +
                                    '<td>' + this.secoValue + '</td>' +
                                    '<td><span class="label label-info">' + this.itemGameValue + '</span></td>' +

                                    '<td>' + this.ceateTime + '</td>' +
                                    '</tr>';
                                $("#tableBody").append(html);
                            });
                        } else {
                            $("#tableBody").append('<tr><th colspan ="7"><center><div class="box-danger">NO DATA</div></center></th></tr>');
                        }

                    } else {
                        alert(data.msg)
                    }
                },
                error: function (e) {
                    alert("查询失败1：" + e);
                }
            });
        });
    }
    /**
     * Click to view details
     * @param id
     */
    $(function () {	//生成底部分页栏
        buildTable("", 1, pagesize);//默认空白查全部
        //创建结算规则
        $("#queryButton").bind("click", function () {
            buildTable(adminID, 1, pagesize);
        });
    });

</script>
</body>
</html>