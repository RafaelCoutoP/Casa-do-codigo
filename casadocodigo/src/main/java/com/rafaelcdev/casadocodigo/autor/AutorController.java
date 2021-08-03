package com.rafaelcdev.casadocodigo.autor;

import javax.validation.Valid;

import com.rafaelcdev.casadocodigo.validacao.CampoUnicoValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<AutorRequest> insertAutor(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validacao(WebDataBinder binder){
        CampoUnicoValid<AutorRequest, String> validadorEmail = new CampoUnicoValid<>("email", AutorRequest.class, repository::existsByEmail);
        binder.addValidators(validadorEmail);
    }
}
