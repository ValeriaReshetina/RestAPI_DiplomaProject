package guru.qa.tests;

import guru.qa.models.user.UserListResponseModel;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static guru.qa.specs.UserSpec.userRequestSpec;
import static guru.qa.specs.UserSpec.userResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Valeria Reshetina")
public class UserTests extends TestBase {

    @Test
    @DisplayName("Successful retrieving of user list")
    @Severity(SeverityLevel.BLOCKER)
    void getUserListTest() {
        String basePath = "/users?page=2";

        UserListResponseModel response = step("GET-request for user list", () ->
                given(userRequestSpec)
                        .when()
                        .get(basePath)
                        .then()
                        .spec(userResponseSpec)
                        .extract().as(UserListResponseModel.class));

        step("Verify response", () -> {
            assertAll(
                    () -> assertEquals(response.getTotal(), (12)),
                    () -> assertEquals(response.getData().stream()
                            .filter(Objects::nonNull)
                            .filter(user -> user.getId() == 10)
                            .findFirst()
                            .get()
                            .getEmail(), "byron.fields@reqres.in")
            );
        });
    }
}
