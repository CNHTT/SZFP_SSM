<%--
  Created by IntelliJ IDEA.
  User: CT
  Date: 2017/7/23
  Time: 19:19
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


    <jsp:include page="/commons/main_list_header.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Data Tables
                <small>advanced tables</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Tables</a></li>
                <li class="active">Data tables</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Hover Data Table</h3>
                            <small>
                                Showing 1 to 10
                            </small>
                            <input class="text-right" type="text"  id="datetimepicker">
                            <button class=" ion-android-search" onclick="searchByTime()"></button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-table-striped">
                                <thead>
                                <tr>
                                    <th>NUMBER</th>
                                    <th>OPER</th>
                                    <th>AWARD_TIME</th>
                                    <th>CreateTime</th>
                                    <th>Device ID</th>
                                    <th>TicketID</th>
                                    <th>TOTAL</th>
                                    <th>GAME SIZE</th>
                                    <th>OTHER</th>
                                </tr>
                                </thead>
                                <tbody id="tableBody">
                                <tr><th colspan ="9"><center>Loading.....</center></th></tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>NUMBER</th>
                                    <th>OPER</th>
                                    <th>AWARD_TIME</th>
                                    <th>CreateTime</th>
                                    <th>Device ID</th>
                                    <th>TicketID</th>
                                    <th>TOTAL</th>
                                    <th>GAME SIZE</th>
                                    <th>OTHER</th>
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
            <!-- /.row -->

            <!-- solid sales graph -->

            <div id="item">
                <div class="box box-solid bg-teal-gradient">
                    <div class="box-header">
                        <i class="fa fa-th"></i>

                        <h3 class="box-title">Data Item</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn bg-teal btn-sm" data-widget="collapse"><i id="itemWindow" class="fa fa-minus"></i>
                            </button>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer no-border">
                        <table id="example" class="table table-bordered table-table-striped">
                            <thead>
                            <tr>
                                <th>NUMBER</th>
                                <th>GAME NAME</th>
                                <th>GAME</th>
                                <th>SECO GAME</th>
                                <th>GAME VALUE</th>
                            </tr>
                            </thead>
                            <tbody id="itemTableBody">
                            <tr><th colspan ="5"><center>Loading.....</center></th></tr>
                            </tbody>
                        </table>
                        <ul id="itemBottomTab"></ul>
                    </div>
                </div>
            </div>

            <!-- /.box -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.4.0
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="ht
        tps://adminlte.io">Almsaeed Studio</a>.</strong> All rights
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
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
</div>
<jsp:include page="/commons/main_data_end.jsp"/>

<!-- page script -->
<script>
    /**
     * Created by CT on 2017/7/15.
     */

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
                buildTable(null,page,pagesize);//默认显示
            }
        };
        $("#bottomTab").bootstrapPaginator(newoptions);
    }



    var  myDate  = new Date();

    $("#datetimepicker").datepicker({
        orientation: "bottom auto",
        keyboardNavigation: false,
        forceParse: false,
        toggleActive: true,
        defaultViewDate: { year: myDate.getFullYear(), month: myDate.getMonth(), day: myDate.getDate() }
    });


    function searchByTime() {
        var  time = $("#datetimepicker").val();

        if(time == ""){
        buildTable(null,1,10)
        }else {
            buildTable(time,1,10);
        }

    }
    /**
     * 生成表格
     * @param c
     * @param a
     * @param b
     */
    function buildTable(c, a, b) {
        var url = "/operator/reportLl.mp"
        console.log('url', url)
        var reqParmes = {"adminID": adminID, 'pageNumber': a, 'pageSize': b,"time":c}
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
                        $("#itemBottomTab").empty();
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
                                    '<td>' + this.AWARD_TIME + '</td>' +
                                    '<td>' + this.operatorCreateTime + '</td>' +
                                    '<td>' + this.terminalID + '</td>' +
                                    '<td>' + this.ticketID + '</td>' +
                                    '<td><span class="label label-info">' + this.total + '</span></td>' +
                                    '<td><span class="label label-info">' + this.gameSize + '</span></td>' +
                                    '<td><button class="label label-default" onclick="showItemInfo(' + this.id + ')">More </button></td>' +
                                    '</tr>';
                                $("#tableBody").append(html);
                            });
                        } else {
                            $("#tableBody").append('<tr><th colspan ="9"><center>ＮＯ　ＤＡＴＡ</center></th></tr>');
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
                buildTable(null, 1, pagesize);
            });
        });


    /**
     * Click to view details
     * @param rid
     */
    function  showItemInfo(rid) {
        function displayItemPage(curtpage,tpage) {
            //分页
            var newoption = {
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
                    buildItemTable(<%=session.getAttribute("id")%>,page,pagesize);//默认显示
                }
            };
            $("#itemBottomTab").bootstrapPaginator(newoption);
        }


        /**
         * 生成表格
         * @param c
         * @param a
         * @param b
         */
        function buildItemTable(c, a, b) {
            var url = "/operator/reportLlItem.mp"
            console.log('url', url)
            var reqParme= {"adminID": adminID, 'pageNumber': a, 'pageSize': b,"rID":rid}
            $(function () {
                $.ajax({
                    type: "post",
                    url: url,
                    data: reqParme,
                    async: true,
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 1) {

                            /**
                             * 分页
                             */
                            displayItemPage(data.data.pageNo, data.data.pages)

                            var datalist = data.data.dataList;
                            $("#listSize").val(datalist.length);
                            $("#itemTableBody").empty();
                            if (datalist.length > 0) {
                                var id = 0;
                                $(datalist).each(function () {
                                    var d = new Date(this.createTime);
                                    var html =
                                        '<tr> ' +
                                        '<td>' + (id + 1) + '</td>' +
                                        '<td>' + this.gameName + '</td>' +
                                        '<td>' + this.itemGame + '</td>' +
                                        '<td>' + this.secoValue + '</td>' +
                                        '<td>' + this.itemGameValue + '</td>' +
                                        '</tr>';
                                    $("#itemTableBody").append(html);
                                });
                            } else {
                                $("#itemTableBody").append('<tr><th colspan ="6"><center>查询无数据</center></th></tr>');
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
            buildItemTable("", 1, pagesize);//默认空白查全部
        });



    }

</script>
</body>
</html>