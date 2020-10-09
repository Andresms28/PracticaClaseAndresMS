<%-- 
    Document   : calculadora.jsp
    Created on : 08-oct-2020, 23:37:36
    Author     : andre
--%>


<%@page import="java.util.Enumeration"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Month"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../Css/calculadora.css">
        <title>Calculadora</title>
    </head>

    <body>
        <div>
            <form action="calculadora.jsp" method="post">
                <%
                    int hora = LocalTime.now().getHour();
                    int min = LocalTime.now().getMinute();
                    int sec = LocalTime.now().getSecond();

                    Calendar fechaActual = Calendar.getInstance();
                    int diaMes = fechaActual.get(Calendar.DAY_OF_MONTH);
                    int anio = fechaActual.get(Calendar.YEAR);

                    Month mes = LocalDate.now().getMonth();
                    DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
                    // Obtiener nombre del mes
                    String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
                    String nombreDiaSemana = diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

                    String solucion = "";

                    try {

                        int primero = Integer.parseInt(request.getParameter("primero"));
                        int segundo = Integer.parseInt(request.getParameter("segundo"));
                        int total = 0;
                        if (request.getParameter("operar").equals("suma")) {
                            total = primero + segundo;
                            solucion = "<p >La solucion de " + primero + " + " + segundo + " es " + total + " </p>";
                        }
                        if (request.getParameter("operar").equals("restar")) {
                            total = primero - segundo;
                            solucion = "<p >La solucion de " + primero + " - " + segundo + " es " + total + " </p>";
                        }
                        if (request.getParameter("operar").equals("dividir")) {
                            if (segundo == 0) {
                                solucion = "<p class='error'>Error, no se puede dividir por cero</p>";
                            } else {
                                total = primero / segundo;
                                solucion = "<p >La solucion de " + primero + " / " + segundo + " es " + total + " </p>";
                            }

                        }
                        if (request.getParameter("operar").equals("multiplicar")) {
                            total=primero*segundo;
                            solucion = "<p >La solucion de " + primero + " * " + segundo + " es " + total + " </p>";
                            }
                        
                        
                    } catch (Exception e) {
                       if(request.getMethod().equals("POST")){
                           solucion = "<p class='error'>Datos de entrada no validos</p>";
                       }
                    }


                %>

                <table>
                    <tr>
                        <td colspan="3">
                            <h1><%= hora%> : <%= min%> : <%= sec%></h1>
                            <h1><%= nombreDiaSemana%> <%= diaMes%> de <%= nombreMes%> de <%= anio%></h1>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" >
                            <h2><%= solucion%></h2> 
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="4">
                            <p><input type="number" name="primero" placeholder="Coloque Primer Digito" />
                                <input type="number" name="segundo" placeholder="Coloque Segundo Digito" /></p>

                        </td>

                        <td colspan="2" rowspan="4" class="radio">
                            <p>Suma<input type="radio" checked="checked" name="operar" value="suma" /></p>
                            <p>Resta<input type="radio" name="operar" value="resta" /></p>
                            <p>Dividir<input type="radio" name="operar" value="dividir" /></p>
                            <p>Multiplicar<input type="radio" name="operar" value="multiplicar" /></p>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Calcular" /><input type="reset" value="Limpiar"><input
                                type="button" onclick="" value="Menú" /></td>

                    </tr>
                </table>
            </form>
        </div>
    </body>

</html>
