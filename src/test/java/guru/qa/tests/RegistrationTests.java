package guru.qa.tests;

import guru.qa.models.registration.MissingPasswordResponseModel;
import guru.qa.models.registration.RegistrationBodyModel;
import guru.qa.models.registration.RegistrationResponseModel;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.specs.RegistrationSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Valeria Reshetina")
public class RegistrationTests extends TestBase {

    @Test
    @DisplayName("Successful user registration")
    @Severity(SeverityLevel.BLOCKER)
    void userRegistrationTest() {
        RegistrationBodyModel registrationData = new RegistrationBodyModel();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("pistol");

        RegistrationResponseModel response = step("POST-request for user registration", () ->
                given(registrationRequestSpec)
                        .body(registrationData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(registrationResponseSpec)
                        .extract().as(RegistrationResponseModel.class));

        step("Verify response", () -> {
            assertAll(
                    () -> assertEquals(response.getId(), (4)),
                    () -> assertEquals(response.getToken(), (config.getToken())));
        });
    }

    @Test
    @DisplayName("Failed attempt to register user")
    @Severity(SeverityLevel.CRITICAL)
    void negativeRegisterUserTest() {
        String basePath = "/register";

        RegistrationBodyModel registrationData = new RegistrationBodyModel();
        registrationData.setEmail("eve.holt@reqres.in");

        MissingPasswordResponseModel response = step("POST-request for user registration without password", () ->
                given(registrationRequestSpec)
                        .body(registrationData)
                        .when()
                        .post(basePath)
                        .then()
                        .spec(missingPasswordRegistrationSpec)
                        .extract().as(MissingPasswordResponseModel.class));

        step("Verify response", () ->
                assertThat(response.getError()).isEqualTo("Missing password"));
    }
}
