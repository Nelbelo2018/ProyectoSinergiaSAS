package com.prueba.patient.Validations.Users;

import com.prueba.patient.Models.Users.User;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface UserValidation {

    public void Validation(User user)throws ResourceNotFound;
}
