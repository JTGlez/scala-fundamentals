import scala.AnyValCompanion

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

    //* How to define custom exceptions
    class myException extends Exception
    val exception = new myException

    // throw exception

    // 1. Crash program with an OutOfMemoryError
    // throw new OutOfMemoryError
    // val array = Array.ofDim(Int.MaxValue) OOM

    // 2. Crash program with a SOError
    // throw new StackOverflowError
    // def infinite: Int = 1 + infinite
    // val noLimit = infinite

    class OverflowException extends Exception
    class UnderflowException extends Exception
    class MathCalculationException extends Exception

    class PocketCalculator

    object PocketCalculator {

        // Int companion object
        val f = Int


        def add(x: Int, y: Int) = try {

            val result = x + y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
            else result 

        } catch {
            case ex: OverflowException => println("Sum exceeds the max Integer size") 
        }

        def sub(x: Int, y: Int) = try {
            
            val result = x + y
            if (x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result 
        } catch {
            case ex: UnderflowException => println("Sub is minor than the minor value for Integers") 
        }

        def mul(x: Int, y: Int): Int = {
            val result = x * y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result < 0) throw new OverflowException
            else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result 
        } 

        def div(x: Int, y: Int) = try {
            
            if(y > 0) x / y
            else throw new MathCalculationException
        } catch {
            case ex: MathCalculationException => println("Division by 0") 
        }

    }

    val result = PocketCalculator.div(2, 0)

    println(result)
    println(Int.MaxValue)

}
