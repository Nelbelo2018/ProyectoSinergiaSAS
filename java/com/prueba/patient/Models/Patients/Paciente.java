package com.prueba.patient.Models.Patients;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prueba.patient.Models.Departamento.Departamento;
import com.prueba.patient.Models.Municipios.Municipio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patients")
public class Paciente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Integer id;
    private String TipoDocumentoId;
    @Column(name = "Number_Document")
    private int NumeroDocumento;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "Second_Name")
    private String secondName;
    @Column(name = "first_lastName")
    private String firstLastName;
    @Column(name = "Second_lastName")
    private String secondLastName;


    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private Set<Municipio>municipios= new HashSet<>();

    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private Set<Departamento>departamentos= new HashSet<>();







}
