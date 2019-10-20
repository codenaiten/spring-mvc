# Configuración inicial de Spring MVC

**_Proyecto con Maven y el servidor Jetty Embebido_**

---

### Pasos:

1. Creamos un **proyecto Maven sin arquetipo**.

3. Añadimos las **dependencias necesarias** en el ``pom.xml``.
   
   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
     
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>com.codenaiten.spring.mvc</groupId>
   	<artifactId>spring-web-mvc</artifactId>
   	<version>1.0.0-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<name>spring-web</name>
   	<description>Configuración XML de un proyecto web con Spring</description>
     
     
     
   	<properties>
       	
       	<spring.version>5.2.0.RELEASE</spring.version>
       	<servlet.api.version>3.0.1</servlet.api.version>
       	<jstl.version>1.2</jstl.version>
       	
       	<built.name>spring-web-mvc</built.name>
       	<source.directory>src/main/java</source.directory>
       	
       	<maven.compiler.plugin.version>3.8.0</maven.compiler.plugin.version>
       	<jdk.version>1.8</jdk.version>
       	<maven.war.plugin.version>3.2.1</maven.war.plugin.version>
       	<jetty-maven-plugin.version>9.4.15.v20190215</jetty-maven-plugin.version>
       	
       	<war.source.directory>src/main/webapp</war.source.directory>
       	
       </properties>
       
       
       
       <dependencies>
   		
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
   		<dependency>
   		    <groupId>org.springframework</groupId>
   		    <artifactId>spring-webmvc</artifactId>
   		    <version>${spring.version}</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
   		<dependency>
   		    <groupId>javax.servlet</groupId>
   		    <artifactId>javax.servlet-api</artifactId>
   		    <version>${servlet.api.version}</version>
   		    <scope>provided</scope>
   		</dependency>
   		
   		<!-- https://mvnrepository.com/artifact/jstl/jstl -->
   		<dependency>
   		    <groupId>jstl</groupId>
   		    <artifactId>jstl</artifactId>
   		    <version>${jstl.version}</version>
   		</dependency>
   		
       </dependencies>
       
       
       
       <build>
       	
       	<finalName>${built.name}</finalName>
       	
           <sourceDirectory>${source.directory}</sourceDirectory>
           
           <plugins>
           
               <plugin>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>${maven.compiler.plugin.version}</version>
                   <configuration>
                     <source>${jdk.version}</source>
                     <target>${jdk.version}</target>
                   </configuration>
               </plugin>
               
               
               <plugin>
                   <artifactId>maven-war-plugin</artifactId>
                   <version>${maven.war.plugin.version}</version>
                   <configuration>
                       <warSourceDirectory>${war.source.directory}</warSourceDirectory>
                   </configuration>
               </plugin>
               
               <plugin>
   	            <groupId>org.eclipse.jetty</groupId>
   	            <artifactId>jetty-maven-plugin</artifactId>
   	            <version>${jetty-maven-plugin.version}</version>
   	            
   	            <configuration>
   	                <scanIntervalSeconds>10</scanIntervalSeconds>
   	                <webApp>
   	                	<contextPath>/</contextPath>
   	                </webApp>
   	            </configuration>
   	        </plugin>
               
           </plugins>
           
       </build>
       
   </project>
   ```
   
   
   
3. Establecemos la **configuración de spring-mvc mediante una clase de configuración**.

   ```java
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
   
   
   
   @Configuration
   @EnableWebMvc
   @ComponentScan( basePackages = "com.codenaiten.spring" )
   public class ConfigMVC implements WebMvcConfigurer{
   	
   	 @Bean
   	 public ViewResolver viewResolver(){
   		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
   		 viewResolver.setViewClass( JstlView.class );
   		 viewResolver.setPrefix( "/WEB-INF/web/view/" );
   		 viewResolver.setSuffix( ".jsp" );
   	 
   	     return viewResolver;
   	 }
   
   	 @Override
   	 public void addResourceHandlers( ResourceHandlerRegistry registry ){
   		 registry.addResourceHandler( "/resources/**" )
   		 	.addResourceLocations( "/WEB-INF/web/resources/" ); 
   	 }
   }
   ```

   

4. Creamos una **clase inizializadora**.

   ```xml
   package com.codenaiten.spring.mvc.config.spring;
   
   //IMPORTS
   import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
   
   
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
   ```

   


5. Creamos nuestro controlador y nuestras vistas donde le hayamos especificado a Spring que estarán.

6. **Arrancamos la aplicación con Jetty** con el comando ``mvn jetty:run``.
