package ru.netology.rest;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
        ValidatableResponse body = given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                ;
    }
    @Test
    void shouldReturnCurrencies() {
        // Given - When - Then
        // Предусловия
        ValidatableResponse body = given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .body("it.currency", "enum": ["RUB", "USD"]);

    }
}
