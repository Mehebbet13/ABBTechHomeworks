package hw2

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

val state = MutableStateFlow("empty") // flow to update UI (in our case just print to logcat)

fun main() {
//    runSync()
    runAsync()
    runBlocking {
        state.collect()
    }
}

fun runSync() {
    println("hw2.runSync method.")
    //  launch 1000 coroutines. Invoke hw2.doWork(index/number of coroutine) one after another. Example 1, 2, 3, 4, 5, etc.

    for (i in 1..30) {
        runBlocking {
            doWork(i.toString())
        }
    }
}

fun runAsync() {
    println("hw2.runAsync method.")
    //  launch 1000 coroutines. Invoke hw2.doWork(index/number of coroutine) in async way. Example 1, 2, 5, 3, 4, 8, etc.

    for (i in 1..30) {
        CoroutineScope(Dispatchers.IO).launch {
            doWork(i.toString())
        }
    }
}


private suspend fun doWork(name: String) {
    delay(500)
    state.update { "$name completed." }
    println(state.value)
}