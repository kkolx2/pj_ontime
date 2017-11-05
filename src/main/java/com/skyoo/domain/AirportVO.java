package com.skyoo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="pj_airport")
@Data
@ToString(exclude="destA")
public class AirportVO {

	@Id
	@Column(name="iata")
	public String iata;
	public String airport;
	public String city;
	public String state;
	public String country;
	@Column(name="lat")
	public double lat;
	@Column(name="lng")
	public double lng;
	
	@OneToMany(mappedBy="iata")
	private List<OntimeVO> destA = new ArrayList<OntimeVO>();
	
}
