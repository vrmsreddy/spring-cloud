package org.ms.spring.cloud.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author MS
 *
 */
@Configuration
public class FeignRequestInterceptor {
	@Autowired(required=true)
	private HttpServletRequest request;
	
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
	    return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate arg0) {
				arg0.header("AUTH-TOKEN", request.getHeader("AUTH-TOKEN"));
			}
	    };
	}
}
