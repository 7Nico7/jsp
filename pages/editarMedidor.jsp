<%
if(session.getAttribute("usuario") != null){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sercicios Generales</title>
        <link rel="stylesheet" type="text/css" href="pages/css/bootstrap.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="pages/css/piede.pagina.css">
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
                                <li><a class="dropdown-item" href="ControllerCFE?pagina=Medidor">Medidor</a></li>
                                <li><a class="dropdown-item" href="ControllerCFE?pagina=Recibo&Tipo=todos">Recibo</a></li>
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
                                            <li><a class="dropdown-item" href="#">${usuario.nombre}</a></li>
                                            <div class="dropdown-divider"></div>
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
            <div class="col-md-17">
                <div class="card">
                    <div class="card-header ">
                        <h5 class="text-white">Editar Medidor</h5>
                    </div>   
                    ${mensaje}
                    <div class="card-body">
                        <form action="ControllerEditar?Editar=Medidor" method="post" onsubmit="guardar.disabled = true; return true;">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label>Medidor Numero</label>
                                    <input class="form-control" type="text" name='cve_medidor' id="cve_medidor" required="required"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Partida</label>
                                    <input class="form-control" type="text" name='partida' id="partida" required="required"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Planta</label>
                                    <input class="form-control" type="text" name='planta' id="planta" required="required"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Local</label>
                                    <input class="form-control" type="text" name='local' id="local" required="required"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Medidor</label>
                                    <input class="form-control" type="text" name='medidor' id="medidor" required="required"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Servicio</label>
                                    <input class="form-control" type="text" name='servicio' id="servicio" required="required"/>
                                </div>
                            </div>
                            <div class="form-group" align="center">
                                <input type="button" name="Regresar" value="Regresar"  class="btn btn-dark" onClick="location.href = 'ControllerCFE?pagina=Medidor'">
                                <button id="guardar" name="guardar"  class="btn btn-primary">Actualizar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <footer class="site-footer">
            <div class="container" align="center">
                <div class="row pt-2 mt-2 text-center">
                    <div class="col-md-12">
                        <img alt="firma blanco.png" height="173" src="imagen/firma_blanco.png" width="100">
                    </div>
                    <div class="col-md-12"><br>
                        <p id="blanco"> Copyright &copy;2022</p>
                    </div>
                    <div class="col-md-12">
                        <strong>Coordinaci&oacute;n General de Modernizaci&oacute;n Administrativa e Innovaci&oacute;n Gubernamental</strong>
                    </div>
                </div>
            </div>
        </footer> 
        <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script>var data = ${json}
                                    var medidor = data;
        </script>
        <script src="pages/js.main/editarMedidor.js" type="text/javascript" defer></script>
    </body>
</html>
<%
}else{
    response.sendRedirect("/serviciosgenerales/index.jsp");
}
%>