package com.prueba.patient.Validations.Municipios;

import com.prueba.patient.Models.Municipios.Municipio;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface MunicipiosValidation {

    public void Validation(Municipio municipio)throws ResourceNotFound;
}
