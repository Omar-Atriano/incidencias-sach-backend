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
@Table(name="Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(name = "idIncidencia")
    private Integer idIncidencia;

    @Column(name = "idSolicito")
    private Integer idSolicito;

    @Column(name = "idAtiende")
    private Integer idAtiende;

    @Column(name = "idModifico")
    private Integer idModifico;

    @Column(name = "idElimino")
    private Integer idElimino;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Column(name = "fechaCita")
    private Date fechaCita;

    @Column(name = "fechaModifico")
    private Date fechaModifico;

    @Column(name = "fechaElimino")
    private Date fechaElimino;

}
