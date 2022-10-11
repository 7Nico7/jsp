 <%
if(session.getAttribute("usuario") != null){
%>
<!DOCTYPE html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" type="text/css" href="pages/css/bootstrap.css">

    <!-- JavaScript Bundle with Popper -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/responsive/2.3.0/js/dataTables.responsive.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.3.0/css/responsive.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.9/sweetalert2.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.9/sweetalert2.min.js"></script>
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
                            <li><a class="dropdown-item" href="ControllerBienes?selecciono=todos">Todos</a></li>
                            <li><a class="dropdown-item" href="ControllerBienes?selecciono=climas">Climas</a></li>
                            <li><a class="dropdown-item" href="ControllerBienes?selecciono=extintores">Extintores</a></li>
                            <li><a class="dropdown-item" href="ControllerBienes?selecciono=impresoras">Impresoras</a></li>
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
                    <button name="accion" value="salir" align="center"  class="btn btn-danger ml-2">Cerrar Sesion</button>
                </form>
            </div>
        </div>
    </nav>
    <br>
    <div class="container">
        <div class="col-md-17">
            <div class="card">
                <div class="card-header ">
                    <h5 class="text-white">Registro de Bienes</h5>
                </div>   
                ${mensaje}
                <div class="card-body">
                    <form action="ControllerBienes" method="post" onsubmit="guardar.disabled = true; return true;">
                        <div class="form-row" >
                            <div class="form-group col-md-3">
                                <label>Seleccione el tipo de Bien</label>
                                <select name='tipoBien' id='tipoBien' class='form-control' required="required">
                                    <option value=''>Seleccionar...</option>
                                    <option value='1'>Clima</option>
                                    <option value='2'>Extintor</option>
                                    <option value='3'>Impresora</option>
                                </select>                         
                            </div> 
                            <div class="form-group col-md-3">
                                <label>Fecha de Mantenimiento</label>
                                <input class="form-control" type="date" name='fechaMantenimiento' id="fechaMantenimiento"/>
                            </div>  
                            <div class="form-group col-md-2" id="manteni">
                                <label>Mantenimiento</label>
                                <select name='tipoMantenimiento' id='tipoMantenimiento' class='form-control' required="required">
                                    <option value='' >Seleccionar...</option>
                                    <option value='1' >Predictivo</option>
                                    <option value='2' >Preventivo</option>
                                    <option value='3' >Correctivo</option>
                                </select>                            
                            </div> 
                            <div class="form-group col-md-3" id="fallaC" >
                                <label>Falla comun</label>
                                <select name='fallas' id='fallas' class='form-control' required="required">
                                    <option value='' >Seleccionar...</option>
                                    <option value='1' >No enfria</option>
                                    <option value='2' >Falta de gas</option>
                                    <option value='3' >Fuga</option>
                                    <option value='4' >No enciende</option>
                                </select>                            
                            </div> 
                            <div class="form-group col-md-4">
                                <label>Observaciones de Mantenimiento</label>
                                <textarea class="form-control" id="mantenimientObservacion" name="mantenimientObservacion"></textarea>
                            </div>
                            <div class="form-group col-md-2" style="display:none" id="estado">
                                <label>Status</label>
                                <select align="center" name='status' id="status" class="form-control">
                                    <option value=''>Seleccionar...</option>
                                    <option value="1">Activo</option>
                                    <option value="2" >Inactivo</option>                            
                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="evidencia">Subir video</label>
                                <input style="background-color:rgba(179,142,93,1)" type="file" class="form-control-file" id="evidencia">
                            </div>
                        </div>
                        <div class="form-group" align="center">
                            <input type="button" name="Regresar" value="Regresar"  class="btn btn-dark" onClick="location.href = 'ControllerBienes?selecciono=mantenimiento'">
                            <button name="guardar" id="guardar" value="bien"  class="btn btn-primary">Guardar</button>
                        </div>
                    </form>    
                </div>
            </div>
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
                    <img alt="firma blanco.png" height="173" src="resources/img/firma_blanco.png" width="100">
                </div>

                <div class="col-md-12"><br>
                    <p id="blanco"> Copyright &copy;2022</p>
                </div>
                <div class="col-md-12">
                    <strong>Coordinaci?n General de Modernizaci?n Administrativa e Innovaci?n Gubernamental</strong>
                </div>

            </div>

        </div>
    </footer>



    <script>


        function cambiarForm() {

            }


     function camposDesactivadosPosiblemente() {
                var camposRe = ['objetoDescripcion', 'marca', 'modelo', 'serie', 'inventario', 'fechaFactura','tonner', 'fechaAltaSistema', 'ubicacionTxt', 'responsable', 'dependencia', 'departamento', 'fechaMantenimiento', 'tipoMantenimiento', 'fallas', 'area', 'status'];
                for (var i = 0; i < camposRe.length; i++) {
                    document.getElementById(camposRe[i]).required = "required";
                    //$(camposRe[i]).prop('required', true);
                }
            }

       
    </script>

</body>
</html>
<%
}else{
    response.sendRedirect("/serviciosgenerales/index.jsp");
}
%>