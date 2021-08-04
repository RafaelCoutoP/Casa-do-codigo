package com.rafaelcdev.casadocodigo.clientes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    /*
    * Adicionar validação
    * Transformar o telefone em um conjunto de telefones (Set)
    * Verificar o codigo feito
    */

    @PostMapping
    public ResponseEntity<ClienteRequest> cadastrarCliente(@RequestBody ClienteRequest request) {
        Cliente cliente = request.toModel();
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }
}