
package Model;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EliminarBien extends Conexion{
    static final String sqlB = "DELETE from bienes WHERE cve_bienes= ?";
    static final String sqlU = "DELETE from ubicaciones Where cve_bienes=?";
    static final String sqlM = "DELETE from fecha_mante_camb where cve_bienes=?";
    public String Eliminar(int cve_bienes){
        String mensaje = null;
        
        PreparedStatement ps = null;
        Connection cn = null;
        Conexion con = null;    
        try {
            con = new Conexion();
            cn = con.getConexion();
            ps = cn.prepareStatement(sqlU);
            ps.setInt(1, cve_bienes);
            ps.executeUpdate();
            ps = cn.prepareStatement(sqlM);
            ps.setInt(1, cve_bienes);
            ps.executeUpdate();
            ps = cn.prepareStatement(sqlB);
            ps.setInt(1, cve_bienes);
            ps.executeUpdate();
            mensaje = "Se Elimino el Registro";
        } catch (SQLException e) {
            System.err.println("ERROR EN EliminarBien.Eliminar " + e);
        }finally{
            try {
                if (cn != null & cn.isClosed() == false) {
                    cn.close();
                }
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(EliminarBien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;
        
    }
    
}
