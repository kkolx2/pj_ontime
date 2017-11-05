package com.skyoo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="pj_ontime")
@Data
@EqualsAndHashCode(of="ono")
public class OntimeVO {

	@Id
//	@SequenceGenerator(allocationSize=1,initialValue=5314, name = "aa")
	@TableGenerator(name = "idGen", table= "id_gen", 
	  pkColumnName="seq_name",
	  valueColumnName="nextval",
	  allocationSize=1, initialValue=5315)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="idGen")
	@Column(name="ono")
	private Integer ono;
	
	private String origin;
	
	private String dest;
	
	@Column(name="distance")
	private Integer distance;
	
	private String ucarrier;
	
	@Column(name="fnum")
	private Integer fnum;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "iata")
	private AirportVO iata;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "code")
	private CarrierVO code;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "oiata")
	private OriginVO oiata;
 	
}
