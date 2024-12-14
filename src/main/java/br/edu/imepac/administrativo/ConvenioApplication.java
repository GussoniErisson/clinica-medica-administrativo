package br.edu.imepac.administrativo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConvenioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvenioApplication.class, args);
    }
    @Bean(name = "modelMapperConvenio")
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }
}
