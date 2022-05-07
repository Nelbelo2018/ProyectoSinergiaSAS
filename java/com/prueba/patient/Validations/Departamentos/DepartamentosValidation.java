package com.prueba.patient.Validations.Departamentos;

import com.prueba.patient.Models.Departamento.Departamento;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface DepartamentosValidation {

    public void Validate(Departamento departamento)throws ResourceNotFound;
}
