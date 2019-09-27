package com.gabrielcamp.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcamp.cursomc.domain.herancies.pagamentoComBoleto;
import com.gabrielcamp.cursomc.domain.herancies.pagamentoComCartao;

@Configuration
public class JacksonConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder () {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(pagamentoComCartao.class);
				objectMapper.registerSubtypes(pagamentoComBoleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
	
}
