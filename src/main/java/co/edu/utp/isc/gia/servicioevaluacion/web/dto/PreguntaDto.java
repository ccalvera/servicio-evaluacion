/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dfch1
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreguntaDto implements Serializable {

    private Long id;
    private String descripcion;
    private String imagen;
    private float valoracion;
    private int tipoPregunta;
    private Long idPrueba;
    
    //Atributos para el tipo de pregunta SeleccionMulipleUnica
    private int rUnicaCorrecta;
    private int rUnicaEstudiante;
    
    //Atributos para el tipo de pregunta SeleccionMulipleUnica
    
    private List<RespuestasPosiblesDto> respuestasPosibles;
    private List<Integer> respuestasEstudiante;
    private List<Integer> respuestasMultiplesCorrectas;
    
    //Atributos para el tipo de pregunta PreguntaAbierta
    private String respuestaAbierta;
    private boolean rAbiertaCorrecta;
    
}
