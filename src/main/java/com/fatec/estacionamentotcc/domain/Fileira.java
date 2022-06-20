package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Fileira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@OneToMany(mappedBy="fileira")
	private List<Vaga> vagas = new ArrayList<>();
	private String descricao;
	private int countComuns;
	private int countPreferencial;
	private int countMensalista;
	private int countDispComuns;
	private int countDispPreferencial;
	private int countDispMensalista;

	public Fileira() {
	}

	public Fileira(String descricao) {
		this.descricao = descricao;
	}	
	
	public Fileira(String descricao, int countComuns, int countPreferencial, int countMensalista) {
		this.descricao = descricao;
		this.countComuns = countComuns;
		this.countPreferencial = countPreferencial;
		this.countMensalista = countMensalista;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public List<Vaga> getVagas() {
		return vagas;
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

	public int getCountComuns() {
		return countComuns;
	}

	public void setCountComuns(int countComuns) {
		this.countComuns = countComuns;
	}

	public int getCountPreferencial() {
		return countPreferencial;
	}

	public void setCountPreferencial(int countPreferencial) {
		this.countPreferencial = countPreferencial;
	}

	public int getCountMensalista() {
		return countMensalista;
	}

	public void setCountMensalista(int countMensalista) {
		this.countMensalista = countMensalista;
	}

	public int getCountDispComuns() {
		return countDispComuns;
	}

	public void setCountDispComuns(int countDispComuns) {
		this.countDispComuns = countDispComuns;
	}

	public int getCountDispPreferencial() {
		return countDispPreferencial;
	}

	public void setCountDispPreferencial(int countDispPreferencial) {
		this.countDispPreferencial = countDispPreferencial;
	}

	public int getCountDispMensalista() {
		return countDispMensalista;
	}

	public void setCountDispMensalista(int countDispMensalista) {
		this.countDispMensalista = countDispMensalista;
	}

}
