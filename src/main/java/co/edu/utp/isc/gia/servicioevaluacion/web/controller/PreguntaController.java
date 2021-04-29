/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.controller;

import co.edu.utp.isc.gia.servicioevaluacion.service.PreguntaService;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PreguntaDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dfch1
 */
@RestController
@RequestMapping("pregunta")
public class PreguntaController {
    
    private PreguntaService preguntaService;
    
    public PreguntaController (PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }
    
    @PostMapping()
    public PreguntaDto saveQuestion(@RequestBody PreguntaDto pregunta){
        return preguntaService.saveQuestion(pregunta);
    }
    
    @GetMapping()
    public List<PreguntaDto> listQuestions(){
        return preguntaService.listQuestions();
    }
    
    
    @GetMapping("/{id}")
    public PreguntaDto findOne(@PathVariable("id") Long id){
        return preguntaService.findOne(id);
    }
    
    @PutMapping("/{id}")
    public PreguntaDto updateQuestion(@PathVariable("id") Long id, @RequestBody PreguntaDto pregunta){
        return preguntaService.updateQuestion(id, pregunta);
    }
    
    @DeleteMapping("/{id}")
    public PreguntaDto deleteQuestion(@PathVariable("id") Long id){
        return preguntaService.deleteQuestion(id);
    }
    
    
}
