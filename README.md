### Spring Cloud Micro services configurations

---> **Spring Eureka Server**
	- Eureka Server Configuration

    
---> **Spring Eureka Client**
	-Eureka Client configuration

--> **Spring ZULL Gateway**
- Routing API mapping to services
- 	Hystrix,Turbine Configuration
- 	Static images
- 	Feign Decoder
- 	Swagger  Configuration
- 	CORS


---> **Spring Boot and Profiles for Log's**
	-Profiles configuration for different evironment's


**URLs for Testing**

## 1)Eureka Server:
	Eureka DashBoard
	http://localhost:8788

## 2)Eureka Client:
	Swagger-UI
	http://localhost:9100/swagger-ui.html
    
    Spring Actuator URLs
    http://localhost:9100/beans
    http://localhost:9100/env
    http://localhost:9100/mappings
    http://localhost:9100/beans
    
## 3)API Gateway :
    Swagger-UI
    http://localhost:9110/swagger-ui.html
    
    Spring Actuator URLs
    http://localhost:9110/beans
    http://localhost:9110/env
    http://localhost:9110/mappings
    http://localhost:9110/beans
    
	Hystrix DashBoard
    http://localhost:9110/hystrix
    
    Direct URL
    http://localhost:9110/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9110%2Fhystrix.stream&title=ms-gateway
