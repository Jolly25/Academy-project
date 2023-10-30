package com.corso.model;

import javax.persistence.*;


@Entity
@Table(name = "ParolaStandard")
public class StandardWord{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdParoleStandard")
	private int id;
	
	@Column(name="cca3")
	private String code;
	
	@Column(name="Common")
	private String value;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

}
