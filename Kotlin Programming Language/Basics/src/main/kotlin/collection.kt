fun main(){

    val n1 = listOf(1, 2, 3, 4)
    n1.forEach {
        println(it)
    }

    val mutableList = mutableListOf(1, 2, 3)
    mutableList.add(4)
    mutableList.removeAt(2)
    println(mutableList)

    val map = mapOf("A" to 1, "B" to 2)
    println(map["A"])

    // Functional Operators
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    val evens = numbers.filter { it % 2 == 0 }
    println(numbers)
    println(doubled)
    println(evens)
}

