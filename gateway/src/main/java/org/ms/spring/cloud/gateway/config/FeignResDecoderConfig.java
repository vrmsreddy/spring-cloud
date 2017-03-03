package org.ms.spring.cloud.gateway.config;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.context.annotation.Configuration;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

/**
 * Decodes error codes while invoking micro service by using @FeignClient.
 * @author MS
 *
 */
@Configuration
public class FeignResDecoderConfig implements Decoder {
	@Autowired(required=true)
	private HttpServletResponse response;
	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;
	
	@Override
	public Object decode(Response feignRes, Type type) throws IOException,
			DecodeException, FeignException {
			System.out.println("Feign Res=" + feignRes.headers().get("auth-token"));
			String token = null;
		 	  if (feignRes.status() == 404) {
		        return Util.emptyValueOf(type);
		      }
		      if (feignRes.body() == null) {
		        return null;
		      }
		      if (byte[].class.equals(type)) {
		        return Util.toByteArray(feignRes.body().asInputStream());
		      }
		      
		      if (String.class.equals(type)) {
		        return Util.toString(feignRes.body().asReader());
		      }
		      if(feignRes.headers().get("auth-token") != null){
		    	  token = feignRes.headers().get("auth-token").toString();
		      }
		      if(StringUtils.isNotBlank(token)){
		    	  response.setHeader("auth-token", token);
		      }
		      
		      return new ResponseEntityDecoder(new SpringDecoder(this.messageConverters)).decode(feignRes, type);
	}
}
