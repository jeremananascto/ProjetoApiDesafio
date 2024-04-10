package com.reqres.model.usuarios.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class AtualizarUsuarioModelResponse {


    private String name;
    private String job;
    private String updatedAt;
}
