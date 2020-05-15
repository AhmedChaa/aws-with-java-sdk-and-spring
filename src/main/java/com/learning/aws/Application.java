package com.learning.aws;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().region(Region.EU_WEST_3).build();
    }

    @Bean
    ApplicationRunner applicationRunner (DynamoDbClient dynamoDbClient) {
        return args -> {
          dynamoDbClient.listTables().tableNames().forEach(System.out::println);
        };
    }
}
