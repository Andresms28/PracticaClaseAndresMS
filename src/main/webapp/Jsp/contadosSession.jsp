<%-- 
    Document   : contadosSession
    Created on : 21-oct-2020, 20:45:48
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
    int contador = 1;

    if (request.getParameter("eliminar") != (null)) {
        session.removeAttribute("contaSesion");
    } else {
        if (sesion.getAttribute("contaSesion") != (null)) {
            contador = ((Integer) sesion.getAttribute("contaSesion"));

        }
    }
    sesion.setAttribute("contaSesion", new Integer(contador + 1));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Css/contador.css">

        <title>Contador de Vistas</title>
    </head>
    <body>
        <div id="container">
            <div id="div1">
                <form action="contadosSession.jsp" method="post">
                    <h2>Has visitado la p&aacute;gina <%= contador%> veces</h2>    
                    <p><input type="checkbox" name="eliminar" value="true"/>&nbsp;Eliminar sesi&oacute;n</p>
                    <p>
                        <span class="botones"><input type="submit" value="Recargar" name="recargar"/></span>
                    </p>
                </form>
            </div>
        </div>

    </body>
</html>
