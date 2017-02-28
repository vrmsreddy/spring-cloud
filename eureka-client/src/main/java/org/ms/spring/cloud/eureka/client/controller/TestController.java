package org.ms.spring.cloud.eureka.client.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(TestController.class);
	
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
		logger.info("Req Received");
		return new ResponseEntity<String>("This is the Response from Client:ID = "+ id, HttpStatus.OK);
	}
}
