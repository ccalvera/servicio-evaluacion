/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.dto;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Prueba;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.RespuestasPosibles;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author dfch1
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreguntaDto implements Serializable {

    private Long id;
    private String descripcion;
    private String imagen;
    private float valoracion;
    private int tipoPregunta;
    private Long idPrueba;

    public Long getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Long idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public int getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }
    
}
