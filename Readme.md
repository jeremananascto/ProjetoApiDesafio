# Desafio Técnico API

Este é o projeto Desafio Técnico API, que contém uma série de configurações e dependências Maven para facilitar o desenvolvimento e execução de testes de API. Este README fornece uma visão geral do projeto, suas dependências e como configurar e executar os testes.

## Requisitos

Certifique-se de ter o seguinte software instalado em seu sistema:

- Java Development Kit (JDK) versão 11 ou superior
- Maven

## Configuração do Projeto

Para configurar o projeto em sua máquina local, siga estas etapas:

1. Clone este repositório em sua máquina local:
   ```bash
   git clone https://exemplo.com/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd Desafio-tecnico-api
   ```

## Dependências

Este projeto utiliza várias dependências Maven para facilitar o desenvolvimento e execução dos testes. Algumas das principais dependências incluem:

- [Lombok](https://projectlombok.org/): Uma biblioteca Java que ajuda a reduzir o código boilerplate.
- [Rest Assured](https://rest-assured.io/): Uma biblioteca Java para escrever testes automatizados para API RESTful.
- [JUnit](https://junit.org/junit5/): Um framework de teste para Java.
- [Java Faker](https://github.com/DiUS/java-faker): Uma biblioteca Java útil para gerar dados falsos.
- [Gson](https://github.com/google/gson): Uma biblioteca Java para serializar e desserializar objetos Java em JSON.
- [Allure Framework](https://github.com/allure-framework/allure2): Um framework de relatório de teste que gera relatórios detalhados e interativos.

## Executando os Testes

Para executar os testes do projeto, utilize o comando Maven:

```bash
Na Raiz do projeto vá em "test" depois "java" e na package "Runners" na classe java  "todos os tests runner".
Este comando executará todos os testes incluídos no projeto.

## Gerando Relatórios

Este projeto está configurado para gerar relatórios de teste utilizando o framework Allure. Para gerar e visualizar os relatórios, execute o seguinte comando Maven:

```bash
mvn allure:serve
```

Isso iniciará um servidor local e abrirá automaticamente uma página da web com os relatórios gerados.

## Contribuição

Se você quiser contribuir para este projeto, sinta-se à vontade para enviar um pull request. Antes de enviar um pull request, certifique-se de seguir as diretrizes de contribuição.

## Suporte

Se você tiver dúvidas ou encontrar problemas ao usar este projeto, abra uma issue no repositório ou entre em contato com a equipe de desenvolvimento.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).