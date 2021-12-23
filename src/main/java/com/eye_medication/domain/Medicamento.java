package com.eye_medication.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Medicamento")
public class Medicamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String fabricante;
	private Long registro_MS;
	private String composição;
	
	@JsonIgnore
	@OneToMany(mappedBy="medicamento")
	private List<ItensPrescricao> itensPrescricao;
	
	
	public Medicamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Medicamento(Long id, String nome, String fabricante, Long registroMS, String composição) {
		super();
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.registro_MS = registroMS;
		this.composição = composição;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Long getRegistroMS() {
		return registro_MS;
	}
	public void setRegistroMS(Long registroMS) {
		this.registro_MS = registroMS;
	}
	public String getComposição() {
		return composição;
	}
	public void setComposição(String composição) {
		this.composição = composição;
	}
	
	
	
	
	public List<ItensPrescricao> getItensPrescricao() {
		return itensPrescricao;
	}



	public void setItensPrescricao(List<ItensPrescricao> itensPrescricao) {
		this.itensPrescricao = itensPrescricao;
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
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
