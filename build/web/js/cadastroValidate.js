$(document).ready(function () {
    $('#register-form').validate({
        rules: {
            email: {
                maxlength: 80,
                required: true
            },
            confirmaEmail: {
                required: true,
                //equalTo: "#email",
            },
            senha: {
                minlength: 6,
                maxlength: 15,
                required: true
            },
            confirmaSenha: {
                required: true,
                //equalTo
            }


        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
    });
    
    $('#login-form').validate({
        rules: {
            email: {
                maxlength: 80,
                required: true
            },

            senha: {
                minlength: 6,
                maxlength: 15,
                required: true
            },
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
    });


});