package com.prueba.patient.Models.Departamento;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "paciente_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Paciente paciente;


}
