<%-- 
    Document   : controlCookie
    Created on : 21-oct-2020, 12:53:46
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    StringBuilder mensaje = new StringBuilder("menucookies.jsp?mensaje=");
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
                    cookie = new Cookie(nombre, request.getParameter("valor"));
                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);
                    mensaje.append("Cookie creada con nombre: ").append(nombre).append(" y contenido: ").append(request.getParameter("valor"));
                } else {
                    mensaje.append("Cookie ya creada");
                }
            }

            if (request.getParameter("enviar").equals("Visualizar")) {
                if (cookie != (null)) {
                    mensaje.append("Cookie  con nombre: ").append(nombre).append(" y su contenido: ").append(cookie.getValue());
                } else {
                    mensaje.append("La cookie: ").append(nombre).append(" no existe y no puede visualizar");
                }

            }
            if (request.getParameter("enviar").equals("Modificar")) {

                if (cookie != (null)) {
                    cookie.setValue(request.getParameter("valor"));
                    response.addCookie(cookie);

                    mensaje.append("Cookie  con nombre: ").append(nombre).append(", Se ha modificado");
                } else {
                    mensaje.append("La cookie: ").append(nombre).append(" no existe y no puede modificar");
                }

            }
            if (request.getParameter("enviar").equals("Eliminar")) {

                if (cookie != (null)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);

                    mensaje.append("Cookie  con nombre: ").append(nombre).append(", Se ha eliminado");
                } else {
                    mensaje.append("La cookie: ").append(nombre).append(" no existe y no puede eliminar");
                }

            }

        }
    } else {
        mensaje.replace(0, mensaje.length(), request.getContextPath());
    }
    response.sendRedirect(mensaje.toString());
%>
