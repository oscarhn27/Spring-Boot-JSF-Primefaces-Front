/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.citasmedicas;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"es.citasmedicas.service.impl","es.citasmedicas.bean"})
@EnableJpaRepositories(basePackages = {"es.citasmedicas.dao"})
@EntityScan(basePackages ={"es.citasmedicas.modelo"})
public class CitasMedicasApp {

    public static void main(String[] args) {
	SpringApplication.run(CitasMedicasApp.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
	ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
	registration.setLoadOnStartup(1);
	registration.addUrlMappings("*.jr");
	return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
	return servletContext -> {
	    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.THEME", "sunny");
	};
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
	return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }
}
