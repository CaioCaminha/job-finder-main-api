package com.caminha.service.impl

import com.caminha.constants.Ids
import com.caminha.dynamoDb.DynamoDBService
import com.caminha.entity.JobEntity
import com.caminha.sqs.SqsConsumer
import com.google.gson.Gson
import jakarta.inject.Inject
import jakarta.inject.Singleton
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse


@Singleton
class JobFinderServiceImpl(
    val sqsConsumer: SqsConsumer,

){

    @Inject
    lateinit var dynamoDBService: DynamoDBService

    fun getJobs(): GetItemResponse? {
        //{ids: [ids]}
        val message: String = sqsConsumer.receiveMessage().body()
        val body = Gson().fromJson(message, Ids::class.java)
        val ids: ArrayList<String> = body.ids
        var jobs: ArrayList<JobEntity> = ArrayList()

        for(id in ids){
            var job: JobEntity
            var getItemResponse: GetItemResponse? = dynamoDBService.getEvent(id)
            var item: MutableMap<String, AttributeValue>
            if(getItemResponse != null){
                item = getItemResponse.item()
                jobs.add(JobEntity(item))
            }
        }
        this.validateJobs(jobs = jobs)

        return null
    }

    fun validateJobs(jobs: ArrayList<JobEntity>): ArrayList<JobEntity> {
        for(job in jobs){
            println(job)
        }
        return jobs
    }
}