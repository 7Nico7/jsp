<%
if(session.getAttribute("usuario") != null){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios Generales</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="pages/css/bootstrap.css">
        <link href="pages/css/styless.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="col-md-17">
                <div class="card">
                    <div class="card-header ">
                        <h5 class="text-white">Editar Bien</h5>
                    </div>  
                    ${mensaje}
                    <div class="card-body">
                        <form action="ControllerEditar?Editar=Bien&cve_bienes=${bien.cve_bienes}" method="POST" onsubmit="guardar.disabled = false; return true;">
                            <div class="form-row" >
                                <div class="form-group col-md-2" >
                                    <label>Numero del Bien</label>
                                    <input align="center" class="form-control" id="id" name="id">
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Tipo de Bien</label>
                                    <select onclick="TipoBien()" name='tipoBien' id='tipoBien' class='form-control' required="required">
                                        <option value=''>Seleccionar...</option>
                                        <option value='1'>Clima</option>
                                        <option value='2'>Extintor</option>
                                        <option value='3'>Impresora</option>
                                    </select>                            
                                </div> 
                                <div class="form-group col-md-3" id="Odescripcion" style="display:none" >
                                    <label>Descripción</label>
                                    <input class="form-control" type="text" name='objetoDescripcion' id="objetoDescripcion"/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="marc">
                                    <label>Marca</label>
                                    <input class="form-control" type="text" name='marca' id='marca'/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="model">
                                    <label>Modelo</label>
                                    <input class="form-control" type="text" id='modelo'name='modelo'/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="numSerie">
                                    <label>Numero de serie</label>
                                    <input class="form-control" type="text" name='serie' id="serie"/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="numInventario">
                                    <label>Numero de inventario</label>
                                    <input class="form-control" type="text" name='inventario' id="inventario"/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="fechaF">
                                    <label>Fecha de Factura</label>
                                    <input class="form-control" type="date" name='fechaFactura' id="fechaFactura"/>
                                </div>     
                                <div class="form-group col-md-3" style="display:none" id="fechaI">
                                    <label>Fecha de instalación</label>
                                    <input class="form-control" type="date" name='fechaAltaSistema' id="fechaAltaSistema"/>
                                </div>               
                                <div class="form-group col-md-3" style="display:none" id="ubica">
                                    <label>Ubicación</label>
                                    <input class="form-control" type="text" name='ubicacionTxt' id="ubicacionTxt"/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="respon">
                                    <label>Responsable</label>
                                    <input class="form-control" type="text" name='responsable' id="responsable"/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="toner">
                                    <label>Tonners</label>
                                    <textarea class="form-control" id="tonner" name="tonner"></textarea>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="depend">
                                    <label>Dependecia</label>
                                    <input class="form-control" type="text" required="required" id='dependencia' name='dependencia'/>
                                </div>
                                <div class="form-group col-md-3" style="display:none" id="departame">
                                    <label>Departemento</label>
                                    <input class="form-control" type="text" name='departamento' id="departamento"/>
                                </div>
                                <div class="form-group col-md-2" style="display:none" id="areaO">
                                    <label>Área</label>
                                    <input class="form-control" type="text" name='area' id="area"/>
                                </div>
                                <div class="form-group col-md-4" style="display:none" id="ubicObser">
                                    <label>Observaciones de Ubicación</label>
                                    <textarea class="form-control" id="ubicacionObservacion" name="ubicacionObservacion"></textarea>
                                </div>
                                <div class="form-group col-md-2" style="display:none" id="estado">
                                    <label>Status</label>
                                    <select align="center" name='status' id="status" class="form-control">
                                        <option value=''>Seleccionar...</option>
                                        <option value="1">Activo</option>
                                        <option value="2" >Inactivo</option>                            
                                    </select>
                                </div>
                            </div>
                            <div class="form-group" align="center">
                                <input type="button" name="Regresar" value="Regresar"  class="btn btn-dark" onClick="location.href = 'ControllerBienes?selecciono=Bienes&Tipo=todosBienes'">
                                <button name="actualizar" id="actualizar"  class="btn btn-primary">Actualizar</button>
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
                        <strong>Coordinación General de Modernización Administrativa e Innovación Gubernamental</strong>
                    </div>

                </div>

            </div>
        </footer>

        <script>
            $(document).ready(function () {

                var cambiar;
                var tipo = '${bien.tipo_bien}';
                switch (tipo) {
                    case 'Climas':
                        cambiar = '1';
                        break;
                    case 'Extintores':
                        cambiar = '2';
                        break;
                    case 'Impresoras':
                        cambiar = '3';
                        break;
                    default:
                        cambiar = '${bien.tipo_bien}';
                }

                var status;
                switch ('${bien.status}') {
                    case  'Activo':
                        status = 1;
                        break;
                    case 'Inactivo':
                        status = 2;
                        break;
                    default:
                        status = '${bien.status}';
                }
                document.getElementById("id").disabled = true;
                document.getElementById("id").value = "${bien.cve_bienes}";

                document.getElementById("tipoBien").value = cambiar;
                //document.getElementById("tipoBien").disabled = "true";
                document.getElementById("objetoDescripcion").value = "${bien.unidad}";
                document.getElementById("marca").value = "${bien.marca}";
                document.getElementById("modelo").value = "${bien.modelo}";
                document.getElementById("serie").value = "${bien.serie}";
                document.getElementById("inventario").value = "${bien.num_inventario}";
                document.getElementById("fechaFactura").value = "${bien.fecha_factura}";
                document.getElementById("fechaAltaSistema").value = "${bien.fecha_instalacion}";
                document.getElementById("ubicacionTxt").value = "${bien.ubic_departamento}";
                document.getElementById("responsable").value = "${bien.responsable}";
                document.getElementById("tonner").value = "${bien.tonner}";
                document.getElementById("dependencia").value = "${bien.dependencia}";
                document.getElementById("departamento").value = "${bien.departamento}";
                document.getElementById("area").value = "${bien.area}";
                document.getElementById("ubicacionObservacion").value = "${bien.ubicaObservaciones}";
                document.getElementById("status").value = status;

                var tipoBien = document.getElementById("tipoBien").value;
                var activar = 'block';
                var desactivar = 'none';

                CamposBien(tipoBien, activar, desactivar);




            });
            function TipoBien() {
                var tipoBien = document.getElementById("tipoBien").value;
                var activar = 'block';
                var desactivar = 'none';
                CamposBien(tipoBien, activar, desactivar);
            }

            function CamposBien(tipoBien, activar, desactivar) {
                if (tipoBien === '1') {
                    document.getElementById("actualizar").disabled = "";
                    extintor(desactivar);
                    impresoras(desactivar);
                    camposDesactivadosPosiblemente();
                    climas(activar);
                }
                if (tipoBien === '2') {
                    document.getElementById("actualizar").disabled = "";
                    climas(desactivar);
                    impresoras(desactivar);
                    camposDesactivadosPosiblemente();
                    extintor(activar);
                }
                if (tipoBien === '3') {
                    document.getElementById("actualizar").disabled = "";
                    climas(desactivar);
                    impresoras(desactivar);
                    camposDesactivadosPosiblemente();
                    impresoras(activar);
                }

            }

            function climas(accion) {
                var campos = ['Odescripcion', 'marc', 'model', 'numSerie', 'numInventario', 'fechaF',
                    'fechaI', 'ubica', 'respon', 'depend', 'departame', 'ubicObser', 'areaO', 'estado'];
                for (var i = 0; i < campos.length; i++) {
                    document.getElementById(campos[i]).style.display = accion;
                }
                document.getElementById("tonner").required = "";
                document.getElementById("fechaFactura").required = "";
            }

            function impresoras(accion) {
                var campos = ['marc', 'model', 'numSerie', 'numInventario', 'ubica', 'respon', 'estado', 'toner'];
                for (var i = 0; i < campos.length; i++) {
                    document.getElementById(campos[i]).style.display = accion;
                }
                var desactivarRequired = ['objetoDescripcion', 'fechaFactura', 'fechaAltaSistema',
                    'dependencia', 'departamento', 'ubicacionObservacion', 'area'];
                for (var i = 0; i < desactivarRequired.length; i++) {
                    document.getElementById(desactivarRequired[i]).required = "";
                }
            }

            function extintor(accion) {
                var campos = ['Odescripcion', 'marc', 'model', 'numInventario', 'respon', 'ubica', 'estado'];
                var desactivarRequired = ['serie', 'fechaFactura', 'fechaAltaSistema', 'tonner', 'dependencia', 'departamento',
                    'ubicacionObservacion', 'area'];
                for (var i = 0; i < campos.length; i++) {
                    document.getElementById(campos[i]).style.display = accion;
                }
                for (var i = 0; i < desactivarRequired.length; i++) {
                    document.getElementById(desactivarRequired[i]).required = "";
                }
            }


            function camposDesactivadosPosiblemente() {
                var camposRe = ["objetoDescripcion", "marca", "modelo", "serie", "area", "inventario", "fechaFactura", "fechaAltaSistema", "ubicacionTxt", "responsable", "dependencia", "departamento", "ubicacionObservacion", "status", "tonner"];
                for (var i = 0; i < camposRe.length; i++) {
                    document.getElementById(camposRe[i]).required = "required";
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
