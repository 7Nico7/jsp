package Controller;

import Model.EliminarBien;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerEliminar", urlPatterns = {"/ControllerEliminar"})
public class ControllerEliminar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eliminarEditar = request.getParameter("Eliminar");
        switch (eliminarEditar) {
            case "eliminarBien":
                eliminarBien(request, response);
                break;
            case "CFE":

            default:
                throw new AssertionError();
        }

    }

    private void eliminarBien(HttpServletRequest request, HttpServletResponse response) {
        try {
            String cve_bienes = request.getParameter("cve_bienes");
            EliminarBien bien = new EliminarBien();
            PrintWriter out;
            out = response.getWriter();
            try {
                String mensaje = bien.Eliminar(Integer.parseInt(cve_bienes));
                if (mensaje != null) {
                    out.println("<h1 class=\"navbar-brand\">" + mensaje + "</h1>");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error " + ex);
            }
        } catch (IOException ex2) {
            System.err.println("Error " + ex2);
        }
    }

}
