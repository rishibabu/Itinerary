package com.codechallenge.itinerarySpecific;

/**
 * Class Name : ItinerarySpecific
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

public class ItinerarySpecific {

	private Long id;

	private String source;

	private String connectingCity;

	private Integer arrivalTime;

	private Integer depTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getConnectingCity() {
		return connectingCity;
	}

	public void setDestiny(String destiny) {
		this.connectingCity = destiny;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getDepTime() {
		return depTime;
	}

	public void setDepTime(Integer depTime) {
		this.depTime = depTime;
	}

}
