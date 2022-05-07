package com.prueba.patient.Controller.Login;

import com.prueba.patient.DAO.UserDAO;
import com.prueba.patient.Models.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioSesionController {

    @RequestMapping(value = "api/login")
    public String inicioSesion(){
        return "api/login";
    }

    @Autowired
    UserDAO userDAO;


    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        if (userDAO.verificarCredenciales(user)){
            return "OK";
        }
        return "FAIL";
    }


}
