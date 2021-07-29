package com.rafaelcdev.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<AutorRequest> insertAutor(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        if(repository.existsByEmail(autorRequest.getEmail())){
            return ResponseEntity.unprocessableEntity().build();
        }
        repository.save(autor);
        return ResponseEntity.ok().build();
    }
}
