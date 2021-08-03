package com.rafaelcdev.casadocodigo.livro;

import java.util.Optional;

import javax.validation.Valid;

import com.rafaelcdev.casadocodigo.autor.AutorRepository;
import com.rafaelcdev.casadocodigo.categoria.CategoriaRepository;
import com.rafaelcdev.casadocodigo.validacao.CampoUnicoValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<Page<LivroListagemResponse>> listaLivros(Pageable pageable) {
        Page<Livro> livros = livroRepository.findAll(pageable);
        Page<LivroListagemResponse> conversao = livros.map(x -> new LivroListagemResponse(x));
        return ResponseEntity.ok(conversao);
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity <LivroDetalheResponse> detalhesLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalheResponse(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
    
    @Transactional
    @PostMapping
    public ResponseEntity<LivroRequest> criaLivro(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(categoriaRepository, autorRepository);     
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validacao(WebDataBinder binder){
        CampoUnicoValid<LivroRequest, String> validadorIsbn = new CampoUnicoValid<>("isbn", LivroRequest.class, livroRepository::existsByIsbn);
        binder.addValidators(validadorIsbn);    
    }
}