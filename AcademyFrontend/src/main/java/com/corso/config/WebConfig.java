package com.corso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.corso.beans.Beans;

@Configuration // qui si creano i bean per Spring core
@EnableAspectJAutoProxy
@EnableWebMvc  // indica che � una applicazione web
@ComponentScan(basePackages={"com.corso"})

@Import({ Beans.class })

public class WebConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp"); 
		return resolver; 
	}
	
	// qui il metodo del resources handler, per file css, immagini e file js (risorse statiche) 
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
	}
	
	
}
