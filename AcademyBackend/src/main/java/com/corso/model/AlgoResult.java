package com.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.corso.dao.BeanDTO;

@Entity
@Table(name = "AlgoResult")
public class AlgoResult implements Comparable<AlgoResult>, BeanDTO{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAlgoResult")
	private int id;
	
	@Column(name = "WinRate")
	private int winrate;
	
	@ManyToOne()
	@JoinColumn(name="IdAlgoritmo")
	private Algorithm algorithm;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getWinrate() {
		return winrate;
	}



	public void setWinrate(int winrate) {
		this.winrate = winrate;
	}



	public Algorithm getAlgorithm() {
		return algorithm;
	}



	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}



	@Override
	public int compareTo(AlgoResult o) {
		return (this.winrate<o.winrate)?1:-1;
	}

}
