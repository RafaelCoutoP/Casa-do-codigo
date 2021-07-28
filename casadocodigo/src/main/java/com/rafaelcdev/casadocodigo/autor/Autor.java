package com.rafaelcdev.casadocodigo.autor;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String description;
    private Instant moment;

    @Deprecated
    public Autor(){
    }

    public Autor(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        moment = Instant.now();
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Instant getMoment() {
        return moment;
    }
}
