package com.rafaelcdev.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    boolean existsByIsbn (String isbn);

}
