package com.caminha.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class ControllerTest {

    @Get("/")
    fun get(): String {
        return "hello controller"
    }
}