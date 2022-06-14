package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date horaChegada;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date horaSaida;
	private double valor;
	private int pagamento; // 0 - dinheiro / 1 - cartao / 2 - pix / 3- mensalista

	@OneToOne
	@JoinColumn(name = "vaga_id")
	private Vaga vaga;
	

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Movimento() {

	}
	
	public Movimento(Vaga vaga, double valor, Usuario usuario,
			int pagamento) {
		this.vaga = vaga;
		this.valor = valor;
		this.usuario = usuario;
		this.pagamento = pagamento;
	}

	public Movimento(int id, Date horaChegada, Date horaSaida, Vaga vaga, double valor, Usuario usuario,
			int pagamento) {
		this.id = id;
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.vaga = vaga;
		this.valor = valor;
		this.usuario = usuario;
		this.pagamento = pagamento;
	}

	public Movimento(Date horaChegada, Date horaSaida, Vaga vaga, Cliente cliente, double valor,
			Usuario usuario, int pagamento) {
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.vaga = vaga;
		this.cliente = cliente;
		this.valor = valor;
		this.usuario = usuario;
		this.pagamento = pagamento;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
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
		Movimento other = (Movimento) obj;
		return id == other.id;
	}

}
