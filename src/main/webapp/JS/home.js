//Para llamar métodos. 
$(document).ready(function () {

    obtenerListaMecanicos()
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
                '<td>' + mecanico.estado + '</td>' +
                '</tr>';
    });
    $('#tbody').html(tabla);
}

        