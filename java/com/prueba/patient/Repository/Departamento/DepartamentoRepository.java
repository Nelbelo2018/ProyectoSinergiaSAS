package com.prueba.patient.Repository.Departamento;

import com.prueba.patient.Models.Departamento.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento,Integer> {

    Collection<Departamento>findAll();
}
