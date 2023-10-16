
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%
    Cookie cookie = null;
    Boolean existe = false;

    Cookie[] cookies = request.getCookies();
    if (cookie != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("nombreCookie")) {
                cookie = cookies[i];
                break;
            }
        }
    }
  
    if (cookie == null) {
        cookie = new Cookie("nombreCookie", URLEncoder.encode("Francisco Javier Gómez García", "UTF-8"));
    } else {
        existe = Boolean.TRUE;
    }

    cookie.setMaxAge(3600); //Una hora en segundos
    response.addCookie(cookie);

    String persona = "";
    Integer version = cookie.getVersion();
    String dominio = cookie.getName();
    Integer contador = 1;
    
    if(request.getMethod().equals("POST")){
    
 
       
    }
    
    
    if (!existe) {
        persona = "Hola " + URLDecoder.decode(cookie.getValue(), "UTF-8");
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
        <h2><%=version%></h2>
        <h2><%=dominio%></h2>
         <h2><%=contador%></h2>
        <form method ="post ">
                <button class="button8" name="recargar">Recargar</button>
                
            </a>
        </form>
        <form method="post" action="../index.html">
            <input id="miBoton" type="submit" value="Menu">
        </form>
    </body>
</html>
