package Controller;

import Model.GetBienes;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "ControllerTablas", urlPatterns = {"/ControllerTablas"})
public class ControllerTablas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        String modulo = request.getParameter("Modulo");
        String tabla = request.getParameter("tabla");
        switch (modulo) {
            case "Bienes":
                Tabla(response, tabla);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    GetBienes bienes = new GetBienes();

    /*Metodo para los datos de la tabla en json*/
    private void Tabla(HttpServletResponse response, String tabla) {
        System.err.println("TAABLA : " + tabla);
        String data = bienes.getBienes(tabla);
        PrintWriter out;
        try {
            out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(data);
            out.flush();
        } catch (IOException ex) {
            System.err.println("ERROR EN ControllerTablas Bienes: " + ex);
        }
    }
}
