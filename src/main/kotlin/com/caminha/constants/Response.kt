package com.caminha.constants

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Objects

@JsonIgnoreProperties(value = ["handler", "hibernateLanyInitializer", "FieldHandler"])
class Response(
    //Any é o tipo generico do kotlin fazendo referencia justamente a palavra any em ingles
    val body: Any,
    val status: Int,
    val error: ArrayList<String>
) {

}