package com.codechallenge.itinerarySpecific.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Class Name : ItineraryNodes
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

public class ItineraryNodes {

	private String name;

	private List<ItineraryNodes> shortestPath = new LinkedList<>();

	private Integer distance = Integer.MAX_VALUE;

	Map<ItineraryNodes, Integer> adjacentNodes = new HashMap<>();

	public void addDestination(ItineraryNodes destination, int distance) {
		adjacentNodes.put(destination, distance);
	}

	public ItineraryNodes(String name) {
		this.name = name;
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItineraryNodes> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<ItineraryNodes> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<ItineraryNodes, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<ItineraryNodes, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

}
