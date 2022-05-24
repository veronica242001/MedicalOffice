package medicaloffice.config;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import java.util.concurrent.TimeUnit;

@Configuration
public class MedicalOfficeConfig {

    @Bean // spring foloseste aceeasi instanta ori de cate ori avem nevoie
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean //bean care va popula baza de date dintr-un fisier Json
    public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[]{new ClassPathResource("person-data.json")});
        return factory;
    }

    @Bean
    public Cache<String, Double> provideCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
    }

}
