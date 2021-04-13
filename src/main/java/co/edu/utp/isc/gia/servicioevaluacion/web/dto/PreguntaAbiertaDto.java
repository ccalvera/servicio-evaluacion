/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author dfch1
 */
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaAbiertaDto extends PreguntaDto{
    private String respuestaAbierta;
    private boolean rAbiertaCorrecta;

    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
    }

    public boolean isrAbiertaCorrecta() {
        return rAbiertaCorrecta;
    }

    public void setrAbiertaCorrecta(boolean rAbiertaCorrecta) {
        this.rAbiertaCorrecta = rAbiertaCorrecta;
    }
    
}
