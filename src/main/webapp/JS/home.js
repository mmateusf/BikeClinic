//Para llamar métodos. 
$(document).ready(function () {
    
    tablaMecanicos();
});

function tablaMecanicos(){
    $.ajax({
        type:"GET",
        dataType:"html",
        url:"./ServletMecanicosListar",
        success: function(result){
            let parsedResult = JSON.parse(result);
            var tabla;
            for (let i = 0; i < parsedResult.length; i++) {
                tabla += '<tr><td>' + parsedResult[i].estado + '</td><td>' + parsedResult[i].password + '</td><td>' + parsedResult[i].rol + '</td><td>' + parsedResult[i].id + '</td><td>' + parsedResult[i].nombre + '</td><td>' + parsedResult[i].primerApellido + '</td><td>'  + parsedResult[i].segundoApellido + '</td><td>'  + parsedResult[i].correo + '</td><td>'  + parsedResult[i].numeroContacto + '</td></tr>';
            }
            $('#tbody').html(tabla);
        }
    });
}