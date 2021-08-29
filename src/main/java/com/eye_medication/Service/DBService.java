package com.eye_medication.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Medico;
import com.eye_medication.repositories.MedicoRepository;

@Service
public class DBService {

	@Autowired
	MedicoRepository medicoRepository;

	public void instanciaBaseDados() {
		Medico med1 = new Medico(null, "Lourival", "000.000.000-00", "11111111", "Rua Belem", "05/03/1998", "GO",
				"Juvenesci", "Masculino");
		med1.setCrm(123456);

		Medico med2 = new Medico(null, "Rosana", "111,111,111-11", "84995602", "Rua Fortaleza", "07/08/1987", "SP",
				"Joana", "Feminino");
		med2.setCrm(987654);

		
		medicoRepository.saveAll(Arrays.asList(med1, med2));
	}

}
