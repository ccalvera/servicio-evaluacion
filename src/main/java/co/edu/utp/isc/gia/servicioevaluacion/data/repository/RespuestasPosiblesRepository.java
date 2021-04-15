/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.data.repository;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Pregunta;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.RespuestasPosibles;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dfch1
 */
public interface RespuestasPosiblesRepository extends CrudRepository<RespuestasPosibles, Object>{
    List<RespuestasPosibles> findByPregunta(Pregunta pregunta);
}
