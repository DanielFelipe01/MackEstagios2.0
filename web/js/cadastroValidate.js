$(document).ready(function () {
    $('#register-form').validate({
        rules: {
            emailTo: {
                maxlength: 80,
                required: true
            },
            confirmaEmail: {
                equalTo: "#emailTo"
            },
            senha: {
                minlength: 6,
                maxlength: 15,
                required: true
            },
            confirmaSenha: {
                equalTo: "#senhaTo"
            }


        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
                

        }
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
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        }
    });





    $('#perfil-form').validate({
        rules: {
            senha: {
                minlength: 6,
                maxlength: 15,
                required: true
            },
            nome: {
                minlength: 5,
                maxlength: 80,
                required: true
            },
            nivel: {
                maxlength: 1,
                required: true
            },
            dataNascimento: {
                minlength: 7,
                maxlength: 10,
                required: true
            },
            rg: {
                minlength: 8,
                maxlength: 15,
                required: true
            },
            cpf: {
                minlength: 11,
                maxlength: 15,
                required: true
            },
            tia: {
                minlength: 7,
                maxlength: 15,
                required: true
            },
            telefone: {
                minlength: 8,
                maxlength: 20,
                required: true
            },
            rua: {
                minlength: 5,
                maxlength: 50,
                required: true
            },
            numero: {
                minlength: 1,
                maxlength: 6,
                required: true
            },
            bairro: {
                minlength: 5,
                maxlength: 50,
                required: true
            },
            cidade: {
                minlength: 5,
                maxlength: 50,
                required: true
            },
            estado: {
                minlength: 5,
                maxlength: 50,
                required: true
            },
            cep: {
                minlength: 3,
                maxlength: 12,
                required: true
            },
            complemento: {
                minlength: 5,
                maxlength: 80,
            },
            curso: {
                minlength: 5,
                maxlength: 70,
                required: true
            },
            semestre: {
                minlength: 1,
                maxlength: 2,
                required: true
            },
            faculdade: {
                minlength: 2,
                maxlength: 60,
                required: true
            },
            unidade: {
                minlength: 5,
                maxlength: 60,
                required: true
            },
            site: {
                minlength: 10,
                maxlength: 100,
                required: true
            },
            cnpj: {
                minlength: 5,
                maxlength: 30,
                required: true
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        }
    });
    
    $('#vaga-form').validate({
        rules: {
            cursos: {
                minlength: 3,
                maxlength: 70,
                required: true
            },
            semestre: {
                maxlength: 2,
                required: true
            },
            nome: {
                minlength: 3,
                maxlength: 80,
                required: true
            },
            bolsa: {
                minlength: 1,
                maxlength: 5,
                required: true
            },
            refeicao: {
                minlength: 1,
                maxlength: 5
            },
            transporte: {
                maxlength: 5
            },
            adicionais: {
                maxlength: 1000
            },
            descricao: {
                minlength: 10,
                maxlength: 1500,
                required: true
            },
            atividades: {
                minlength: 5,
                maxlength: 1500,
                required: true
            },
            horario: {
                maxlength: 15
            },
            validade: {
                minlength: 5,
                maxlength: 15,
                required: true
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        }
    });

});
