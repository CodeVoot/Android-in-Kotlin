fun main(){
    greet()
    println(add(2,3))
    println( default())
}

fun greet(){
    println("Hello Good evening Good afternoon Good morning")
}

fun add(a:Int,b:Int):Int{
    return a+b
}

fun default(name:String = "default value"):String{
    return "$name"
}