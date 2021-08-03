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
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<EstadoRequest> criandoEstado(@RequestBody @Valid EstadoRequest request) {
        Estado estado = request.toModel(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validador(WebDataBinder binder){
        CampoUnicoValid<EstadoRequest, String> validarNome = new CampoUnicoValid<>("nome", EstadoRequest.class, estadoRepository::existsByNome);
        binder.addValidators(validarNome);
    }
}
