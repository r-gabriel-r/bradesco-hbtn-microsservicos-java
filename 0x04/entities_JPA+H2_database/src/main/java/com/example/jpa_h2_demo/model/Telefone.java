package com.example.jpa_h2_demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Telefone {
	
	@Id
	private long id;
	
	private int DDD;
	
	private int numero;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int dDD) {
		DDD = dDD;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
