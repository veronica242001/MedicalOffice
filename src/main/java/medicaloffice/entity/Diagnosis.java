package medicaloffice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "diagnosis_key_sequence_generator")
    @SequenceGenerator(name = "diagnosis_key_sequence_generator", sequenceName = "diagnosis_sequence", allocationSize = 1)
    private Long Id;

    private String diagnosisName;
    private String details;
}
