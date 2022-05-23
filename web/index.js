function analisaSexo(sexo) {
    sexo = $('#sexo').val();
    switch (sexo) {
        case 'masculino':
            return true;
            break;
        case 'feminino':
            return true;  
            break;
        case 'neutro':
            return true;
        default:
            return false;
            break;
    }
}
function analisaEmail(email) {
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
}
("#botaoinput").submit(function(e){
    $('#ResultadoCadastro').text("daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    $.ajax({
           type: "POST",
           url: '/crud_usuario/registrausuario',
           dataType:'json',
           data: $("#formularioCadastro").serialize(),
           success: function(data){     
            }
         })
         
})
