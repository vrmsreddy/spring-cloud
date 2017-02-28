package org.ms.spring.cloud.gateway.service.client;

import org.springframework.http.ResponseEntity;



/**
 * Client service to call ms-client-1.
 * @author MS
 *
 */
public interface ClientService {
	
	/**
	 * @param id
	 * @param sortOrder
	 * @param currentPageNumber
	 * @param pageCapacity
	 * @return
	 */
	public ResponseEntity<String> getId(int id,
			String sortOrder, int currentPageNumber, int pageCapacity);
}
