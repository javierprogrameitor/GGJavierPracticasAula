

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesiones en JSP</title>
    </head>
    <body>
        <h2>Carrito de la compra con Sesiones</h2>
        <form name="Formulario" action="EjemploSesiones.jsp">
            <p>
                <label>
                    <input type="checkbox" name="articulos" value="agua" >
                    Agua </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="leche" >
                    Leche </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pan" >
                    Pan </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="galletas" >
                    Galletas </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="carne" >
                    Carne </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pescado" >
                    Pescado </label>
                <br>
                <input type="submit" name="button" value="Enviar" >
                <br>
            </p>
        </form>

        <h2>Carro de la compra</h2>
        <ul>
            <%
                List<String> ListaElementos = (List<String>) session.getAttribute("misElementos");

                if (ListaElementos == null) {

                    ListaElementos = new ArrayList<String>();
                    session.setAttribute("misElementos", ListaElementos);
                }

                String[] elementos = request.getParameterValues("articulos");
                if (elementos != null) {
                    for (String elemTemp : elementos) {

                        ListaElementos.add(elemTemp);
                    }
                }
                //Para leer lo que tiene la ListaElemntos
                for (String elemTemp : ListaElementos) {
            %>
            <li><%= elemTemp%> </li>   
                <%
                    }
                %>
        </ul>      
    </body>
</html>