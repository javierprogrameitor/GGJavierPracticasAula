<%-- 
    Document   : pruebaBeans
    Created on : 11 oct. 2023, 16:20:57
    Author     : javier
--%>
<%@page import="es.albarregas.beans.Persona"%>

<%
    Persona persona = new Persona();    
   // Persona persona1 = new Persona("Pedro","Prieto",Byte.parseByte("0"),2000.0);  
    persona.setNombre("Juan");
    persona.setApellidos("Macias");
    persona.setNumHijos(Byte.parseByte("2"));
    persona.setSalario(1200.34);
    
    
  // session.setAttribute("personaSesion", persona);
    
    // request.setAttribute("personaPeticion", persona);
    
      response.sendRedirect("pruebaBeansSalida.jsp");

%>
