package com.codechallenge.itinerarySpecific.Model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Class Name : ItineraryGraph
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Service
public class ItineraryGraph {

	private Set<ItineraryNodes> nodes = new HashSet<>();

	private Set<ItineraryNodes> Unsettlednodes = new HashSet<>();

	// Setters and Getters

	public Set<ItineraryNodes> getUnsettlednodes() {
		return Unsettlednodes;
	}

	public void setUnsettlednodes(Set<ItineraryNodes> unsettlednodes) {
		Unsettlednodes = unsettlednodes;
	}

	public Set<ItineraryNodes> getNodes() {
		return nodes;
	}

	public void setNodes(Set<ItineraryNodes> nodes) {
		this.nodes = nodes;
	}

	public void addNode(ItineraryNodes nodeA) {
		nodes.add(nodeA);
	}

}
