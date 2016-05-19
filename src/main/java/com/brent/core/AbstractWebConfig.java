package com.brent.core;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by brent.su on 2016/5/19.
 */

@EnableWebMvc
public abstract class AbstractWebConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", DispatcherServlet.class);
        dispatcher.setInitParameter("contextConfigLocation", getClass().getName());
        dispatcher.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        dispatcher.setInitParameter("contextInitializerClasses", DefaultAppContextInitializer.class.getName());
        dispatcher.addMapping("/*");
        dispatcher.setLoadOnStartup(1);
    }
}
