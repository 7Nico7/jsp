package Model;

import Conexion.Conexion;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMantenimiento_Id {

    public String GetMantnimientoID(String cve_mantenimiento, String tipo_bien, String num_inventario) {
        Gson gson = new Gson();
        String json = null;
        String sql = """
                     select * from fecha_mante_camb 
                     where cve_fecha_mante_camb=""" + cve_mantenimiento + ";";

        PreparedStatement ps = null;
        Connection con = null;
        Conexion cn = null;
        ResultSet rs = null;
        try {
            cn = new Conexion();
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Mantenimientos M = new Mantenimientos();
                M.setCve_bienes(rs.getString("cve_bienes"));
                M.setCve_mantenimiento(rs.getString("cve_fecha_mante_camb"));
                M.setTipoMantenimiento(rs.getString("cve_tipoMantenimiento"));
                M.setFallas(rs.getString("cve_fallas"));
                M.setTipo_bien(tipo_bien);
                M.setNum_inventario(num_inventario);
                M.setFecha_manteni(rs.getString("fecha"));
               // M.setEvidenciaVideo(rs.getString("archivo"));
                M.setNombre_archivo(rs.getString("nombre_archivo"));
                M.setCambioET(rs.getString("cambio_et"));
                M.setMant_descripcion(rs.getString("descripcion"));
                M.setTonnersCambiados(rs.getString("tornner_cambiado"));
                json = gson.toJson(M);
            }
        } catch (SQLException e) {
            System.err.println("ERROR EN GetMantenimiento_ID : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }

                if (con != null) {
                    con.close();
                    con = null;
                }
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (cn != null) {
                    cn = null;
                }

            } catch (SQLException e2) {
                System.err.println("ERROR : " + e2);
            }
        }

        return json;
    }
}
