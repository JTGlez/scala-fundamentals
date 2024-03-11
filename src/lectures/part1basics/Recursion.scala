import scala.annotation.tailrec
object Recursion extends App {

  // * Every call to the factorial is stored on the JVM Stack Frame
  // * This example showcases how the recursive functions are processed: until the case base is
  // * reached, the compute of the intermediate results starts until we get the final results
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of " + n + "- I first need factorial of " + (n - 1)
      )
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }
  println(factorial(10))

  // TODO: But, a potential issue arises: the stack frame may become oversaturated at large numbers
  // This throws a java.lang.StackOverflowError
  // println(factorial(5000))

  // * However, this limitation can be overcome if we modify our function algorithm.
  def anotherFactorial(n: Int): BigInt = {

    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // Tail Recursion
    }

    factHelper(n, 1)
  }

  /** anotherFactorial(4) = factHelper(4, 1)
    * \= factHelper(3, 4 * 1)
    * \= factHelper(2, 3 * 4 * 1)
    * \= factHelper(1, 2 * 3 * 4 * 1)
    * \= 2 * 3 * 4 * 1 == 1 * 2 * 3 * 4
    */

  // If we use Int, we get a 0 as result because the number will be too big for an Int
  println(anotherFactorial(5000))

  // * Another example using the sum of the first n numbers
  // The tailrec annotation will throw an error if the function is not tail-recursive
  // @scala.annotation.tailrec 
  def sum(n: Int): Int = {
    if (n <= 0) 0
    else n + sum(n - 1)
  }

  // TODO: Notice how every call to sum creates a new stack frame, which store the info of the actual call and waiting the result of the next before it can continue
  // For n = 3, it computes for
  /** sum(3)
    * \= 3 + sum(2)
    * \= 3 + (2 + sum(1))
    * \= 3 + (2 + (1 + sum(0)))
    * \= 3 + (2 + (1 + 0))
    * \= 3 + (2 + 1)
    * \= 3 + 3
    * \= 6
    */

  // * Now, rewriting the last function using tail recursion
  def sumTail(n: Int): Int = {
    @scala.annotation.tailrec
    def sumAux(n: Int, accumulator: Int): Int = {
      if (n <= 0) accumulator
      else sumAux(n - 1, n + accumulator) // This allows to preserve the same call stack without creating another one
    }
    sumAux(n, 0)
  }

  // TODO: Instead of the previous functions, sumAux is the last expression evaluated everytime
  // TODO: As a result, sumAux is replaced in every iteration as we don't need to store the previous evaluations
  // TODO: The key is to use recursive calls as the last expression evaluated
  // For n = 3, it computes for
  /** sumTail(3) = sumAux(3, 0)
    * = sumAux(2, 3 + 0)
    * = sumAux(1, 2 + 3 + 0)
    * = sumAux(0, 1 + 2 + 3 + 0)
    * = 1 + 2 + 3 + 0 = 6
    */

    // * Exercises. Hint: accumulators must have the same desired return type
    // TODO: Accumulators should be used to store intermedium results between calls, instead of call the function itself

    // 1. Concatenate a string n times.

    def concatTail(str: String, n: Int) = {
        @scala.annotation.tailrec
        def concatAux(str: String, n: Int, accumulator: String): String = {
            if(n <= 0) accumulator
            else concatAux(str, n - 1, accumulator + str)

        }
        concatAux(str, n, "")
    }

    println(concatTail("Hello! ", 3))

    /** concatTail("Hola ", 3) = concatAux("Hola ", 3, "")
      * = concatAux("Hola ", 2, "" + "Hola ")
      * = concatAux("Hola ", 1, "" + "Hola " + "Hola ")
      * = concatAux("Hola ", 0, "" + "Hola " + "Hola " + "Hola ")
      * = "Hola Hola Hola"
      */

    // 2. isPrime function tail recursive

    def isPrimeTailRecursive(n: Int): Boolean = {
        @scala.annotation.tailrec
        def isPrimeUntilAux(t: Int, accumulator: Boolean): Boolean = {
            if (n <= 1) false
            else if (t <= 1) accumulator
            else isPrimeUntilAux(t - 1, accumulator && (n % t != 0))
        }
        isPrimeUntilAux(n / 2, true)
    }

    /** isPrimeTalRecursive(5) = isPrimeUntilAux(2, true)
      * = isPrimeUntilAux(1, true && (5 % 2 != 0)) //Evalúa a true el acc
      * = true
      */

    /** isPrimeTalRecursive(4) = isPrimeUntilAux(2, true)
      * = isPrimeUntilAux(1, true && (4 % 2 != 0)) //Evalúa a false el acc
      * = false
      */

    println("Are you prime? " + isPrimeTailRecursive(997))

    // 3. Fibonacci function, tail recursive
    // TODO: Thumb rule: you need as many acumulators as recursive calls you have.

    def fibonacciTail(n: Int): Int = {
        @scala.annotation.tailrec
        def fibonacciAux(n: Int, acc1: Int, acc2: Int): Int = {
            if (n <= 0 ) acc1
            else fibonacciAux(n - 1, acc2, acc1 + acc2)
        }
        fibonacciAux(n, 0, 1)
    }

    println("Secuencia de Fibonacci es: " + fibonacciTail(8))

    /** fibonacciTail(6) = fibonacciAux(6, 0, 1)
      * = fibonacciAux(5, 1, 1 + 0)
      * = fibonacciAux(4, 1 + 0, 1 + 1 + 0)
      * = fibonacciAux(3, 1 + 1 + 0, 1 + 1 + 0 + 1 + 0 )
      * = fibonacciAux(2, 3, 5)
      * = fibonacciAux(1, 5, 3 + 5)
      * = 8
      */
}
