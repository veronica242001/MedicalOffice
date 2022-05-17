package domain;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Treatment {
    private String details;
    private Map<Medicine, Integer> treatment = new HashMap<>(); // cate zile
}
