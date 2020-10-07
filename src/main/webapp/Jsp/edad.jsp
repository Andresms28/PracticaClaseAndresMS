<%-- 
    Document   : saludos
    Created on : 06-oct-2020, 16:41:00
    Author     : andre
--%>

<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalTime" %>
<!DOCTYPE html>
<html lang="sp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Css/saludo.css" />
        <title>Edad Jsp</title>
    </head>
    <body>
        <%

            String nombre = request.getParameter("nombre")+" ";
            String anos="";
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fnac=LocalDate.parse(request.getParameter("edad"),formato);
            LocalDate ahora=LocalDate.now();
            
            Period diferencia = Period.between(fnac,ahora);//diferencia entre fecha dada y fecha actual
            
            if(diferencia.getYears()<=0 && diferencia.getMonths()<=0 && diferencia.getDays()<=0){
                anos="No ha nacido aun";
            }else{
                anos="tienes ";
                if(diferencia.getYears()>0){
                    anos+=diferencia.getYears()+" años ";
                }
                if(diferencia.getMonths()>0){
                    anos+=diferencia.getMonths()+" meses ";
                }
                if(diferencia.getDays()>0){
                    anos+=diferencia.getDays()+" dias ";
                }
            }
        %>         

        <div id="container2">
            <h1>Datos</h1>
            <h2><%= nombre %> <%= anos%> </h2>


            <p><a href="<%= request.getContextPath()%>">Menú inicial</p>
        </div>
    </body>
</html>
