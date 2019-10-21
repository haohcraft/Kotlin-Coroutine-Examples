package com.codingwithmitch.coroutineexamples

import kotlinx.coroutines.*

suspend fun getData(input: Int) {
    delay(500)
    println("my data: $input")
}

suspend fun getDataButFail() {
    delay(2000)
    println("run getDataButFail after some delay")
    throw IndexOutOfBoundsException()
}

suspend fun getDataDemo() = coroutineScope {

    childJob = launch {

        repeat(10) { time ->
            getData(time)
            println("Child is active? ${childJob.isActive}")
        }
    }
    launch {

        getDataButFail()
    }
}


lateinit var childJob: Job

fun main() = runBlocking {

    try {
        getDataDemo()
    } catch (e: java.lang.IndexOutOfBoundsException) {
        println("caught an exception")
    }

    println("At the end, is child job active: ${childJob.isActive}")
    println("End")
}