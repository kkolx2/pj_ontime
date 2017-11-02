package com.skyoo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name="pj_carrier")
@EqualsAndHashCode(of = "code")
@ToString(exclude="ucarrierC")
public class CarrierVO{

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	

	@OneToMany(mappedBy="code",fetch=FetchType.LAZY)
	private List<OntimeVO> ucarrierC = new ArrayList<OntimeVO>(); 
	
}
