package com.codenaiten.spring.mvc.web.controller;

//IMPORTS
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
* Controlador que maneja nuestras peticiones de ejemplo.
* 
* @author indenaiten
* @email indenaiten@gmail.com
*
*/
@Controller
@RequestMapping( value = "/", method = RequestMethod.GET )
public class HelloWorldController {

	//ATTRIBUTES
	private String mainView = "helloWorld";
	
	
	
	/**
	 * Petición para mostrar un saludo en nuestra web
	 * 
	 * @param name
	 * @return ModelAndView
	 */
	@GetMapping( "/hi/{name}")
	public ModelAndView hi( @PathVariable( "name" ) String name ){
		//BUILD MESSAGE
		String msg = new StringBuilder( "Hello " )
				.append( name )
				.append( " !!!" )
				.toString();
		
		return new ModelAndView( this.mainView )
				.addObject( "msg", msg );
	}
	
}
