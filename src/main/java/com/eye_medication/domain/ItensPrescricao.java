package com.eye_medication.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property= "id")	
public class ItensPrescricao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private  String indicacao;
	
	
	//@JsonIgnore
	//private Prescricao prescricao;
	
	@ManyToOne//(cascade = {CascadeType.ALL})
	private Medicamento medicamento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Prescricao prescricao;
	
	
	public ItensPrescricao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	





	public ItensPrescricao(Long id, Prescricao prescricao) {
		super();
		this.id = id;
		this.prescricao = prescricao;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	
	public Prescricao getPrescricao() {
		return prescricao;
	}



	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
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
		ItensPrescricao other = (ItensPrescricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
