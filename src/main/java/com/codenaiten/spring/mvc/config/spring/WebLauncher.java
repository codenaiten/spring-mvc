package com.codenaiten.spring.mvc.config.spring;

//IMPORTS
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Clase que inicializa la aplicación web.
 * 
 * @author indenaiten
 * @email angel.herce.soto@gmail.com
 *
 */
public class WebLauncher extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ConfigMVC.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
