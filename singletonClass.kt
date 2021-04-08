
fun main()
{
    println(SingletonClass.name)
    println("The answer of addition is ${SingletonClass.add(3,2)}")
    println("The answer of addition is ${SingletonClass.add(10,15)}")
}

// Singleton classes are a special class which can only have one instance!
object SingletonClass
{
    init
    {
        println("Singleton class invoked.")
    }

    var name = "GFG Is Best"
    fun add(num1:Int,num2:Int):Int
    {
        return num1.plus(num2)
    }
}
