package com.codechallenge.itinerarySpecific.Controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codechallenge.itinerarySpecific.ItinerarySpecific;
import com.codechallenge.itinerarySpecific.Model.ItineraryView;
import com.codechallenge.itinerarySpecific.Service.ShortestPathService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Class Name : ItinerarySpecificController
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@RestController
@RequestMapping("/itinerary")
public class ItinerarySpecificController {

	@Autowired
	ShortestPathService spService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value = "This API service retrives all the list of itineraries from the table", notes = "", response = Arrays.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully processed and retrieved itineraries") })
	@GetMapping(path = "/itineraryAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItinerarySpecific[] consumeItinerary() {

		ResponseEntity<ItinerarySpecific[]> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/itinerarylist/show/", ItinerarySpecific[].class);
		ItinerarySpecific[] response = responseEntity.getBody();

		return response;

	}

	@ApiOperation(value = "This API service retrives only  the list of itineraries from the Source provided in the request based on shortest arrival time", notes = "", response = ItineraryView.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully processed and retrieved itineraries") })
	@RequestMapping(path = "/shortestPathByTime/{source}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItineraryView>> shortestPathByTime(@PathVariable String source) {

		ResponseEntity<ItinerarySpecific[]> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/itinerarylist/show/", ItinerarySpecific[].class);
		ItinerarySpecific[] response = responseEntity.getBody();

		return ResponseEntity.ok(spService.showItineraryByTime(response, source.toUpperCase()));

		// return response;

	}

	@ApiOperation(value = "This API service retrives only  the list of itineraries from the Source provided in the request based on shortest number of connections", notes = "", response = ItineraryView.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully processed and retrieved itineraries") })
	@RequestMapping(path = "/shortestPathByConnections/{source}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItineraryView>> shortestPathByConnections(@PathVariable String source) {

		ResponseEntity<ItinerarySpecific[]> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/itinerarylist/show/", ItinerarySpecific[].class);
		ItinerarySpecific[] response = responseEntity.getBody();

		return ResponseEntity.ok(spService.showItineraryByConnections(response, source.toUpperCase()));

		// return response;

	}

}