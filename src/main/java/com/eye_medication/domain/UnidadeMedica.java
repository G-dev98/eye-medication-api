package com.eye_medication.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	//private Paciente paciente;
	
	@JsonIgnore
	@OneToOne(mappedBy="unidadeMedica")
	//@JsonIgnore
	private PacienteUM pUM ;

	@JsonIgnore
	@OneToMany(mappedBy="UM")
	private List<Movimentacao> movimentacaoUM;
	
	
	public UnidadeMedica() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UnidadeMedica(Long id, String tipo, Integer nQuarto, Integer nCama) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nQuarto = nQuarto;
		this.nCama = nCama;
	}



	
	/*public List<PacienteUM> getpUM() {
		return pUM;
	}


	public void setpUM(List<PacienteUM> pUM) {
		this.pUM = pUM;
	}*/


	/*public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}*/


	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getnCama() {
		return nCama;
	}



	public List<Movimentacao> getMovimentacaoUM() {
		return movimentacaoUM;
	}


	public void setMovimentacaoUM(List<Movimentacao> movimentacaoUM) {
		this.movimentacaoUM = movimentacaoUM;
	}


	public PacienteUM getpUM() {
		return pUM;
	}


	public void setpUM(PacienteUM pUM) {
		this.pUM = pUM;
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

	
	/*public String getStatus() {
		return status;
	}

	public void setStatus(Paciente paciente) {
		
		if(paciente!=null) {
			this.status = "Ocupado";
		}else {
			this.status = "Livre";
		}	
	}*/

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
