<%
if(session.getAttribute("usuario")!= null){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="pages/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
        <script src="js/boostra.excel.js"></script>
        <title>Detalle Bienes</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbarSupportedContent">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <a class="navbar-brand" href="#">CGMAIG</a>
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="principal.jsp">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link active dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                                Bienes
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=Bienes&Tipo=todos">Todos</a></li>
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=Bienes&Tipo=climas">Climas</a></li>
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=Bienes&Tipo=extintores">Extintores</a></li>
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=Bienes&Tipo=impresoras">Impresoras</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                CFE
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=todos">Medidores</a></li>
                                <li><a class="dropdown-item" href="ControllerBienes?selecciono=climas">Recibos</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link active" href="ControllerBienes?selecciono=Mantenimientos&Tipo=todos">Mantenimiento</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Vehiculos
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ControllerVehiculos?selecciono=vehiculos">Vehiculos</a></li>
                                <li><a class="dropdown-item" href="ControllerVehiculos?selecciono=gasolina">Carga de Gasolina</a></li>
                                <li><a class="dropdown-item" href="ControllerVehiculos?selecciono=servicios">Servicios</a></li>
                            </ul>
                        </li>
                    </ul>
                    <div align="right">
                        <div class="container-fluid" >
                            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                                <ul class="navbar-nav mr-auto">
                                    <li class="nav-item dropdown" > 
                                        <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            <span class="material-icons">account_circle</span>
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-right">
                                            <li><a style="color: #fff; " href="#">${usuario.nombre}</a></li>
                                            <li><a class="dropdown-item" href="ControllerVehiculos?selecciono=gasolina">Perfil</a></li>
                                            <li><a class="dropdown-item" href="ControllerVehiculos?selecciono=vehiculos">Usuarios</a></li>
                                            <li>

                                            <li>
                                                <a class="dropdown-item" href="Validar?accion=salir">
                                                    <span class="material-icons">
                                                        logout</span>
                                                </a>
                                            </li>
                                    </li>                             
                                </ul>
                                </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <br>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <div class="form-row">
                        <div class="form-group col-md-7">
                            <h5 class="text-white">Información del Bien</h5>
                        </div>
                        <div class="form-group col-md-3">
                            <button class="btn btn-success" id="Excel">Excel</button>
                        </div>
                    </div> 
                </div> 
                <table id="infoBienes" class="table">
                    <tr>
                        <th>Numero de Bien</th>
                        <td>${bien.cve_bienes}</td>
                        <th>Tipo de Bien</th>
                        <td>${bien.tipo_bien}</td>
                    </tr>
                    <tr>
                        <th>INVENTARIO</th>
                        <td>${bien.num_inventario}</td>
                        <th>MARCA</th>
                        <td>${bien.marca}</td>
                    </tr>

                    <tr>
                        <th>MODELO</th>
                        <td>${bien.modelo}</td>
                        <th>SERIE</th>
                        <td>${bien.serie}</td>
                    </tr>
                    <tr>
                        <th>FECHA DE FACTURA</th>
                        <td>${bien.fecha_factura}</td>
                        <th>FECHA DE AL SISTEMA</th>
                        <td>${bien.fecha_instalacion}</td>
                    </tr>

                    <tr>
                        <th>Ubicacion</th>
                        <td>${bien.ubic_departamento}</td>
                        <th>Responsable</th>
                        <td>${bien.responsable}</td>
                    </tr>

                    <tr>
                        <th>Tonner</th>
                        <td>${bien.tonner}</td>
                        <th>Dependencia</th>
                        <td>${bien.dependencia}</td>
                    </tr>
                    <tr>
                        <th>Departamento</th>
                        <td>${bien.departamento}</td>
                        <th>Área</th>
                        <td>${bien.area}</td>
                    </tr>
                    <tr>
                        <th>Observaciones de Ubicación</th>
                        <td>${bien.ubicaObservaciones}</td>
                        <th>Estado</th>
                        <td>${bien.status}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="form-group" align="center">
            <input type="button" name="Regresar" value="Regresar"  class="btn btn-dark" onClick="location.href = 'ControllerBienes?selecciono=Bienes&Tipo=todosBienes'">
        </div>
        <script>

                $(function () {
                    $("#Excel").click(function (e) {
                        var table = $("#infoBienes");
                        if (table && table.length) {
                            $(table).table2excel({
                                exclude: ".noExl",
                                name: "Excel Document Name",
                                filename: "${bien.tipo_bien}" + new Date().toISOString().replace(/[\-\:\.]/g, "") + ".xls",
                                fileext: ".xls",
                                exclude_img: true,
                                exclude_links: true,
                                exclude_inputs: true,
                                preserveColors: false
                            });
                        }
                    });

                });
        </script>
    </body>
</html>
<%
}else{
    response.sendRedirect("/serviciosgenerales/index.jsp");
}
%>