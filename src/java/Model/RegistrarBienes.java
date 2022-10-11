package Model;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrarBienes extends Conexion {
 
//Registra el Bien
    public String Registrar(Bienes b) {

        Conexion con = null;
        Connection cn = null;
        PreparedStatement ps;
        String sql = "insert bienes(cve_tipoBien, cve_estado, marca, modelo, fecha_instalacion, "
                + "fecha_factura, num_inventario, unidad, serie)value (?,?,?,?,?,?,?,?,?);";
        ResultSet rs = null;
        con = new Conexion();
        String mensaje = "";
        int id;
        try {
            cn = con.getConexion();
            ps = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, b.getTipo_bien());
            ps.setString(2, b.getStatus());
            ps.setString(3, b.getMarca());
            ps.setString(4, b.getModelo());
           //EL bien tipo clima solo tiene estas fechas
            if (b.getTipo_bien() == "1") {
            ps.setString(5, b.getFecha_instalacion());
            ps.setString(6, b.getFecha_factura());
            }else{
            ps.setString(5, null);
            ps.setString(6, null);
            }
            ps.setString(7, b.getNum_inventario());
            ps.setString(8, b.getUnidad());
            ps.setString(9, b.getSerie());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
                mensaje = "<div class=\"alert alert-success\" role=\"alert\">\n" + "Se registro el Bien Numero " + id + "\n" + "</div>";
                //Se registra la ubicacion del Bien
                ubicacion(b, id, cn);
                //Si el bien es de tipo Impresora Se registra los Tonners
                if (b.getTipo_bien() == "3") {
                   tonners(b, id, cn);
                }

            }
        } catch (SQLException ex) {
            mensaje = "<div class=\"alert alert-danger\" role=\"alert\">\n" + "Nose Registro el bien, ERROR: " + ex + "\n" + "</div>";
            System.err.println("ERROR SQL " + ex);
        }finally {
            try {
                if (cn != null & cn.isClosed() == false) {
                    cn.close();
                    
                }
            } catch (SQLException ex) {
                System.err.println("ERROR en RegistrarBienes cn.close " + ex);
            }
            cn = null;
        }
        return mensaje;
    }

    private void ubicacion(Bienes b, int id, Connection cn) {
        String sql = "insert ubicaciones(cve_bienes, ubic_departamento, departamento, dependencia, area, responsable, observaciones) "
                + "values (?,?,?,?,?,?,?);";
        PreparedStatement ps;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, b.getUbic_departamento());
            ps.setString(3, b.getDepartamento());
            ps.setString(4, b.getDependencia());
            ps.setString(5, b.getArea());
            ps.setString(6, b.getResponsable());
            ps.setString(7, b.getUbicaObservaciones());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERROR EN ubicacion " + e);
        }
    }

    private void tonners(Bienes b, int id, Connection cn) {
        String sql = "insert tonners(cve_bienes, nombre) values (?,?);";
        
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, b.getTonner());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN tonners : " + e);
        }
    }
}