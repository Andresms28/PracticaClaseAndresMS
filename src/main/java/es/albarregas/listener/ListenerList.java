/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Emilio
 */
public class ListenerList implements ServletContextListener, ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener,
        HttpSessionActivationListener, HttpSessionBindingListener,
        ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Se ha invocado contextInitialized: ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Se ha invocado contextDestroyed: ...");

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Se ha invocado attributeAdded: ...");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Se ha invocado attributeRemoved: ...");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        System.out.println("Se ha invocado attributeReplaced: ...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Se ha invocado sessionCreated: ...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Se ha invocado sessionDestroyed: ...");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Se ha invocado attributeAdded: ...");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Se ha invocado attributeRemoved: ...");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Se ha invocado attributeReplaced: ...");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("Se ha invocado sessionWillPassivate: ...");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("Se ha invocado sessionDidActivate: ...");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Se ha invocado valueBound: ...");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Se ha invocado valueUnbound: ...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Se ha invocado requestDestroyed: ...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Se ha invocado requestInitialized: ...");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Se ha invocado attributeAdded: ...");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Se ha invocado attributeRemoved: ...");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Se ha invocado attributeReplaced: ...");
    }

}
