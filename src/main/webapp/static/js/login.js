/**
 * Created by 戴尔 on 2017/7/14.
 */
$(function () {

    if( $('#loginHint').html().length ==0 || $('#loginHint').html()== null){
        //alert( $('#loginHint').html());
        $('#loginHint').hide();
    }
});

var urlRootContext=(function () {
    var strPath = window.document.location.pathname;
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    return postPath;
})();

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
   if ($("#usernamesignup").val() == ""){
       $("#usernamesignup").focus();
       $("#usernamesignup").tips({
           sida:1,
           msg:"用户名不能为空",
           time:3
       });
       return false;
   }  if ($("#sitesignup").val() == ""){
       $("#sitesignup").focus();
       $("#sitesignup").tips({
           sida:1,
           msg:"地址不能为空",
           time:3
       });
       return false;
   }


   var  emailReg =new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
   var  emailObj = document.getElementById("emailsignup");
   if (!emailReg.test(emailObj.value)){
           $('#emailsignup').focus();
           $("#emailsignup").tips({
               side:1,
               msg: '请输入正确的邮箱地址',
               bg: '#AE81FF',
               time: 3
           });
           return false;
   }


    if ($('#passwordsignup').val().length < 6) {
        $('#passwordsignup').focus();
        $("#passwordsignup").tips({
            side: 1,
            msg: '密码不能小于6位',
            bg: '#AE81FF',
            time: 3
        });
        return false;
    }
    if ($('#passwordsignup_confirm').val() != $('#passwordsignup').val()) {
        $('#passwordsignup_confirm').focus();
        $("#passwordsignup_confirm").tips({
            side: 2,
            msg: '两次密码不一致',
            bg: '#AE81FF',
            time: 3
        });
        return false;
    }

    var  regName = $("#usernamesignup").val();
   var  regEmail = $("#emailsignup").val();
   var  regPwd = $("#passwordsignup").val();
   var  site =  $("#sitesignup").val();
   var  reqParmes = {'name':regName,'email':regEmail,"pwd":regPwd,"site":site}
    $.ajax({
       type:"POST" ,
        url :'/user/register',
        data: reqParmes,
        dataType:'json',
        async:true,
        success:function (data) {
           $.DialogByZ.Confirm({Title:"Hint",Content:"Registration to the landing",BtnL:"OK",BtnR:"NO",FunL:confirmL,FunR:alerts})
        }
    });
}


function  confirmL() {
    $.DialogByZ.Close();
    window.location.hash="#tologin";window.location.reload();
}
function  alerts() {
    $.DialogByZ.Close();
}