package com.microservice.service.config;

import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("actuator-endpoints")
//if you want: register bean only if profile is set
public class ActuatorConfig {

 @Bean
 public HttpExchangeRepository httpTraceRepository() {
     return new InMemoryHttpExchangeRepository();
 }

}