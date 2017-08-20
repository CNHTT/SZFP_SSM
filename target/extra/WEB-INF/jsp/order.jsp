<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/8/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String path =request.getContextPath();
%>
<html>

<head>
    <title>SHOPPING CART</title>
    <meta charset="utf-8" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="<%=path%>/static/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME CSS -->
    <link href="<%=path%>/static/css/font-awesome.min.css" rel="stylesheet" />
    <!-- Google	Fonts -->

    <link rel="stylesheet"  type="text/css" href="<%=path%>/static/css/dialog.css">
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css' />
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/static/css/animate-custom.css">
</head>
<body>

    <div >

            <div  id="shopping">
                <h1>SHOPPING</h1>
                <table class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>NUMBER</th>
                        <th>CLASS NAME</th>
                        <th>SHOP NAME</th>
                        <th>PRICE</th>
                        <th>INFO</th>
                        <th>OPERATION</th>
                    </tr>
                    <tbody id="itemTableBody">
                </table>
                <div class="form-inline">  <ul id="bottomTab"></ul>
                    <button type="button" class="btn btn-primary" data-toggle="collapse"
                            data-target="#shoppingCart">
                        SHOPPING CART
                    </button> </div>


                <div id="shoppingCart" class="collapse">
                    <h1>SHOPPING CART</h1>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>NUMBER</th>
                            <th>NAME</th>
                            <th>UNIT PRICE</th>
                            <th>AMOUNT</th>
                            <th>MONEY</th>
                            <th>DELETE</th>
                        </tr>
                        </thead>

                        <tbody id="goods">
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4" align="right">TOTAL</td>
                            <td id="total"></td>
                            <td id="submit"></td>
                        </tr>
                        </tfoot>
                    </table>

                    <div align="center" id="submitorder"  class="form-horizontal">

                        <div id="showTips"></div>
                        <div >
                            <div class="form-group">
                                <label class="col-sm-2 control-label"  >CustomerName</label><div class="col-sm-10">
                                <input id="customerName" type="text" class="form-control" placeholder="文本输入"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"  >CustomerAddress</label><div class="col-sm-10">
                                <input id="customerAddress"  type="text" class="form-control" placeholder="文本输入"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"  >customerPhone</label><div class="col-sm-10">
                                <input id="customerPhone"  type="text" class="form-control" placeholder="文本输入"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"  >REMARK</label><div class="col-sm-10">
                                <input id="remark"  type="text" class="form-control" placeholder="文本输入"></div>
                            </div>


                            <input type="button" class="btn btn-danger" value="加入购物车" onclick="submitOrder();">

                        </div>
                    </div>
                </div>



        </div>
    </div>




<!--  Jquery Core Script -->
<script src="<%=path%>/static/js/jquery-1.9.0.min.js"></script>
<!--  Core Bootstrap Script -->
<script src="<%=path%>/static/js/bootstrap.js"></script>
<script src="<%=path%>/static/js/bootstrap-paginator.js"></script>
<script src="<%=path%>/static/js/shopping.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/dialog.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/jquery.tips.js"></script>
<script>
     function submitOrder() {

         var arr =[];
         var  tbody =   document.getElementById("goods");
         var  trs   =   tbody.getElementsByTagName("tr");
         var len = trs.length;
         if (len==0){
             alert("please add shop");
         }else {
             for(var i=0;i<trs.length;i++) {
                 var item={};
                 //获取每一行下第4个td的内容(金额)
                 var number = trs[i].getElementsByTagName("td")[0].innerHTML;
                 var name = trs[i].getElementsByTagName("td")[1].innerHTML;
                 var price = trs[i].getElementsByTagName("td")[2].innerHTML;
                 var AMOUNT = trs[i].getElementsByTagName("td")[3].getElementsByTagName("input")[1].value;
                 item.id =number;
                 item.Quantity =AMOUNT;
                 item.food = name;
                 item.amount =price;
                 arr.push(item)
             }

             var customerName =$("#customerName").val();
             var customerAddress =$("#customerAddress").val();
             var customerPhone =$("#customerPhone").val();
             var remark =$("#remark").val();
             var total=$("#total").val();


             if(customerName==""||customerAddress=="" ||customerPhone==""||remark==""){
                 $("#showTips").tips({
                     side:1,
                     msg: 'can not be empty',
                     bg: '#AE81FF',
                     time: 3
                 })
             }else {
                 var reqParmes ={"datas":JSON.stringify(arr),"customerName":customerName,
                     "customerAddress":customerAddress,"customerPhone"
                         :customerPhone,"remark":remark ,"total":total}
//                    window.location.href='/order/submit?datas='+JSON.stringify(arr)+
//                        '&customerName='+customerName+
//                        '&customerAddress='+customerAddress+
//                        '&customerPhone='+customerPhone+
//                        '&total='+total+
//                        '&remark='+remark;
                     $.ajax({
                         type:"get",
                         url:"/order/submit",
                         data:reqParmes,
                         dataType:'json',
                         async:true
                     })
             }
         }


     }
</script>

</body>
</html>
