<%-- 
    Document   : pruebaBeansSalida
    Created on : 11 oct. 2023, 16:37:44
    Author     : javier
--%>

<%@page import="es.albarregas.beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida</title>
    </head>
    <body>
        <h1>Ejemplos de atributos</h1>
        <h2>De petición</h2>
        <%
            Persona persona = (Persona) session.getAttribute("personaSesion");

            if (persona != null) {

                String nombre = persona.getNombre();
                String apellidos = persona.getApellidos();

                /*
            session = request.getSession(true);
            if (session == null) {

                persona = (Persona) request.getAttribute("personaPeticion");
                 */
        %>

        <p>Nombre: <%= nombre %></p> 
        <p>Apellidos: <%= apellidos %></p>

        <%
        } else {
        %>
        <p>No se encontraron</p>
        <%
            }
        %>


    </body>
</html>
