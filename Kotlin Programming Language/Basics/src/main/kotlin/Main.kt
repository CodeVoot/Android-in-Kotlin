fun main() {
    println("Hello World!")
    // var is mutable and val is immutable
    val a = 15

    // not fixing data type of variable
    var age = 15
    println(age)
    // fixing the data type of variable
    var n1 : Int = 16
    println(n1)

    // Control Flow statements

    val number = 10

    val result = if (number > 0) {
        "Positive"
    } else {
        "Negative"
    }

    println(result)

    // read input
    val readword = readln()
    println("Enter the word")
    println(readword)

    // Switch
    val day = 2

    when (day) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        else -> println("Invalid day")
    }

    // loops
    for (i in 1..5) {
        println(" "+ i)
    }

    var i = 1
    while (i <= 5) {
        println(" "+ i)
        i++
    }
}