package Controller;

import Model.BuscarBienes_Id;
import Model.GetBienes;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControllerEditar", urlPatterns = {"/ControllerEditar"})
public class ControllerEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editar = request.getParameter("Editar");

        switch (editar) {
            case "Bien":
                paginaEditarBienes(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private void paginaEditarBienes(HttpServletRequest request, HttpServletResponse response) {
        BuscarBienes_Id bien = new BuscarBienes_Id();
        String cve_bienes = request.getParameter("cve_bienes");
        String mensaje = bien.buscarBien(Integer.parseInt(cve_bienes));
        request.setAttribute("data", cve_bienes);
        try {
            request.getRequestDispatcher("pages/mantenimientos.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControllerEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editar = request.getParameter("Editar");

        switch (editar) {
            case "Bien":

                break;
            default:
                throw new AssertionError();
        }
    }
}
