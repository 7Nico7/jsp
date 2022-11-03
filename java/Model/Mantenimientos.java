package Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Mantenimientos extends Bienes {

    private String cve_mantenimiento;
    private String tipoMantenimiento;
    private String fallas;
    private String fecha_manteni;
    private String mant_descripcion;
    private String nombre_archivo;
    private String evidenciaVideo;
    private String evidenciaFoto;
    private String cambioET;
    private String tonnersCambiados;
    private String dias_restantes;
    private String proximo_mantenimiento;

    public Mantenimientos() {
    }

    public String getCve_mantenimiento() {
        return cve_mantenimiento;
    }

    public void setCve_mantenimiento(String cve_mantenimiento) {
        this.cve_mantenimiento = cve_mantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public String getFallas() {
        return fallas;
    }

    public void setFallas(String fallas) {
        this.fallas = fallas;
    }

    public String getFecha_manteni() {
        return fecha_manteni;
    }

    public void setFecha_manteni(String fecha_manteni) {
        this.fecha_manteni = fecha_manteni;
    }

    public String getMant_descripcion() {
        return mant_descripcion;
    }

    public void setMant_descripcion(String mant_descripcion) {
        this.mant_descripcion = mant_descripcion;
    }

    public String getEvidenciaVideo() {
        return evidenciaVideo;
    }

    public void setEvidenciaVideo(String evidenciaVideo) {
        this.evidenciaVideo = evidenciaVideo;
    }

    public String getEvidenciaFoto() {
        return evidenciaFoto;
    }

    public void setEvidenciaFoto(String evidenciaFoto) {
        this.evidenciaFoto = evidenciaFoto;
    }

    public String getCambioET() {
        return cambioET;
    }

    public void setCambioET(String cambioET) {
        this.cambioET = cambioET;
    }

    public String getTonnersCambiados() {
        return tonnersCambiados;
    }

    public void setTonnersCambiados(String tonnersCambiados) {
        this.tonnersCambiados = tonnersCambiados;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String getDias_restantes() {
        return dias_restantes;
    }

    public void setDias_restantes(String dias_restantes) {
        this.dias_restantes = dias_restantes;
    }

    public String getProximo_mantenimiento() {
        return proximo_mantenimiento;
    }

    public void setProximo_mantenimiento(String proximo_mantenimiento) {
        this.proximo_mantenimiento = proximo_mantenimiento;
    }

    public Mantenimientos ObtenerDatos(HttpServletRequest request) {
        Mantenimientos datos = new Mantenimientos();

        datos.setCve_bienes(request.getParameter("cve_bienes"));
        //System.err.println("CVE_BIENES :  " + datos.getCve_bienes());
        datos.setCve_mantenimiento(request.getParameter("num_mantenimiento"));
        datos.setTipo_bien(request.getParameter("tipoBien"));
        datos.setNum_inventario(request.getParameter("numInventario"));
        datos.setFecha_manteni(request.getParameter("fechaMantenimiento"));
        datos.setTipoMantenimiento(request.getParameter("tipoMantenimiento"));
        datos.setFallas(request.getParameter("fallas"));
        datos.setMant_descripcion(request.getParameter("mantenimientObservacion"));

        SetRutaArchivo guardar = new SetRutaArchivo();
        //Guardar el archivo y obtener la ruta
        Archivo archivo = new Archivo();
        try {
            archivo = guardar.RutaArchivoGuardado(request.getPart("evidencia"));

        } catch (IOException | ServletException ex) {
            System.err.println("Error en Guardar Ruta :" + ex);
        }
        //La ruta del archivo guardado
        datos.setEvidenciaVideo(archivo.getRuta());
        datos.setNombre_archivo(archivo.getNombre());
        datos.setCambioET(request.getParameter("seCambio"));
        datos.setTonnersCambiados("tonnerCambiados");
        return datos;

    }

}
