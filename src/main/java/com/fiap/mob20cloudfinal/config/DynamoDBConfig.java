package com.fiap.mob20cloudfinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {
	  
	public static final String SERVICE_ENDPOINT = "dynamodb.us-east-1.amazonaws.com";
    public static final String REGION = "us-east-1";

    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonDynamoDBConfig());
    }

    private AmazonDynamoDB amazonDynamoDBConfig() {
    	return AmazonDynamoDBClientBuilder.standard()
    			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION)).build();
    }
}
