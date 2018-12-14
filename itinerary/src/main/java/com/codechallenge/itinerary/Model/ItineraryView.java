package com.codechallenge.itinerary.Model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


/**
 * Class Name : ItineraryView
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */


@Service
public class ItineraryView {

	private String source;

	private String destiny;

	private Integer arrivalTime;

	// private String connections;

	private List<String> connections = new LinkedList<>();

	public List<String> getConnections() {
		return connections;
	}

	public void setConnections(List<String> connections) {
		this.connections = connections;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
