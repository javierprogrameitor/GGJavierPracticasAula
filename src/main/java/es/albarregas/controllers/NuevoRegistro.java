package es.albarregas.controllers;

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
@WebServlet(name = "NuevoRegistro", urlPatterns = {"/NuevoRegistro"})
public class NuevoRegistro extends HttpServlet {

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
        processRequest(request, response);
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
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<title>Nuevo Registro</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' type='text/css' href=\'CSS/style.css\'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='apartado3'>");
                      
            boolean errores = true;
            //EStoy probando con tan solo estas pequeñas comprobaciones que todo empieza 
            // a funcionar, pero no soy capar de mostrar el contenido una vez que ha sido 
            // corregido en el servlet el formulario..
            
            String textoNombre = request.getParameter("nombre");
            String textoUsuario = request.getParameter("usuario");
            String textoPassword = request.getParameter("password");

            if (textoNombre.length() == 0) {
                out.println("El nombre es necesario");
                errores = false;
            }
            if (textoUsuario.length() == 0) {
                out.println("El usuario es necesario");
                errores = false;
            }
            if (textoPassword.length() == 0) {
                out.println("La contraseña es requerida");
                errores = false;
            }
            out.println("</div>");
       
            if (errores == false) {
                out.println("<div class='apartado1'>");
                out.println("<h2>NUEVO REGISTRO</h2>");
                out.println("<form action=\"NuevoRegistro\" method=\"post\">");
                out.println("<br>");
                out.println("<h2>Informacion Personal</h2>");
                out.println("<label>*Nombre</label>");
                out.println("<input class='usuario' type='text' name='usuario'>");
                out.println("<br>");
                out.println("<label>Apellidos</label>");
                out.println("<input class=\"apellidos\" type=\"text\" name=\"apellidos\" value = " + request.getParameter("apellidos") + ">");
                out.println("<br>");
                out.println("<label>Sexo</label>");
                out.println("<label><input type=\"radio\" name=\"sexo\" value = " + request.getParameter("hombre") + "\">Hombre</label>");
                out.println("<label><input type=\"radio\" name=\"sexo\" value = " + request.getParameter("mujer") + " \">Mujer</label>");
                out.println("<br>");
                out.println("<br>");
                out.println("<label>Fecha de nacimiento</label>");

                out.println("<select name=\"dia\" >");

                out.println("               <option value=\"1\">1</option>");
                out.println("               <option value=\"2\">2</option>");
                out.println("               <option value=\"3\">3</option>");
                out.println("               <option value=\"4\">4</option>");
                out.println("               <option value=\"5\">5</option>");
                out.println("               <option value=\"6\">6</option>");
                out.println("               <option value=\"7\">7</option>");
                out.println("               <option value=\"8\">8</option>");
                out.println("               <option value=\"9\">9</option>");
                out.println("               <option value=\"10\">10</option>");
                out.println("               <option value=\"11\">11</option>");
                out.println("               <option value=\"12\">12</option>");
                out.println("               <option value=\"14\">14</option>");
                out.println("               <option value=\"15\">15</option>");
                out.println("               <option value=\"16\">16</option>");
                out.println("               <option value=\"17\">17</option>");
                out.println("               <option value=\"18\">18</option>");
                out.println("               <option value=\"19\">19</option>");
                out.println("               <option value=\"20\">20</option>");
                out.println("               <option value=\"21\">21</option>");
                out.println("               <option value=\"22\">22</option>");
                out.println("               <option value=\"23\">23</option>");
                out.println("               <option value=\"24\">24</option>");
                out.println("               <option value=\"25\">25</option>");
                out.println("               <option value=\"26\">26</option>");
                out.println("               <option value=\"27\">27</option>");
                out.println("               <option value=\"28\">28</option>");
                out.println("               <option value=\"29\">29</option>");
                out.println("               <option value=\"30\">30</option>");
                out.println("               <option value=\"31\">31</option>");

                out.println("</select>");
                out.println("<select name=\"mes\" >");

                out.println("               <option value=\"1\">1</option>");
                out.println("               <option value=\"2\">2</option>");
                out.println("               <option value=\"3\">3</option>");
                out.println("               <option value=\"4\">4</option>");
                out.println("               <option value=\"5\">5</option>");
                out.println("               <option value=\"6\">6</option>");
                out.println("               <option value=\"7\">7</option>");
                out.println("               <option value=\"8\">8</option>");
                out.println("               <option value=\"9\">9</option>");
                out.println("               <option value=\"10\">10</option>");
                out.println("               <option value=\"11\">11</option>");
                out.println("               <option value=\"12\">12</option>");

                out.println("</select>");
                out.println("<select name=\"año\" >");
                out.println("               <option value=\"1991\">1991</option>");
                out.println("               <option value=\"1992\">1992</option>");
                out.println("               <option value=\"1993\">1993</option>");
                out.println("               <option value=\"1994\">1994</option>");
                out.println("               <option value=\"1995\">1995</option>");
                out.println("               <option value=\"1996\">1996</option>");
                out.println("               <option value=\"1997\">1997</option>");
                out.println("               <option value=\"1098\">1998</option>");
                out.println("               <option value=\"1999\">1999</option>");
                out.println("               <option value=\"2000\">2000</option>");
                out.println("               <option value=\"2001\">2001</option>");
                out.println("               <option value=\"2002\">2002</option>");
                out.println("               <option value=\"2003\">2003</option>");
                out.println("               <option value=\"2004\">2004</option>");
                out.println("               <option value=\"2005\">2005</option>");
                out.println("               <option value=\"2006\">2006</option>");
                out.println("               <option value=\"2007\">2007</option>");
                out.println("               <option value=\"2008\">2008</option>");
                out.println("               <option value=\"2009\">2009</option>");
                out.println("               <option value=\"2010\">2010</option>");
                out.println("               <option value=\"2011\">2011</option>");
                out.println("               <option value=\"2013\">2013</option>");
                out.println("               <option value=\"2014\">2014</option>");
                out.println("               <option value=\"2015\">2015</option>");
                out.println("</select>");

                out.println("    <h2>Datos de Acceso</h2>");
                out.println("   <label>*Usuario</label>");
                out.println("<input class=\"usuario\" type=\"text\" name=\"usuario\" value = " + request.getParameter("usuario") + ">");
                out.println("<br>");
                out.println("   <label>*Contraseña</label>");
                out.println("<input class=\"pasword\" type=\"text\" name=\"pasword\" value = " + request.getParameter("pasword") + ">");
                out.println("<br>");
                out.println("<h2>Informacion general</h2>");
                out.println("  <label>Preferencias:</label>");
                out.println("<input type=\"checkbox\" name=\"gustos\" value=\"deportes\">Deportes");
                out.println("<br>");
                out.println("<input type=\"checkbox\" name=\"gustos\" value=\"deportes\">Lectura");
                out.println("<br>");
                out.println("<input type=\"checkbox\" name=\"gustos\" value=\"deportes\">Lectura");
                out.println("<br>");
                out.println("<input type=\"checkbox\" name=\"gustos\" value=\"deportes\">Lectura");
                out.println("<br>");
                out.println("<input type=\"submit\" name=\"btnEnviar\" value=\"Enviar\">");
                out.println("<input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\">");
                out.println("<br>");
                out.println("</form>");
                out.println("</div>");

            } else {

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

                        out.println("<div class='apartado2'>");
                        out.println("<ul>");
                        out.println("<li>");
                        out.println(nombreCampo + " : ");
                        for (String valor : valoresCampo) {
                            out.print(valor + " ");
                        }
                        out.println("</li>");
                        out.println("</ul>");
                        out.println("</div>");
                    }
                }
                out.println("<p><a href=\".\">Men&uacute; Inicial</a></p>");

            }
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
