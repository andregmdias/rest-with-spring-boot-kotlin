package br.com.giannatech.restwithspringbootkotlin.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean

class ModelMapperConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper: ModelMapper = ModelMapper();
        modelMapper.configuration.setSkipNullEnabled(true);
        return modelMapper;
    }
}