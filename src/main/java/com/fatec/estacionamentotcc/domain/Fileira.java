package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Fileira implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Vaga> vagas;
	private String descricao;
	private int id;

	public Fileira(ArrayList<Vaga> vagas, String descricao) {
		this.vagas = vagas;
		this.descricao = descricao;

	}

	public Fileira(ArrayList<Vaga> vagas, int id) {
		this.vagas = vagas;
		this.id = id;
	}

	public Fileira(ArrayList<Vaga> vagas, int id, String descricao) {
		this.vagas = vagas;
		this.descricao = descricao;
		this.id = id;
	}

	public Fileira(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fileira other = (Fileira) obj;
		return id == other.id;
	}

}
