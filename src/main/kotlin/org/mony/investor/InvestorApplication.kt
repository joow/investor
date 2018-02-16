package org.mony.investor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

val OBJECT_MAPPER: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

fun main(args: Array<String>) {
    if (args.size != 1) throw RuntimeException("input file should be provided !")

    val input = OBJECT_MAPPER.readValue(File(args.first()), Input::class.java)
    println(Portfolio(input.positions).optimize(input.investment, input.allocations))
}
