object HOFsCurries extends App {

    // Int and a second function which receives a string and another function which receives a int and returns a boolean. All of this returns an Int and
    // then, we have a second function which receives a only int and returns a Int
    val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null //* Higher order function

    // Function that applies a function n times over a value
    // nTimes(f, n, x)
    // nTimes(f, 3, x) = f(f(f(x))) = nTImes(f, 2, f(x)) f(f...) is nTimes(f, 2)
    // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

    //* Higher order functions to compute a value
    def nTimes(f: Int => Int, n: Int, x: Int): Int = 
        if (n <= 0) x
        else nTimes(f, n-1, f(x))

    val plusOne = (x: Int) => x + 1
    println(nTimes(plusOne, 10, 1)) // 11

    //* Currying to nTimes

    // nTimesBetter now returns a lambda function
    // ntb(plusOne, 10) = x => plusOne(plusOne...(x))
    def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = 
        if (n <= 0) (x: Int) => x // Identity function
        else (x: Int) => nTimesBetter(f, n-1)(f(x)) 
    
    /**
      * nTimesBetter(plusOne, 3) => (x) => nTimesBetter(plusOne, 2)(plusOne(x))
      * nTimesBetter(plusOne, 3) => (x) => (x) => nTimesBetter(plusOne, 1)plusOne((plusOne(x)))
      * nTimesBetter(plusOne, 3) => (x) => (x) => (x) => nTimesBetter(plusOne, 0)(plusOne(plusOne(plusOne(x))))
      * TimesBetter(plusOne, 3) => (x) => (x) => (x) => (x) => x
      */

    /**
      * nTimesBetter(plusOne, 3)(5)
      * => nTimesBetter(plusOne, 2)(plusOne(5))
      * => nTimesBetter(plusOne, 1)(plusOne(plusOne(5)))
      * => nTimesBetter(plusOne, 0)(plusOne(plusOne(plusOne(5))))
      * => x = 8
      * 
      */

    val incrementBy3 = nTimesBetter(plusOne, 3)
    val newValue = incrementBy3(5)
    println(newValue)

    //* Curried functions: useful as helpers to reuse them in multiple values

    val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
    val add3 = superAdder(3) // y = 3 + y
    println(add3(10))
    println(superAdder(3)(10))

    //* Function with multiple parameter lists, so they can act like curried functions
    def curriedFormatter(c: String)(x: Double): String = c.format(x)

    val standardFormat: (Double => String) = curriedFormatter("%4.2f")
    println(standardFormat(20))

    // This is the longer way
    def curriedStandard: String => (Double => String) = (form: String) => (value: Double) => form.format(value)
    println(curriedStandard("%4.2f")(20))

    //* Another example: partial application
    def boringSum: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
    def funnySum(x: Int)(y: Int): Int = x + y

    val xEqual5: (Int => Int) = funnySum(7) // If we omit the return declaration, we could use funnySum(7)(_)

    println(xEqual5(5))

    // toCurry function

    def toCurry(f: (Int, Int) => Int): (Int => (Int => Int)) =
        x => y => f(x, y)

    def fromCurry(f: (Int => (Int => Int))): (Int, Int) => Int = 
        (x, y) => f(x)(y)

    def compose[A, B, T](f: A => B, g: T => A): T => B = 
        x => f(g(x))
    
    def andThen[A, B, C](f: A => B, g: B => C): A => C =
        x => g(f(x))

    def superAdder2: (Int => Int => Int) = toCurry(_ + _)

    def add4 = superAdder2(4)
    println(add4(17)) // 21

    val add2 = (x: Int) => x + 2
    val times3 = (x: Int) => x * 3

    val composed = compose(add2, times3)
    val ordered = andThen(add2, times3)

    println(composed(4)) // Apply operations in different orders
    println(ordered(4))    
   
}