package com.rafaelcdev.casadocodigo.livro;

import java.math.BigDecimal;

public class LivroDetalheResponse {

    private String autorNome;
    private String autorDescricao;
    private String titulo;
    private String isbn;
    private Integer numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
   
    public LivroDetalheResponse(Livro entidade) {
        autorNome = entidade.getAutor().getNome();
        autorDescricao = entidade.getAutor().getDescricao();
        titulo = entidade.getTitulo();
        isbn = entidade.getIsbn();
        numeroPaginas = entidade.getNumeroPaginas();
        preco = entidade.getPreco();
        resumo = entidade.getResumo();
        sumario = entidade.getSumario();
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }  
}