package com.prueba.patient.Repository.Patients;

import com.prueba.patient.Models.Patients.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteJpa extends JpaRepository<Paciente,Integer> {
}
