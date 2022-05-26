package medicaloffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorOutputDTO {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
}
