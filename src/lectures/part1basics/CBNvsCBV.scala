
object CBNvsCBV extends App {

    // First, we create two functions with Long (as Scala and JVM uses Long for timestamps related functions)
    def calledByValue(x: Long): Unit = {
        println("By value: " + x) // println("By value: " + 123454656778L)
        println("By value: " + x)
    }

    // * The arrow tells the compiler that the parameter will be called by name
    def calledByName(x: => Long): Unit = {
        println("By name: " + x) // println("By name: " + System.nanoTime())
        println("By name: " + x)  
    }

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    // TODO: Why the second one returned different results between the println's?
    // *1. In calledByValue the parameter expression is evaluated before the function runs itself, and so the same value is used on every x call inside the function
    // *2. In calledByName, nanoTime is lazy-evaluated, and that means that is evaluated two times inside the function, not before the functions runs itself

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = println(x)

    // printFirst(infinite(), 34) This will crash the JVM with an infinite exception
    printFirst(34, infinite()) // This won't crash as infinite() is never being evaluated inside printFirst
  
}
