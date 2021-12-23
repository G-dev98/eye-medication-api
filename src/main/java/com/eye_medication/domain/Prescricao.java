package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Prescricao")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property= "id")
public class Prescricao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	
	@OneToMany(mappedBy="prescricao")
	@JsonManagedReference
	private List<ItensPrescricao> itensPrescricao;

	@ManyToOne
	private Prontuario prontuario;
	
	
	
	public Prescricao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Prescricao(Long id,Prontuario prontuario,Date dataCriacao) {
		super();
		this.id = id;
		this.prontuario = prontuario;
		this.dataCriacao = dataCriacao;
		
	}



	public Date getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItensPrescricao> getItensPrescricao() {
		return itensPrescricao;
	}

	public void setItensPrescricao(List<ItensPrescricao> itensPrescricao) {
		this.itensPrescricao = itensPrescricao;
	}

	
	
	public Prontuario getProntuario() {
		return prontuario;
	}



	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
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
		Prescricao other = (Prescricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
