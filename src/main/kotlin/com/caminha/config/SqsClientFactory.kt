package com.caminha.config

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Value
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient

class SqsClientFactory {

    @Value("\${aws.key}")
    lateinit var awsKeyId: String
    @Value("\${aws.secret}")
    lateinit var awsSecret: String

    @Bean
    @Primary
    open fun sqsClient(): SqsClient {
        var credentials: AwsBasicCredentials = AwsBasicCredentials.create(awsKeyId, awsSecret)
        return SqsClient.builder().region(Region.US_EAST_1)
            .credentialsProvider(StaticCredentialsProvider.create(credentials)).build()
    }
}
