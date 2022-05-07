package com.prueba.patient.Validations.Patients;

import com.prueba.patient.Models.Patients.Paciente;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface PacienteValidation {

    public void Validate(Paciente paciente)throws ResourceNotFound;
}
