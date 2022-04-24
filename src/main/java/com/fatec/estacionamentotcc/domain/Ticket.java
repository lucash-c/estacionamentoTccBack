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
	private int cod;
	private Date chegada;
	private Date saida;
	private int permanencia;
	private double valor;
	private double valorHora;

	private Vaga vaga;
	private Usuario usuario;

	public Ticket() {
	}

	public Ticket(int cod) {
		this.cod = cod;
	}

	public Ticket(int cod, String chegada, int permanencia, double valor, double valorHora, Vaga vaga,
			Usuario usuario) {
		this.cod = cod;
		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.permanencia = permanencia;
		this.valor = valor;
		this.valorHora = valorHora;
		this.vaga = vaga;
		this.usuario = usuario;
	}

	public Ticket(Vaga vaga, Usuario usuario, String chegada, String saida) {
		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			this.saida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(saida);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.vaga = vaga;
		this.usuario = usuario;
	}

	public Ticket(String chegada, String saida, int permanencia) {

		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			this.saida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(saida);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.permanencia = permanencia;
	}

	public Ticket(int cod, String chegada, String saida, int permanencia, double valor, double valorHora, Vaga vaga,
			Usuario usuario) {
		this.cod = cod;
		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			this.saida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(saida);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.permanencia = permanencia;
		this.valor = valor;
		this.valorHora = valorHora;
		this.vaga = vaga;
		this.usuario = usuario;

	}

	public Ticket(String chegada, Vaga vaga, Usuario usuario) {

		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.vaga = vaga;
		this.usuario = usuario;
	}

	public Ticket(String chegada, Vaga vaga) {

		this.vaga = vaga;
		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Ticket(String chegada, Vaga vaga, Cliente cliente) {

		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.vaga = vaga;
	}

	public Ticket(String chegada, Vaga vaga, String saida) {

		try {
			this.chegada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(chegada);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			this.saida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(saida);
		} catch (ParseException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.vaga = vaga;

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

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
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

	public String getDataHoraChegadaFormatada() {

		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(chegada);

	}

	public String getDiaChegadaFormatada() {

		return new SimpleDateFormat("dd-MM-yyyy").format(chegada);

	}

	public String getHoraChegadaFormatada() {
		return new SimpleDateFormat("HH:mm:ss").format(chegada);
	}

	public void imprime(Ticket ticket) {

	}

	public String getDiaSaidaFormatada() {
		return new SimpleDateFormat("dd-MM-yyyy").format(saida);
	}

	public String getDataHoraSaidaFormatada() {

		if (saida != null) {
			return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(saida);
		} else {
			return "";

		}
	}

	public String getHoraSaidaFormatada() {

		if (saida != null) {

			return new SimpleDateFormat("HH:mm:ss").format(saida);
		} else {

			return "";

		}
	}

	public int getVagaId() {

		return vaga.getId();

	}

	public int getUsuarioId() {

		return usuario.getId();

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
		Ticket other = (Ticket) obj;
		return cod == other.cod;
	}

}
