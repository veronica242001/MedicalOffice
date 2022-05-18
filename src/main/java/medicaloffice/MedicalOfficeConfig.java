package medicaloffice;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicalOfficeConfig {

    @Bean // spring foloseste aceeasi instanta ori de cate ori avem nevoie
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
