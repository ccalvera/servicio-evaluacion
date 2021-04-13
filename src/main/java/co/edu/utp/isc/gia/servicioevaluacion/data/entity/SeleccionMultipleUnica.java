/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.data.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author dfch1
 */
@Entity
@DiscriminatorValue("1")
public class SeleccionMultipleUnica extends Pregunta {
    @Column(name = "r_unica_estudiante")
    private int respuestaEstudiante;
    
    @Column(name = "r_unica_correcta")
    private int respuestaCorrecta;
}
