package com.softengine.accountservice.conf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanFactory {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}