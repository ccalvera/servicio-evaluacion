/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author dfch1
 */
@NoArgsConstructor
@AllArgsConstructor
public class SeleccionMultipleMultipleDto extends PreguntaDto {

    private List<RespuestasPosiblesDto> respuestasPosibles;
    private List<RespuestasEstudianteDto> respuestasEstudiante;
    private List<RespuestasMultiplesCorrectasDto> respuestasMultiplesCorrectas;

    public List<RespuestasPosiblesDto> getRespuestasPosibles() {
        return respuestasPosibles;
    }

    public void setRespuestasPosibles(List<RespuestasPosiblesDto> respuestasPosibles) {
        this.respuestasPosibles = respuestasPosibles;
    }

    public List<RespuestasEstudianteDto> getRespuestasEstudiante() {
        return respuestasEstudiante;
    }

    public void setRespuestasEstudiante(List<RespuestasEstudianteDto> respuestasEstudiante) {
        this.respuestasEstudiante = respuestasEstudiante;
    }

    public List<RespuestasMultiplesCorrectasDto> getRespuestasMultiplesCorrectas() {
        return respuestasMultiplesCorrectas;
    }

    public void setRespuestasMultiplesCorrectas(List<RespuestasMultiplesCorrectasDto> respuestasMultiplesCorrectas) {
        this.respuestasMultiplesCorrectas = respuestasMultiplesCorrectas;
    }
    
}
