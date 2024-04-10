package com.reqres.tests.base.tests;

import com.reqres.Utils.SetEnvUtils;
import com.reqres.Utils.ConvertJsonUtils;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BaseTest {

    // Enum para representar os ambientes
    public enum Environment {
        DEV, HML, PRD
    }

    // Configuração única do RestAssured que será executada uma vez
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    @BeforeAll
    public static void setUp() {
        // Obtenha o ambiente de alguma configuração externa
        Environment environment = getEnvironmentFromConfiguration();
        SetEnvUtils.setEnvironment(environment.toString());

        // Configurar a base URI para RestAssured
        RestAssured.baseURI = SetEnvUtils.getBaseUrl();




        log.info("Iniciando testes de API no ambiente: {}", environment);
    }

    /**
     * Obtém o ambiente a partir de alguma configuração externa.
     *
     * @return Ambiente configurado.
     */
    private static Environment getEnvironmentFromConfiguration() {
        // Lógica para obter o ambiente de alguma configuração externa
        return Environment.HML;
    }

}



