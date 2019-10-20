package com.codenaiten.spring.mvc.config.spring;

//IMPORTS
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



/**
 * Clase de configuración de Spring MVC
 * 
 * @author indenaiten
 * @email angel.herce.soto@gmail.com
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.codenaiten.spring" )
public class ConfigMVC implements WebMvcConfigurer{
	
	/**
	 * Establecemos la clase que resolverá las vistas.
	 * 
	 * @return ViewResolver
	 * 
	 * @author indenaiten
	 * @email angel.herce.soto@gmail.com
	 */
	 @Bean
	 public ViewResolver viewResolver(){
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		 viewResolver.setViewClass( JstlView.class );
		 viewResolver.setPrefix( "/WEB-INF/web/view/" );
		 viewResolver.setSuffix( ".jsp" );
	 
	     return viewResolver;
	 }
	 
	 

	 /**
	  * Mapeamos la ruta virtual con la real de los recursos estáticos.
	  * 
	  * @author indenaiten
	  * @email angel.herce.soto@gmail.com
	  */
	 @Override
	 public void addResourceHandlers( ResourceHandlerRegistry registry ){
		 registry.addResourceHandler( "/resources/**" )
		 	.addResourceLocations( "/WEB-INF/web/resources/" ); 
	 }
}
