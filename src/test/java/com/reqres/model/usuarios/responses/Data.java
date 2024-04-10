package com.reqres.model.usuarios.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Data {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
