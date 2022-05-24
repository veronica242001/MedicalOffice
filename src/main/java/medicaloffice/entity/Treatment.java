package medicaloffice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "treatment_key_sequence_generator")
    @SequenceGenerator(name = "treatment_key_sequence_generator", sequenceName = "treatment_sequence", allocationSize = 1)
    private Long Id;

    private String details;
    //private Map<Medicine, Integer> treatment = new HashMap<>(); // cate zile

    @ManyToMany
    @JoinTable(
            name = "treatment_to_medicine",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private List<Medicine> medicines;
}
