package org.ms.spring.cloud.gateway.config;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *@author MS
 *Static Image Configuration
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurerAdapter.class})
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ResourceConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
	// Absolute URL ,Where media files located in windows or linux file system
	@Value("${ms.media.baseURL}")
	private String mediaBaseURL;
	
	/*mapping url to access images(e.g: <img src=/watch/images/xyz.jpg>,here 
	 * mapping URL is /watch and point to baseURL i.e c:\watch\images\xyz.jpg) */
	@Value("${ms.media.mappingURL}")
	private String mappingURL;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(mappingURL).addResourceLocations(
				mediaBaseURL);
		super.addResourceHandlers(registry);
	}
}
