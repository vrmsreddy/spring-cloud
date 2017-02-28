package org.ms.spring.cloud.gateway.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.ms.spring.cloud.gateway.service.client.ClientService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MS
 *
 */
@RestController
public class TestController {
	@Autowired
	private ClientService clientService;
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * @param id
	 * @param sortOrder
	 * @param currentPageNumber
	 * @param pageCapacity
	 * @return
	 */
	@RequestMapping(value = "/ms/test/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "PRIVATE:This is the API for Swagger Test")
	public ResponseEntity<String> getId(
			@ApiParam (value="A valid PlaceId") 
						@RequestParam (name = "id", required = true) int id,
			@ApiParam(value = "Order of sort,desc and asc are the values, by default it will be sorted in descending order", required = false, defaultValue = "asc") 
						@RequestParam(required = false, defaultValue = "asc", name = "sortOrder") String sortOrder,
			@ApiParam(value = "Pagination parameter, By default it fetches the data from starting page", required = false, defaultValue = "0") 
						@RequestParam(required = false, defaultValue = "0", name = "currentPageNumber") int currentPageNumber,
			@ApiParam(value = "Capacity of data displayed in one page, default is 10", required = false, defaultValue = "10") 
						@RequestParam(required = false, defaultValue = "10", name = "pageCapacity") int pageCapacity) {
		logger.info("Calling Client");
		return clientService.getId(id, sortOrder, currentPageNumber, pageCapacity);
	}
}
