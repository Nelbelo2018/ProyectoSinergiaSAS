package com.prueba.patient.Models.Municipios;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prueba.patient.Models.Generos.Genero;
import com.prueba.patient.Models.Patients.Paciente;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Municipios")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipio_id")
    private Integer id;
    private String Name;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonBackReference
    private Paciente paciente_id;




}
