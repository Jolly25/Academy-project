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
@Table(name = "Segnalazione")
public class Segnalazione implements BeanDTO{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdSegnalazione")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="IdUser")
	private User idUser;
	
	@ManyToOne()
	@JoinColumn(name="IdMatch")
	private Match match;

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

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
