<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" type="text/css" href="../CSS/jsp.css">
    </head>
    <body>       


        <%            String nombre = request.getParameter("nombre");

            String sexo = "";

            if (request.getParameter("sexo").equals("hombre")) {
                sexo = "Señora";
            } else {
                sexo = "Señor";
            }

        %>
        <p>Hola:<%=sexo%> <%=nombre%> </p>
          <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">
        </form>
    </body>



</html>
