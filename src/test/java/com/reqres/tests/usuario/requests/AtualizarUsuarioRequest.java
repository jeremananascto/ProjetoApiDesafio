package com.reqres.tests.usuario.requests;

import com.reqres.Utils.ConvertJsonUtils;
import com.reqres.Utils.FakerDataUsuarioUtils;
import com.reqres.endpoints.Endpoints;
import com.reqres.model.usuarios.requests.UsuarioModelRequest;
import com.reqres.model.usuarios.responses.AtualizarUsuarioModelResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;


@Slf4j
public class AtualizarUsuarioRequest {

    private UsuarioModelRequest usuarioModelRequest;
    private String step;
    private static final String CONTENT_TYPE_JSON = "application/json";
    private AtualizarUsuarioModelResponse atualizarUsuarioModelResponse;
    private int userId = 2;


    public void atualizarCamposNameEjob() {
        usuarioModelRequest = UsuarioModelRequest.builder()
                .name(FakerDataUsuarioUtils.gerarRandomName())
                .job(FakerDataUsuarioUtils.gerarRandomJob())
                .build();


    }

    @Step("Realizar atualização do cadastro de usuario - Patch")
    public AtualizarUsuarioModelResponse realizarAtualzacaoDeUsuarioValido() {


         step = "atualizando cadastro de usuario";
        log.info(step);

        Response response = given()
                .log().all()
                .header("Content-Type", CONTENT_TYPE_JSON)
                .when()
                .body(ConvertJsonUtils.convertJavaObjectToJson(this.usuarioModelRequest))
                .patch(Endpoints.USERS + userId);

        response.then().statusCode(HttpStatus.SC_OK);

        log.info("Corpo da resposta: {}", response.getBody().asString());

        atualizarUsuarioModelResponse = response.as(AtualizarUsuarioModelResponse.class);
        assertThat(atualizarUsuarioModelResponse.getName()).isNotNull();
        assertThat(atualizarUsuarioModelResponse.getJob()).isNotNull();
        assertThat(atualizarUsuarioModelResponse.getUpdatedAt()).isNotNull();

        return atualizarUsuarioModelResponse;


    }
}