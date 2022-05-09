package com.prueba.patient.Service;

import com.prueba.patient.Models.Patients.Paciente;
import com.prueba.patient.Models.Users.User;
import com.prueba.patient.Repository.Patients.PacienteJpa;
import com.prueba.patient.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PacienteJpa pacienteJpa;


    public List<User>getList(){
        return userRepository.findAll();
    }

    public User getUserId(Integer id){
        return userRepository.findById(id).get();
    }

    public void SaveUser(User user){
        userRepository.save(user);
    }

    public void DeleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public Paciente getPacienteId(Integer id){
        return pacienteJpa.findById(id).get();
    }

}
