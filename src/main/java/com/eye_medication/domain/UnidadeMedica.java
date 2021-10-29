package com.eye_medication.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name="UnidadeMedica")
public class UnidadeMedica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	private Integer nQuarto;
	private String status;
	private Integer nCama;
	
	private Paciente paciente;

	
	
	
	public UnidadeMedica() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UnidadeMedica(Long id, String tipo, Integer nQuarto, String status, Integer nCama, Paciente paciente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nQuarto = nQuarto;
		this.status = status;
		this.nCama = nCama;
		this.paciente = paciente;
	}
	
	

	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Integer getnCama() {
		return nCama;
	}



	public void setnCama(Integer nCama) {
		this.nCama = nCama;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getnQuarto() {
		return nQuarto;
	}

	public void setnQuarto(Integer nQuarto) {
		this.nQuarto = nQuarto;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(Paciente paciente) {
		
		if(paciente!=null) {
			this.status = "Ocupado";
		}else {
			this.status = "Livre";
		}	
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
		UnidadeMedica other = (UnidadeMedica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
