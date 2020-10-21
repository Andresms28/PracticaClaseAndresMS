<%-- 
    Document   : controlCookie
    Created on : 21-oct-2020, 12:53:46
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    StringBuilder mensaje = new StringBuilder("menuCookie.jsp?mensaje=");
    System.out.println("El valor del boton es " + request.getParameter("enviar") + " y el nombre es " + request.getParameter("name"));

    if (!request.getParameter("enviar").equals("Indice")) {

        if (request.getParameter("enviar").length() != 0) {

            String nombre = request.getParameter("nombre");
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {

                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(nombre)) {
                        cookie = cookies[i];
                        break;
                    }
                }
            }

            if (request.getParameter("enviar").equals("Crear")) {

                if (cookie == (null)) {
                    cookie= new Cookie(nombre, request.getParameter("valor"));
                    cookie.setMaxAge(60*60);
                    response.addCookie(cookie);
                    mensaje.append("Cookie creada con nombre: ").append(nombre).append(" y contenido: ").append(request.getParameter("valor"));
                }else{
                    mensaje.append("Cookie ya creada"); 
                }
            }
            
            
            
        }
    }
%>
