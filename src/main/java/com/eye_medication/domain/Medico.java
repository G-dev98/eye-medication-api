package com.eye_medication.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name = "Medico")
public class Medico extends Pessoa {
	
	private Integer crm;

	public Medico(Integer crm) {
		super();
		this.crm = crm;
	}

	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(Integer id, String nome, String cpf, String telefone, String endereco, String dataNascimento,
			String naturalidade, String nomeMae, String sexo) {
		super(id, nome, cpf, telefone, endereco, dataNascimento, naturalidade, nomeMae, sexo);
		// TODO Auto-generated constructor stub
	}

	public Integer getCrm() {
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}

}
