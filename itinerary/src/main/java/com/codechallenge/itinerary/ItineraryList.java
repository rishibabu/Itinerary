package com.codechallenge.itinerary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class Name : ItineraryList
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Entity
public class ItineraryList {

	@Id
	private Long id;

	@Column(name = "source")
	private String source;

	@Column(name = "destiny")
	private String destiny;

	@Column(name = "arrival_time")
	private Integer arrivalTime;

	@Column(name = "dep_time")
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

	public Integer getDepTime() {
		return depTime;
	}

	public void setDepTime(Integer depTime) {
		this.depTime = depTime;
	}

}
