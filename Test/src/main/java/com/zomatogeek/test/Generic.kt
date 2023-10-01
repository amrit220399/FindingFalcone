package com.zomatogeek.test

fun main(){
    val listItems = listOf("Amrit", "Anjay", "Mohan", "Anmol", "Vijay")
    val listIntItems = listOf(10, 20, 23, 30, 40)
    val finder = Finder(listItems)
    finder.findItem("Amrit"){
        println("Found $it")
    }
    finder.findItem("Akshay"){
        println("Found $it")
    }
    val finderInt = Finder(listIntItems)
    finderInt.findItem(23){
        println("Found: $it")
    }

    val input = Result.SUCCESS
    getResult(input)

    Repository.fetchStart()
    getResult(Repository.getCurrentState())
    Repository.fetchFinished()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())
}
class Finder<T>(private val list: List<T>) {
    fun findItem(item: T, foundItem: (element: T?) -> Unit ) {
        val itemFoundList = list.filter { it == item }

        if(itemFoundList.isNullOrEmpty()) foundItem(null)
        else foundItem(itemFoundList.first())
    }

}

fun getResult(result: Result) {
    return when(result){
        Result.SUCCESS -> println("Success!")
        Result.ERROR -> println("Error!")
        Result.PENDING -> println("Pending!")
        Result.LOADING -> println("Loading...!")
    }
}
enum class Result {
    SUCCESS,
    ERROR,
    PENDING,
    LOADING
}

// Cannot create multiple objects of this object class (Singleton Class)
//Only one reference in the entire app
//Access members, methods without creating an instance
object Repository {
    private var loadState: Result = Result.PENDING

    private var dataFetched: String? = null

    fun fetchStart(){
        loadState = Result.LOADING
        dataFetched = "data"
    }
    fun fetchFinished(){
        loadState = Result.SUCCESS
        dataFetched = null
    }

    fun error(){
        loadState = Result.ERROR
    }

    fun getCurrentState() : Result = loadState

}