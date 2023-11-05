package com.example.todobackend.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Momen Magdy
 *
 * spring configuration class defines a bean for a ModelMapper
 */

@Configuration
public class ModelMapperConfiguration {

    /**
     * crates and configures the modelMapper bean
     *
     * @return the ModelMapper bean.
     */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
