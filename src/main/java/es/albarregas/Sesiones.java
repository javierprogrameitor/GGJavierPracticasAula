package es.albarregas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javier
 */
@WebServlet(name = "Sesiones", urlPatterns = {"/Sesiones"})
public class Sesiones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sesiones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Has accedido sin pasar por el formulario <a href=\"" + request.getContextPath() + "\">Men&uacute;</a></h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            // Obtener la sesión actual o crear una nueva si no existe
            HttpSession session = request.getSession(true);

            // Obtener el contador de sesiones de la sesión actual
            Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");

            // Si el contador no existe en la sesión, inicializarlo a 1
            if (sessionCounter == null) {
                sessionCounter = 1;
            } else {
                // Si el contador existe, incrementarlo en 1
                sessionCounter++;
            }

            // Establecer el contador actualizado en la sesión
            session.setAttribute("sessionCounter", sessionCounter);

            // Mostrar el contador de sesiones en la respuesta
            //  response.setContentType("text/html");
            // response.getWriter().println("<h1>Contador de sesiones: " + sessionCounter + "</h1>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HTTP</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form  method=\"post\" action= \"" + request.getContextPath() + "/Sesiones\">");

            out.println("<h1>Contador de sesiones: " + sessionCounter + "</h1>");
            /*
              <label for="checkbox">¿Aceptas los términos y condiciones?
                    <input id="micheckbox" type="checkbox" name="micheckbox" required>
                </label>
             */

            out.println("<input type=\"checkbox\" name=\"check\">");
            out.println("<h3>Check</h3>");
            out.println("<br>");
            out.println("<input type=\"submit\" name=\"btnEnviar\" value=\"Enviar\">");
            out.println("<p><a href=\".\">Men&uacute;</a></p>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
