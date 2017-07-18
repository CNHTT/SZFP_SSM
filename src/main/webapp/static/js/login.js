/**
 * Created by 戴尔 on 2017/7/14.
 */
$(function () {

    if( $('#loginHint').html().length ==0 || $('#loginHint').html()== null){
        //alert( $('#loginHint').html());
        $('#loginHint').hide();
    }
});



function  checkLogin() {

    var reg = new RegExp("^[a-z0-9_-]{6,18}$");
    var obj = document.getElementById("password");
    if (reg.test(obj.value)){
        return true;
    }else {
        $("#password").tips({
            side:1,
            msg:'密码长度为6-18',
            time:3,
            color:'#FFF',//文字颜色，默认为白色
            bg:'#FD9720',//背景色，默认为红色
        });
        $("#password").focus();
        return false;
    }
}


function  userReg() {
    // if (){
    //
    // }
}
