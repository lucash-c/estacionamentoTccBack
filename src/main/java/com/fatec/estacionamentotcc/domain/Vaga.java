package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int indexFileira;
	private int estado; // 1 para ocupado - 0 para desocupado
	private String tipo;
	private int fileiraId;

	public Vaga(int fileiraId) {
		this.fileiraId = fileiraId;
	}

	public Vaga(int id, int indexFileira, int estado, String tipo, int fileiraId) {
		this.id = id;
		this.indexFileira = indexFileira;
		this.estado = estado;
		this.tipo = tipo;
		this.fileiraId = fileiraId;
	}

	public Vaga(int id, int indexFileira, String tipo, int fileiraId) {
		this.id = id;
		this.indexFileira = indexFileira;
		this.tipo = tipo;
		this.fileiraId = fileiraId;
	}

	public Vaga(int id, int fileiraId) {
		this.id = id;
		this.fileiraId = fileiraId;
	}

	public Vaga(String tipo, int fileiraId, int id) {
		this.id = id;
		this.tipo = tipo;
		this.fileiraId = fileiraId;
	}

	public Vaga(String tipo, int fileiraId) {

		this.tipo = tipo;
		this.fileiraId = fileiraId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFileiraId() {
		return fileiraId;
	}

	public int getIndexFileira() {
		return indexFileira;
	}

	public void setIndexFileira(int indexFileira) {
		this.indexFileira = indexFileira;
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

	@Override
	public int hashCode() {
		return Objects.hash(fileiraId, id);
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
		return fileiraId == other.fileiraId && id == other.id;
	}

}
