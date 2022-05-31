function loadUsers() {  
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/crud_usuario/listausuario",
        success: function (Listeruser) {
            let Listertr = "";
            $.each(Listeruser,function(i,user){
            Listertr += `<tr><td>${user.cpf}</td><td>${user.email}</td><td>${user.senha}</td><td>${user.sexo}</td><td>${user.dataregistro}</td><td><a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></tr>`
            })
            $('#listerUser').append(Listertr);
        },
        error: function() {
            alert('erro ao carregar usuarios')
        },
    })
    }