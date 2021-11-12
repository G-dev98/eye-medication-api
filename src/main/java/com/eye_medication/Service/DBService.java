package com.eye_medication.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Doenca;
import com.eye_medication.domain.Medico;
import com.eye_medication.domain.Paciente;
import com.eye_medication.repositories.DoencaRepository;
import com.eye_medication.repositories.MedicoRepository;
import com.eye_medication.repositories.PacienteRepository;

@Service
public class DBService {

	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	DoencaRepository doencaRepository;

	public void instanciaBaseDados(){
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
		pac1.setDoenca(Arrays.asList(doe1,doe2));
		
		pacienteRepository.saveAll(Arrays.asList(pac1));
	}

}
