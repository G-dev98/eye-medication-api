package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="PacienteUM")
public class PacienteUM implements Serializable{

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
	
	
	
	//@ManyToOne
	@OneToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	
	//@ManyToOne
	@OneToOne
	@JoinColumn(name="UM_id")
	private UnidadeMedica unidadeMedica;
	

	
	
	public PacienteUM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PacienteUM(Long id, Date dataMovimentacao, Paciente paciente, UnidadeMedica unidadeMedica) {
		super();
		this.id = id;
		this.dataMovimentacao = dataMovimentacao;
		this.paciente = paciente;
		this.unidadeMedica = unidadeMedica;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente pacientes) {
		this.paciente = pacientes;
	}

	public UnidadeMedica getUnidadeMedica() {
		return unidadeMedica;
	}

	public void setUnidadeMedica(UnidadeMedica unidadeMedicas) {
		this.unidadeMedica = unidadeMedicas;
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
		PacienteUM other = (PacienteUM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
