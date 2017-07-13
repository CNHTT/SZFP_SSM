/**
 * Created by CT on 2017/7/13.
 */
$(document).ready(function () {

    $("#tosingin").click(function () {
        $.ajax({
            type:"get",
            dataType:"json",
            url:"${pageContext.request.contextPath}/singin",
            data:$("#signInForm").serialize(),
            success:function (data) {


                var code = data.code;
                if (code == -1){
                    $("#loginerror").html(data.msg);
                }

                window.setTimeout(function () {
                    $("#loginerror").html("");
                },2000)
            },
            error:function (request) {

            }}
        )
    });

        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: '邮箱地址不能为空'
                        }
                    }
                }
            }
        })
            .on('success.form.bv', function(e) {
                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function(result) {
                    console.log(result);
                }, 'json');
            });
});