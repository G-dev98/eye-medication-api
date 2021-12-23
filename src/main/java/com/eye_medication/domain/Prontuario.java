package com.eye_medication.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Prontuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property= "id")
public class Prontuario implements Serializable {

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

	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	
	/*@OneToMany(mappedBy = "prontuario")
	private List<Movimentacao> listaMovimentacao; (mappedBy = "prontuario" )*/

	
	@OneToMany(mappedBy="prontuario")
	/*@JoinTable(name = "historico", uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_movimentacao",
	"id_prontuario" }), joinColumns = @JoinColumn(name = "id_prontuario"), inverseJoinColumns = @JoinColumn(name = "codigo_movimentacao"))
	*/private List<Movimentacao> listaMovimentacao;
	
	
	@OneToMany(mappedBy="prontuario")
	//@JoinColumn(name = "prescricao_id")
	private List<Prescricao> prescricao;
	
	public Prontuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Prontuario(Long id, Date dataCriacao, Paciente paciente) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.paciente = paciente;
	}



	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}



	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}



	/*public Movimentacao getMovimentacao() {
		return movimentacao;
	}



	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}*/



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	
	
	public Date getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}



	public List<Prescricao> getPrescricao() {
		return prescricao;
	}



	public void setPrescricao(List<Prescricao> prescricao) {
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
		Prontuario other = (Prontuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
