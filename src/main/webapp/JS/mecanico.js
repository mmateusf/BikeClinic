$(document).ready(function () {

    validarCliente();
    registrarCliente();
//correo
    checkCorreo();
//Registrar servicio offcanvas
    $("#form-servicio").submit(function (event) {
        event.preventDefault();
        registrarServicio();

    });
});

function checkCorreo() {
    $('#Correo, #CorreoC').on('keyup', function () {
        if ($('#Correo').val() === $('#CorreoC').val()) {
            $('#message').html(' Coinciden.').css('color', 'green');
        } else
            $('#message').html(' Los correos no coinciden.').css('color', 'red');
    });
}
//ZONA de Cliente
function validarCliente() {

    let idCliente;
    let busqueda;
    $("#Documento").keyup(function (event) {
        event.preventDefault();
        idCliente = event.target.value; //val()
        busqueda = buscarCliente(idCliente);
    });
    if (busqueda !== false) {
        actualizarCliente();
    } else {
    }
}


function registrarCliente() {

    let tipoID = $("#Documento").val();
    let idCliente = $("#Identificacion").val();
    let nombre = $("#Cliente").val();
    let primerApellido = $("#Papellido").val();
    let segundoApellido = $("#Sapellido").val();
    let correo = $("#Correo").val();
    let numeroContacto = $("#Telefono").val();

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
                //remueve clases y habilita pestañas
                //nav link.
                $("#nav-cliente-tab").removeClass("active");
                $('#nav-cliente-tab').prop('aria-selected', false);
                $("nav-cliente-tab").prop('disabled', true);
                //panel
                $("#nav-cliente").removeClass("show");
                $("#nav-cliente").removeClass("active");

                //next tab
                $("#nav-moto-tab").addClass("active");
                $('#nav-moto-tab').prop('aria-selected', true);
                $("#nav-moto-tab").prop('disabled', false);
                //panel
                $("#nav-moto").addClass("show");
                $("#nav-moto").addClass("active");

            } else {
                //ta listo esto.
                $("#register-cliente").removeClass("d-none");
            }
        }
    });
}

function actualizarCliente() {
    //alert sobre actualizar sino se manda a siguiente pestaña
}
//setear recibe datos, si se mete paramentro en val() se pueden setear
let tipoID = $("#Documento").val();
let idCliente = $("#Identificacion").val();
let nombre = $("#Cliente").val();
let primerApellido = $("#Papellido").val();
let segundoApellido = $("#Sapellido").val();
let correo = $("#Correo").val();
let numeroContacto = $("#Telefono").val();
$("#password-error").removeClass("d-none");

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
                if (confirm("El cliente ya está registrado, ¿desea actualizar sus datos?")) {
                    actualizarCliente();
                } else {
                    //remueve clases y habilita pestañas
                    //nav link.
                    $("#nav-cliente-tab").removeClass("active");
                    $('#nav-cliente-tab').prop('aria-selected', false);
                    $("nav-cliente-tab").prop('disabled', true);
                    //panel
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
            } else {
                console.log("El usuario" + idCliente + "no está resgistrado");
                $("#register-error").removeClass("d-none");
            }
        }
    });
}