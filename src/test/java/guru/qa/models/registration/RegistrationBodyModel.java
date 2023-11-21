package guru.qa.models.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RegistrationBodyModel {
    private String email, password;
}
