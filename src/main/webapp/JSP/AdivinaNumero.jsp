<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../CSS/jsp.css">
    </head>
    <%!
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        int contador = 0;
        String mensaje = "";
    %>
    <body>
        <h1>Adivinar un número del 1 al 100</h1>
        <%
            String guessStr = request.getParameter("guess");
            int numero = (guessStr != null && !guessStr.isEmpty()) ? Integer.parseInt(guessStr) : -1;
            if (numero != -1) {
                do {
                    if (numero > numeroSecreto) {
                        mensaje = "Intenta con un número más pequeño.";
                        contador++;
                        break;
                    } else if (numero < numeroSecreto) {
                        mensaje = "Intenta con un número más grande.";
                        contador++;
                        break;
                    } else if (numero == numeroSecreto) {
                        mensaje = "¡Felicidades! Has adivinado el número en " + contador + " veces.";
                        break;
                    }
                } while (numero != numeroSecreto);
            }
        %>
        <form action="AdivinaNumero.jsp" method="post">
            <p>Intenta adivinar un número entre 1 y 100:</p>
            <input type="text" name="guess" />
            <input type="submit" value="Adivinar" />
        </form>
        <p><%= mensaje%></p>
        <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">
        </form>
    </body>
</html>