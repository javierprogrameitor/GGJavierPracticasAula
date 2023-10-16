<%-- 
    Document   : Cookies
    Created on : 9 oct. 2023, 20:03:42
    Author     : javier
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%
    Cookie cookie = null;
    Boolean existe = false;
    int contador = 0;

    Cookie[] cookies = request.getCookies();
    if (cookie != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("nombreCookie")) {
                cookie = cookies[i];
                //  contador = Integer.parseInt(cookie.getValue());
                break;
            }
        }

        for (Cookie c : cookies) {
            if (c.getName().equals("contador")) {
                contador = Integer.parseInt(c.getValue());
            }
        }
    }

    contador++;

    if (cookie == null) {

        cookie = new Cookie("nombreCookie", URLEncoder.encode("Francisco Javier Gómez García", "UTF-8"));
        cookie = new Cookie("contador", Integer.toString(contador));
    } else {
        existe = Boolean.TRUE;
    }

    cookie.setMaxAge(3600); //Una hora en segundos
    response.addCookie(cookie);
    
    String persona = "";
    String cont = "";

    if (!existe) {
        persona = "Hola " + URLDecoder.decode(cookie.getValue(), "UTF-8");
        cont = "Contador: " +  URLDecoder.decode(cookie.getValue(), "UTF-8");
    } else {
        persona = "Todavia no tenemos datos tuyos";
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=persona%></h1>
        <h1><%=cont%></h1>
        <form>
            <a href="Cookies.jsp">
                <button class="button8">Recargar</button>
            </a>
        </form>
        <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">

        </form>
    </body>
</html>
