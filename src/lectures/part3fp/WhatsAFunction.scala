package lectures.part3fp

import java.util.function

object WhatsAFunction extends App {

    //* FP: Use Functions as first class elements, like sending them as arguments, returned or being assigned to a variable
    // TODO: The problem is OOP itself, where everything is an object.

    // This is what a OOP can do to simulate a function
    trait MyFunction[A, B] {
        def apply(element: A): B = ???
    }

    // Anonymous instance
    val doubler = new MyFunction[Int, Int] {
        override def apply(element: Int): Int = element * 2
    }

    // Now we can call doubler like it is actually a function
    println(doubler(2))

    // Function types = Function1[A, B]. Up to 22 parameters
    val stringToIntConverter = new Function1[String, Int] {
        override def apply(string: String): Int = string.toInt
    }

    println(stringToIntConverter("3") + 4)

    // Syntactic sugar for Function2[A, B, R] === (A, B) => R
    val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
        override def apply(a: Int, b: Int): Int = a + b
    }

    //* All Scala Functions are objects instatiated from the Function1 to the Function22!

    // 1. A function which takes 2 string and concatenates them

    val concatString = new Function2[String, String, String] {
        override def apply(v1: String, v2: String): String = v1 + " " +  v2
    }

    println(concatString("Hola", "Scala"))

    // 2. Transform MyPredicate and MyTransformer into function types

    // 3. Define a function which takes an int and returns another function which takes an int and returns an int

    //* Closure: v1 is visible inside v2.
    val superAdder: Int => (Int => Int) = new Function1[Int, Function1[Int, Int]]{
        override def apply(v1: Int): Int => Int = new Function1[Int, Int]{

          override def apply(v2: Int): Int = v1 + v2

        } 

    }

    // Returns 7
    val adder3 = superAdder(3) // adder3 is actually a function
    println(adder3(4))

    //* Currying technique: they can be called with multiple parameters
    println(superAdder(3)(4))


}
