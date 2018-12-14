package com.codechallenge.itinerarySpecific.Model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


/**
 * Class Name : ItineraryView
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Service
public class ItineraryView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String source;

	private String destiny;

	private Integer arrivalTime;

	private Integer numberOfConnections;

	// private String connections;

	private List<String> connections = new LinkedList<>();

	public Integer getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(Integer numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}

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
