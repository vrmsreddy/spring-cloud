package org.ms.spring.cloud.gateway.config;

import static feign.FeignException.errorStatus;

import org.springframework.context.annotation.Configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Decodes error codes while invoking Other micro service
 * @FeignClient.
 * 
 * @author MS
 *
 */
@Configuration
public class FeignErrorDecoderConfig implements ErrorDecoder {
		/* (non-Javadoc)
		 * @see feign.codec.ErrorDecoder#decode(java.lang.String, feign.Response)
		 */
		@Override
		public Exception decode(String methodKey, Response response) {
			if(response.status() > 400){
				return new Exception( response.reason());
			}
		   return errorStatus(methodKey, response);
		}
}
