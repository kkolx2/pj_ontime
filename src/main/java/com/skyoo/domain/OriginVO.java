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
@Table(name="pj_origin")
@Data
@ToString(exclude="destB")
public class OriginVO {

	@Id
	@Column(name="oiata")
	public String oiata;
	public String oairport;
	public String ocity;
	public String ostate;
	public String ocountry;
	@Column(name="olat")
	public double olat;
	@Column(name="olng")
	public double olng;
	
	@OneToMany(mappedBy="oiata")
	private List<OntimeVO> destB = new ArrayList<OntimeVO>();
	
}
