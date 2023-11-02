package com.corso.model;

import javax.persistence.*;

import com.corso.checkstring.AlgorithmType;

@Entity
@Table(name = "Algoritmo")
public class Algorithm{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAlgoritmo")
	private int id;
	
	@Column(name="Nome")
	@Enumerated(EnumType.STRING)
	private AlgorithmType algorithm;

	public Algorithm() {}
	
	public Algorithm(AlgorithmType name) {
		algorithm = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlgorithmType getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(AlgorithmType algorithm) {
		this.algorithm = algorithm;
	}
	
	public String toString() {
		return algorithm.toString();
	}

	public boolean equals(Object o) {
		if(!(o instanceof Algorithm)) return false;
		Algorithm a = (Algorithm) o;
		if(this.algorithm.equals(a.algorithm)) return true;
		return false;
	}
	
}
