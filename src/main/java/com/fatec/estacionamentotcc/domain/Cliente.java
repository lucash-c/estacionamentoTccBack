package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	private String nome;
	private String telefone;
	private String rg;
	private double mensalidade;
	private String vencimento;
	private boolean bloqueado;
	private String observacao;
	
	@JsonIgnore
	@OneToOne(mappedBy="cliente")
	private Movimento movimento;

	public Cliente() {
	}
	
	

	public Cliente(String nome) {
		this.nome = nome;
	}



	public Cliente(int cod, String nome, String telefone, String rg, double mensalidade, String vencimento,
			 String observacao) {
	
		this.cod = cod;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.bloqueado = false;
		this.observacao = observacao;
		
	}

	public Cliente(int cod, String nome, String telefone, String rg, double mensalidade, String vencimento,
			boolean bloqueado, String observacao, Movimento movimento) {
		this.cod = cod;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.bloqueado = bloqueado;
		this.observacao = observacao;
		this.movimento = movimento;
	}	

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return cod == other.cod;
	}
	
	
	
	

	

}
