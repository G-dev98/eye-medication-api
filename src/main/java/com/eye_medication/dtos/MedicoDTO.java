package com.eye_medication.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.eye_medication.domain.Medico;

public class MedicoDTO {

	/**
	 * 
	 */
	@NotEmpty(message = "Campo CRM é obrigatorio")
	@Length(min = 5, max = 100, message = "Campo CRM precisa ter no máximo 100 caracteres")
	private Integer crm;
	private String nome;

	public MedicoDTO(
			@Length(min = 0, max = 100, message = "Campo CRM precisa ter no máximo 100 caracteres") Medico medico) {
		super();
		this.crm = medico.getCrm();
		this.nome = medico.getNome();
	}

	public MedicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCrm() {
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}

}
