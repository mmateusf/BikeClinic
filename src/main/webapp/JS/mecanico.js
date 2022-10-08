let idClienteO;

$(document).ready(function () {

    validarCliente();
    checkCorreo();
//Correcto, para botón registrar. sin validar.
    $("#btnSubmitUser").click(function (event) {
        event.preventDefault();
        registrarCliente();

    });
});

//ok js, Validado
function checkCorreo() {
    $('#Correo, #CorreoC').on('keyup', function () {
        if ($('#Correo').val() === $('#CorreoC').val()) {
            $('#message').html(' Coinciden.').css('color', 'green');
        } else
            $('#message').html(' Los correos no coinciden.').css('color', 'red');
    });
}
//ZONA de Cliente
//Funciona la validación, no setea algunos datos y valida dos veces.
function validarCliente() {

    let idCliente;
    $("#Identificacion").on('keyup', function (event) {
        event.preventDefault();
        idCliente = $("#Identificacion").val();
        console.log("el id es: " + idCliente);
        buscarCliente(idCliente);
    });
    //no necesito if, busqueda hace el llamado de actualizar
}

//falta todo lo del back
function registrarCliente() {

    let tipoID = $("#Documento").val();
    let idCliente = $("#Identificacion").val();
    let nombre = $("#Cliente").val();
    let primerApellido = $("#Papellido").val();
    let segundoApellido = $("#Sapellido").val();
    let correo = $("#Correo").val();
    let numeroContacto = $("#Telefono").val();
    //asigna en la global, pues es irrelevante para esto el if pues no se puede cambiar el id.
    //si no existe se ejecutará está cuando se de click en el botón enviar.
    idClienteO = idCliente;
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletClienteRegistro",
        data: $.param({
            tipoId: tipoID,
            idCliente: idCliente,
            nombre: nombre,
            primerApellido: primerApellido,
            segundoApellido: segundoApellido,
            correo: correo,
            numeroContacto: numeroContacto
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                pasarPestañaCliente();
                console.log("Se registró correctamente el cliente");
            } else {
                //ta listo esto.
                $("#register-cliente").removeClass("d-none");
            }
        }
    });
}

//Funciona, validado
function actualizarCliente(tipoId, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto) {
    //alert sobre actualizar sino se manda a siguiente pestaña
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletClienteActualizar",
        data: $.param({
            tipoId: tipoId,
            idCliente: idCliente,
            nombre: nombre,
            primerApellido: primerApellido,
            segundoApellido: segundoApellido,
            correo: correo,
            numeroContacto: numeroContacto
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                alert("Actuazlición exitosa");
                pasarPestañaCliente();
                console.log("Se actulizó cliente: " + idCliente);
                //sí se algo con la tabla aquí se puede construir.
            } else {
                $("#actualizar.cliente").removeClass("d-none");
            }
        }
    });
}

//Funciona validado.
function buscarCliente(idCliente) {
//buscará por id returnará booleano, tal vez también los datos. 
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletClienteBuscar",
        data: $.param({
            idCliente: idCliente
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                console.log("El usuario " + idCliente + " ya está registrado");
                //setear datos del cliente en el formulario
                //setear recibe datos, si se mete paramentro en val() se pueden setear
                tipo = document.getElementById('Documento').value;
                $("#Documento").val(tipo);
                $("#Identificacion").val(idCliente);
                $("#Cliente").val(parsedResult.nombre);
                $("#Papellido").val(parsedResult.primerApellido);
                $("#Sapellido").val(parsedResult.segundoApellido);
                $("#Correo").val(parsedResult.correo);
                $("#CorreoC").val(parsedResult.correo);
                $("#Telefono").val(parsedResult.numeroContacto);
                //bloquea id
                $("#Identificacion").prop('disabled', true);
                //asigna en la global, pues es irrelevante para esto el if pues no se puede cambiar el id.
                idClienteO = idCliente;

                if (confirm("El cliente ya está registrado, ¿desea actualizar sus datos?")) {
                    alert("Cuando actualice los datos debe dar click en el botón de 'Editar Registro'");
                    $("#btnSubmitUser").prop('disabled', true);
                    $("#btnEditUser").prop('disabled', false);
                    
                    //le da espacio a actualizar los nuevos datos
                    $("#btnEditUser").click(function (event) {
                        event.preventDefault();
                        //recolecta nuevos datos
                        let tipoId = $("#Documento").val();
                        let idCliente = $("#Identificacion").val();
                        let nombre = $("#Cliente").val();
                        let primerApellido = $("#Papellido").val();
                        let segundoApellido = $("#Sapellido").val();
                        let correo = $("#Correo").val();
                        let numeroContacto = $("#Telefono").val();
                        //llama función
                        actualizarCliente(tipoId, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto);

                    });
                } else {
                    pasarPestañaCliente();
                }
            } else {
                console.log("El usuario :" + idCliente + ", no está resgistrado");
                $("#btnEditUser").prop('disabled', true);
                //podría ir un alert sobre que no está registrado.
            }
        }
    });
}

//Funciona validado.
function pasarPestañaCliente() {

    //remueve clases y habilita pestañas
    //nav link.
    $("#nav-cliente-tab").removeClass("active");
    $('#nav-cliente-tab').prop('aria-selected', false);
    $("#nav-cliente-tab").prop('disabled', true);
    //panel (creo que se puede hacer en una sola.
    $("#nav-cliente").removeClass("show");
    $("#nav-cliente").removeClass("active");

    //next tab
    $("#nav-moto-tab").addClass("active");
    $('#nav-moto-tab').prop('aria-selected', true);
    $("#nav-moto-tab").prop('disabled', false);
    //panel
    $("#nav-moto").addClass("show");
    $("#nav-moto").addClass("active");
}