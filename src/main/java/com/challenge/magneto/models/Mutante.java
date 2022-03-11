package com.challenge.magneto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "mutantes")
public class Mutante {
	
	@Id @Column(name = "id")
	private long id;
	
	@Column(name = "dna")
	private String [] dna;
	
	@Column(name = "mutante")
	private int mutante;

	public String [] getDna() {
		return dna;
	}

	public void setDna(String [] dna) {
		this.dna = dna;
	}

	public int getMutante() {
		return mutante;
	}

	public void setMutante(int mutante) {
		this.mutante = mutante;
	}
	
	public long getId() {
		return id;
	}


	

}
