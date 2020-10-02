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
 * @author andre
 */
@WebServlet(name = "SegundoValidar", urlPatterns = {"/SegundoValidar"})
public class SegundoValidar extends HttpServlet {

    private String vnom, vcontr;
    private boolean adv = true;

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

        if (!validar(request)) {

            if (adv == true) {
                mostrarAdver(request, response);
            } else {
                pintarHtml(request, response);
            }

        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Css/styleFormSimpleServlet.css\">");
                out.println("<title>Servlet Segundo Validar</title>");
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
        }
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

    public void pintarHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fallo = "";
        response.setContentType("text/html;charset=UTF-8");
        
        if (vnom.equals("")) {
            fallo += " <li> Nombre no es correcto </li> ";
        }

        if (vcontr.equals("")) {
            fallo += "<li> Contraseña no es correcto </li> ";
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<!--\n"
                    + "To change this license header, choose License Headers in Project Properties.\n"
                    + "To change this template file, choose Tools | Templates\n"
                    + "and open the template in the editor.\n"
                    + "-->\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Index Segundo Validar</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"Css/styleFormSimple.css\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <h1>Segundo Validar</h1>\n"
                    + "        <form method=\"post\" action=\"SegundoValidar\" >\n"
                    + "            <div class='validar'>\n"
                    + "            <h1>Error en los campos requeridos</h1>\n"
                    + "            <ul>\n"
                    + "            " + fallo + "\n"
                    + "            </ul>\n"
                    + "            </div>\n"
                    + "            <div>\n"
                    + "                <fieldset>\n"
                    + "                    <legend>Datos Usuario</legend>\n"
                    + "                    <p>Usuario: <input type=\"text\" name=\"Usuario\" value=\"" + vnom + "\" ></p>\n"
                    + "                    <p>Contraseña : <input type=\"password\" name=\"Contrasena\" value=\"" + vcontr + "\" ></p>\n"
                    + "                    <p>Sexo:\n"
                    + "                        <input type=\"radio\" name=\"Sexo\" value=\"Hombre\" checked=\"checked\"> Hombre\n"
                    + "                        <input type=\"radio\" name=\"Sexo\" value=\"Mujer\"> Mujer\n"
                    + "                    </p>\n"
                    + "                    <p>Edad : <input type=\"number\" name=\"Edad\" value=\"18\" ></p>\n"
                    + "\n"
                    + "\n"
                    + "                </fieldset>\n"
                    + "                <fieldset>\n"
                    + "                    <legend>Datos complementarios:</legend>\n"
                    + "                    <p>Estado civil\n"
                    + "                        <input type=\"radio\" name=\"Estado Civil\" value=\"Soltero\" checked=\"checked\"> Soltero\n"
                    + "                        <input type=\"radio\" name=\"Estado Civil\" value=\"Casado\"> Casado\n"
                    + "                        <input type=\"radio\" name=\"Estado Civil\" value=\"Viudo\"> Viudo\n"
                    + "                        <input type=\"radio\" name=\"Estado Civil\" value=\"Divorciado\"> Divorciado\n"
                    + "                    </p>\n"
                    + "                    <p>Aficion/es (press Ctrl seleccionar varios:</p>\n"
                    + "                    <select name=\"Aficiones\" multiple=\"multiple\" size=\"6\">\n"
                    + "                        <option selected=\"selected\">Deporte </option>\n"
                    + "                        <option>Música</option>\n"
                    + "                        <option>Viajes</option>\n"
                    + "                        <option>Informática</option>\n"
                    + "                        <option>Tiendas</option>\n"
                    + "                        <option>Juegos</option>\n"
                    + "                    </select>\n"
                    + "                    <p>Si deseas mandar simplemente una opinion o comentario escribelo aquí.<br>\n"
                    + "                        <textarea name=\"comentario\" rows=\"2\" cols=\"50\" placeholder=\"Escriba aqui...\" > </textarea>\n"
                    + "                    </p>\n"
                    + "\n"
                    + "                </fieldset>\n"
                    + "                <fieldset>\n"
                    + "                    <legend>Medios Tecnologicos:</legend>\n"
                    + "                    <p>Conexion a internet:\n"
                    + "                        <input type=\"radio\" name=\"Conexion a internet\" value=\"Si\" checked=\"checked\"> Si\n"
                    + "                        <input type=\"radio\" name=\"Conexion a internet\" value=\"No\"> No                        \n"
                    + "                    </p>\n"
                    + "                    \n"
                    + "                    <p>Sistema operativo:</p>\n"
                    + "                    <select name=\"Sistema Operativo\"  size=\"4\">\n"
                    + "                        <option selected=\"selected\">Linux </option>\n"
                    + "                        <option>Windows</option>\n"
                    + "                        <option>Macintosh</option>\n"
                    + "                        <option>Solaris </option>                        \n"
                    + "                    </select>               \n"
                    + "\n"
                    + "                </fieldset>\n"
                    + "\n"
                    + "            </div>\n"
                    + "            <p class=\"submit\">\n"
                    + "                <input type=\"submit\" value=\"Enviar\">\n"
                    + "                <input type=\"reset\" value=\"Borrar\">\n"
                    + "            </p>\n"
                    + "        </form>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");

        }
    }

    private boolean validar(HttpServletRequest request) {
        vnom = request.getParameter("Usuario");
        vcontr = request.getParameter("Contrasena");
        boolean ok = true;

        if (vnom.replace(" ", "").equals("") || vnom == (null)) {
            ok = false;
            if (vnom == (null)) {
                vnom = "";
            }

        }
        if (vcontr.replace(" ", "").equals("") || vcontr == (null)) {
            ok = false;
            if (vcontr == (null)) {
                vcontr = "";
            }

        }
        return ok;
    }

    private void mostrarAdver(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<!--\n"
                    + "To change this license header, choose License Headers in Project Properties.\n"
                    + "To change this template file, choose Tools | Templates\n"
                    + "and open the template in the editor.\n"
                    + "-->\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Cuadro Advertencia</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"Css/styleFormSimple.css\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <h1>Fomulario Simple</h1>\n"
                    + "        <form method=\"post\" action=\"SegundoValidar\" >\n"
                    + "            <div class='validar'>\n"
                    + "            <h1>Error en los campos requeridos</h1>\n"
                    + "                    <p><input type=\"text\" name=\"Usuario\" value=\"" + vnom + "\" hidden=\"hidden\"></p>\n"
                    + "                    <p><input type=\"password\" name=\"Contrasena\" value=\"" + vcontr + "\" hidden=\"hidden\" ></p>\n"
                    + "            </div>\n"
                    + "            <p class=\"submit\">\n"
                    + "                <input type=\"submit\" value=\"Aceptar\">\n"
                    + "            </p>\n"
                    + "        </form>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
            adv = false;
        }
    }
}
