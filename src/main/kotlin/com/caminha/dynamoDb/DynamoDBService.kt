package com.caminha.dynamoDb

import com.caminha.config.DynamoDBClientFactory
import jakarta.inject.Inject
import jakarta.inject.Singleton
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*


@Singleton
class DynamoDBService {

    @Inject
    lateinit var client: DynamoDBClientFactory

    val table_name: String = "jf-job-finder"
    final val  ID_COLUMN = "id"

    open fun getEvent(objectId: String): GetItemResponse? {
        var searchCriteria = HashMap<String, AttributeValue>()
        searchCriteria.put(ID_COLUMN, AttributeValue.fromS(objectId))
        var request: GetItemRequest = GetItemRequest.builder()
            .tableName(table_name)
            .key(searchCriteria)
            .build()
        return client.dynamoDbClient().getItem(request)
    }
    open fun deleteEvent(objectId: String): DeleteItemResponse? {
        var searchCriteria = HashMap<String, AttributeValue>()
        searchCriteria.put(ID_COLUMN, AttributeValue.fromS(objectId))
        var request: DeleteItemRequest = DeleteItemRequest.builder()
            .tableName(table_name)
            .key(searchCriteria)
            .build()
        return client.dynamoDbClient().deleteItem(request)
    }
}