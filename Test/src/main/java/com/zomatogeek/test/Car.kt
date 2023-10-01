package com.zomatogeek.test


fun main(){
    val car = Car(color = "Green", model = "MDS")
    car.color="Blue" // this overrides the init block values as well
    car.model = "NEO" // this overrides the init block values as well
    val secondcar = Car(color = "White", model = "AA1")

    val truck = Truck(color = "Magenta", model = "TATA")
    truck.drive()


    println("Car ${car.color} Model: ${car.model}")
    println("Second Car ${secondcar.color} Model: ${secondcar.model}")

    car.drive()
    car.speed(minSpeed = 100, maxSpeed = 199)

    truck.speed(minSpeed = 40, maxSpeed = 100)

    val button = Button("Button")
    button.onCLick(message = "This is a button!")

    val superMario = Character(name = "Mario")
    superMario.onCLick("This is SuperMario!")

    println("Hello Amrit".append(" How R U!"))
    println("This is Fun!".removeFirstAndLastChars())

    val person = Person(name = "Amrit", age = 24)
    println(person)

    val listOfPeople = listOf(person, Person(name = "Aman", age = 23), Person(name = "Ajay", age = 25))
    listOfPeople.forEach { person ->  println("Name: ${person.name}, Age: ${person.age}") }
}


// Extension Function
fun String.append(toAppend: String) : String = this.plus(toAppend)

fun String.removeFirstAndLastChars() : String = this.substring(1, this.length - 1)


// Every class is Kotlin is child of Any class just like Object class in JAVA
open class Car(var color: String = "Blue", var model: String = "BMW") {
//    var color: String = color
//    var model: String = model

    init {
        // init block overrides the paramter values passed
        color = "Yellow"
        model = "GT1"
    }
    open fun drive(){
        println("Driving.....vrooooomm!")
    }

    open fun speed(minSpeed: Int, maxSpeed: Int){
        println("Min Speed is $minSpeed, Max Speed is $maxSpeed")
    }
}

class Truck(color: String = "Blue", model: String = "BMW") : Car(color, model) {
    override fun speed(minSpeed: Int, maxSpeed: Int) {
//        super.speed(minSpeed, maxSpeed)
        println("Truck with Min Speed is $minSpeed, Max Speed is $maxSpeed")

    }

    override fun drive() {
//        super.drive()
        println("Vrooooom! Truck is driving!")
    }
}


// Interfaces

interface ClickEvent {
    fun onCLick(message: String)
}

class Button(val label: String) : ClickEvent {
    override fun onCLick(message: String) {
        println("Clicked by $label and here's the message: $message")
    }

}

class Character(val name: String) : ClickEvent {
    override fun onCLick(message: String) {
        println("Clicked by $name and here's the message: $message")
    }

}

// data Class

data class Person(var name: String, var age: Int)