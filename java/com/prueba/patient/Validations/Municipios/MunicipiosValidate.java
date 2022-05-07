package com.prueba.patient.Validations.Municipios;

import com.prueba.patient.Models.Municipios.Municipio;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class MunicipiosValidate implements MunicipiosValidation{

    private void Message(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }


    @Override
    public void Validation(Municipio municipio) throws ResourceNotFound {
        if (municipio.getId()==null){
            this.Message("El Campo es Obligatorio,Intente Nuevamente");
        }
        if (municipio.getName()==null){
            this.Message("El Nombre es Obligatorio,Intente Nuevamente");

        }
        if (municipio.getGenero()==null){
            this.Message("El Genero es Obligatorio es Obligatorio,Intente Nuevamente");

        }

    }
}
