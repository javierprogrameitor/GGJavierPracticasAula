package es.albarregas;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Iterator;
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
    private final String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
        "Noviembre", "Diciembre"
    };
    private final String[] error = {"El nombre es obligatorio", "El usuario es obligatorio", "La contraseña es obligatoria", "Fecha de nacimiento incorrecta"};

    private Enumeration<String> parametros;

    private final String[] pf = {"Deportes", "Lectura", "Cine", "Viajes"};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"es\">");
        out.println("<head>");
        out.println("<title>Nuevo Registro</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\'CSS/style.css\'>");
        out.println("</head>");
        out.println("<body>");

        // Buscamos el error en los datos de entrada 
        boolean hayError = false; // variable que me indicará si existe error
        int tipoError[] = new int[4];  // Array donde se almacenan los diferentes errores
        for (int i = 0; i < tipoError.length; i++) {
            tipoError[i] = -1;
        }

        parametros = request.getParameterNames();
        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();
            if (nombre.equals("Nombre") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[0] = 0;
            } else if (nombre.equals("Usuario") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[1] = 1;
            } else if (nombre.equals("Password") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[2] = 2;
            } else if (nombre.equals("dia")) {
                int diaEnt = Integer.parseInt(request.getParameter("dia"));
                int mesEnt = Integer.parseInt(request.getParameter("mes"));
                int yearEnt = Integer.parseInt(request.getParameter("anio"));
                try {
                    LocalDate fecha = LocalDate.of(yearEnt, mesEnt, diaEnt);

                } catch (DateTimeException e) {
                    hayError = true;
                    tipoError[3] = 3;
                }
            }

        }

        // Comprobamos la ausencia de errores
        if (!hayError) { // Escribimos lod datos del registro
            int camposFecha = 0;
            out.println("<div id='contenido'>");
            out.println("<h2>Registro satisfactorio</h2>");
            StringBuilder fecha = new StringBuilder("Fecha de nacimiento: <strong>");
            Map<String, String[]> mapa = request.getParameterMap();
            // Recorriendo el Map con Iterator

            Iterator<Map.Entry<String, String[]>> entries = mapa.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String[]> entrada = entries.next();
                if (!entrada.getKey().startsWith("env")) {

                    if (entrada.getKey().equals("dia") || entrada.getKey().equals("mes") || entrada.getKey().equals("anio")) {
                        camposFecha++;
                        if (entrada.getKey().equals("mes")) {
                            for (String valor : entrada.getValue()) {
                                fecha.append(meses[Integer.parseInt(valor) - 1]);
                            }

                        } else {

                            for (String valor : entrada.getValue()) {
                                fecha.append(valor);
                            }
                        }
                        fecha.append(" de ");
                    }

                    if (camposFecha < 1 || camposFecha > 3) {
                        out.println("<p>" + entrada.getKey() + ": <strong>");
                        StringBuilder sb = new StringBuilder();
                        for (String valor : entrada.getValue()) {
                            sb.append(valor).append(", ");

                        }
                        out.println(sb.replace(sb.length() - 2, sb.length(), "</strong>") + "</p>");
                    } else {
                        if (camposFecha == 3) {
                            out.println("<p>" + fecha.replace(fecha.length() - 4, fecha.length(), "</strong>") + "</p>");
                            camposFecha++;
                        }
                    }
                }

            }
            out.println("<br />");
            out.println("<p><a href='" + request.getContextPath() + "'>Men&uacute; inicial</a></p>");
            out.println("</div>");

        } else {
            out.println("<br />");
            out.println("<p><a href='" + request.getContextPath() + "'>Men&uacute; inicial</a></p>");
            out.println("</div>");
            out.println("<div class=\"apartado3\">");
            out.println("<div class=\"apartado1\">");
            out.println("<h2>NUEVO REGISTRO</h2>");
            out.println("<form  method=\"post\" action= \"" + request.getContextPath() + "/NuevoRegistro\">");
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
            for (int i = 0; i < 31; i++) {
                out.println("<option value=\"" + i + "\">" + i + "</option>");
            }
            out.println("</select>");
            out.println("<select name=\"mes\" >");
            for (int i = 0; i < 12; i++) {
                out.println("<option value=\"" + i + "\">" + i + "</option>");
            }
            out.println("</select>");
            out.println("<select name=\"año\" >");
            for (int i = 1991; i < 2015; i++) {
                out.println("<option value=\"" + i + "\">" + 1 + "</option>");
            }
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
        }
    }
}

/*
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
