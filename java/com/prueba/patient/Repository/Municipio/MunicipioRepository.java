package com.prueba.patient.Repository.Municipio;

import com.prueba.patient.Models.Municipios.Municipio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio,Integer> {

    Collection<Municipio>findAll();
}
