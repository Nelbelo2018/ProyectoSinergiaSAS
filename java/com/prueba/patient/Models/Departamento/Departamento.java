package com.prueba.patient.Models.Departamento;

import com.prueba.patient.Models.Patients.Paciente;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamento_id")
    private Integer id;
    private String Departamento;


    @ManyToMany
    @JoinTable(name = "paciente_departamentos",joinColumns = @JoinColumn(name = "departamento_id",
            referencedColumnName = "departamento_id"),inverseJoinColumns = @JoinColumn(name = "paciente_id",
            referencedColumnName = "paciente_id"))
    private Set<Paciente> pacientes=new HashSet<>();

}
