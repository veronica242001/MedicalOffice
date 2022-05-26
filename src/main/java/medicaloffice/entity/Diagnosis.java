package medicaloffice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @Builder
    public Diagnosis(String diagnosisName, String details) {
        this.diagnosisName = diagnosisName;
        this.details = details;
    }

    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
