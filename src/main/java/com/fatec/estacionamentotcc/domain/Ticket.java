package com.fatec.estacionamentotcc.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



/**
 * esta classe vai gerenciar os serviÃ§os prestados pelo estacionamento
 *
 * @author lucas
 */
@Entity
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String serial;
	private Date chegada;
	private Date saida;
	private int permanencia;
	private double valor;
	private String tipoVaga;
	private boolean bloqueado;
	private String tipoPagamento;
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	

	@OneToOne
	@JoinColumn(name="vaga_id")
	private Vaga vaga;
	

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Ticket() {
	}
	
	public void setPermanencia(int permanencia) {
		this.permanencia = permanencia;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(String chegada) {
		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		try {
			this.saida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(saida);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}
	}



	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}



	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getPermanencia() {
		return permanencia;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getVagaId() {

		return vaga.getId();

	}

	public int getUsuarioId() {

		return usuario.getId();

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
		Ticket other = (Ticket) obj;
		return id == other.id;
	}

	public String getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

}
