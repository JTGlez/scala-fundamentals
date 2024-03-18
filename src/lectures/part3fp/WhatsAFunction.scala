package lectures.part3fp

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






    
  
}
