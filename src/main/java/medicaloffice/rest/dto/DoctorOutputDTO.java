package medicaloffice.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorOutputDTO {
    @JsonProperty
    private String firstName;
}
