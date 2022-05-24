package medicaloffice.entity;

import lombok.*;
import medicaloffice.domain.MedicalSpecialty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@DiscriminatorValue("1")
public class Doctor extends Person {

    private MedicalSpecialty specialty;

    @Builder
    public Doctor(String firstName, String lastName, String email, MedicalSpecialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialty = specialty;
    }

    @Override
    public String getName() {
        return String.format("Doctorul", firstName, lastName);
    }
}
