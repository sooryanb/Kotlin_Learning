

fun main() {

    var a: Int? = null

    // let function is often used to provide null safety calls.
    // only executes if the value is not null!
    a?.let {
        print(it)
    }

    a = 2
    a?.let {
        print(it)
    }
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")

    // apply function is mostly used to initialize members.
    val cmp = Company().apply {
        name = "Pepper"
        status = "Busy"
    }
    println(cmp.name)


    // with example.
    val numbersList = mutableListOf("one", "two", "three")
    with(numbersList) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }

    // also example. used where we have to perform additional operations when we have initialized the object members.
    numbersList
        .also { println("The list elements before adding new one: $it") }
        .add("four")


    // Difference between using run and let. Run is a combination of 'let' and 'with'
    val service = MultiportService("https://example.kotlinlang.org", 80)
    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

// the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }

}

class Company(){

    lateinit var name: String
    lateinit var status: String

}

class MultiportService(var url: String, var port: Int) {
    fun prepareRequest(): String = "Default request"
    fun query(request: String): String = "Result for query '$request'"
}