/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioevaluacion.service;

import co.edu.utp.isc.gia.servicioevaluacion.data.entity.Prueba;
import co.edu.utp.isc.gia.servicioevaluacion.data.repository.PruebaRepository;
import co.edu.utp.isc.gia.servicioevaluacion.exception.BadRequestException;
import co.edu.utp.isc.gia.servicioevaluacion.exception.TestNotFoundException;
import co.edu.utp.isc.gia.servicioevaluacion.web.dto.PruebaDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfch1
 */
@Service
public class PruebaService {

    private PruebaRepository pruebaRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public PruebaService(PruebaRepository pruebaRepository, ModelMapper modelMapper) {
        this.pruebaRepository = pruebaRepository;
        this.modelMapper = modelMapper;
    }

    public PruebaDto saveTest(PruebaDto prueba) {
        Prueba myPrueba = modelMapper.map(prueba, Prueba.class);
        myPrueba = pruebaRepository.save(myPrueba);
        PruebaDto resp = modelMapper.map(myPrueba, PruebaDto.class);
        return resp;
    }

    public PruebaDto findTest(Long id) {
        if (pruebaRepository.existsById(id)) {
            return modelMapper.map(pruebaRepository.findById(id).get(), PruebaDto.class);
        } else {
            throw new TestNotFoundException("Not Found");
        }
    }

    public List<PruebaDto> listAll() {
        List<PruebaDto> pruebaDto = null;
        List<Prueba> pruebas = (List<Prueba>) pruebaRepository.findAll();
        if (pruebas != null && !pruebas.isEmpty()) {
            pruebaDto = new ArrayList<>();
            for (Prueba prueba : pruebas) {
                pruebaDto.add(modelMapper.map(prueba, PruebaDto.class));
            }
        }
        return pruebaDto;
    }
    
//    public PruebaDto checkTest(Long id){
//        if(pruebaRepository.existsById(id)){
//            return null;
//        }else{
//            throw new TestNotFoundException("Test not found");
//        }
//    }

    public PruebaDto removeTest(Long id) {
        if (pruebaRepository.existsById(id)) {
            PruebaDto deleted = findTest(id);
            pruebaRepository.deleteById(id);
            return deleted;
        }
        throw new TestNotFoundException("Test Not Found");
    }

    public PruebaDto updateTest(Long id, PruebaDto prueba) {
        if (prueba == null) {
            throw new BadRequestException("Parametro no valido");
        } else {
            if (pruebaRepository.existsById(id)) {
                prueba.setId(id);
                PruebaDto updated = saveTest(prueba);
                return updated;
            } else {
                throw new TestNotFoundException("Test not found");
            }
        }
    }

}
