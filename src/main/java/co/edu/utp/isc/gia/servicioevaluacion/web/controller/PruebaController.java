/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.web.controller;

import co.edu.utp.isc.gia.servicioevaluacion.service.PruebaService;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PruebaDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dfch1
 */
@RestController
@RequestMapping("prueba")
public class PruebaController {
    
    private PruebaService pruebaService;
    
    public PruebaController(PruebaService pruebaService){
        this.pruebaService = pruebaService;
    }
    
    @PostMapping()
    public PruebaDto saveTest(@RequestBody PruebaDto prueba){
        return pruebaService.saveTest(prueba);
    }
    
    @GetMapping()
    public List<PruebaDto> listAll(){
        return pruebaService.listAll();
    }
    
    @GetMapping("/{id}")
    public PruebaDto findTest(@PathVariable("id") Long id){
        return pruebaService.findTest(id);
    }
    
    @DeleteMapping("/{id}")
    public PruebaDto removeTest(@PathVariable("id") Long id){
        return pruebaService.removeTest(id);
    }
}
