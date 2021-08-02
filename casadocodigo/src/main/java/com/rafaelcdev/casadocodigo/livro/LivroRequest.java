package com.rafaelcdev.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.Instant;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.rafaelcdev.casadocodigo.autor.Autor;
import com.rafaelcdev.casadocodigo.autor.AutorRepository;
import com.rafaelcdev.casadocodigo.categoria.Categoria;
import com.rafaelcdev.casadocodigo.categoria.CategoriaRepository;

public class LivroRequest {

    @NotBlank @NotNull
    private String titulo;
    @NotBlank @Size(max = 500) 
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Positive @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank 
    private String isbn;
    @Future
    private Instant dataPublicacao;
    @NotNull
    private Long idCategoria;
    @NotNull 
    private Long idAutor;
    

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas,
            String isbn, Instant dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    /*
    * Get And Sett necessario para serialização do JSON,
    * pois estava dando erro no campo ao tentar verificar erro de duplicação.
    */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository ) {
        Categoria categoria = categoriaRepository.getById(this.idAutor);
        Autor autor = autorRepository.getById(this.idAutor); 
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoria, autor);
    }
}