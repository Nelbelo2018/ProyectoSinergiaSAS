package com.prueba.patient.Controller.Municipio;

import com.prueba.patient.Models.Municipios.Municipio;
import com.prueba.patient.Repository.Municipio.MunicipioRepository;
import com.prueba.patient.Util.Exceptions.ResourceNotFound;
import com.prueba.patient.Validations.Municipios.MunicipiosValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private MunicipiosValidate municipiosValidate;


    @RequestMapping(value = "List",method = RequestMethod.GET)
    public ResponseEntity<Collection<Municipio>> listarMunicipio(){
        return new ResponseEntity<>(municipioRepository.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "municipio/{id}",method = RequestMethod.GET)
    public ResponseEntity<Municipio>getMunicipioId(@PathVariable Integer id){
        Municipio municipio=municipioRepository.findById(id).orElseThrow();
        if (municipio!= null){
            return new ResponseEntity<>(municipioRepository.findById(id).orElseThrow(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveMunicipio(@RequestBody Municipio municipio)throws ResourceNotFound {
        Map<String,Object>response=new HashMap<>();
        this.municipiosValidate.Validation(municipio);
        this.municipioRepository.save(municipio);
        response.put("Mensaje","El Municipio Fue Registrado Con Exito ".concat(municipio.toString()));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "Delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteMunicipio(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            municipioRepository.deleteById(id);
            response.put("Mensaje","El Municipio Ha Sido Eliminado con Exito ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","El Municipio No Se Ha podido Eliminar ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }



}
