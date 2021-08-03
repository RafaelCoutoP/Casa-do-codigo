package com.rafaelcdev.casadocodigo.categoria;

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
@RequestMapping(value = "categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<CategoriaRequest> insertCategoria(@RequestBody @Valid CategoriaRequest request){
        Categoria categoria = request.toModel();
        repository.save(categoria);    
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validacao(WebDataBinder binder){
        CampoUnicoValid<CategoriaRequest, String> validadorNome = new CampoUnicoValid<>("nome", CategoriaRequest.class, repository::existsByNome);
        binder.addValidators(validadorNome);    
    }
}