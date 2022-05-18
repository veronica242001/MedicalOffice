package medicaloffice.domain;

import lombok.Builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Patient extends Person {

    @Builder
    public Patient( String firstName, String lastName, String email) {
        this.firstName =firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getName() {
        return String.format("Pacientul", firstName, lastName);
    }
}
