package es.albarregas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javier
 */
@WebServlet(name = "FormularioComplejo", urlPatterns = {"/FormularioComplejo"})
public class FormularioComplejo extends HttpServlet {

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
            out.println("<title>Registro</title>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioComplejo</title>");

            out.println("<link rel='stylesheet' type='text/css' href=\'CSS/style.css\'");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> FORMULARIOS </h1>");
            out.println("<h2> Datos introducidos en el formulario </h2>");
            out.println("<ul>");
            /*
            *
           // Este métdo es mucho mas sencillo y legible, pero no lo imprime igual
           //----------------------------------------------------------------------
            Map<String, String[]> form = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : form.entrySet()) {
                String key = entry.getKey();
                String[] valor = entry.getValue();
                if (!key.startsWith("btn")) {
                    for (String list : valor) {
                            out.println("<li>" + key + " : " + list + "</li>");
                    }
                }
            }
            *
             */
            Map<String, String[]> form = request.getParameterMap();

            Enumeration<String> nombre = request.getAttributeNames();

            while (nombre.hasMoreElements()) {
                String key = nombre.nextElement();
                String[] values = request.getParameterValues(key);
                form.put(key, values);

            }
            for (Map.Entry<String, String[]> entry : form.entrySet()) {
                String nombreCampo = entry.getKey();
                String[] valoresCampo = entry.getValue();

                if (!nombreCampo.startsWith("btn")) {

                    out.println("<li>");
                    out.println(nombreCampo + " : ");
                    for (String valor : valoresCampo) {
                        out.print(valor + " ");
                    }
                    out.println("</li>");
                }
            }

            out.println("<ul>");
            out.println("<p><a href=\".\">Men&uacute; Inicial</a></p>");
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
