package Model;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuscarBienes_Id extends Conexion {

    public String buscarBien(int cve_bienes) {
        String mensaje = "";
        PreparedStatement ps = null;
        Connection con = null;
        Conexion cn = null;

        try {
            cn = new Conexion();
            con = cn.getConexion();
            ps = con.prepareStatement(mensaje);
            ps.setInt(1, cve_bienes);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERROR EN BuscarBienes_Id.buscarBien : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
                System.err.println("ERROR : " + e2);
            }
        }
        return mensaje;
    }
}
