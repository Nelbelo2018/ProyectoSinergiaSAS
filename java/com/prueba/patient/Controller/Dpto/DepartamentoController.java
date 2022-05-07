package com.prueba.patient.Controller.Dpto;

import com.prueba.patient.Models.Departamento.Departamento;
import com.prueba.patient.Repository.Departamento.DepartamentoRepository;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import com.prueba.patient.Validations.Departamentos.DepartamentosValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/departamento")
public class DepartamentoController {

     @Autowired
    private DepartamentoRepository departamentoRepository;

     @Autowired
     private DepartamentosValidate departamentosValidate;

    @RequestMapping(value = "List",method = RequestMethod.GET)
    public ResponseEntity<Collection<Departamento>> listarDepartamentos(){
        return new ResponseEntity<>(departamentoRepository.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "departamento/{id}",method = RequestMethod.GET)
    public ResponseEntity<Departamento>getDepartamentoId(@PathVariable Integer id){
        Departamento departamento=departamentoRepository.findById(id).orElseThrow();
        if (departamento!= null){
            return new ResponseEntity<>(departamentoRepository.findById(id).orElseThrow(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveDepartamento(@RequestBody Departamento departamento)throws ResourceNotFound {
        Map<String ,Object>response=new HashMap<>();
        this.departamentosValidate.Validate(departamento);
        this.departamentoRepository.save(departamento);
        response.put("Mensaje","El Departamento Ha Sido Registrado ");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "Delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteDepartamento(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            departamentoRepository.deleteById(id);
            response.put("Mesnaje","El Departamento Ha sido Eliminado con Exito ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","El Departamento No Se Ha podido Eliminar ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

    }

}
