package com.corso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.corso.dao.BeanDTO;

@Entity
@Table(name = "Risultato")
public class Risultato implements BeanDTO{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdRisultato")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="IdUser")
	private User idUser;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="IdBandiereRisultato")
	private List<BandiereRisultato> bandiereDaIndovinare;
	
	@Column(name = "BandiereIndovinate")
	private int score;
	
	@Column(name = "BandiereViste")
	private int bandiereViste;
	
	public Risultato() {};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBandiereViste() {
		return bandiereViste;
	}

	public void setBandiereViste(int bandiereViste) {
		this.bandiereViste = bandiereViste;
	}

	public List<BandiereRisultato> getBandiereDaIndovinare() {
		return bandiereDaIndovinare;
	}

	public void setBandiereDaIndovinare(List<BandiereRisultato> bandiereDaIndovinare) {
		this.bandiereDaIndovinare = bandiereDaIndovinare;
	}
	
	

}
