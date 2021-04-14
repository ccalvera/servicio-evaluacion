/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.data.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dfch1
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DiscriminatorValue("Multiple")
public class SeleccionMultipleMultiple extends Pregunta {
   @OneToMany(mappedBy = "seleccion_multiple_multiple",
            cascade = CascadeType.ALL)
    private List<RespuestasPosibles> respuestasPosibles;
   
   @OneToMany(mappedBy = "seleccion_multiple_multiple",
            cascade = CascadeType.ALL)
    private List<RespuestasEstudiante> respuestasEstudiante;
   
   @OneToMany(mappedBy = "seleccion_multiple_multiple",
            cascade = CascadeType.ALL)
    private List<RespuestasMultiplesCorrectas> respuestasMultiplesCorrectas;
   
   
}
