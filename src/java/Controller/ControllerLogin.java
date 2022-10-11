package Controller;

import Model.Autentica;
import Model.RegistrarUsuario;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.out;

import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class ControllerLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("ingresar")) {
            verificar(request, response);
        } else if (accion.equalsIgnoreCase("salir")) {
            cerrarSession(request, response);
        } else if (accion.equalsIgnoreCase("registrar")) {
            registrar(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion;
        Autentica consulta;
        Usuarios usuario;
        usuario = this.obtenerUsuario(request);
        consulta = new Autentica();
        try {
            //Se verifica si el correo y contraseña existen
            usuario = consulta.Auntenticar(usuario);
        } catch (Exception ex) {
            System.err.println("ERROR en usuario = consulta.postAuntentica");
        }
        //Se valida el resultado de la Autenticacion
        if (usuario != null) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            //Se envia un mensaje
            request.setAttribute("msje", "Bienvenido al Sistema");
            try {
                //Se redirecciona a la pagina Principal
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //Si el Usuario no coincide con el de la Bd envia un Mensaje de Error
            String linea1 = "<div class=\"alert alert-danger\" role=\"alert\">";
            String linea2 = "Correo o Contraseñas incorrectos!</div>";
            request.setAttribute("msje", linea1 + "\n" + linea2);
            try {
                //Recarga el Index
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Obtiene los datos del Logeo
    private Usuarios obtenerUsuario(HttpServletRequest request) {
        Usuarios u = new Usuarios();
        u.setCorreo(request.getParameter("correo"));
        u.setContra(request.getParameter("contra"));

        return u;
    }
    
    private void cerrarSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion;
        sesion = request.getSession();
        //Se cierra la sesion
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        try {
            //Redirecciona al Login
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.err.println("ERROR en cerrarSession");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        RegistrarUsuario rg = new RegistrarUsuario();
        //Obtiene los datos del Formulario
        Usuarios datos = obtenerDatos(request);
        String mensaje = "";
        PrintWriter out;
        try {
            out = response.getWriter();
            try {
                //Se envia el Usuario y retorna el Mensaje si registro el Usuario
                mensaje = rg.registrarUsuario(datos);
                //Se envia un Mensaje del Registro
                out.println("<h1 class=\"navbar-brand\">" + mensaje + "</h1>");
            } catch (Exception ex) {
                Logger.getLogger(ControllerBienes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        //Retorna el Usuario para el Registro
    private Usuarios obtenerDatos(HttpServletRequest request) {
        Usuarios u = new Usuarios();
        String nombre = (String) request.getParameter("nombre");
        String correo = (String) request.getParameter("correo");
        String contra = (String) request.getParameter("contra");

        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setContra(contra);
        return u;
    }

}
