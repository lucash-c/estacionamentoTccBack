package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	// private int id;
	private String modelo;
	private String cor;
	private String placa;
	private String tipo;
	private String observacao;

	public Veiculo(String modelo, String cor, String placa, String tipo, String observacao) {
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
		this.observacao = observacao;
	}

	public Veiculo(String modelo, String cor, String placa, String tipo) {
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(placa, other.placa);
	}

}