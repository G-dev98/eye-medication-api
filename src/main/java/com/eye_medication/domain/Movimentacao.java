package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "Movimentacao")
public class Movimentacao implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataMovimentacao;
	
	
	private String tipo;
	
	@ManyToOne
	private Paciente paciente;
	@ManyToOne
	private UnidadeMedica UM;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	/*@JoinTable(name = "historico", uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_movimentacao",
	"id_prontuario" }), joinColumns = @JoinColumn(name = "codigo_movimentacao"), inverseJoinColumns = @JoinColumn(name = " id_prontuario"))
	*/private Prontuario prontuario;
	
	
	public Movimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movimentacao(Long id, Date dataEntrada,String tipo, Paciente paciente, UnidadeMedica uM,Prontuario prontuario) {
		super();
		this.id = id;
		this.dataMovimentacao = dataEntrada;
		this.tipo = tipo;
		this.paciente = paciente;
		this.UM = uM;
		this.prontuario = prontuario;
	}
	
	
	

	
	
	/*public List<Prontuario> getProntuario() {
		return prontuario;
	}

	public void setProntuario(List<Prontuario> prontuario) {
		this.prontuario = prontuario;
	}*/

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataMovimentacao;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataMovimentacao = dataEntrada;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public UnidadeMedica getUM() {
		return UM;
	}

	public void setUM(UnidadeMedica uM) {
		UM = uM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	
}
