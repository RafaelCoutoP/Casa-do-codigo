package com.rafaelcdev.casadocodigo.paisestado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

    boolean existsByNome(String nome);
}
