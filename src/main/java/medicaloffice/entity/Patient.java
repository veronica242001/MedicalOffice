package medicaloffice.entity;

import lombok.*;
import medicaloffice.entity.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
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
