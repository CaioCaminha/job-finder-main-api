package com.caminha.entity

import software.amazon.awssdk.services.dynamodb.model.AttributeValue

class JobEntity(
    val item: MutableMap<String, AttributeValue>,
) {

    var id: String
    var Company: String
    var Description: String
    var Title: String
    var JobUrl: String

    init {
        this.id = item.getValue("id").toString()
        this.Company = item.getValue("Company").toString()
        this.Description = item.getValue("Description").toString()
        this.Title = item.getValue("Title").toString()
        this.JobUrl = item.getValue("JobUrl").toString()
    }

}