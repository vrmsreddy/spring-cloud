package org.ms.spring.cloud.gateway.service.client;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * @author MS
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	Client client;
	
	/**
	 * @param id
	 * @param sortOrder
	 * @param currentPageNumber
	 * @param pageCapacity
	 * @return
	 */
	public ResponseEntity<String> serviceError(int id,
			String sortOrder, int currentPageNumber, int pageCapacity) {
		return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	@HystrixCommand(fallbackMethod = "serviceError")
	public ResponseEntity<String> getId(int id,
			String sortOrder, int currentPageNumber, int pageCapacity) {
		ResponseEntity<String> response = null;
		try {
			response = client.getId(id, sortOrder, currentPageNumber, pageCapacity);
		} catch (Exception e) {
			logger.info("Exception in client....."+e.getMessage());
		}
		return response;
	}

}
