package Controller;

import Model.Bienes;
import Model.GetBienes_Id;
import Model.ActualizarBien;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControllerEditar", urlPatterns = {"/ControllerEditar"})
public class ControllerEditar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");

    }

    //Redireciona a la pagina Editar con los datos del Elemento
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtiene lo que se va editar, para redireccionar a la Pagina.
        String editar = request.getParameter("Editar");
        switch (editar) {
            case "Bien":
                paginaEditarBien(request, response);

                break;
            default:
                throw new AssertionError();
        }
    }

     //Metodo POST Recibe los datos para actualizar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtiene a lo que se va editar
        String editar = request.getParameter("Editar");

        switch (editar) {
            case "Bien":
                ActualizarBien(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }
    
        private void ActualizarBien(HttpServletRequest request, HttpServletResponse response) {
        Bienes bien = new Bienes();
        //Se envian los parametros request, donde se obtiene el bien
        bien = bien.Bien(request);
        
        ActualizarBien actualiza = new ActualizarBien();
        //Actualiza el bien y Retorna un Mensaje
        String mensaje = actualiza.Actualizar(bien);
        //Se envia el mensaje
        request.setAttribute("mensaje", mensaje);
        //Se envia el bien actualizado
        request.setAttribute("bien", bien);
        try {
            request.getRequestDispatcher("pages/editarBien.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControllerEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        //Redireciona a la Pagina con los datos, para editar el Bien
    private void paginaEditarBien(HttpServletRequest request, HttpServletResponse response) {
        String cve_bienes = request.getParameter("cve_bienes");
        String tipo_bien = request.getParameter("tipo_bien");
        GetBienes_Id buscar = new GetBienes_Id();
        Bienes bien = new Bienes();
        try {
            //Se envia el ID y el tipo de Bien para buscar la ubicacion, y caracteristicas del Bien, sin el mantenimiento
            bien = buscar.buscarBien(Integer.parseInt(cve_bienes), tipo_bien);
            request.setAttribute("bien", bien);
            request.getRequestDispatcher("pages/editarBien.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("ERROR EN paginaEditarBien : " + ex);
        }
    }

}
