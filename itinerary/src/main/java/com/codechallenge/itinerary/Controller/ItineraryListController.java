package com.codechallenge.itinerary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.itinerary.ItineraryList;
import com.codechallenge.itinerary.Service.ItineraryListService;

/**
 * Class Name : ItineraryListController
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@RestController
public class ItineraryListController {

	@Autowired
	ItineraryListService itListService;

	@RequestMapping(value = "/itinerarylist/show/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItineraryList> retrieveAllItineraryList() {

		return itListService.getAllList();

	}

}
