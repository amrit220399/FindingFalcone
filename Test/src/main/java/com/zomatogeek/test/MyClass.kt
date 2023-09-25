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

}