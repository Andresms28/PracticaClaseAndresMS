<%-- 
    Document   : contador
    Created on : 14-oct-2020, 20:24:11
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Css/contador.css">
        <title>Contador jsp</title>
    </head>
    <%
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("CONTADOR")) {
                    cookie = cookies[i];
                    break;
                }
            }
        }
        if (cookie == null) {
            cookie = new Cookie("CONTADOR", "0");
        } else if (request.getParameter("eliminar") != null) {
            cookie.setValue("0");
        }
        int contador = Integer.parseInt(cookie.getValue());
        cookie.setValue(Integer.toString(contador + 1));
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

    %>
    <body>
        <div id="container">
            <div class="div1">
            <h2>Has visitado este sitio web <%= cookie.getValue()%> <%= (cookie.getValue().equals("1")) ? "vez" : "veces"%></h2>
            <%
                if (cookie.getValue().equals("1")) {
            %>
            <h3>Informacion de la cookie </h3>
            <p>Caducidad: <%= (cookie.getMaxAge()!= 1)?cookie.getMaxAge()+" segundos":"Hasta que se cierre el Navegador" %></p>
            <p>Nombre: <%= cookie.getName() %></p>
            <p>Segura: <%= cookie.getSecure()%></p>
            <p>Version: <%= cookie.getValue()%></p>
            <%
                }
            %>
            </div>
            <div>
            <form action="contador.jsp" method="post">
                <span class="botones"><input type="submit" value="Recargar" name="recarga" /></span>
                <span class="botones"><input type="submit" value="Eliminar" name="eliminar" /></span>
                <span class="botones"><input type="submit" value="Indice" name="indice" value="Indice" onclick="location.href='<%= request.getContextPath() %>';" /></span>
            </form>
            </div>
        </div>
    </body>
</html>
