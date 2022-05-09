package com.prueba.patient.Controller.Users;

import com.prueba.patient.Models.Users.User;
import com.prueba.patient.Service.UserService;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import com.prueba.patient.Validations.Users.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/usuario")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidate userValidate;

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>saveUsers(@RequestBody User user)throws ResourceNotFound{
        Map<String,Object>response=new HashMap<>();
        this.userValidate.Validation(user);
        this.userService.SaveUser(user);
        response.put("Mensaje","Usuario Registrado ".concat(user.toString()));
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
