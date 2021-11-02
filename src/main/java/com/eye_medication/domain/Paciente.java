package com.eye_medication.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name="Paciente")
public class Paciente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String dataNascimento;
	private String naturalidade;
	private String nomeMae;
	private String sexo;
	private String status;

	@OneToMany(mappedBy="pacientes")
	//@JoinColumn(name="doenca_id")
	private List <Doenca> doenca = new ArrayList<>();
	
	@OneToMany(mappedBy="pacientes")
	private List<PacienteUM> pUM = new ArrayList<>();


	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Paciente(Integer id, String nome, String cpf, String telefone, String endereco, String dataNascimento,
			String naturalidade, String nomeMae, String sexo, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.nomeMae = nomeMae;
		this.sexo = sexo;
		this.status = status;
		
	}







	public List<PacienteUM> getpUM() {
		return pUM;
	}



	public void setpUM(List<PacienteUM> pUM) {
		this.pUM = pUM;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	


	public List<Doenca> getDoenca() {
		return doenca;
	}



	public void setDoenca(List<Doenca> doenca) {
		this.doenca = doenca;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
