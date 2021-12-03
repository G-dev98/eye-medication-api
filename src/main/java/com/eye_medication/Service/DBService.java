package com.eye_medication.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Doenca;
import com.eye_medication.domain.Medico;
import com.eye_medication.domain.Paciente;
import com.eye_medication.domain.PacienteUM;
import com.eye_medication.domain.UnidadeMedica;
import com.eye_medication.repositories.DoencaRepository;
import com.eye_medication.repositories.MedicoRepository;
import com.eye_medication.repositories.PacienteRepository;
import com.eye_medication.repositories.PacienteUMRepository;
import com.eye_medication.repositories.UnidadeMedicaRepository;

@Service
public class DBService {

	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	DoencaRepository doencaRepository;
	
	@Autowired
	UnidadeMedicaRepository umRepository;
	
	@Autowired
	PacienteUMRepository pcUMRepository;

	public void instanciaBaseDados() throws ParseException{
		Medico med1 = new Medico(null, "Lourival", "000.000.000-00", "11111111", "Rua Belem", "05/03/1998", "GO",
				"Juvenesci", "Masculino");
		med1.setCrm(123456);

		Medico med2 = new Medico(null, "Rosana", "111,111,111-11", "84995602", "Rua Fortaleza", "07/08/1987", "SP",
				"Joana", "Feminino");
		med2.setCrm(987654);

		Medico med3 = new Medico(null, "Babi", "000.000.000-00", "11111111", "Rua Belem", "05/03/1998", "GO",
				"Juvenesci", "Feminino");
		med3.setCrm(34567);
		
		medicoRepository.saveAll(Arrays.asList(med1, med2,med3));
		
		Doenca doe1 = new Doenca(null,"Rinite alergica","Alergia a poeira");
		Doenca doe2 = new Doenca(null,"Gripe","Reação de febre,nariz escorrendo,espirros");
		Doenca doe3 = new Doenca(null,"Alergia a dipirona","Reação alergica ao medicamento");
		
		
		
		doencaRepository.saveAll(Arrays.asList(doe1,doe2,doe3));
		
		Paciente pac1 = new Paciente(null, "Lourival", "000.000.000-00", "11111111", "Rua Belem", "05/03/1998", "GO",
				"Juvenesci", "Masculino", "internado");
		Paciente pac2 = new Paciente(null, "Mariana", "000.000.000-00", "222222222", "Rua Belem", "15/11/1987", "GO",
				"Juvenesci", "Feminino", "internado");
		
		
		
		pac1.setDoencas(Arrays.asList(doe1,doe2,doe3));
		pac2.setDoencas(Arrays.asList(doe1));
		
	
		pacienteRepository.saveAll(Arrays.asList(pac1,pac2));
		
		UnidadeMedica um1 = new UnidadeMedica(null,"UTI",2,2);
		
		
		umRepository.saveAll(Arrays.asList(um1));
		
		PacienteUM pac_um1 = new PacienteUM(null,new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2021") ,pac1,um1);
		//PacienteUM pac_um2 = new PacienteUM(null,new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2021") ,pac2,um1);
		
		pcUMRepository.save(pac_um1);
		//pcUMRepository.save(pac_um2);
		
		
	}

}
