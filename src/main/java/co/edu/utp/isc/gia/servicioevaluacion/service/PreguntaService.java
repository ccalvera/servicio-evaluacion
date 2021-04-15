/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.service;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Pregunta;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.PreguntaAbierta;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Prueba;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.RespuestasPosibles;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.SeleccionMultipleMultiple;
import co.edu.utp.isc.gia.servicioevaluacion.data.entity.SeleccionMultipleUnica;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PreguntaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PruebaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasPosiblesRepository;
//import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasEstudiantesRepository;
//import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasMultiplesCorrectasRepository;
//import co.edu.utp.isc.gia.servicioevaluacion.data.repository.RespuestasPosiblesRepository;
import co.edu.utp.isc.gia.servicioevaluacion.exception.BadRequestException;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PreguntaDto;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.RespuestasPosiblesDto;
import java.util.ArrayList;
import java.util.List;
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
    private RespuestasPosiblesRepository respuestasPosiblesRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public PreguntaService(PreguntaRepository preguntaRepository, PruebaRepository pruebaRepository, ModelMapper modelMapper,RespuestasPosiblesRepository respuestasPosiblesRepository) {
        this.preguntaRepository = preguntaRepository;
        this.pruebaRepository = pruebaRepository;
        this.respuestasPosiblesRepository = respuestasPosiblesRepository;
//        this.respuestasEstudiantesRepository = respuestasEstudiantesRepository;
//        this.respuestasMultiplesCorrectasRepo = respuestasMultiplesCorrectasRepo;
//        this.respuestasPosiblesRepo = respuestasPosiblesRepo;
        this.modelMapper = modelMapper;
    }

    public PreguntaDto saveQuestion(PreguntaDto preguntaDto) {

        switch (preguntaDto.getTipoPregunta()) {
            //Tipo de pregunta con respuestas unica
            case 1: {
                //Encuentro la prueba en el repositorio
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo Pregunta
                SeleccionMultipleUnica pregunta = modelMapper.map(preguntaDto, SeleccionMultipleUnica.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                pregunta = preguntaRepository.save(pregunta);
                //Creo la lista para guardar las preguntas que llegan del Dto
                List<RespuestasPosiblesDto> respuestasPosibles = new ArrayList();
                //recorro la lista de preguntas y las guardo 
                for (RespuestasPosiblesDto respuestaPosibleDto : preguntaDto.getRespuestasPosiblesDto()) {
                    RespuestasPosibles respuestaPosible = modelMapper.map(respuestaPosibleDto, RespuestasPosibles.class);
                    respuestaPosible.setPregunta(pregunta);
                    respuestaPosible = respuestasPosiblesRepository.save(respuestaPosible);
                    respuestasPosibles.add(modelMapper.map(respuestaPosible, RespuestasPosiblesDto.class));
                }
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                //Le asigno las respuestas posibles a la pregunta para retornarla
                preguntaDto.setRespuestasPosiblesDto(respuestasPosibles);
                return preguntaDto;
            }
            //Tipo de pregunta con respuesta multiple
            case 2: {
                //Encuentro la prueba en el repositorio
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo Pregunta
                SeleccionMultipleMultiple pregunta = modelMapper.map(preguntaDto, SeleccionMultipleMultiple.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                pregunta = preguntaRepository.save(pregunta);
                //Creo una lista para guardar la lista de preguntas que llegan del DTO
                List<RespuestasPosiblesDto> respuestasPosibles = new ArrayList();
                
                for (RespuestasPosiblesDto respuestaPosibleDto : preguntaDto.getRespuestasPosiblesDto()) {
                    RespuestasPosibles respuestaPosible = modelMapper.map(respuestaPosibleDto, RespuestasPosibles.class);
                    respuestaPosible.setPregunta(pregunta);
                    respuestaPosible = respuestasPosiblesRepository.save(respuestaPosible);
                    respuestasPosibles.add(modelMapper.map(respuestaPosible, RespuestasPosiblesDto.class));
                }
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                //Le asigno las respuestas posibles a la pregunta para retornarla
                preguntaDto.setRespuestasPosiblesDto(respuestasPosibles);
                return preguntaDto;
            }
            //Tipo pregunta abierta
            case 3:
                //Encuentro la prueba en el repositorio
                Prueba prueba = pruebaRepository.findById(preguntaDto.getIdPrueba()).get();
                //mapeo la preguntaDto a tipo PreguntaAbierta
                PreguntaAbierta pregunta = modelMapper.map(preguntaDto, PreguntaAbierta.class);
                //Asigno la pregunta a una prueba
                pregunta.setPrueba(prueba);
                //Guardo la pregunta
                pregunta = preguntaRepository.save(pregunta);
                //mapeo la pregunta a tipo DTO para retornarla
                preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
                return preguntaDto;

            default:
                throw new BadRequestException("Tipo de pregunta invalido");
        }
    }

    public List<PreguntaDto> listQuestions() {
        List<PreguntaDto> preguntaDto = null;
        List<Pregunta> preguntas = (List<Pregunta>) preguntaRepository.findAll();
        if (preguntas != null && !preguntas.isEmpty()) {
            preguntaDto = new ArrayList<>();
            for (Pregunta pregunta : preguntas) {
                preguntaDto.add(modelMapper.map(pregunta, PreguntaDto.class));
            }
        }
        return preguntaDto;
    }

    public PreguntaDto findOne(Long id) {
        if (!preguntaRepository.existsById(id)) {
            throw new BadRequestException("Pregunta no encontrada");
        }
        return modelMapper.map(preguntaRepository.findById(id).get(), PreguntaDto.class);
    }

    public PreguntaDto updateQuestion(Long id, PreguntaDto preguntaDto) {
        if (preguntaDto == null) {
            throw new BadRequestException("Pregunta invalida");
        } else {
            if (preguntaRepository.existsById(id)) {
                preguntaDto.setId(id);
                PreguntaDto updated = saveQuestion(preguntaDto);
                return updated;
            }
        }
        throw new BadRequestException("Pregunta no encontrada");
    }

    public PreguntaDto deleteQuestion(Long id) {
        if (preguntaRepository.existsById(id)) {
            PreguntaDto deleted = findOne(id);
            preguntaRepository.deleteById(id);
            return deleted;
        } else {
            throw new BadRequestException("Question not found");
        }
    }
}
