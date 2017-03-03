package org.ms.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author MS
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy
@EnableHystrixDashboard
@EnableTurbine
@EnableCircuitBreaker
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
