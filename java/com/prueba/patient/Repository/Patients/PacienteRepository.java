package com.prueba.patient.Repository.Patients;

import com.prueba.patient.Models.Patients.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente,Integer> {

   Collection<Paciente> findAll();


}
