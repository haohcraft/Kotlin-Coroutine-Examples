package com.codingwithmitch.coroutineexamples

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun log(msg: String) = println("${Thread.currentThread().name}, ${coroutineContext[Job]} $msg")

fun main() = runBlocking { // this: CoroutineScope
    coroutineScope {

        println("4 Coroutine scope is over") // This line is not printed until the nested launch completes
    }
}
