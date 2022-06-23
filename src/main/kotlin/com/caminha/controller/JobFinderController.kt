package com.caminha.controller

import com.caminha.constants.Response
import com.caminha.service.JobFinderService
import com.caminha.sqs.SqsConsumer
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller(value = "/v1/jobs" )
class JobFinderController(
    val service: JobFinderService
) {

    @Inject
    lateinit var sqsConsumer: SqsConsumer

    @Get(value="/",produces = arrayOf(MediaType.APPLICATION_JSON))
    fun getJob(): Response {
        return try {
            Response(status = HttpStatus.OK.code, body = "", error = ArrayList<String>())
        }catch (ex: java.lang.Exception){
            val error = ArrayList<String>()
            //especie de if ternário nativo do kotlin
            //caso ex.message for diferente de nulo starta uma "funcion" let tendo como escopo adicionar o elemento ex.message {it} ao array error
            ex.message?.let { error.add(it) }
            println("Error occurred -> ${ex.message}")
            Response(status = HttpStatus.BAD_REQUEST.code, body = "", error = error )
        }
    }


}