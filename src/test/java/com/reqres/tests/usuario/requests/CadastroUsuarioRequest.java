package com.reqres.tests.usuario.requests;

import com.reqres.Utils.ConvertJsonUtils;
import com.reqres.Utils.FakerDataUsuarioUtils;
import com.reqres.endpoints.Endpoints;
import com.reqres.model.usuarios.requests.UsuarioModelRequest;
import com.reqres.model.usuarios.responses.CadastroUsuarioModelResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CadastroUsuarioRequest {


    private UsuarioModelRequest usuarioModelRequest;
    private String step;
    private static final String CONTENT_TYPE_JSON = "application/json";
    private CadastroUsuarioModelResponse usuarioModelResponse;
    private String HEADER = "charset=utf-8";
    ;


    public void preencherCamposNameEjob() {
        usuarioModelRequest = UsuarioModelRequest.builder().name(FakerDataUsuarioUtils.gerarRandomName()).job(FakerDataUsuarioUtils.gerarRandomJob()).build();


    }


    @Step("Realizar cadastro - POST")
    public CadastroUsuarioModelResponse realizarCadastroDeUsuarioValido() {
        step = "realizando cadastro do usuario";
        log.info(step);


        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .body(ConvertJsonUtils.convertJavaObjectToJson(usuarioModelRequest))
                .post(Endpoints.USERS);


        log.info("Corpo da resposta: {}", response.getBody().asString());


        response.then().statusCode(HttpStatus.SC_CREATED);


        usuarioModelResponse = response.as(CadastroUsuarioModelResponse.class);
        assertThat(usuarioModelResponse.getName()).isNotNull();
         assertThat(usuarioModelResponse.getJob()).isNotNull();
        assertThat(usuarioModelResponse.getCreatedAt()).isNotNull();


        return usuarioModelResponse;

    }

    @Step("Realizar cadastro - POST - validando schema")
    public CadastroUsuarioModelResponse validarSchemaCadastroUsuario() {
        step = "validando scheema usuario";
        log.info(step);


        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .body(ConvertJsonUtils.convertJavaObjectToJson(usuarioModelRequest))
                .post(Endpoints.USERS);


        log.info("Corpo da resposta: {}", response.getBody().asString());


        response.then().statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schemas/cadastrarusuario.json"));


        usuarioModelResponse = response.as(CadastroUsuarioModelResponse.class);
        assertThat(usuarioModelResponse.getName()).isNotNull();
        assertThat(usuarioModelResponse.getJob()).isNotNull();
        assertThat(usuarioModelResponse.getCreatedAt()).isNotNull();


        return usuarioModelResponse;


    }


    @Step("Realizar cadastro - POST - validando header")
    public CadastroUsuarioModelResponse validarHeaderDoResponse() {
        step = "validando header do response";
        log.info(step);


        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .body(ConvertJsonUtils.convertJavaObjectToJson(usuarioModelRequest))
                .post(Endpoints.USERS);


        log.info("Corpo da resposta: {}", response.getBody().asString());


        response.then().statusCode(HttpStatus.SC_CREATED);

        usuarioModelResponse = response.as(CadastroUsuarioModelResponse.class);
        assertThat(usuarioModelResponse.getName()).isNotNull();
        assertThat(usuarioModelResponse.getJob()).isNotNull();
        assertThat(usuarioModelResponse.getCreatedAt()).isNotNull();
        assertThat(response.getHeader("Content-Type")).contains(CONTENT_TYPE_JSON).contains(HEADER);


        return usuarioModelResponse;


    }
}





