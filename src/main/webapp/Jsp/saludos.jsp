<%-- 
    Document   : saludos
    Created on : 06-oct-2020, 16:41:00
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalTime" %>
<!DOCTYPE html>
<html lang="sp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Css/saludo.css" />
        <title>Saludo Jsp</title>
    </head>
    <body>
        <%
            String tratamiento = null;
            tratamiento = request.getParameter("sexo").equals("hombre") ? "señor" : "señora";

            int hora = LocalTime.now().getHour();
            String saludo = null;

            if (hora >= 8 && hora < 13) {
                saludo = "os dias";
            } else if (hora >= 13 && hora < 19) {
                saludo = "as tardes";
            } else {
                saludo = "as noches";
            }
        %>         

        <div id="container2">
            <h1>Datos</h1>
            <h2>Buen<%= saludo%> <%= tratamiento%> <%=request.getParameter("nombre")%></h2>
        
        
        <p><a href="<%= request.getContextPath()%>">Menú inicial</p>
        </div>
    </body>
</html>
