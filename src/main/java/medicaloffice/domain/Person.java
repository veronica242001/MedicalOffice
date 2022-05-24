package medicaloffice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Getter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type", discriminatorType = DiscriminatorType.INTEGER)
@NoArgsConstructor
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_key_sequence_generator")
    @SequenceGenerator(name = "person_key_sequence_generator", sequenceName = "person_sequence", allocationSize = 1)
    private Long id;
    protected String firstName;
    protected String lastName;
    protected String email;

    public abstract String getName();

}
