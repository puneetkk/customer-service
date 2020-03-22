package com.company.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.mongodb.MongoClient;

@SpringBootApplication@ComponentScan({ "com.company.local" })
@EnableMongoRepositories({ "com.company.local.customer.repo" })
public class CustomerApplication implements CommandLineRunner {

	public static final Logger LOGGER = LoggerFactory.getLogger(CustomerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Inside run method");
	}
	
	@Bean
    public MongoClient mongofunc() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost",27017);//localhost, 27017
        return mongoClient;
    } 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongofunc(),"customerdb");
        return mongoTemplate;
    }
    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); 
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        LOGGER.info("Inside corsConfigurer");
        return new CorsFilter(source);
    }
}
