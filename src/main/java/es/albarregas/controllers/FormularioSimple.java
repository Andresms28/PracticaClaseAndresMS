/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emilio
 */
@WebServlet(name = "FormularioSimple", urlPatterns = {"/FormularioSimple"})
public class FormularioSimple extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Css/styleFormSimpleServlet.css\">");
        out.println("<title>Servlet Fomulario Simple</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Datos introducidos en el formulario</h1>");
        out.println("<div id='contenido'>");
        out.println("<div class='elementos'>");

        Enumeration<String> parametros = request.getParameterNames();

        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();
            if (!nombre.startsWith("env")) {
                if (nombre.equals("Aficiones")) {
                    String[] items = request.getParameterValues("Aficiones");
                    out.print("<strong>" + nombre + ": </strong>");

                    for (int i = 0; i < items.length; i++) {
                        if (items[i].equals("MÃºsica")) {
                            out.println("Música ");
                        } else {
                            if (items[i].equals("InformÃ¡tica")) {
                                out.println("Informática ");
                            } else {
                                out.print(items[i] + " ");
                            }
                        }

                    }
                    out.print("<br/>");
                } else {
                    out.println("<strong>" + nombre + ": </strong>" + request.getParameter(nombre) + "<br/>");
                }

            }
        }

        out.println("</div>");
        out.println("</div>");
        out.print("<p class='indice'><a href='" + request.getContextPath() + "'>Men&uacute; inicial</a></p>");
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
