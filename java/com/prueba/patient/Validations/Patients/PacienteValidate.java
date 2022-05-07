package com.prueba.patient.Validations.Patients;

import com.prueba.patient.Models.Patients.Paciente;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class PacienteValidate implements PacienteValidation {

    private void Message(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }


    @Override
    public void Validate(Paciente paciente) throws ResourceNotFound {
        if (paciente.getTipoDocumentoId()==null){
            this.Message("El Tipo De Documento Es Obligatorio");
        }
        if (paciente.getFirstName()==null){
            this.Message("El Primer Nombre Es Obligatorio");

        }
        if (paciente.getSecondName()==null){
            this.Message("El Segundo Nombre Es Obligatorio");

        }
        if (paciente.getFirstLastName()==null){
            this.Message("El Primer Apellido Es Obligatorio");

        }
        if (paciente.getSecondLastName()==null){
            this.Message("El Segundo Apellido es Obligatorio");
        }
        if (paciente.getNumeroDocumento()==0){
            this.Message("Rellene Todos Los Campos");
        }

    }
}
