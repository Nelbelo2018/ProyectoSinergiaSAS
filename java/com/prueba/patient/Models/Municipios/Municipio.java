package com.prueba.patient.Models.Municipios;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    //muchos municipios puede pertenecer a un paciente
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "paciente_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Paciente paciente;




}
