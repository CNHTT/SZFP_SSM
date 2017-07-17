/**
 * Created by CT on 2017/7/15.
 */

var pagesize =5;
var options={
    currentPage:1,
    totalPages:10,
    size:"normal",
    alignment:"center",
    bootstrapMajorVersion:3,
    itemTexts:function (type,page,current) {
        switch (type){
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
    },
    onPageClicked:function (e,originalEvent,type,page) {
        var userName = "Extra";
        buildTable(userName,page,pagesize);
    }
}

var urlRootContext=(function () {
    var strPath = window.document.location.pathname;
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    return postPath;
})();

/**
 * 生成表格
 * @param userName
 * @param page
 * @param pagesize
 */
function buildTable(userName, page, pagesize) {
    var   url = urlRootContext +"/user/list.do"
    console.log('url',url)
    var   reqParmes = {'pageNumber':page,'pageSize':pagesize}
    $(function () {
        $.ajax({
            type:"get",
            url:url,
            data:reqParmes,
            async:false,
            dataType:"json",
            success:function (data) {
                console.log('logn',data)
                if (data.code == 1) {
                    var newoptions = {
                        currentPage: page ==1?1:page-1,
                        totalPages: data.data.pages == 0 ? 1 : data.data.pages,
                        size: "normal",
                        alignment: "center",
                        bootstrapMajorVersion:3,
                        itemTexts: function (type, page, current) {

                            console.log("aaa"+type+ "  "
                                +page+"  "+current)
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
                            console.log("aaa"+type+ "  "
                            +page)
                            var username = "Extra"
                            buildTable(userName,page,pagesize);//默认显示
                        }
                    }

                    $("#bottomTab").bootstrapPaginator("setOptions",newoptions);
                    var datalist=data.data.dataList;
                    $("#tableBody").empty();
                    if (datalist.length>0){
                        $(datalist).each(function () {
                            var html =
                                '<tr> '+
                                '<td>'+ this.id +'</td>'+
                                '<td> <i class="fa fa-user" ></i> <span class="label label-danger">'+this.isDelete+'</span></td>' +
                                '<td>'+this.userName+'</td>'+
                                '<td><span class="label label-info">'+this.userEmail+'</span></td>'+
                                '<td>'+this.createTime+'</td>'+
                                '<td><a href="#" class="label label-default">More </a></td>'+
                                '</tr>';
                            $("#tableBody").append(html);
                        });
                    }else {
                        $("#tableBody").append('<tr><th colspan ="6"><center>查询无数据</center></th></tr>');
                    }
                }else {
                    alert(data.msg)
                }
            },
            error:function (e) {
                alert("查询失败1："+e);
            }
        });
    });
}

$(function () {	//生成底部分页栏
    $('#bottomTab').bootstrapPaginator(options);
    buildTable("",1,pagesize);//默认空白查全部
    //创建结算规则
    $("#queryButton").bind("click",function(){
        var userName = "Extra";
        buildTable(userName,1,pagesize);
    });
});