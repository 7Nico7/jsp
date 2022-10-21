package Model;

import Conexion.Conexion;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get_Id_Inventarios_Bienes {

    public String ObtenerIdInventerios_Bienes() {
        final String sql = "select cve_bienes, num_inventario from bienes";
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bienes bienes = new Bienes();
        String json = null;
        Gson gson = new Gson();
        try {
            con = new Conexion();
            cn = con.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                bienes.setCve_bienes("cve_bienes");
                bienes.setNum_inventario("num_inventario");
            }
            json = gson.toJson(bienes);

        } catch (SQLException e) {
            System.err.println("ERROR en : " + e);
        } finally {
            try {
                if (cn != null && cn.isClosed() == false) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null && rs.isClosed() == false) {
                    rs.close();
                }
                if (con != null) {
                    con = null;
                }
            } catch (SQLException ex) {
                System.err.println("ERROR en cerrar cn");
            }
        }
        return json;
    }
}
