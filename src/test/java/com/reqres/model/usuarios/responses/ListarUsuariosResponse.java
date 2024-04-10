package com.reqres.model.usuarios.responses;

import com.reqres.model.usuarios.responses.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Getter
@NoArgsConstructor
@ToString
public class ListarUsuariosResponse {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;




}
