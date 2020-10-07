/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emilio
 */
@WebServlet(name = "FormularioValidado", urlPatterns = {"/FormularioValidado"})
public class FormularioValidado extends HttpServlet {

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
        crearHtml(request, response);
        
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
    }// </editor-fold>
    
    public void crearHtml(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Index Desde Servlet</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"Css/styleFormSimple.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Fomulario Simple</h1>\n" +
"        <form method=\"post\" action=\"FormularioValidado\" >\n" +
"            <div>\n" +
"                <fieldset>\n" +
"                    <legend>Datos Usuario</legend>\n" +
"                    <p>Usuario: <input type=\"text\" name=\"Usuario\" ></p>\n" +
"                    <p>Contraseña : <input type=\"password\" name=\"Contrasena\" ></p>\n" +
"                    <p>Sexo:\n" +
"                        <input type=\"radio\" name=\"Sexo\" value=\"Hombre\"> Hombre\n" +
"                        <input type=\"radio\" name=\"Sexo\" value=\"Mujer\"> Mujer\n" +
"                    </p>\n" +
"                    <p>Edad : <input type=\"number\" name=\"Edad\" ></p>\n" +
"\n" +
"\n" +
"                </fieldset>\n" +
"                <fieldset>\n" +
"                    <legend>Datos complementarios:</legend>\n" +
"                    <p>Estado civil\n" +
"                        <input type=\"radio\" name=\"Estado Civil\" value=\"Soltero\"> Soltero\n" +
"                        <input type=\"radio\" name=\"Estado Civil\" value=\"Casado\"> Casado\n" +
"                        <input type=\"radio\" name=\"Estado Civil\" value=\"Viudo\"> Viudo\n" +
"                        <input type=\"radio\" name=\"Estado Civil\" value=\"Divorciado\"> Divorciado\n" +
"                    </p>\n" +
"                    <p>Aficion/es (press Ctrl seleccionar varios:</p>\n" +
"                    <select name=\"Aficiones\" multiple=\"multiple\" size=\"6\">\n" +
"                        <option>Deporte </option>\n" +
"                        <option>Música</option>\n" +
"                        <option>Viajes</option>\n" +
"                        <option>Informática</option>\n" +
"                        <option>Tiendas</option>\n" +
"                        <option>Juegos</option>\n" +
"                    </select>\n" +
"                    <p>Si deseas mandar simplemente una opinion o comentario escribelo aquí.<br>\n" +
"                        <textarea name=\"comentario\" rows=\"2\" cols=\"50\" > </textarea>\n" +
"                    </p>\n" +
"\n" +
"                </fieldset>\n" +
"                <fieldset>\n" +
"                    <legend>Medios Tecnologicos:</legend>\n" +
"                    <p>Conexion a internet:\n" +
"                        <input type=\"radio\" name=\"Conexion a internet\" value=\"Si\"> Si\n" +
"                        <input type=\"radio\" name=\"Conexion a internet\" value=\"No\"> No                        \n" +
"                    </p>\n" +
"                    \n" +
"                    <p>Sistema operativo:</p>\n" +
"                    <select name=\"Sistema Operativo\"  size=\"4\">\n" +
"                        <option>Linux </option>\n" +
"                        <option>Windows</option>\n" +
"                        <option>Macintosh</option>\n" +
"                        <option>Solaris </option>                        \n" +
"                    </select>               \n" +
"\n" +
"                </fieldset>\n" +
"\n" +
"            </div>\n" +
"            <p class=\"submit\">\n" +
"                <input type=\"submit\" value=\"Enviar\">\n" +
"                <input type=\"reset\" value=\"Borrar\">\n" +
"            </p>\n" +
"        </form>\n" +
"\n" +
"    </body>\n" +
"</html>\n" +
"");
            
        }
    }

}
