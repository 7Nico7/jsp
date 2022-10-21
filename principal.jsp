<%
if(session.getAttribute("usuario")!= null){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="pages/css/bootstrap.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
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
                            <a class="nav-link active" href="ControllerLogin">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="ControllerLogin">Perfil</a>
                        </li>
                    </ul>
                    <form action="Validar" method="POST">
                        <span class="text-white">${msje} ${usuario.nombre}</span>
                        <button name="accion" value="salir" align="center"  class="btn btn-danger ml-2">Cerrar Sesion</button>
                    </form>
                </div>
            </div>
        </nav>
        <br>

        <div class="menu_iconos">
            <div class="container__menu_iconos">
                <a class="menu_box" href="ControllerBienes?selecciono=Bienes&Tipo=todosBienes">
                    <span class="material-icons">grid_view</span>
                    <h5>Todos Los Bienes</h5>
                </a>
                <a class="menu_box" href="ControllerBienes?selecciono=Bienes&Tipo=climas">
                    <span class="material-icons">ac_unit</span> 
                    <h5>Climas</h5>
                </a>
                <a class="menu_box" href="ControllerBienes?selecciono=Bienes&Tipo=extintores">
                    <span class="material-icons">fire_extinguisher</span>
                    <h5>Extintores</h5>
                </a>
                <a class="menu_box" href="ControllerBienes?selecciono=Bienes&Tipo=impresoras">
                    <span class="material-icons">print</span>
                    <h5>Impresoras</h5>
                </a>
                <a class="menu_box" href="ControllerBienes?selecciono=mantenimiento">
                    <span class="material-icons">engineering</span>
                    <h5>Mantenimiento</h5>
                </a>
            </div>
        </div>

        <div>
            <section class="conten">
            </section>
        </div>
        <footer class="site-footer">
            <div class="container" align="center">
                <div class="row pt-2 mt-2 text-center">
                    <div class="col-md-12">
                        <img height="173" src="imagen/firma_blanco.png">
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