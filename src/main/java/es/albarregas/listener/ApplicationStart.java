/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 *
 * @author Emilio
 */
public class ApplicationStart implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext contexto= sce.getServletContext();
        System.out.println("Aplicacion arrancando en el contexto: "+contexto.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext contexto= sce.getServletContext();
        System.out.println("Aplicacion del contexto: "+contexto.getContextPath()+" Deteniendose");
    }
    
}
