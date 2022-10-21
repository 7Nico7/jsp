<%
if(session.getAttribute("usuario") != null){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" type="text/css" href="pages/css/bootstrap.css">
    <link href="pages/css/piede.pagina.css" rel="stylesheet" type="text/css"/>
    <!-- Iconos -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- jquery -->
    <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>

    <!-- dataTable -->
    <link rel="stylesheet" type="text/css" href="js/DataTables/datatables.min.css"/>
    <script type="text/javascript" src="js/DataTables/datatables.min.js"></script>

    <!-- Editar Excel dataTable -->
    <script src="js/datatables-buttons-excel-styles.js" type="text/javascript"></script>
    <script src="js/datatables-buttons-excel-styles.templates.js" type="text/javascript"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <!-- sweetalert2 -->
    <link href="pages/css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
    <script src="js/sweetalert2.min.js" type="text/javascript"></script>

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
                        <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Bienes
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="ControllerBienes?selecciono=Bienes&Tipo=todosBienes">Todos</a></li>
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

                    <li class="nav-item">
                        <a class="nav-link active" href="ControllerBienes?selecciono=mantenimiento">Mantenimiento</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="ControllerUsuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="ControllerPerfil">Perfil</a>
                    </li>
                </ul>
                <form action="Validar" method="POST">
                    <span class="text-white">Bienvenido ${usuario.nombre}</span>
                    <button name="accion" value="salir"  class="btn btn-danger ml-2">Cerrar Sesion</button>
                </form>
            </div>
        </div>
    </nav>
    <br>

    <div class="container">
        <div class="col-md-16">
            <div class="card">
                <div class="card-header text-right">
                    <a href="ControllerBienes?selecciono=Mantenimiento&tipo=extintores" class="btn btn-sm btn-primary">Extintores</a>
                    <a href='ControllerBienes?selecciono=Mantenimiento&tipo=climas' class="btn btn-sm btn-primary">Climas</a>
                    <a href='ControllerBienes?selecciono=Mantenimiento&tipo=impresoras' class="btn btn-sm btn-primary">Impresoras</a> 
                    <a href='ControllerBienes?selecciono=Mantenimiento=&tipo=todos' class="btn btn-sm btn-primary">Todos</a>
                    <a href='ControllerBienes?selecciono=nuevoMantenimiento' class="btn btn-sm btn-primary">Nuevo</a>
                </div>   
            </div>

            <h5>${data}</h5>
            <table id="example" class="table table-bordered display nowrap" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo de Bien</th>
                        <th>Serie</th>
                        <th>Inventario</th>
                        <th>Fecha de Mantenimiento</th>
                        <th>Proximo Mantenimiento</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
            <br>
    <div>
        <section class="conten">
        </section>
    </div>
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
                    <strong>Coordinación General de Modernización Administrativa e Innovación Gubernamental</strong>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>
<%
}else{
    response.sendRedirect("/serviciosgenerales/index.jsp");
}
%>