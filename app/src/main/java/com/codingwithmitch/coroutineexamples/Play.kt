package com.codingwithmitch.coroutineexamples

import kotlinx.coroutines.*



fun main() = runBlocking { // this: CoroutineScope
    launch {
        delay(0)
        println("Task from runBlocking")
    }


    coroutineScope { // Creates a coroutine scope
        launch {
            delay(0)
            println("Task from nested launch")
        }

        delay(0)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}

