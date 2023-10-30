package com.corso.model;

import javax.persistence.*;


@Entity
@Table(name = "standardwords")
public class StandardWord{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="isocode")
	private String code;
	
	@Column(name="country")
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
