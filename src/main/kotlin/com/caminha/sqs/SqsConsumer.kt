package com.caminha.sqs

import com.caminha.config.SqsClientFactory
import software.amazon.awssdk.services.sqs.model.*;
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class SqsConsumer {

    @Inject
    lateinit var client: SqsClientFactory

    var url: String = "https://sqs.us-east-1.amazonaws.com/926265474128/jf-messages.fifo"

    open fun receiveMessage(): Message{
        try {
            var receiveMessageRequest: ReceiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(url)
                .maxNumberOfMessages(1)
                .build()

            var message: Message = client.sqsClient().receiveMessage(receiveMessageRequest).messages()[0]
            return message
        }catch (ex: SqsException){
            ex.printStackTrace()
            System.exit(1)
            throw ex
        }
    }
}



