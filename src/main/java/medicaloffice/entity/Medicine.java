package medicaloffice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "medicine_key_sequence_generator")
    @SequenceGenerator(name = "medicine_key_sequence_generator", sequenceName = "medicine_sequence", allocationSize = 1)
    private Long id;

    private String medicineName;
    private String companyName;

    @ManyToMany
    @JoinTable(
            name = "treatment_to_medicine",
            joinColumns =@JoinColumn(name = "treatment_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> treatments;
}
