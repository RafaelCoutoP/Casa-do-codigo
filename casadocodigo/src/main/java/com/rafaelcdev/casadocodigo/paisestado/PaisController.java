package com.rafaelcdev.casadocodigo.paisestado;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.rafaelcdev.casadocodigo.validacao.CampoUnicoValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/paises")
public class PaisController {
    
    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<PaisRequest> criarPais(@RequestBody @Valid PaisRequest request) {
        Pais pais = request.toModel();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validador(WebDataBinder binder){
        CampoUnicoValid<PaisRequest, String> validarNome = new CampoUnicoValid<>("nome", PaisRequest.class, paisRepository::existsByNome); 
        binder.addValidators(validarNome);
    }
}