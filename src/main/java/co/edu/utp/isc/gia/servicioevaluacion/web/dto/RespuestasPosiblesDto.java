/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 *
 * @author dfch1
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
class RespuestasPosiblesDto extends PreguntaDto {
    private Long id;
    private List<RespuestasPosiblesDto> respuestaPosible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RespuestasPosiblesDto> getRespuestaPosible() {
        return respuestaPosible;
    }

    public void setRespuestaPosible(List<RespuestasPosiblesDto> respuestaPosible) {
        this.respuestaPosible = respuestaPosible;
    }
}
