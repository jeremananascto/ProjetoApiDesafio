package com.reqres.model.usuarios.responses;

import com.reqres.model.usuarios.responses.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ListarUsuarioResponse {

    private Data data;
    private Support support;
}
