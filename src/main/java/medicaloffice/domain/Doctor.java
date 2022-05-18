package medicaloffice.domain;

import lombok.*;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    private MedicalSpecialty specialty;

    @Builder
    public Doctor( String firstName, String lastName, String email, MedicalSpecialty specialty) {
        this.firstName =firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialty = specialty;
    }

    @Override
    public String getName() {
        return String.format("Doctorul", firstName, lastName);
    }
}
