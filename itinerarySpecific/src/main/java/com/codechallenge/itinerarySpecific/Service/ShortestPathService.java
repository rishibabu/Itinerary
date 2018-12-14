package com.codechallenge.itinerarySpecific.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.itinerarySpecific.ItinerarySpecific;
import com.codechallenge.itinerarySpecific.Model.ItineraryGraph;
import com.codechallenge.itinerarySpecific.Model.ItineraryNodes;
import com.codechallenge.itinerarySpecific.Model.ItineraryView;


/**
 * Class Name : ShortestPathService
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Service
public class ShortestPathService {

	@Autowired
	ItineraryGraph graph;

	@SuppressWarnings("unlikely-arg-type")
	public ItineraryGraph getTheShortestPath(ItinerarySpecific[] its, String Origin) {

		Set<ItineraryNodes> mainCitiesSet = new LinkedHashSet<>();

		Set<ItineraryNodes> mainCitiesTempSet = new LinkedHashSet<>();

		List<ItineraryNodes> mainCitiesList = new ArrayList<>();

		Set<String> mainCitiesStringSet = new LinkedHashSet<>();

		Set<ItineraryNodes> sourceCitiesSet = new LinkedHashSet<>();

		Set<ItineraryNodes> connectionCitiesSet = new LinkedHashSet<>();

		ItineraryGraph graph = new ItineraryGraph();

		ItineraryNodes mainCityNodes = new ItineraryNodes("");

		// Creating a Set of All Cities
		for (ItinerarySpecific itinerarySpecific : its) {

			if (mainCitiesStringSet.isEmpty() || !mainCitiesStringSet.contains(itinerarySpecific.getSource())) {
				mainCityNodes = new ItineraryNodes(itinerarySpecific.getSource());
				mainCitiesSet.add(mainCityNodes);
				mainCitiesStringSet.add(itinerarySpecific.getSource());

			}

		}

		// Adding into the Set the city presents in the Connecting Cities set but not in
		// the Source

		for (ItinerarySpecific itinerarySpecific : its) {

			if (mainCitiesStringSet.isEmpty() || !mainCitiesStringSet.contains(itinerarySpecific.getConnectingCity())) {
				mainCityNodes = new ItineraryNodes(itinerarySpecific.getConnectingCity());
				mainCitiesSet.add(mainCityNodes);
				mainCitiesStringSet.add(itinerarySpecific.getConnectingCity());

			}

		}

		// Creating SourceCities Set from the mainCitiesSet

		for (ItinerarySpecific itinerarySpecific : its) {

			for (ItineraryNodes itineraryNodes : mainCitiesSet) {

				if (itineraryNodes.getName().contains(itinerarySpecific.getSource())) {

					sourceCitiesSet.add(itineraryNodes);

				}

			}
		}

		// Creating Connection Cities Set from the mainCitiesSet ConnectingCities are
		// the cities connected from the Source

		for (ItinerarySpecific itinerarySpecific : its) {

			for (ItineraryNodes itineraryNodes : mainCitiesSet) {

				if (itineraryNodes.getName().contains(itinerarySpecific.getConnectingCity())) {

					connectionCitiesSet.add(itineraryNodes);

				}

			}
		}

		// Adding the Connecting Cities to the Source and adding the total time taken
		// from Source to those Connecting Cities

		for (ItinerarySpecific itinerarySpecific : its) {

			for (ItineraryNodes itineraryNodesSource : sourceCitiesSet) {

				for (ItineraryNodes itineraryNodesDestiny : connectionCitiesSet)

				{
					if (itinerarySpecific.getSource().equals(itineraryNodesSource.getName())
							&& itinerarySpecific.getConnectingCity().equals(itineraryNodesDestiny.getName())) {
						itineraryNodesSource.addDestination(itineraryNodesDestiny,
								(itinerarySpecific.getArrivalTime() - itinerarySpecific.getDepTime()));
					}

				}

			}
		}

		// Adding all the city nodes to the graph object

		for (ItineraryNodes itineraryNodes : mainCitiesSet) {

			graph.addNode(itineraryNodes);

		}

		// Passing the Source/Origin from the request to find the shortest path

		for (ItineraryNodes itineraryNodes : mainCitiesSet) {

			if (itineraryNodes.getName().contains(Origin)) {
				graph = calculateShortestPathFromSource(graph, itineraryNodes);
			}

		}

		return graph;

	}

	public static ItineraryGraph calculateShortestPathFromSource(ItineraryGraph graph, ItineraryNodes source) {
		source.setDistance(0);

		Set<ItineraryNodes> settledNodes = new HashSet<>();
		Set<ItineraryNodes> unsettledNodes = new HashSet<>();

		unsettledNodes.add(source);

		while (unsettledNodes.size() != 0) {
			ItineraryNodes currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			for (Entry<ItineraryNodes, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
				ItineraryNodes adjacentNode = adjacencyPair.getKey();
				Integer edgeWeight = adjacencyPair.getValue();
				if (!settledNodes.contains(adjacentNode)) {
					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		return graph;
	}

	private static ItineraryNodes getLowestDistanceNode(Set<ItineraryNodes> unsettledNodes) {
		ItineraryNodes lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (ItineraryNodes node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	private static void calculateMinimumDistance(ItineraryNodes evaluationNode, Integer edgeWeigh,
			ItineraryNodes sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<ItineraryNodes> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public List<ItineraryView> showItineraryByTime(ItinerarySpecific[] its, String origin) {

		List<ItineraryView> itineraries = new ArrayList<>();

		graph = getTheShortestPath(its, origin);

		Set<ItineraryNodes> setOfNodes = new HashSet<>();

		setOfNodes = graph.getNodes();

		for (ItineraryNodes itineraryNodes : setOfNodes) {

			ItineraryView iV = new ItineraryView();

			iV.setSource(origin);

			iV.setDestiny(itineraryNodes.getName());

			iV.setArrivalTime(itineraryNodes.getDistance());

			List<String> connections = new ArrayList<>();

			for (ItineraryNodes itineraryNodes2 : itineraryNodes.getShortestPath()) {

				connections.add(itineraryNodes2.getName());

			}

			iV.setConnections(connections);

			iV.setNumberOfConnections(connections.size());

			itineraries.add(iV);

			// Java 8 Lambda expression to remove object having zero connections
			itineraries.removeIf(s -> s.getNumberOfConnections().equals(0));
		}

		return itineraries;

	}

	public List<ItineraryView> showItineraryByConnections(ItinerarySpecific[] its, String origin) {

		List<ItineraryView> itineraries = new ArrayList<>();

		graph = getTheShortestPath(its, origin);

		Set<ItineraryNodes> setOfNodes = new HashSet<>();

		setOfNodes = graph.getNodes();

		for (ItineraryNodes itineraryNodes : setOfNodes) {

			ItineraryView iV = new ItineraryView();

			iV.setSource(origin);

			iV.setDestiny(itineraryNodes.getName());

			iV.setArrivalTime(itineraryNodes.getDistance());

			List<String> connections = new ArrayList<>();

			for (ItineraryNodes itineraryNodes2 : itineraryNodes.getShortestPath()) {

				connections.add(itineraryNodes2.getName());

			}

			iV.setConnections(connections);

			iV.setNumberOfConnections(connections.size());

			itineraries.add(iV);
			// Sorting according to the number of connections using java 8 lambda expression
			itineraries.sort((ItineraryView iV1, ItineraryView iV2) -> iV1.getNumberOfConnections()
					.compareTo(iV2.getNumberOfConnections()));

			// Java 8 Lambda expression to remove object having zero connections
			itineraries.removeIf(s -> s.getNumberOfConnections().equals(0));

		}

		return itineraries;

	}

}
