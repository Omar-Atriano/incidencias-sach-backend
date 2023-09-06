package com.sach.incidenciasbackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Incidencias")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaHora")
    private Date fechaHora;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "aclaracion")
    private String aclaracion;
}
