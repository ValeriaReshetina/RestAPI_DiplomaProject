package guru.qa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

@Owner("Valeria Reshetina")
public class ReqresTests extends TestBase {

    @Test
    @DisplayName("Successful creation of user")
    @Severity(SeverityLevel.BLOCKER)
    void userCreationTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body("{ \"name\": \"Valeria Reshetina\", \"job\": \"QA\" }")
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201);
    }

    @Test
    @DisplayName("Successful deletion of user")
    @Severity(SeverityLevel.BLOCKER)
    void userDeletionTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body("{ \"name\": \"Valeria Reshetina\", \"job\": \"QA\" }")
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    @DisplayName("Successful user registration")
    @Severity(SeverityLevel.BLOCKER)
    void userRegistrationTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }")
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Failed attempt to register user")
    @Severity(SeverityLevel.CRITICAL)
    void negativeRegisterUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\" }")
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

    @Test
    @DisplayName("Successful retrieving of user list")
    @Severity(SeverityLevel.CRITICAL)
    void getUsersListTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .get("/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("support.text",
                        is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
