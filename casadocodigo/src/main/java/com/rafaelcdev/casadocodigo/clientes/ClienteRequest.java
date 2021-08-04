package com.rafaelcdev.casadocodigo.clientes;


public class ClienteRequest {

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private EnderecoClienteRequest enderecoCliente;
    private String telefone;
    

    public ClienteRequest(String email, String nome, String sobrenome, String documento,
            EnderecoClienteRequest enderecoCliente,  String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.enderecoCliente = enderecoCliente;
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoClienteRequest getEnderecoCliente() {
        return enderecoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente toModel() {
        EnderecoCliente novoEndereco = enderecoCliente.paraEndereco();
        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, novoEndereco, this.telefone);
    }
}