<%-- 
    Document   : menucookies
    Created on : 20-oct-2020, 17:09:44
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Css/contador.css">
        <title> Control de cookies</title>
    </head>
    <body>
        <form action="controlCookie.jsp" method="post">
            <div id="container">
                <div class="div1">
                    <h1>Control de cookies!</h1>

                    <table >
                        <tr>
                            <td colspan="2"><label for="nombre">Nombre de la cookie</label></td>
                            <td colspan="3"><input type="text" name="nombre" id="nombre"/></td>
                        </tr>

                        <tr>
                            <td colspan="2"><label for="valor">Valor de la cookie</label></td>
                            <td colspan="3"><input type="text" name="valor" id="valor"/></td>
                        </tr>
                        <tr>                    
                            <td colspan="4"></td>
                        </tr>

                        <tr>
                            <td><input type="submit" name="enviar" value="Crear"/></td>
                            <td><input type="submit" name="enviar" value="Visualizar"/></td>
                            <td><input type="submit" name="enviar" value="Modificar"/></td>
                            <td><input type="submit" name="enviar" value="Eliminar"/></td>
                            <td><input type="submit" name="enviar" value="Indice"/></td>
                        </tr>
                        <tr>                    
                            <td colspan="4"></td>
                        </tr>
                        <tr>
                            <%
                                String mensaje = (request.getParameter("mensaje") != null) ? request.getParameter("mensaje") : "";
                            %>
                            <td colspan="4"><%= mensaje%></td>
                        </tr>



                    </table>
                </div>
            </div>
        </form>
    </body>
</html>
