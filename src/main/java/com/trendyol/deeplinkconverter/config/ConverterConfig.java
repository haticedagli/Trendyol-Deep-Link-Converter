package com.trendyol.deeplinkconverter.config;

import com.trendyol.deeplinkconverter.service.todeeplinkconverter.ToDeeplinkConverterFactory;
import com.trendyol.deeplinkconverter.service.tourlconverter.ToURLConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    public ToDeeplinkConverterFactory toDeeplinkConverterFactory(){
        return new ToDeeplinkConverterFactory();
    }

    @Bean
    public ToURLConverterFactory toURLConverterFactory(){
        return new ToURLConverterFactory();
    }
}
