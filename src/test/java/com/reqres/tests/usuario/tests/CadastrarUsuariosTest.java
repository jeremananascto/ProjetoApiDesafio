package com.reqres.tests.usuario.tests;

import com.reqres.tests.base.tests.BaseTest;
import com.reqres.tests.usuario.requests.CadastroUsuarioRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Cadastro de usuario")
@Slf4j
public class CadastrarUsuariosTest extends BaseTest {

    private CadastroUsuarioRequest cadastroUsuarioRequest;


    /**
     * inicialização da classe .
     */
    @BeforeEach
    public void configurar() {
        cadastroUsuarioRequest = new CadastroUsuarioRequest();
        log.info("Configuração concluída. Objeto UsuarioRequest criado.");
    }

    @Test
    @Tag("todos")
    @Description("Realiazar cadastro de usuario com sucesso")
    public void realizarCadastroDeUsuarioComSucesso() {
        cadastroUsuarioRequest.preencherCamposNameEjob();
        cadastroUsuarioRequest.realizarCadastroDeUsuarioValido();


    }

    @Test
    @Tag("todos")
    @Tag("schemas")
    @Description("Deve validar o schema json de um cadstro de  usuario")
    public void deveValidarSchemaDeUmCadastroDeUmUsuario() {
        cadastroUsuarioRequest.preencherCamposNameEjob();
        cadastroUsuarioRequest.validarSchemaCadastroUsuario();


    }

    @Test
    @Tag("todos")
    @Description("Validando headers do response ")
    public void deveValidarOheaderDoResponse() {
        cadastroUsuarioRequest.preencherCamposNameEjob();
        cadastroUsuarioRequest.validarHeaderDoResponse();


    }

}