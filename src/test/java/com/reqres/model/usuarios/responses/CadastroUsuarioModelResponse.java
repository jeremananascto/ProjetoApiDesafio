package com.reqres.model.usuarios.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class CadastroUsuarioModelResponse {
    private String name;
    private String job;
    private int id;
    private String createdAt;

}
