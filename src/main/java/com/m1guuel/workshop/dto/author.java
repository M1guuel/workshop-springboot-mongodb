package com.m1guuel.workshop.dto;

import java.io.Serializable;

import com.m1guuel.workshop.domain.User;

public class author  implements Serializable{
	private String id;
	private String nome;

	public author() {

	}

	public author(User obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
