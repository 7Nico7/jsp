package Model;

import jakarta.servlet.http.HttpServletRequest;

public class Mantenimientos extends Bienes {
    
    private String tipoMantenimiento;
    private String fallas;
    private String fecha_manteni;
    private String mant_descripcion;
    private String evidenciaVideo;
    private String evidenciaFoto;

    public Mantenimientos() {
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

    public Mantenimientos ObtenerDatos(HttpServletRequest request) {
        Mantenimientos datos = new Mantenimientos();
        datos.setCve_bienes("cve_bienes");
        datos.setTipo_bien(request.getParameter("tipoBien"));
        datos.setFecha_manteni(request.getParameter("fechaMantenimiento"));
        datos.setTipoMantenimiento(request.getParameter("tipoMantenimiento"));
        datos.setFallas(request.getParameter("fallas"));
        datos.setMant_descripcion(request.getParameter("mantenimientObservacion"));

        return datos;

    }
}
