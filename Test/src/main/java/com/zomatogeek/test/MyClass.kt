package com.zomatogeek.test

fun main() {
    //print("Hello World")

//    var myName = "Amrit"
//    myName = "Singh"
    // var is mutable
    val name: String
    val age = 24
    // val is immutable
    if(age > 18){
        name = "Amrit"
    }else{
        name = "Singh"
    }
    println("Hello my name is $name and I'm $age years old.")


    // Types in Kotlin
    // - small
    // - medium
    // - large
    // - x-large

    // Int - a whole Number - 32 bits
    // Byte - 8 bits
    // Short - 16 bits
    // Long - 64 bits

    val myLong = 1L
    print(myLong)

    // Float - Decimal Numbers (32 bits)
    // Double  - (64 bits)

    val e = 2.653662888
    val efloat = 2.653662888f
    val efloat2 = 2.653662888F

    println(e)
    println(efloat)
    println(efloat2)

    // Float will round itself to atleast 6 or 7 decimal places

    // when condition

    val amount = 90

    when(amount) {
        in 0..100 -> print("0-100 is not enough!")
        200 -> print("You are progressing...")
        500 -> print("You have come so far but still more to go!")
        1000 -> print("You are too close to your goal!")
        in 1000..9999 -> print("Volla! You've made it!")
        else -> {
            print("$amount is not enough to progress further. Gather more!")
        }
    }

    println()

    for (i in 1..100){
        if (i%3 == 0){
            print("$i,")
        }
    }

    println()
    val animalAge = 7
    println("The cat age is ${calculateCatAge(animalAge)}")

    println(message = "The dog age is ${calculateDogAge(animalAge)}")

    println("Lambda Sum is ${sum(10, 20)}")

    name2("Amrit")

    enhancedMessage("Hello Training Lambda!"){
        12
    }
    enhancedMessage("Hello Training Lambda!"){
        sum(5,10)
    }

    enhancedMessage2("Hello Trailing Lambda Two!"){
        print(it)
        sum(12,20)
    }
}

fun calculateCatAge(age: Int): Int{
    return age * 7
}

fun calculateDogAge(age: Int) : Int = age * 8

// Lambda Function
// val lambdaName: Type = { parameterList -> codeBody }
val sum: (Int, Int) -> Int = { a, b -> a + b }

val catAgeLambda: (Int) -> Int = { age -> age * 8 }

val catAgeLambda2: (Int) -> Int = {  it * 7 }

// NOTE: Unit in Kotlin means void/nothing
val name: (String) -> Unit = { name -> print(name) }

val name2: (String) -> Unit = { print(it) }

// Trailing Lambda
// ( Last parameter of a function must be a function so that it can be passed as parameter
// within body of function or lambda )

// Lambda Curly Braces are Bold than normal function Curly Braces

fun enhancedMessage(message: String, funAsParameter: () -> Int ){
    println("$message ${funAsParameter()}")
}

fun enhancedMessage2(message: String, funAsParameter: (String) -> Int ){
    println("$message ${funAsParameter("Hey!")}")
}