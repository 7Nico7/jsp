$(document).ready(function () {

    var table = $('#example').DataTable({
        responsive: true,
        ajax: {
            url: 'ControllerBienes?selecciono=tabla',
            dataSrc: ''
        },
        columns: [
            {data: 'cve_bienes'},
            {data: 'tipo_bien'},
            {data: 'num_inventario'},
            {data: 'serie'},
            {data: 'responsable'},
            {data: 'status'},
            {defaultContent: "<button class='btn btn-sm btn-info btnEditar'><span class='material-icons'>edit</span></button>\n\
                    <button class='btn btn-sm btn-danger btnBorrar'><span class='material-icons'>delete</span></button>\n\
                    <button class='btn btn-sm btn-success btnEvidencia'><span class='material-icons'>smart_display</span></button>"}
        ]
    });

    $(document).on("click", ".btnEditar", function () {
        var fila = $(this).closest("tr");
        var cve_bienes = fila.find("td:eq(0)").text();
        var datos = "cve_bienes=" + cve_bienes;
        if (editar) {
            $.ajax({
                url: "ControllerEditar?Editar=Bien", type: 'POST', data: datos,
                success: function (data) {
                    if (data.trim() === null) {
                        swal('Error!', 'Ah ocurrido un error nose pudo eliminar el registro', 'error');
                    } else {
                        swal('Mensaje del sistema', data.trim(), 'success');
                    }
                    //Limpiar();
                    table.ajax.reload(null, false);
                }, error: function (xml, data) {
                    swal('Error!', 'Ah ocurrido un error nose pudo eliminar el registro', 'error');
                }
            });
        }

    });

    $(document).on("click", ".btnBorrar", function () {
        var opcion = "elimnarBien";
        var fila = $(this).closest("tr");
        var cve_bienes = fila.find("td:eq(0)").text(); //capturo el ID
        var datos = "cve_bienes=" + cve_bienes;
        var eliminar = confirm("Eliminar Registro");
        if (eliminar) {
            $.ajax({
                url: "ControllerEliminar?Eliminar=eliminarBien", type: 'POST', data: datos,
                success: function (data) {
                    if (data.trim() === null) {
                        swal('Error!', 'Ah ocurrido un error nose pudo eliminar el registro', 'error');
                    } else {
                        swal('Mensaje del sistema', data.trim(), 'success');
                    }
                    //Limpiar();
                    table.ajax.reload(null, false);
                }, error: function (xml, data) {
                    swal('Error!', 'Ah ocurrido un error nose pudo eliminar el registro', 'error');
                }
            });
        }
    });
});
