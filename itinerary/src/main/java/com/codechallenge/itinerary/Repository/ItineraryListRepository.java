package com.codechallenge.itinerary.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codechallenge.itinerary.ItineraryList;

/**
 * Interface Name : ItineraryListService
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

public interface ItineraryListRepository extends JpaRepository<ItineraryList, Long>

{

	List<ItineraryList> findBySource(String source);

}
