
class Person {
    companion object Test {
        fun callMe() = println("I'm called.")
    }
}

fun main(args: Array<String>) {
    Person.callMe()
}