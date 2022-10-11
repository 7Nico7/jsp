package Model;

import Conexion.Conexion;
import Model.Bienes;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class GetBienes {

    public String getBienes() {
        String parte1 = "select b.cve_bienes, tb.tipo, serie, marca, modelo, num_inventario, responsable, ubic_departamento, estado from bienes as b";
        String parte2 = " inner join tipoBien as tb on b.cve_tipoBien=tb.cve_tipoBien\n"
                + "inner join ubicaciones as u on b.cve_bienes=u.cve_bienes\n"
                + "inner join estado as e on b.cve_estado=e.cve_estado;";
        String sql = parte1 + parte2;
        String json = null;
        Gson gson = new Gson();
        Conexion conecta = null;
        List<Bienes> bienes = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection con = null;
        try {
            conecta = new Conexion();
            con = conecta.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Bienes b = new Bienes();
                b.setCve_bienes(rs.getString("cve_bienes"));
                b.setTipo_bien(rs.getString("tipo"));
                b.setMarca(rs.getString("marca"));
                b.setModelo(rs.getString("modelo"));
                b.setNum_inventario(rs.getString("num_inventario"));
                b.setSerie(rs.getString("serie"));
                b.setUbic_departamento(rs.getString("ubic_departamento"));
                b.setResponsable(rs.getString("responsable"));
                b.setStatus(rs.getString("estado"));
                bienes.add(b);
            }

            json = gson.toJson(bienes);

        } catch (SQLException ex) {
            System.err.println("ERROR en getBienes : " + ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return json;

    }

}
