package com.prueba.patient.Validations.Departamentos;

import com.prueba.patient.Models.Departamento.Departamento;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class DepartamentosValidate implements DepartamentosValidation{

    private void Message(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }


    @Override
    public void Validate(Departamento departamento)throws ResourceNotFound {
        if (departamento.getId()==null){
            this.Message("El Campo No puede estar Vacio, Intente Nuevamente");
        }
        if (departamento.getDepartamento()==null){
            this.Message("El Nombre No puede estar Vacio, Intente Nuevamente");

        }
        if (departamento.getDepartamento()==null){
            this.Message("El Paciente_Id No puede estar Vacio, Intente Nuevamente");

        }
    }
}
