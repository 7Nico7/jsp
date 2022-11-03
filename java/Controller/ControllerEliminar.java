package Controller;

import Model.EliminarBien;
import Model.EliminarMantenimiento;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "ControllerEliminar", urlPatterns = {"/ControllerEliminar"})
public class ControllerEliminar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        out = response.getWriter();
        String eliminarEditar = request.getParameter("Eliminar");

        if (!StringUtils.isBlank(eliminarEditar)) {
            switch (eliminarEditar) {
                case "eliminarBien":
                    eliminarBien(request, response);
                    break;
                case "mantenimiento":
                    eliminarMantenimiento(request, response);
                    break;
                default:
                    out.println("desconocido");
            }
        } else {
            out.println("nulo");
        }
    }

    private void eliminarBien(HttpServletRequest request, HttpServletResponse response) {
        try {
            String cve_bienes = request.getParameter("cve_bienes");
            EliminarBien bien = new EliminarBien();
            PrintWriter out;
            out = response.getWriter();

            try {
                String mensaje = null;
                if (!StringUtils.isBlank(cve_bienes)) {
                    if (Integer.parseInt(cve_bienes) > 0) {
                        mensaje = bien.Eliminar(Integer.parseInt(cve_bienes));
                        
                    } else {
                        try {
                            request.setAttribute("error", "Error: El ID no es Correcto");
                            request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
                        } catch (ServletException ex) {
                            Logger.getLogger(ControllerEliminar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    request.setAttribute("error", "Error: El ID Es NULO ");
                    try {
                        request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
                    } catch (ServletException ex) {
                        Logger.getLogger(ControllerEliminar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (mensaje != null) {
                    out.print(mensaje);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error " + ex);
            }
        } catch (IOException ex2) {
            System.err.println("Error " + ex2);
        }
    }

    private void eliminarMantenimiento(HttpServletRequest request, HttpServletResponse response) {
        try {
            String cve_mantenimiento = request.getParameter("cve_mantenimiento");
            EliminarMantenimiento mantenimiento = new EliminarMantenimiento();
            PrintWriter out;
            out = response.getWriter();

            try {
                String mensaje = null;
                if (!StringUtils.isBlank(cve_mantenimiento)) {
                    if (Integer.parseInt(cve_mantenimiento) > 0) {
                        mensaje = mantenimiento.Eliminar(Integer.parseInt(cve_mantenimiento));
                    } else {
                        try {
                            request.setAttribute("error", "Error: El ID no es Correcto");
                            request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
                        } catch (ServletException ex) {
                            Logger.getLogger(ControllerEliminar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    request.setAttribute("error", "Error: El ID Es NULO ");
                    try {
                        request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
                    } catch (ServletException ex) {
                        Logger.getLogger(ControllerEliminar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (mensaje != null) {
                    out.print(mensaje);
                    System.err.println("MNSAJ : " + mensaje);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error " + ex);
            }
        } catch (IOException ex2) {
            System.err.println("Error " + ex2);
        }
    }

}
