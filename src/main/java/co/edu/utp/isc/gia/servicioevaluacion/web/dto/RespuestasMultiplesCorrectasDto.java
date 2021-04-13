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
public class RespuestasMultiplesCorrectasDto extends PreguntaDto {
    private Long id;
    private List<RespuestasMultiplesCorrectasDto> respuestasCorrectas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RespuestasMultiplesCorrectasDto> getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public void setRespuestasCorrectas(List<RespuestasMultiplesCorrectasDto> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

}
