package com.reqres.tests.usuario.tests;

import com.reqres.tests.base.tests.BaseTest;
import com.reqres.tests.usuario.requests.AtualizarUsuarioRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Slf4j
@Feature("Atualizar usuario")
public class AtualizarUsuariosTest extends BaseTest {


    private AtualizarUsuarioRequest atualizarUsuarioRequest;


    /**
     * inicialização da classe .
     */
    @BeforeEach
    public void configurar() {
        atualizarUsuarioRequest = new AtualizarUsuarioRequest();
        log.info("Configuração concluída. Objeto UsuarioRequest criado.");
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar atualização do cadastro do usuario")
    public void DeverealizarAtualizacaoDoCadstroDoUsuario() {
        atualizarUsuarioRequest.atualizarCamposNameEjob();
        atualizarUsuarioRequest.realizarAtualzacaoDeUsuarioValido();


    }


}












