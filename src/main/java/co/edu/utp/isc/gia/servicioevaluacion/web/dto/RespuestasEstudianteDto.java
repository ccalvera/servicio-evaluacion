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
public class RespuestasEstudianteDto extends PreguntaDto {
    private Long id;
    private List<RespuestasEstudianteDto> respuestaDadaMultiple;

    public Long getId() {
        return id;
    }

    public List<RespuestasEstudianteDto> getRespuestaDadaMultiple() {
        return respuestaDadaMultiple;
    }

    public void setRespuestaDadaMultiple(List<RespuestasEstudianteDto> respuestaDadaMultiple) {
        this.respuestaDadaMultiple = respuestaDadaMultiple;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
