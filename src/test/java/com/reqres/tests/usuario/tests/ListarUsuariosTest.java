package com.reqres.tests.usuario.tests;

import com.reqres.tests.base.tests.BaseTest;
import com.reqres.tests.usuario.requests.ListarUsusariosRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Slf4j
@Feature("Listar usuarios")
public class ListarUsuariosTest extends BaseTest {


    private ListarUsusariosRequest listarUsusariosRequest;


    /**
     * inicialização da classe .
     */
    @BeforeEach
    public void configurar() {
        listarUsusariosRequest = new ListarUsusariosRequest();
        log.info("Configuração concluída. Objeto UsuarioRequest criado.");
    }

    @Test
    @Tag("todos")
    @Description("Realiazar consulta de usuario por id")
    public void deveRetornarUmUsuario() {
        listarUsusariosRequest.realizarConsultaIdDeUsuarioValido();


    }

    @Test
    @Tag("todos")
    @Description("Consultar lista de usuarios cadastrados")
    public void deveRetornarUmaListaDeUsuarios() {
        listarUsusariosRequest.consultarTodosUsuarios();

    }

    @Test
    @Tag("todos")
    @Tag("schemas")
    @Description("Validar schema do retorno de um usuario")
    public void validarSchemaDeUmUsuario() {
        listarUsusariosRequest.validarSchemaUsuarioId();

    }


    @Test
    @Tag("todos")
    @Tag("schemas")
    @Description("Validar schema do retorno de uma lista de usuarios")
    public void validarSchemaDeUmaListaDeUsuarios() {
        listarUsusariosRequest.validarSchemaListaDeusuarios();

    }
}