//Para llamar métodos. 
$(document).ready(function () {

    obtenerListaMecanicos();
    cambiarEstadoMecanico();

});


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
                tabla += (mecanico.estado === "Activo" ? 'checked>' : '>' );
                tabla += '<label class="form-check-label" for="estado-mecanico">' + mecanico.estado + '</label>' +
                '</div>' +  
                '</td>' +
                '</tr>';
    });

    $('#tbody').html(tabla);

}



function cambiarEstadoMecanico() {

    $(document).on('change', '#estado-mecanico', function (event) {
        event.preventDefault();
        let idUsuario = $(this).parent().parent().parent().children().first().text();
        let estado = $(this).parent().parent().parent().children().last().text();
        if (estado.trim() === 'Activo') {
            estado = 'Inactivo';
            console.log("Funciona true if");

        } else {
            estado = 'Activo';

            console.log("Funciona false if");
        }
        console.log("Funciona antes ajax");
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
                    obtenerListaMecanicos()

                } else {
                    console.log("Hubo un problema al cambiar estado mecánicos JS");
                }
            }
        });
    });
}
