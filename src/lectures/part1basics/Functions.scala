package lectures.part1basics;

object Functions extends App {

    // * Basic function with only one expression; we can omit the brackets in this case
    // But, if we have multiple expressins, we can use a code block with brackets

    // * The compiler can also figure out the return type of the functions if not specified
    def aFunction(a: String, b: Int) = a + " " + b
    println(aFunction("Hi!", 5))    

    // TODO: Parameterless functions can also be called without parenthesis
    def aParameterlessFunction(): Int = 42
    // println( aParameterlessFunction() ) Deprecates syntax, we can omit the ()
    println( aParameterlessFunction ) // Returns 42

    // Instead of using loops, we can define a repeated function using recursion
    // * When you need loops, use instead recursion if possible
    // TODO: Recursive functions, unlike normal ones, need to have the return type specified, otherwise the compiler will complain
    def aRepeatedFunction(aString: String, n: Int): String = {
        if (n == 1) aString
        else aString + aRepeatedFunction(aString, n - 1)
    }

    println(aRepeatedFunction("Me Repito ", 3))

    // * If we're going to create a function with side effects, it's a good practice to return a Unit type
    def aFunctionWithSideEffects(aString: String): Unit = println(aString)

    // * A function can have inside another function declarations: this is called "Closure"

    def aBigFuntion(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b
        aSmallerFunction(n, n-1)        
    }

    println("My value is: " +  aBigFuntion(3)) // 3 + 2 = 5

    // TODO: Write the next functions

    // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
    def greetings(name: String, age: Int): String = {
        s"Hi, my name is $name and I am $age years old"
    }

    println(greetings("Yorch", 25))

    // 2. Factorial function 1 * 2 * 3 * ... * n
    def factorial(n: Int): Int = {
        if (n <= 0) 1
        else n * factorial(n-1)
    }

    println(factorial(5))

    // 3. A Fibonnaci function: a stream of numbers f(1) = 1, f(2) = 2..., f(n) = f(n-1) + f(n-2)
    def fibonacci(n: Int): Int = {
        if (n == 0 || n == 1) n
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

    println("My fibonacci is " +  fibonacci(2))

    // 4. Functions which tests if a number is even or odd.
    def testPrime(n: Int): String = if (n % 2 == 0) "Prime" else "Odd"

    println("The number is " + testPrime(3))

    // 5. Function to test is a number is prime until a certain number. Checks for every call if n is divided by t
    // if it's different of 0, then check the t - 1 value until you find a number that makes n % t = 0 (a non-prime)
    // if the last evaluated expression is true, then the number is prime.
    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t - 1)
        }
        isPrimeUntil(n / 2)
    }

    println(isPrime(37 * 17))

}