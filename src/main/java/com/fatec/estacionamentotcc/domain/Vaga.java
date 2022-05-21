package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int estado; // 1 para ocupado - 0 para desocupado
	private String tipo;
	
	@JsonIgnore
	@OneToOne(mappedBy="vaga")
	private Ticket ticket;
	
	@JsonIgnore
	@OneToOne(mappedBy="vaga")
	private Movimento movimento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fileira_id")
	private Fileira fileira;
	private int indexFileira;

	public Vaga() {

	}

	public Vaga(String tipo, Fileira fileira) {
		this.tipo = tipo;
		this.fileira = fileira;
	}

	public Vaga(int id, int estado, String tipo, Fileira fileira, int indexFileira) {
		this.id = id;
		this.estado = estado;
		this.tipo = tipo;
		this.fileira = fileira;
		this.indexFileira = indexFileira;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Fileira getFileira() {
		return fileira;
	}

	public void setFileira(Fileira fileira) {
		this.fileira = fileira;
	}

	public int getIndexFileira() {
		return indexFileira;
	}

	public void setIndexFileira(int indexFileira) {
		this.indexFileira = indexFileira;
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
		Vaga other = (Vaga) obj;
		return id == other.id;
	}



	public Ticket getTicket() {
		return ticket;
	}



	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	

}
