package com.rafaelcdev.casadocodigo.livro;

public class LivroListagemResponse {

    private Long idLivro;
    private String titulo;
    
    public LivroListagemResponse(Livro entidade){
        idLivro = entidade.getId();
        titulo = entidade.getTitulo();
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
