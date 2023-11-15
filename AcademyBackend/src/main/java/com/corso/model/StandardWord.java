package com.corso.model;

import javax.persistence.*;

import com.corso.dao.BeanDTO;


@Entity
@Table(name = "ParolaStandard")
public class StandardWord implements BeanDTO{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdParoleStandard")
	private int id;

	@Column(name="cca2")
	private String cca2;
	
	@Column(name="cca3")
	private String cca3;
	
	@Column(name="Difficolta")
	private int difficolta;
	
	public int getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(int difficolta) {
		this.difficolta = difficolta;
	}

	@Column(name="Common")
	private String value;

	public int getId() {
		return id;
	}

	public String getCca2() {
		return cca2;
	}

	public void setCca2(String cca2) {
		this.cca2 = cca2;
	}

	public String getCca3() {
		return cca3;
	}

	public void setCca3(String cca3) {
		this.cca3 = cca3;
	}

	public String getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

}
