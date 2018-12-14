package com.codechallenge.itinerary.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.itinerary.ItineraryList;
import com.codechallenge.itinerary.Repository.ItineraryListRepository;

/**
 * Class Name : ItineraryListService
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Service
public class ItineraryListService {

	@Autowired
	ItineraryListRepository itRepo;

	public List<ItineraryList> getListByOrigin(String source)

	{
		return itRepo.findBySource(source);

	}

	public List<ItineraryList> getAllList()

	{
		return itRepo.findAll();

	}

}
