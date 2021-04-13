/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.data.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dfch1
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "respuestas_estudiante")
public class RespuestasEstudiante implements Serializable {

    @Id
    private Long id;

    @Column(name = "respuesta_dada_multiple")
    private int respuestaDadaMultiple;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pregunta")
    private SeleccionMultipleMultiple seleccion_multiple_multiple;

}
