package com.caminha.config

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Value
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

class DynamoDBClientFactory {
    @Value("\${aws.key}")
    lateinit var awsKeyId: String
    @Value("\${aws.secret}")
    lateinit var awsSecret: String

    @Bean
    @Primary
    open fun dynamoDbClient(): DynamoDbClient{
        var credentials: AwsBasicCredentials = AwsBasicCredentials.create(awsKeyId, awsSecret)
        return DynamoDbClient.builder().region(Region.US_EAST_1)
            .credentialsProvider(StaticCredentialsProvider.create(credentials)).build()
    }
}