class Person(val name: String, var age: Int){
    fun introduce() {
        println("Hi, I am $name and I am $age years old")
    }
}

// Inheritance
open class Animal{
    open fun method(){
        println("Animal class")
    }
}

class Dog : Animal(){
    override fun method(){
        println("Dog class")
    }
}


fun main(){
    val p1 = Person("Mayank", 25)
    p1.introduce()
}


var name: String = "Kotlin" // Cannot be null
// name = null // Compiler error

var nullableName: String? = "Kotlin" // Can be null
// nullableName = null // Valid


