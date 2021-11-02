package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente pacientes;
	
	
	
	@ManyToOne
	@JoinColumn(name="UM_id")
	private UnidadeMedica unidadeMedicas;
	

	
	
	public PacienteUM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PacienteUM(Long id, Date dataMovimentacao, Paciente pacientes, UnidadeMedica unidadeMedicas) {
		super();
		this.id = id;
		this.dataMovimentacao = dataMovimentacao;
		this.pacientes = pacientes;
		this.unidadeMedicas = unidadeMedicas;
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

	public Paciente getPacientes() {
		return pacientes;
	}

	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}

	public UnidadeMedica getUnidadeMedicas() {
		return unidadeMedicas;
	}

	public void setUnidadeMedicas(UnidadeMedica unidadeMedicas) {
		this.unidadeMedicas = unidadeMedicas;
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
