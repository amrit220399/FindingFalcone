package com.zomatogeek.test

fun main(){

//    Kotlin Collection Functions Cheat Sheet Link:
//    https://medium.com/mobile-app-development-publication/kotlin-collection-functions-cheat-sheet-975371a96c4b

//    Collections ( List, ArrayList, listOf(), mutableListOf() )
//    Collections usually contains objects/items in a certain order of the same type.

    val listOfNames = listOf("James", "Paul", "Rafael", "Gina")
    // Immutable list
    println(listOfNames)

    for (item in listOfNames){
        println(item)
    }

    listOfNames.forEach{
        println("For Each lambda name: $it")
    }

    val myMutableList = mutableListOf(12, 20, 10, 19)
    // add
    myMutableList.add(30)
    println(myMutableList)
    // removeAt
    myMutableList.removeAt(0)
    println(myMutableList)
    // remove
    myMutableList.remove(19)
    println(myMutableList)
    // size
    println(myMutableList.size)
    // get
    println(myMutableList.get(1))
    println(myMutableList[1])
    // indexOf
    println(myMutableList.indexOf(10))
    // filter
    println("Filter ${myMutableList.filter { it == 20 }}")

    // Sets
    val mySet = setOf(10, 20, 20, 30, 50, 100, 10)
    // contains unique elements in any order. Order is NOT fixed for sets
    // immutable set
    println(mySet)

    val myMutableSet = mutableSetOf(10, 250, 27, 100, 10, 20, 27)
    println(myMutableSet)

    myMutableSet.add(250) // will not be added since already there is set
    println(myMutableSet)


    // Map

    val secretMap = mapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
    // immutable
    println(secretMap)
    // keys
    println(secretMap.keys)
    // values
    println(secretMap.values)

    if ("Up" in secretMap) println("Yes! Up is in secretMap")
    if (4 in secretMap.values) println("Yes! 4 is in secretMap values")

    val mutableSecretMap = mutableMapOf("Zero" to 0, "One" to 1, "Two" to 2)
    mutableSecretMap.put("Three", 3)
    mutableSecretMap["Four"] = 4
    println(mutableSecretMap)

    // Different Item types in one list
    val mySecondList = listOf(1, 2, "Three")
    println(mySecondList)

    // Empty Collections
    val emptyList = emptyList<String>()
    val emptySet = emptySet<Int>()
    val emptyMap = emptyMap<String, Int>()

    println(emptyList)
    println(emptySet)
    println(emptyMap)



}