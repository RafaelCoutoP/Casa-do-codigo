package com.rafaelcdev.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotNull @Size(max = 400)
    private String description;
    
    public AutorRequest(Long id, String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public AutorRequest(Autor entity) {
        name = entity.getName();
        email = entity.getEmail();
        description = entity.getDescription();
    }

    public String getEmail() {
        return email;
    }

    public Autor toModel() {
        return new Autor(this.name, this.email, this.description);
    }
}