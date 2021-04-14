/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.service;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Pregunta;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.PreguntaAbierta;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Prueba;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.SeleccionMultipleUnica;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PreguntaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PruebaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasEstudiantesRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasMultiplesCorrectasRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasPosiblesRepository;
import co.edu.utp.isc.gia.servicioevaluacion.exception.BadRequestException;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PreguntaDto;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfch1
 */
@Service
@Slf4j
@ToString
public class PreguntaService {

    private PreguntaRepository preguntaRepository;
    private PruebaRepository pruebaRepository;
    private RespuestasEstudiantesRepository respuestasEstudiantesRepository;
    private RespuestasMultiplesCorrectasRepository respuestasMultiplesCorrectasRepo;
    private RespuestasPosiblesRepository respuestasPosiblesRepo;
    private ModelMapper modelMapper = new ModelMapper();

    public PreguntaService(PreguntaRepository preguntaRepository, PruebaRepository pruebaRepository, RespuestasEstudiantesRepository respuestasEstudiantesRepository, RespuestasMultiplesCorrectasRepository respuestasMultiplesCorrectasRepo, RespuestasPosiblesRepository respuestasPosiblesRepo, ModelMapper modelMapper) {
        this.preguntaRepository = preguntaRepository;
        this.pruebaRepository = pruebaRepository;
        this.respuestasEstudiantesRepository = respuestasEstudiantesRepository;
        this.respuestasMultiplesCorrectasRepo = respuestasMultiplesCorrectasRepo;
        this.respuestasPosiblesRepo = respuestasPosiblesRepo;
        this.modelMapper = modelMapper;
    }

    public PreguntaDto saveQuestion(PreguntaDto preguntaDto) {

        switch (preguntaDto.getTipoPregunta()) {
            case 1: {
                //Encuentro la prueba en el repositorio
                log.warn("preguntaDto: " + preguntaDto);
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo Pregunta
                SeleccionMultipleUnica pregunta = modelMapper.map(preguntaDto, SeleccionMultipleUnica.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                log.warn("pregunta: " + pregunta);
                pregunta = preguntaRepository.save(pregunta);
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                log.warn("preguntaDto: " + preguntaDto);
                return preguntaDto;
            }
            case 2: {
                //Encuentro la prueba en el repositorio
                log.warn("preguntaDto: " + preguntaDto);
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo Pregunta
                Pregunta pregunta = modelMapper.map(preguntaDto, Pregunta.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                log.warn("pregunta: " + pregunta);
                pregunta = preguntaRepository.save(pregunta);
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                log.warn("preguntaDto: " + preguntaDto);
                return preguntaDto;
            }
            case 3:
                //Encuentro la prueba en el repositorio
                log.warn("preguntaDto: " + preguntaDto);
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo PreguntaAbierta
                PreguntaAbierta pregunta = modelMapper.map(preguntaDto, PreguntaAbierta.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                log.warn("pregunta: " + pregunta);
                pregunta = preguntaRepository.save(pregunta);
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                log.warn("preguntaDto: " + preguntaDto);
                return preguntaDto;

            default:
                throw new BadRequestException("Tipo de pregunta invalido");
        }
    }
}
