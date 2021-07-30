package com.rafaelcdev.casadocodigo.validacao;

import java.lang.reflect.Field;
import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CampoUnicoValid<T, P> implements Validator {

    private String campo;
    private Class<? extends T> classeParaSerValidada;
    private Function<P, Boolean> metodoQueVainoBanco;

    public CampoUnicoValid(){

    }

    public CampoUnicoValid(String campo, Class<? extends T> classeParaSerValidada,
            Function<P, Boolean> metodoQueVainoBanco) {
        this.campo = campo;
        this.classeParaSerValidada = classeParaSerValidada;
        this.metodoQueVainoBanco = metodoQueVainoBanco;
    }

    /* verifica a classe que o spring tem em mãos e compara os requisitos com a classe passada no parametro
    * caso requisitos aceitos valida 
    * caso requisitos não seja aceitos não faz nada 
    */
    @Override
    public boolean supports(Class<?> clazz) {
        return this.classeParaSerValidada.isAssignableFrom(clazz);
    }

    //lógica de validação
    @Override
    public void validate(Object o, Errors errors) {
       
    try {
        Field declaredField = classeParaSerValidada.getDeclaredField(this.campo);
        declaredField.setAccessible(true);
        Object objetoASerPesquisado = declaredField.get(o);
        Boolean existeNome = metodoQueVainoBanco.apply((P) objetoASerPesquisado);    
           
            if(existeNome){
                errors.rejectValue(campo, "campoUnico", "O Campo deve ser unico");
            }

       } catch (IllegalAccessException | NoSuchFieldException e) {
           e.printStackTrace();
       }
    }
}