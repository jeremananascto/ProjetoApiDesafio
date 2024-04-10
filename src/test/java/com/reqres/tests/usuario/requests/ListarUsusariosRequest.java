package com.reqres.tests.usuario.requests;

import com.reqres.endpoints.Endpoints;
import com.reqres.model.usuarios.responses.Data;
import com.reqres.model.usuarios.responses.ListarUsuarioResponse;
import com.reqres.model.usuarios.responses.ListarUsuariosResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Slf4j
public class ListarUsusariosRequest {

    private String step;
    private static final String CONTENT_TYPE_JSON = "application/json";
    private ListarUsuarioResponse listarUsuarioResponse;
    private ListarUsuariosResponse listarUsuariosResponse;
    private int userId = 2;


    @Step("Realizar consulta de usuario pelo id  - GET")
    public ListarUsuarioResponse realizarConsultaIdDeUsuarioValido() {

        log.info("Realizando consulta de usuário pelo ID: {}", userId);
        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .get(Endpoints.USERS + userId);

        log.info("Corpo da resposta: " + response.getBody().asString());

        response.then().statusCode(HttpStatus.SC_OK);


        listarUsuarioResponse = response.as(ListarUsuarioResponse.class);
        Assert.assertNotNull(listarUsuarioResponse.getData().getId());
        Assert.assertNotNull(listarUsuarioResponse.getData().getEmail());
        Assert.assertNotNull(listarUsuarioResponse.getData().getFirst_name());
        Assert.assertNotNull(listarUsuarioResponse.getData().getLast_name());
        Assert.assertNotNull(listarUsuarioResponse.getData().getAvatar());
        Assert.assertNotNull(listarUsuarioResponse.getSupport().getUrl());
        Assert.assertNotNull(listarUsuarioResponse.getSupport().getText());


        return listarUsuarioResponse;

    }


    @Step("Realizar consulta de usuario pelo id  - GET")
    public ListarUsuariosResponse consultarTodosUsuarios() {
        step = "realizando consulta de usuario";
        log.info(step);
        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .get(Endpoints.USERS);

        log.info("Corpo da resposta: " + response.getBody().asString());

        response.then().statusCode(HttpStatus.SC_OK);


        listarUsuariosResponse = response.as(ListarUsuariosResponse.class);
        Assert.assertNotNull(listarUsuariosResponse.getData().isEmpty());
        Assert.assertNotNull(listarUsuariosResponse.getPage());
        Assert.assertNotNull(listarUsuariosResponse.getPer_page());
        Assert.assertNotNull(listarUsuariosResponse.getTotal());
        Assert.assertNotNull(listarUsuariosResponse.getPage());
        Assert.assertNotNull(listarUsuariosResponse.getSupport().getText());
        Assert.assertNotNull(listarUsuariosResponse.getSupport().getUrl());
        List<Data> usuarios = listarUsuariosResponse.getData();
        int perPage = listarUsuariosResponse.getPer_page();
        Assertions.assertThat(usuarios.size()).isEqualTo(perPage);


        return listarUsuariosResponse;


    }


    @Step("validar schema de um usuario - GET")
    public ListarUsuariosResponse validarSchemaUsuarioId() {
        step = "realizando validação de schema do usuario";
        log.info(step);
        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .get(Endpoints.USERS + userId);

        log.info("Corpo da resposta: " + response.getBody().asString());

        response.then().statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/usuario.json"));


        listarUsuarioResponse = response.as(ListarUsuarioResponse.class);
        Assert.assertNotNull(listarUsuarioResponse.getData().getId());
        Assert.assertNotNull(listarUsuarioResponse.getData().getEmail());
        Assert.assertNotNull(listarUsuarioResponse.getData().getFirst_name());
        Assert.assertNotNull(listarUsuarioResponse.getData().getLast_name());
        Assert.assertNotNull(listarUsuarioResponse.getData().getAvatar().contains(".jpg"));
        Assert.assertNotNull(listarUsuarioResponse.getSupport().getUrl());
        Assert.assertNotNull(listarUsuarioResponse.getSupport().getText());



        return listarUsuariosResponse;


    }


    @Step("validar schema de uma lista de usuarios - GET")
    public ListarUsuariosResponse validarSchemaListaDeusuarios() {
        step = "realizando validação de schema do usuario";
        log.info(step);
        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .get(Endpoints.USERS);

        log.info("Corpo da resposta: " + response.getBody().asString());

        response.then().statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/usuarios.json"));


        listarUsuariosResponse = response.as(ListarUsuariosResponse.class);
        Assert.assertNotNull(listarUsuariosResponse.getData().isEmpty());
        Assert.assertNotNull(listarUsuariosResponse.getPage());
        Assert.assertNotNull(listarUsuariosResponse.getPer_page());
        Assert.assertNotNull(listarUsuariosResponse.getTotal());
        Assert.assertNotNull(listarUsuariosResponse.getPage());
        Assert.assertNotNull(listarUsuariosResponse.getSupport().getText());
        Assert.assertNotNull(listarUsuariosResponse.getSupport().getUrl());
        List<Data> usuarios = listarUsuariosResponse.getData();
        int perPage = listarUsuariosResponse.getPer_page();
        Assertions.assertThat(usuarios.size()).isEqualTo(perPage);


        return listarUsuariosResponse;

    }
}