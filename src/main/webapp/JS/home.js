//Para llamar métodos. 
$(document).ready(function () {

    obtenerListaMoto();
    obtenerListaOrdenes();
    obtenerListaMecanicos();
    obtenerServicios();
    obtenerProductos();
    cambiarEstadoMecanico();
    

//    $("#btnActualizar").click(function (event) {
//        event.preventDefault();
//        obtenerListaMecanicos();
//        console.log("Funciona el botón ese.");
//    });

    $("#form-servicio").submit(function (event) {
        event.preventDefault();
        registrarServicio();

    });

    $("#form-producto").submit(function (event) {
        event.preventDefault();
        registrarProducto();

    });
});

//Mecáncos
function obtenerListaMecanicos() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMecanicosListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarMecanicos(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista mecánicos");
            }
        }
    });
}

function mostrarMecanicos(listaMecanicos) {

    let tabla = "";
    $.each(listaMecanicos, function (index, mecanico) {

        mecanico = JSON.parse(mecanico);
        tabla += '<tr>' +
                '<td>' + mecanico.id + '</td>' +
                '<td>' + mecanico.nombre + ' ' + mecanico.primerApellido + ' ' + mecanico.segundoApellido + '</td>' +
                '<td>' + mecanico.correo + '</td>' +
                '<td>' + mecanico.numeroContacto + '</td>' +
                '<td>' + /* Aquí se chequea y se agrega el valor de check */
                '<div d-inline class="form-check form-switch">' +
                '<input class="form-check-input" type="checkbox" role="switch" id="estado-mecanico"';
        tabla += (mecanico.estado === "Activo" ? 'checked>' : '>');
        tabla += '<label class="form-check-label" for="estado-mecanico">' + mecanico.estado + '</label>' +
                '</div>' +
                '</td>' +
                '</tr>';
    });

    $('#tbody').html(tabla);

}

//Motos
function obtenerListaMoto() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMotoListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarMotos(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista HVmotos");
            }
        }
    });
}

function mostrarMotos(listaMotos) {

    let tarjeta = "";

    $.each(listaMotos, function (index, moto) {
        let motoParsed = JSON.parse(moto);

        tarjeta += '<article class="m-2 ">' +
                '<div class="container col-4 ">' +
                '<div class="card" style="width: 17rem;">' +
                '<img src="./img/moto.jpg" class="card-img-top" alt="logo-moto">' +
                '<div class="card-body bg-dark rounded">' +
                '<h5 class="card-title text-white">' + motoParsed.placa + '</h5>' +
                '<p class="card-text text-white">' + motoParsed.marca + ' ' + motoParsed.modelo + '</p>' +
                '</div>' +
                '<ul class="list-group list-group-flush">' +
                '<li class="list-group-item">' + '<strong>ID Cliente:</strong> ' + motoParsed.idCliente + '</li>' +
                '<li class="list-group-item">' + '<strong>Nombre:</strong> ' + motoParsed.nombreCliente + '</li>' +
                '<li class="list-group-item">' + '<strong>Año modelo:</strong> ' + motoParsed.annoRegistro + '</li>' +
                '</ul>' +
                '<div class="card-body text-center">' +
                '<button type="button" class="activar-modal btn btn-dark" data-bs-toggle="modal" data-bs-target="#' + motoParsed.placa + '">' +
                'Ver ordenes de servicio' +
                '</button>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</article>';
    });
    $('.tarjetero').html(tarjeta);
}

//Ordenes de servicio
function obtenerListaOrdenes() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletOrndeListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarOrdenes(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista Ordenes de servicio");
            }
        }
    });
}
//Entonces socio, haga lo siguiente, dos funciones llamando estado y registros(con servlets y controller
//Luego llame un par de funciones que va declarar dentro de mostrarOrdenes que setten los datos dentro de accordeons 
function mostrarOrdenes(listaOrdenes) {
    let modal = "";
    $.each(listaOrdenes, function (index, orden) {
        let ordenParsed = JSON.parse(orden);
        modal += '<article>' +
                '<!-- Scrollable modal -->' +
                '<!-- Vertically centered scrollable modal -->' +
                '<div class="cajitas modal-dialog modal-dialog-centered modal-dialog-scrollable ">' +
                '<div class="modal fade" id="' + ordenParsed.placaMoto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header bg-dark border-top border-start border-end border-3 ">' +
                '<h5 class="modal-title text-white" id="staticBackdropLabel"><strong>Registro de moto: </strong>' + ordenParsed.placaMoto + '</h5>' +
                '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
                '</div>' +
                '<div id="ordenes" class="ordenes modal-body border border border-3 border-dark" style="--bs-border-opacity: .8;">';
        verOrdenesPorMoto();
        function verOrdenesPorMoto() {

            $.each(listaOrdenes, function (index, ordenPorM) {
                let ordenMotoParsed = JSON.parse(ordenPorM);
                //solo poner las ordenes de está moto.
                if (ordenMotoParsed.placaMoto === ordenParsed.placaMoto) {

                    //Cambié de lugar el h2 y el button
                    modal += '<!--AQUÍ inician los accordeon-->' +
                            '<div class="accordion accordion-flush" id="accordionFlushOrdenes">' +
                            '<div class="accordion-item">' +
                            '<h2 class="accordion-header" id="flush-heading-' + ordenMotoParsed.idOrden + '">' +
                            '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-' + ordenMotoParsed.idOrden + '" aria-expanded="false" aria-controls="flush-collapse-' + ordenMotoParsed.idOrden + '">' +
                            '<strong>Ordén de Servicio:  #</strong>' + ordenMotoParsed.idOrden +
                            '</button>' +
                            '</h2>' +
                            '<div id="flush-collapse-' + ordenMotoParsed.idOrden + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-' + ordenMotoParsed.idOrden + '" data-bs-parent="#accordionFlushOrdenes">' +
                            '<div class="accordion-body">' +
                            '<ul class="list-group list-group-flush">' +
                            '<li class="list-group-item"><strong>Fecha de ingreso:  </strong>' + ordenMotoParsed.date + '</li>' +
                            '<li class="list-group-item"><strong>Motivo de ingreso:  </strong>' + ordenMotoParsed.motivo + '</li>' +
                            '<li class="list-group-item"><strong>Diagnóstico:  </strong>' + ordenMotoParsed.descripcionDiagnostico + '</li>' +
                            '<li class="list-group-item"><strong>Documentos en resguardo:  </strong>' + ordenMotoParsed.documentos + '</li>' +
                            '<li class="list-group-item"><strong>Realiza anticipo:  </strong>' + ordenMotoParsed.anticipo + '</li>' +
                            '<li class="list-group-item"><strong>Valor anticipo:  </strong>$' + ordenMotoParsed.valorAnticipo + '</li>' +
                            '<li id="orden-' + ordenMotoParsed.idOrden + '"class="orden-' + ordenMotoParsed.idOrden + ' list-group-item"><strong>Autorización prueba de ruta:  </strong>' + ordenMotoParsed.autorizacionRuta + '</li>' +
                            '<li id="orden-registro-' + ordenMotoParsed.idOrden + '"class="orden-registro-' + ordenMotoParsed.idOrden + ' list-group-item"><strong>Servicios y productos por Orden</strong></li>' +
                            '<!--Cierra inicio de modal-->' +
                            '</ul>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>';
                } //termina if ordenes
            });
        }
        //termina el acordeon y el modal.
        modal += '<div class="modal-footer mb-3">' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</article>';
    });
    $('.modale').html(modal);
}


function cambiarEstadoMecanico() {

    //Para cambiar el estado en la interfaz cuando se da clic en el switch button 
    $(document).on('change', '#estado-mecanico', function (event) {
        event.preventDefault();
        let idUsuario = $(this).parent().parent().parent().children().first().text();
        let estado = $(this).parent().parent().parent().children().last().text();
        if (estado.trim() === 'Activo') {
            estado = 'Inactivo';
        } else {
            estado = 'Activo';
        }

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletMecanicoModificarEstado",
            data: $.param({
                idUsuario: idUsuario,
                estado: estado
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult !== false) {
                    console.log("Funciona success");
                    obtenerListaMecanicos();
                } else {
                    console.log("Hubo un problema al cambiar estado mecánicos JS");
                }
            }
        });
    });
}

//Servicios
function registrarServicio() {

    let nombreServicio = $("#nameServicio").val();
    let detalleServicio = $("#desServicio").val();
    let valorServicio = $("#valServicio").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletServicioRegistrar",
        data: $.param({
            nombreServicio: nombreServicio,
            detalleServicio: detalleServicio,
            valorServicio: valorServicio
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#register-success-ser").removeClass("d-none");


            } else {
                $("#register-error-ser").removeClass("d-none");
            }
        }
    });
}


function obtenerServicios() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletServiciosListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarServicios(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista servicios");
            }
        }
    });
}


function mostrarServicios(listaServicios) {


    let tabla = "";
    $.each(listaServicios, function (index, servicio) {

        servicioParsed = JSON.parse(servicio);
        tabla += '<tr>' +
                '<td>' + servicioParsed.idServicio + '</td>' +
                '<td>' + servicioParsed.nombreServicio + '</td>' +
                '<td>' + servicioParsed.detalleServicio + '</td>' +
                '<td>' + servicioParsed.valorServicio + '</td>' +
                '</tr>';
    });

    $('#tbodyServicios').html(tabla);
}

//todo tooodoo
function actualizarServicio() {

}

//Productos
function registrarProducto() {
    
    let nombre = $("#nameProducto").val();
    let valorProducto = $("#valProducto").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoRegistrar",
        data: $.param({
            nombre: nombre,
            valorProducto: valorProducto
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#register-success-pro").removeClass("d-none");

            } else {
                $("#register-error-pro").removeClass("d-none");
            }
        }
    });

}


function obtenerProductos() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductosListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarProductos(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista productos");
            }
        }
    });
}


function mostrarProductos(listaProductos) {

    let tabla = "";
    $.each(listaProductos, function (index, producto) {

        productoParsed = JSON.parse(producto);
        tabla += '<tr>' +
                '<td>' + productoParsed.idProducto + '</td>' +
                '<td>' + productoParsed.nombre + '</td>' +
                '<td>' + productoParsed.valorProducto + '</td>' +
                '</tr>';
    });

    $('#tbodyProductos').html(tabla);
}

//todoooo todooo
function actualizarProducto() {

}