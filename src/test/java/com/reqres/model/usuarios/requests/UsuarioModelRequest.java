package com.reqres.model.usuarios.requests;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;


@Getter
@Builder
public class UsuarioModelRequest {

    private String name;
    private String job;

    public UsuarioModelRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }


}