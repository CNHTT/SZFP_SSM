/**
 * Created by CT on 2017/7/15.
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
            var username = "Extra";
            buildTable(username,page,pagesize);//默认显示
        }
    };
    $("#bottomTab").bootstrapPaginator(newoptions);
}

var urlRootContext=(function () {
    var strPath = window.document.location.pathname;
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    postPath = "192.168.0.126:8080"
    return postPath;
})();

/**
 * 生成表格
 * @param userName
 * @param a
 * @param b
 */
function buildTable(userName, a, b) {
    var   url = "/user/list.do"
    console.log('url',url)
    var   reqParmes = {'pageNumber':a,'pageSize':b}
    $(function () {
        $.ajax({
            type:"post",
            url:url,
            data:reqParmes,
            async:true,
            dataType:"json",
            success:function (data) {

                if (data.code == 1) {

                    /**
                     * 分页
                     */
                    displayPage(data.data.pageNo,data.data.pages)

                    var datalist=data.data.dataList;
                    $("#listSize").val(datalist.length);
                    $("#tableBody").empty();
                    if (datalist.length>0){
                        $(datalist).each(function () {

                            var d = new Date(this.createTime);
                            var    youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
                            var userId = this.id;
                            var html =
                                '<tr> '+
                                '<td>'+ userId +'</td>'+
                                '<td> <i class="fa fa-user" ></i> <span class="label label-danger">'+this.isDelete+'</span></td>' +
                                '<td>'+this.userName+'</td>'+
                                '<td><span class="label label-info">'+this.userEmail+'</span></td>'+
                                '<td>'+this.createTime+'</td>'+
                                '<td><button class="label label-default" onclick="showInfo('+userId+')">More </button></td>'+
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


/**
 * Click to view details
 * @param id
 */
function  showInfo(id) {
    alert(id);

}


$(function () {	//生成底部分页栏
    buildTable("",1,pagesize);//默认空白查全部
    //创建结算规则
    $("#queryButton").bind("click",function(){
        var userName = "Extra";
        buildTable(userName,1,pagesize);
    });
});