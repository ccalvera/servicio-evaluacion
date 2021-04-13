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
public class SeleccionMultipleUnicaDto extends PreguntaDto {
    private int rUnicaCorrecta;
    private int rUnicaEstudiante;

    public int getrUnicaCorrecta() {
        return rUnicaCorrecta;
    }

    public void setrUnicaCorrecta(int rUnicaCorrecta) {
        this.rUnicaCorrecta = rUnicaCorrecta;
    }

    public int getrUnicaEstudiante() {
        return rUnicaEstudiante;
    }

    public void setrUnicaEstudiante(int rUnicaEstudiante) {
        this.rUnicaEstudiante = rUnicaEstudiante;
    }
}
