
object Exceptions extends App{

    val x: String = null
    // println(x.length()) NullPointerException! No one catched it, so the program will crash

    //* Throwing exceptions
    // In order to throw anything, throwable objects should come from throwable classes that extends the Throwable class
    // Exception(something went wrong!) and Error(internal error of the JVM) are the major Throwable subtypes

    // val aWeirdValue: String = throw new NullPointerException // Throws an exception, and returns nothing. Nothing can substitute any other data type

    //* Catch exceptions

    def getInt(withExceptions: Boolean): Int =
        if (withExceptions) throw new RuntimeException("No Int for you!")
        else 42
    
    val potentialFail = try { // Anyval comes from the two branches: Int or Unit, so, the compiler decides it will be a AnyVal
        // Code that might fail
        getInt(false)
    } catch {
        case ex: RuntimeException => println("Caught a Runtime exception") // If we change the expected exception, this will crash
    //* Finally is optional and doesn't influence the return type of the exception. Use it only for side effects (like login in a page)
    } finally {
        println("Im running no matter what")
    }

    println(potentialFail) // Unit value or Int value




}
