package com.zomatogeek.test

import java.io.IOException

fun main(){
    val input: MyResult= NotLoading
    getResultTwo(input)

    RepositoryTwo.fetchStart()
    getResultTwo(RepositoryTwo.getCurrentState())
    RepositoryTwo.fetchFinished()
    getResultTwo(RepositoryTwo.getCurrentState())
    RepositoryTwo.error()
    getResultTwo(RepositoryTwo.getCurrentState())
    RepositoryTwo.customFailure()
    getResultTwo(RepositoryTwo.getCurrentState())
    RepositoryTwo.anotherCustomFailure()
    getResultTwo(RepositoryTwo.getCurrentState())
}

// can be made as sealed class MyResult in order to get rid of else(default case) in when statement
// but all the objects of sealed class must be present in the same file

sealed class Failure : MyResult() {
    data class CustomFailure(val customFailure: IOException) : Failure()
    data class AnotherCustomFailure(val anotherCustomFailure: NullPointerException) : Failure()
}


//abstract class MyResult
sealed class MyResult

data class Success(val dataFetched: String?) : MyResult()
data class Error(val exception: Exception) : MyResult()

object Loading: MyResult()

object NotLoading: MyResult()


fun getResultTwo(result: MyResult) {
    return when(result){
        is Error -> {
         println(result.exception)
        }
        is Success -> {
            println(result.dataFetched)
        }
        is Loading -> {
            println("Loading...")
        }
        is NotLoading -> {
            println("Idle State")
        }
        is Failure.CustomFailure -> {
            println(result.customFailure.toString())
        }
        is Failure.AnotherCustomFailure -> {
            println(result.anotherCustomFailure.toString())
        }
    }
}

object RepositoryTwo {
    private var loadState: MyResult = NotLoading

    private var dataFetched: String? = null

    fun fetchStart(){
        loadState = Loading
        dataFetched = "data"
    }
    fun fetchFinished(){
        loadState = Success(dataFetched)
        dataFetched = null
    }

    fun error(){
        loadState = Error(exception = Exception("Exception"))
    }

    fun getCurrentState() : MyResult = loadState

    fun customFailure() {
        loadState = Failure.CustomFailure(IOException("Custom failure"))
    }

    fun anotherCustomFailure() {
        loadState = Failure.AnotherCustomFailure(NullPointerException("Another Custom Failure"))
    }

}
