package com.prueba.patient.Controller.Patients;



import com.prueba.patient.Models.Departamento.Departamento;
import com.prueba.patient.Models.Patients.Paciente;
import com.prueba.patient.Repository.Patients.PacienteRepository;
import com.prueba.patient.Service.UserService;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import com.prueba.patient.Validations.Patients.PacienteValidate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "api/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteValidate pacienteValidate;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "pacientes",method = RequestMethod.GET)
    public ResponseEntity<Collection<Paciente>>listarPacientes(){
        return new ResponseEntity<>(pacienteRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "paciente/{id}",method = RequestMethod.GET)
    public ResponseEntity<Paciente>getPacienteId(@PathVariable Integer id){
        Paciente paciente=pacienteRepository.findById(id).orElseThrow();
        if (paciente!= null){
            return new ResponseEntity<>(pacienteRepository.findById(id).orElseThrow(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "Update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object>UpdatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
        Map<String, Object>response=new HashMap<>();
        try {
            Paciente UpdatePaciente=userService.getPacienteId(id);
            pacienteRepository.save(paciente);
            response.put("Mensaje","El Paciente Ha Sido Actualizado ".concat(id.toString()));
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception exception){
            response.put("Mensaje","No se pudo actualizar el Paciente ".concat(id.toString()));
            return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SavePaciente(@RequestBody Paciente paciente)throws ResourceNotFound {
        Map<String,Object>Response=new HashMap<>();
        this.pacienteValidate.Validate(paciente);
        this.pacienteRepository.save(paciente);
        Response.put("Mensaje","El Paciente Ha Sido Registrado con Exito ".concat(paciente.toString()));
        return new ResponseEntity<>(Response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "Delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeletePaciente(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            pacienteRepository.deleteById(id);
            response.put("Mensaje","Este Paciente Ha sido Eliminado del sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","El Paciente No Se Ha podido Eliminar ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{id}/departamentos",method = RequestMethod.GET)
    public ResponseEntity<Collection<Departamento>>listarDepartamentosPaciente(@PathVariable Integer id){
        Paciente paciente=pacienteRepository.findById(id).orElseThrow();
        if (paciente!= null){
            return new ResponseEntity<>(paciente.getDepartamentos(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


}
