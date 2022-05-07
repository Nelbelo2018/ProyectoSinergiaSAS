package com.prueba.patient.Validations.Users;

import com.prueba.patient.Models.Users.User;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class UserValidate implements UserValidation{

    private void Message(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }

    @Override
    public void Validation(User user) throws ResourceNotFound {
        if (user.getName()==null){
            this.Message("El Nombre Es Obligatorio,Intente Nuevamente");
        }
        if (user.getLastName()==null){
            this.Message("El Apellido Es Obligatorio,Intente Nuevamente");

        }
        if (user.getDocumento()==0){
            this.Message("Rellene Todos Los Campos");

        }
        if (user.getContraseña()==null){
            this.Message("La Contraseña Es Obligatoria,Intente Nuevamente");

        }
    }
}
