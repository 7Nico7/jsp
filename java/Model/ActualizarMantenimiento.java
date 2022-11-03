package Model;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.poi.util.StringUtil;

public class ActualizarMantenimiento {

    public String Actualizar(Mantenimientos M) {
        String sql = """
                     UPDATE fecha_mante_camb SET cve_bienes = ?, cve_tipoMantenimiento = ?, cve_fallas = ?, 
                     fecha = ?, descripcion = ?, archivo = ?, nombre_archivo= ?, cambio_et = ?, tornner_cambiado=?
                     where cve_fecha_mante_camb=?""";

        String mensaje = "";
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String camposValidados = respuestaValida(M);

        if ("correcto".equals(camposValidados)) {
            try {
                con = new Conexion();
                cn = con.getConexion();
                ps = cn.prepareStatement(sql);

                ps.setString(1, M.getCve_bienes());
                ps.setString(2, M.getTipoMantenimiento());
                ps.setString(4, M.getFecha_manteni());
                ps.setString(5, M.getMant_descripcion());
                if (!StringUtil.isBlank(M.getEvidenciaVideo())) {
                    ps.setString(6, M.getEvidenciaVideo());
                    ps.setString(7, M.getNombre_archivo());
                } else {
                    ps.setString(6, " ");
                    ps.setString(7, " ");
                }

                if ("1".equals(M.getTipo_bien())) {
                    ps.setString(8, " ");
                    ps.setString(9, " ");
                    ps.setString(3, M.getFallas());

                } else {
                    ps.setInt(3, 5);
                    if (StringUtil.isBlank(M.getCambioET())) {
                        ps.setString(8, M.getCambioET());
                    } else {
                        ps.setString(8, " ");
                    }
                    if (StringUtil.isBlank(M.getTonnersCambiados())) {
                        ps.setString(9, M.getTonnersCambiados());
                    } else {
                        ps.setString(9, " ");
                    }
                }

                ps.setString(10, M.getCve_mantenimiento());
                ps.executeUpdate();
                mensaje = "<div class=\"alert alert-success\" role=\"alert\">\n"
                        + "  Se actualizo el Mantenimiento!\n"
                        + "</div>";
            } catch (SQLException e) {
                mensaje = """
                      <div class="alert alert-danger" role="alert">
                      Nose Actualizo el bien, ERROR: """ + e + "\n" + "</div>";
                System.err.println("ERROR en Actualizar Mantenimiento : " + e);
            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }

                    if (con != null) {
                        con = null;
                    }

                    if (ps != null) {
                        ps.close();
                        ps = null;
                    }

                    if (rs != null) {
                        rs.close();
                        rs = null;
                    }
                } catch (SQLException ex) {
                    System.err.println("ERROR cerrar Conexiones : " + ex);
                }
            }
        } else {
            mensaje = camposValidados;
        }

        return mensaje;
    }

    private String respuestaValida(Mantenimientos M) {
        String respuesta = null;
        String[] campos = {};
        String[] camposNombre = {};
        if (!StringUtil.isBlank(M.getTipo_bien())) {
            if ("1".equals(M.getTipo_bien())) {
                String[] campos1 = {M.getCve_bienes(), M.getNum_inventario(), M.getFecha_manteni(), M.getTipoMantenimiento(), M.getFallas()};
                String[] camposNombre1 = {"El Numero de Bien es NULO", "Campo Inventario NULO", "Fecha de Mantenimiento NULA", "Tipo de Mantenimiento NULO", "Falla NULA"};
                campos = campos1;
                camposNombre = camposNombre1;
            }
            if ("2".equals(M.getTipo_bien())) {
                String[] campos1 = {M.getCve_bienes(), M.getNum_inventario(), M.getFecha_manteni(), M.getCambioET(), M.getTipoMantenimiento()};
                String[] campoNombre1 = {"El Numero de Bien es NULO", "Campo Inventario NULO", "Fecha de Mantenimiento NULA", "Responda si, se Cambio el extintor", "Tipo de Mantenimiento NULO"};
                campos = campos1;
                camposNombre = campoNombre1;
            }

            if ("3".equals(M.getTipo_bien())) {

                if ("1".equals(M.getCambioET())) {
                    String[] campos1 = {M.getCve_bienes(), M.getNum_inventario(), M.getFecha_manteni(), M.getCambioET(), M.getTipoMantenimiento()};
                    String[] campoNombre1 = {"El Numero de Bien es NULO", "Campo Inventario NULO", "Fecha de Mantenimiento NULA", "Responda si, se Cambio el Tonner", "Tipo de Mantenimiento NULO"};
                    campos = campos1;
                    camposNombre = campoNombre1;
                } else {
                    String[] campos1 = {M.getCve_bienes(), M.getNum_inventario(), M.getFecha_manteni(), M.getCambioET(), M.getTipoMantenimiento(), M.getTonnersCambiados()};
                    String[] campoNombre1 = {"El Numero de Bien es NULO", "Campo Inventario NULO", "Fecha de Mantenimiento NULA", "Responda si, se Cambio el Tonner", "Tipo de Mantenimiento NULO", "Los tonners cambiados son NULOS"};
                    campos = campos1;
                    camposNombre = campoNombre1;
                }

            }

            ValidaCampos Campos = new ValidaCampos();

            String validar = Campos.valida(campos, camposNombre);
            respuesta = validar;
        }

        return respuesta;
    }

}
