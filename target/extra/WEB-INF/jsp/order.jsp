<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/8/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body class="hold-transition skin-blue sidebar-mini">--%>
<%--<div class="wrapper">--%>


    <%--<input type="button" value="post" onclick="postOrder()">--%>

    <%--<div id="control-sidebar-bg"></div>--%>
<%--</div>--%>
<%--<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>--%>
<%--<script>--%>
    <%--function postOrder() {--%>

        <%--var  url = "http://39.108.61.105/order/submit";--%>

        <%--var reqParmes ={"data" :"{id:17,type:1}"}--%>

        <%--$.ajax({--%>
            <%--type:"post",--%>
            <%--url:url,--%>
            <%--data:reqParmes,--%>
            <%--async:true,--%>
            <%--dataType:"json",--%>
            <%--success:function (data) {--%>
                <%--$("#control-sidebar-bg").append(data)--%>
            <%--},--%>
            <%--error:function (e) {--%>
                <%--alert("查询失败1："+e);--%>
            <%--}--%>
        <%--});--%>

    <%--}--%>
<%--</script>--%>
<%--</body>--%>

<head>
    <title>购物车</title>
    <meta charset="utf-8" />
    <jsp:include page="/commons/main_head.jsp"/>
    <style type="text/css">
        h1 {
            text-align:center;
        }
        table {
            margin:0 auto;
            width:60%;
            border:2px solid #aaa;
            border-collapse:collapse;
        }
        input {
            margin: 5px 0;
            padding-left: 2px;
            background-position: right center;
            background-repeat: no-repeat;
            border-color: olivedrab;
            box-shadow: none;
        }
        table th, table td {
            border:2px solid #aaa;
            padding:5px;
            text-align:center
        }
        th {
            background-color:#eee;
        }
    </style>
    <script type="text/javascript">
        //加入购物车=================================================
        //调用此函数时传入了this,声明参数来接收它,参数名不能叫this(关键字)
        function add_shoppingcart(btn){
            //获取按钮的爷爷
            var tr = btn.parentNode.parentNode;
            //获取tr的所有孩子(tds)
            var tds = tr.getElementsByTagName("td");
            //获取第1个td的内容(商品名)
            var name = tds[0].innerHTML;
            //获取第2个td的内容(单价)
            var price = tds[1].innerHTML;
            //创建一个新的tr,设置内容,追加到tbody下
            var newtr = document.createElement("tr");
            newtr.innerHTML = '<td>'+name+'</td>'+
                '<td>'+price+'</td><td align="center" >'+
                '<input type="button" class="btn btn-info" value="-" onclick="decrease(this);"/> '+
                '<input type="text"  size="3" readonly value="1"/> '+
                '<input type="button" class="btn btn-info"  value="+" onclick="increase(this);"/>'+
                '</td>'+
                '<td>'+price+'</td>'+
                '<td align="center"><input type="button"  class="btn btn-info" value="x" onclick="drop(this);"/></td>';//添加删除事件
            var tbody = document.getElementById("goods");
            tbody.appendChild(newtr);
            sum();
        }
        //加法 数量不能大于库存========================================
        function increase(btn){
            //获取按钮的父亲
            var td2 = btn.parentNode;
            //获取td2内的文本框
            var text = td2.getElementsByTagName("input")[1];
            //获取文本框内值+1后写回文本框
            var amount = text.value;
            text.value = ++amount;
            //获取td2的哥哥td1,从中取出单价
            var td1 = td2.parentNode.getElementsByTagName("td")[1];
            var price = td1.innerHTML;
            //计算金额
            var mny = price*amount;
            //获取td2的弟弟td3,将金额写回td3
            var td3 = td2.parentNode.getElementsByTagName("td")[3];
            td3.innerHTML = mny;
            sum();
        }
        //减法 数量不能小于1 =================================================
        function decrease(btn){
            //获取按钮的父亲td2
            var td2 = btn.parentNode;
            //获取td2的文本框
            var text = td2.getElementsByTagName("input")[1];
            //获取文本框的值-1写回文本框
            var amount = text.value;
            if(amount<1){
                text.value = 0;
            }
            if(amount>0){
                text.value = --amount;
            }
            //获取td2的哥哥td1,从中取回单价
            var td1 = td2.parentNode.getElementsByTagName("td")[1];
            var price = td1.innerHTML;
            //计算金额
            var mny = price*amount;
            //获取td2的弟弟td3,将金额写入td3
            var td3 = td2.parentNode.getElementsByTagName("td")[3];
            td3.innerHTML = mny;
            sum();
        }
        //删除tr行,而不是删除tr行中所有td====================
        function drop(btn){
            var tr = btn.parentNode.parentNode;
            var tbody = document.getElementById("goods");
            tbody.removeChild(tr);
            sum();
        }
        //计算总金额
        function sum() {
            //获取购物车内所有的数据行
            var tbody =
                document.getElementById("goods");
            var trs =
                tbody.getElementsByTagName("tr");
            //遍历这些行
            var s = 0;
            for(var i=0;i<trs.length;i++) {
                //获取每一行下第4个td的内容(金额)
                var mny =
                    trs[i].getElementsByTagName("td")[3].innerHTML;
                //累加
                s += parseFloat(mny);
            }
            //将合计值写入合计列(id="total")
            var td =
                document.getElementById("total");
            td.innerHTML = s;
        }
    </script>
</head>
<body>
<h1>SHOPPING</h1>
<table>
    <tr>
        <th>商品</th>
        <th>单价(元)</th>
        <th>颜色</th>
        <th>库存</th>
        <th>好评率</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>罗技M185鼠标</td>
        <td>80</td>
        <td>黑色</td>
        <td>893</td>
        <td>98%</td>
        <td align="center">
            <input type="button" value="加入购物车" onclick="add_shoppingcart(this);"/>
        </td>
    </tr>
    <tr>
        <td>微软X470键盘</td>
        <td>150</td>
        <td>黑色</td>
        <td>9028</td>
        <td>96%</td>
        <td align="center">
            <input type="button" value="加入购物车" onclick="add_shoppingcart(this);"/>
        </td>
    </tr>
    <tr>
        <td>洛克iphone6手机壳</td>
        <td>60</td>
        <td>透明</td>
        <td>672</td>
        <td>99%</td>
        <td align="center">
            <input type="button" value="加入购物车" onclick="add_shoppingcart(this);"/>
        </td>
    </tr>
    <tr>
        <td>蓝牙耳机</td>
        <td>100</td>
        <td>蓝色</td>
        <td>5</td>
        <td>95%</td>
        <td align="center">
            <input type="button" value="加入购物车" onclick="add_shoppingcart(this);"/>
        </td>
    </tr>
    <tr>
        <td>金士顿U盘</td>
        <td>70</td>
        <td>红色</td>
        <td>482</td>
        <td>100%</td>
        <td align="center">
            <input type="button" class="btn btn-danger" value="加入购物车" onclick="add_shoppingcart(this);"/>
        </td>
    </tr>
</table>
<section class="content-header">
    <ul id="bottomTab"></ul>
</section>

<h1>SHOPPING CART</h1>
<table>
    <thead>
    <tr>
        <th>商品</th>
        <th>单价(元)</th>
        <th>数量</th>
        <th>金额(元)</th>
        <th>删除</th>
    </tr>
    </thead>

    <tbody id="itemTableBody">
    <tbody id="goods">
    </tbody>
    <tfoot>
    <tr>
        <td colspan="3" align="right">总计</td>
        <td id="total"></td>
        <td></td>
    </tr>
    </tfoot>
</table>
<!-- page script -->
<script>
    /**
     * Created by CT on 2017/7/15.
     */

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
    /**
     * 生成表格
     * @param c
     * @param a
     * @param b
     */
    function buildTable(c, a, b) {
        var url ="http://localhost:8080/order/shopItem?adminID=18";
        console.log('url', url)
        $(function () {
            $.ajax({
                type: "post",
                url: url,
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


    $(function () {	//生成底部分页栏
        buildTable("",1,pagesize);//默认空白查全部
        //创建结算规则
        $("#queryButton").bind("click",function(){
            var userName = "Extra";
            buildTable(userName,1,pagesize);
        });
    });
</script>
</body>
</html>
