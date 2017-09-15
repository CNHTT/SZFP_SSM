/**
 * Created by CT on 2017/8/19.
 */


var pagesize =5;
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
    var url ="/order/shopItem";
    console.log('url', url)
    $(function () {
        $.ajax({
            type: "post",
            url: url,
            async: true,
            data:{'adminID':18,'pageNumber':a,'pageSize':b},
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {

                    /**
                     * 分页
                     */


                    var datalist = data.data.dataList;
                    $("#itemTableBody").empty();
                    if (datalist.length > 0) {
                        displayPage(data.data.pageNo, data.data.pages)
                        $(datalist).each(function () {
                            var d = new Date(this.createTime);
                            var youWant = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
                            var html =
                                '<tr> ' +
                                '<td>' + this.id+ '</td>' +
                                '<td>' + this.className + '</td>' +
                                '<td>' + this.foodName +' </td>' +
                                '<td>' + this.foodPrice + '</td>' +
                                '<td><span class="label label-info btn btn-default" data-toggle="tooltip" data-placement="top" title='+this.foodInfo+'>' + "info" + '</span></td>' +
                                '<td align="center"> <input type="button" class="btn btn-danger" value="ADD SHOPPING CART" onclick="add_shoppingcart(this);"/> </td>' +
                                '</tr>';
                            $("#itemTableBody").append(html);
                        });
                    } else {
                        $("#itemTableBody").append('<tr><th colspan ="9"><center>ＮＯ　ＤＡＴＡ</center></th></tr>');
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
 * 生成底部分页栏
 */
$(function () {
    buildTable("",1,pagesize);//默认空白查全部
});


//加入购物车=================================================
//调用此函数时传入了this,声明参数来接收它,参数名不能叫this(关键字)
function add_shoppingcart(btn){
    //获取按钮的爷爷
    var tr = btn.parentNode.parentNode;
    //获取tr的所有孩子(tds)
    var tds = tr.getElementsByTagName("td");
    //获取第1个td的内容(商品名)
    var number = tds[0].innerHTML;
    var className = tds[1].innerHTML;
    var name = tds[2].innerHTML;
    //获取第2个td的内容(单价)
    var price = tds[3].innerHTML;
    //创建一个新的tr,设置内容,追加到tbody下
    var newtr = document.createElement("tr");
    newtr.innerHTML =
        '<td>'+number+'</td>'+
        '<td>'+className+'</td>'+
        '<td>'+name+'</td>'+
        '<td>'+price+'</td>' +
        '<td align="center" >'+
        '<input type="button" value="-" onclick="decrease(this);"/> '+
        '<input type="text"  size="3" readonly value="1"/> '+
        '<input type="button"   value="+" onclick="increase(this);"/>'+
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
    var td1 = td2.parentNode.getElementsByTagName("td")[3];
    var price = td1.innerHTML;
    //计算金额
    var mny = price*amount;
    //获取td2的弟弟td3,将金额写回td3
    var td3 = td2.parentNode.getElementsByTagName("td")[5];
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
    var td1 = td2.parentNode.getElementsByTagName("td")[3];
    var price = td1.innerHTML;
    //计算金额
    var mny = price*amount;
    //获取td2的弟弟td3,将金额写入td3
    var td3 = td2.parentNode.getElementsByTagName("td")[5];
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
            trs[i].getElementsByTagName("td")[5].innerHTML;
        //累加
        s += parseFloat(mny);
    }
    if (s==0){
        $("#submit").empty();
    }else {

        $("#submit").empty();
        $("#submit").append('<a  href="#tosubmitorder" class="to_submitorder">SUBMIT</a>');
    }
    //将合计值写入合计列(id="total")
    var td =
        document.getElementById("total");
    td.innerHTML = s;
}
