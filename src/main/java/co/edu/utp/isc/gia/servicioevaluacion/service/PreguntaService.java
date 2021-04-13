/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.service;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Prueba;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PreguntaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PruebaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasEstudiantesRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasMultiplesCorrectasRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasPosiblesRepository;
import co.edu.utp.isc.gia.servicioevaluacion.exception.TestNotFoundException;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PreguntaDto;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfch1
 */
@Service
public class PreguntaService {

    private PreguntaRepository preguntaRepository;
    private PruebaRepository pruebaRepository;
    private RespuestasEstudiantesRepository respuestasEstudiantesRepository;
    private RespuestasMultiplesCorrectasRepository respuestasMultiplesCorrectasRepo;
    private RespuestasPosiblesRepository respuestasPosiblesRepo;
    private ModelMapper modelMapper = new ModelMapper();

    public PreguntaService(PreguntaRepository preguntaRepository, PruebaRepository pruebaRepository, RespuestasEstudiantesRepository respuestasEstudiantesRepository, RespuestasMultiplesCorrectasRepository respuestasMultiplesCorrectasRepo, RespuestasPosiblesRepository respuestasPosiblesRepo,  ModelMapper modelMapper) {
        this.preguntaRepository = preguntaRepository;
        this.pruebaRepository = pruebaRepository;
        this.respuestasEstudiantesRepository = respuestasEstudiantesRepository;
        this.respuestasMultiplesCorrectasRepo = respuestasMultiplesCorrectasRepo;
        this.respuestasPosiblesRepo = respuestasPosiblesRepo;
        this.modelMapper = modelMapper;
    }

    public PreguntaDto saveQuestion(PreguntaDto pregunta) {
        
        
        
//        switch (pregunta.getTipoPregunta()) {
//            case 1:
//            {
//               
//            }
//            case 2:
//            {
//               
//            }
//            case 3:
//            {
//                Pregunta myPregunta = modelMapper.map(pregunta, Pregunta.class);
//                myPregunta = preguntaRepository.save(myPregunta);
//                PreguntaDto resp = modelMapper.map(myPregunta, PreguntaDto.class);
//                return resp;
//            }
//            default:
//                throw new BadRequestException("Type not found");
//        }
    }

}
