
data class PersonDetail(val name: String, val age: Int)

fun main() {

    val product = { a: Int, b: Int -> a * b }
    val result = product(9, 3)
    println(result)
    callMe({println("Function called.")})

    val people = listOf(
        PersonDetail("Jack", 34),
        PersonDetail("Shelly", 19),
        PersonDetail("Patrick", 13),
        PersonDetail("Jill", 12),
        PersonDetail("Shane", 22),
        PersonDetail("Joe", 18)
    )

    val selectedPerson = people.filter { it.name.startsWith("J") }.maxByOrNull { it.age }
    println("${selectedPerson?.name} : ${selectedPerson?.age}")
}


//The empty parenthesis suggest that, the passed anonymous function doesn't accept any parameters.
// And, the Unit keyword suggest that the anonymous function doesn't return any value.
fun callMe(greeting: () -> Unit) {
    greeting()
}