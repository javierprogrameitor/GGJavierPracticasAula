<%-- 
    Document   : CalcularEdad
    Created on : 3 oct. 2023, 20:06:58
    Author     : javier
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcular Edad</title>
        <link rel="stylesheet" type="text/css" href="../CSS/jsp.css">
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("edad");
            int dia = 1;

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fechaNacimiento = formato.parse(fecha);

            Date fechaActual = new Date();

            // Crear instancias de Calendar para las fechas
            Calendar calendarioNacimiento = Calendar.getInstance();
            Calendar calendarioActual = Calendar.getInstance();

            // Establecer las fechas en los calendarios
            calendarioNacimiento.setTime(fechaNacimiento);
            calendarioActual.setTime(fechaActual);

            // Calcular la diferencia en años, meses y días
            int anios = calendarioActual.get(Calendar.YEAR) - calendarioNacimiento.get(Calendar.YEAR);
            int meses = calendarioActual.get(Calendar.MONTH) - calendarioNacimiento.get(Calendar.MONTH);
            int dias = calendarioActual.get(Calendar.DAY_OF_MONTH) - calendarioNacimiento.get(Calendar.DAY_OF_MONTH);

            // Ajustar los valores si los días o meses son negativos
            if (dias < 0) {
                meses--;
                calendarioActual.add(Calendar.MONTH, -1);
                dias += calendarioActual.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
            if (meses < 0) {
                anios--;
                meses += 12;
            }
            if (dias == 1) {
                dia = dias;
        %>
        <p>Hola:<%=nombre%> Tiene <%=dia%> dia de edad</p>
        <br>
        <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">
        </form>
        
        <%
        } else {
        %>
        <p>Hola:<%=nombre%> Tiene <%=dias%> dias de edad</p> 
        <br>
        <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">
        </form>
       
        <%
            }
        %>      
    </body>
</html>
