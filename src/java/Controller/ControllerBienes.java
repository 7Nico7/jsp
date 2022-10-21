package Controller;

import Model.Bienes;
import Model.GetBienes_Id;
import Model.Get_Id_Inventarios_Bienes;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.RegistrarBienes;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "ControllerBienes", urlPatterns = {"/ControllerBienes"})
public class ControllerBienes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        doPost(request, response);
    }

    //Metodo GET Utilizado Para Obtnener datos o direccionar a otra pagina
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtiene la pagina a la que se redireccionara
        String selecciono = request.getParameter("selecciono");
        //Obtiene el tipo de Bien
        String tipo = request.getParameter("Tipo");
        //Si selecciono no es un nulo o espacios
        if (!StringUtils.isBlank(selecciono)) {
            Selecciono(request, response, selecciono, tipo);
        } else {
            request.setAttribute("error", "Error: El valor selecciono = " + selecciono);
            request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
        }
    }

    private void Selecciono(HttpServletRequest request, HttpServletResponse response, String selecciono, String tipo) {

        try {
            // Selecciono es UN BIEN Y el tipo No es nulo o espacios
            if ("Bienes".equals(selecciono) && (!StringUtils.isBlank(tipo))) {
                Bienes(request, response, tipo);
            } else {
                // Si seleccciono no es Un Bien entonces
                switch (selecciono) {
                    case "detalleBienes":
                        detalleBienes(request, response);
                        break;
                    case "mantenimiento":
                        mantenimiento(request, response);
                        break;
                    case "nuevoBien":
                        String mensaje = request.getParameter("mensaje");
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("pages/nuevoBien.jsp").forward(request, response);
                        break;
                    case "nuevoMantenimiento":
                        paginaNuevoMantenimiento(request, response);
                        break;
                    default:
                        request.setAttribute("error", "Error no se reconoce el Parametro selecciono = " + selecciono);
                        request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
                }
            }

        } catch (ServletException | IOException ex) {
            System.err.println("ERROR Selecciono : " + ex);
        }
    }

    //Redireciona a la pagina Bienes con el Titulo del Archivo y el tipo de Bien
    private void Bienes(HttpServletRequest request, HttpServletResponse response, String tipo) {
        // Obtiene el titulo del archivo
        String titulo = getTitulo(tipo);
        //Valida si el titulo es nulo o espacios
        if (!StringUtils.isBlank(titulo)) {
            String[] datos = {titulo, tipo};
            try {
                //Se envian los datos: titulo del archivo y el tipo de bien
                request.setAttribute("data", datos);
                request.getRequestDispatcher("pages/Bienes.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                System.err.println("Error en Bienes");
            }
        } else {
            try {
                String[] titulos = {"todosBienes", "climas", "extintores", "impresoras"};
                request.setAttribute("error", "Error: no se reconoce el Parametro titulo = " + tipo);
                request.setAttribute("titulo", "Parametros aeptados por titulo = " + Arrays.toString(titulos));
                request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                System.err.println("Error en Bienes : " + ex);
            }
        }
    }

//Nombre y Titulo Para los Archivos
    private String getTitulo(String tipo) {
        String titulo = "";
        switch (tipo) {
            case "todosBienes":
                titulo = "Lista Total de Bienes";
                break;
            case "climas":
                titulo = "Lista Total de Climas";
                break;
            case "extintores":
                titulo = "Lista Total de Extintores";
                break;
            case "impresoras":
                titulo = "Lista Total de Impresoras";
                break;
            default:
                titulo = null;
        }
        return titulo;
    }

    // Meodo POST Utilizado Para registrar 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtiene lo que se Guardara
        String guardar = request.getParameter("guardar");
        System.err.println("GUARDAR : " + guardar);
        if (!StringUtils.isBlank(guardar)) {
            switch (guardar) {
                case "bien":
                    GuardarBien(request, response);
                    break;
                case "mantenimiento":
                    GuardarMantenimiento(request, response);
                    break;
                default:
                    String[] guarda = {"bien", "mantenimiento"};
                    request.setAttribute("error", "Error: no se reconoce el Parametro 'guardar' = " + guardar);
                    request.setAttribute("titulo", "Parametros aceptados por 'guardar' = " + Arrays.toString(guarda));
                    request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Error: El Parametro 'guardar' es Nulo");
            request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
        }
    }

    private void detalleBienes(HttpServletRequest request, HttpServletResponse response) {
        String cve_bienes = request.getParameter("Cve_Bienes");

        String tipo_bien = request.getParameter("Tipo_bien");
        GetBienes_Id buscar = new GetBienes_Id();
        Bienes bien = new Bienes();
        try {
            //Se envia el ID y el tipo de Bien para buscar la ubicacion, y caracteristicas del Bien, sin el mantenimiento
            bien = buscar.buscarBien(Integer.parseInt(cve_bienes), tipo_bien);
            request.setAttribute("bien", bien);
            request.getRequestDispatcher("pages/detallesBienes.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("ERROR EN detalleBienes : " + ex);
        }
    }

    //Guarda el Bien Recibido
    private void GuardarBien(HttpServletRequest request, HttpServletResponse response) {
        RegistrarBienes re = new RegistrarBienes();
        Bienes bien = new Bienes();
        //Se envian los parametros request y retorna el Bien
        bien = bien.Bien(request);
        //Registra el Bien y retorna un Mensaje
        String mensaje = re.Registrar(bien);
        try {
            response.sendRedirect("ControllerBienes?selecciono=nuevoBien&mensaje=" + mensaje);
        } catch (IOException ex) {
            System.err.println("ERROR EN GuardarBien : " + ex);
        }
    }

    private void mantenimiento(HttpServletRequest request, HttpServletResponse response) {
        String datos = "Lista total de Mantenimientos";
        try {
            request.setAttribute("data", datos);
            request.getRequestDispatcher("pages/mantenimientos.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("error manetiniento" + ex);
        }
    }

    private void GuardarMantenimiento(HttpServletRequest request, HttpServletResponse response) {

    }

    private void paginaNuevoMantenimiento(HttpServletRequest request, HttpServletResponse response) {
        Get_Id_Inventarios_Bienes bienes = new Get_Id_Inventarios_Bienes();
        String json = bienes.ObtenerIdInventerios_Bienes();
        String[] datos = {json, ""};
        try {
            request.setAttribute("data", datos);
            request.getRequestDispatcher("pages/nuevoMantenimiento.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("ERROR en paginaNuevoMantenimiento : " + ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
