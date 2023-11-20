package guru.qa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.specs.DeleteSpec.deleteResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Owner("Valeria Reshetina")
public class DeleteTests extends TestBase {

    @Test
    @DisplayName("Successful user deletion")
    @Severity(SeverityLevel.BLOCKER)
    void userDeletionTest() {
        String basePath = "/users/2";

        step("DELETE-request for user deletion", () -> {
            given()
                    .delete(basePath)
                    .then()
                    .log().body()
                    .spec(deleteResponseSpec);
        });
    }
}
