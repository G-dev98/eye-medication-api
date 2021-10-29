package com.eye_medication.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.eye_medication.domain.Paciente;

public class PacienteDTO {
	
	@NotEmpty(message = "Campo CPF é obrigatorio")
	@Length(min = 11, max = 11, message = "Campo CPF precisa ter no máximo 11 caracteres")
	private String cpf;
	private String nome;
	private Integer id;
	
	public PacienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PacienteDTO(
			@NotEmpty(message = "Campo CPF é obrigatorio") @Length(min = 11, max = 11, message = "Campo CPF precisa ter no máximo 11 caracteres") Paciente paciente) {
		super();
		this.cpf = paciente.getCpf();
		this.nome = paciente.getNome();
		this.id = paciente.getId();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	 
	
}
