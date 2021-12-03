package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Tipo_De_Movimentacao")
public class TipoDeMovimentacao implements Serializable {
	

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


	
	




	public TipoDeMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoDeMovimentacao(Long id, Date dataEntrada, String tipo, Paciente paciente, UnidadeMedica uM) {
		super();
		this.id = id;
		this.dataMovimentacao = dataEntrada;
		this.tipo = tipo;
		this.paciente = paciente;
		UM = uM;
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
		TipoDeMovimentacao other = (TipoDeMovimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	
}
