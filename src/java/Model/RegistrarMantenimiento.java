package Model;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrarMantenimiento extends Conexion {

    public String Mantenimiento(Mantenimientos M) {
        String mensaje = "";
        final String sql = "insert fecha_mante_camb(cve_bienes,cve_tipoMantenimiento, cve_fallas,"
                + " fecha, descripcion, evidencia) values (?,?,?,?,?,?);";
        Connection cn = null;
        PreparedStatement ps = null;
        Conexion con = null;
        try {
            con = new Conexion();
            cn = con.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, M.getCve_bienes());
            ps.setString(2, M.getTipoMantenimiento());
            ps.setString(3, M.getFallas());
            ps.setString(4, M.getFecha_manteni());
            ps.setString(5, M.getMant_descripcion());
            ps.setString(6, M.getEvidenciaVideo());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERROR EN RegistrarMantenimiento : " + e);
        } finally {
            try {
                if (cn != null && cn.isClosed() == false) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con = null;
                }
            } catch (SQLException ex) {
                System.err.println("ERROR en cerrar cn RegistrarMantenimiento : " + ex);
            }
        }
        return mensaje;
    }
}
