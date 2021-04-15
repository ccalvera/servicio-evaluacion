/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "prueba")
public class Prueba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @Column(name = "nota_maxima")
    private int notaMaxima;
    
    @Column(name = "codigo_estudiante")
    private int codigoEstudiante;
    
    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;
    
    private double nota;

    @OneToMany(mappedBy = "prueba",
            cascade = CascadeType.ALL)
    private List<Pregunta> pregunta;

}
