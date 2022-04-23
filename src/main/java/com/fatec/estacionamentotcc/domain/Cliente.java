package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int codigo;
	String nome;
	String telefone;
	String rg;
	double mensalidade;
	String vencimento;
	boolean bloqueado;
	String observacao;

	public Cliente(String nome, String telefone, String rg, double mensalidade, String vencimento, boolean bloqueado,
			String observacao) {
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.bloqueado = bloqueado;
		this.observacao = observacao;
	}

	public Cliente(int codigo, String nome, String telefone, String rg, double mensalidade, String vencimento,
			boolean bloqueado, String observacao) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.bloqueado = bloqueado;
		this.observacao = observacao;
	}

	public Cliente(int codigo, String nome, String telefone, String rg, double mensalidade, String vencimento,
			boolean bloqueado) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.bloqueado = bloqueado;
	}

	public Cliente(String nome, String telefone, String rg, double mensalidade, String vencimento, String observacao) {
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.mensalidade = mensalidade;
		this.vencimento = vencimento;
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, rg);
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
		return codigo == other.codigo && Objects.equals(rg, other.rg);
	}

}
