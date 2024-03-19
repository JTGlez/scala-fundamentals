object AnonymousFunctions extends App {

    // POO way to create a new function by "instantiating" the trait Function1
    val doubler = new Function1[Int, Int] {
        override def apply(x: Int): Int = x * 2
    }

    // Scala syntatic sugar to simplify function creation with arrow notation: lambda or anonymous function
    val doublerArrow: Int => Int = x => x * 2
    val doublerWithoutReturn= (x: Int) => x * 2

    // Multiple params: multiple params in parenthesis
    val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

    // No params: it just return 3!
    val justDoSomething = () => 3

    //* When using lambdas, we need to call the function with (), like JS or other languages (we cant call it by just the name as we can do using OOP Scala)
    println(justDoSomething) // Prints the function itself
    println(justDoSomething()) // Prints the 3

    // Curly braces styles with lambdas
    val stringToInt = { (str: String) =>
        str.toInt
    }

    // Moar syntatic sugar! 
    val niceIncrementer: Int => Int = (x: Int) => x +1
    // Omitting the x!
    val nicerIncrementer: Int => Int = _ + 1 // The underscore acts as a placeholder of the input value

    val nicerAdder: (Int, Int) => Int = _ + _ // (a, b) => a + b
    println(nicerAdder(2, 3))

    // TODO: We need to strictly declare the types to make the compiler be able to understand the "context" of the underscore (Basically, what is every _)

    // 2. Rewrite the superAdder with arrow notation

    val superAdder: Int => (Int => Int) = new Function1[Int, Function1[Int, Int]]{
    override def apply(v1: Int): Int => Int = new Function1[Int, Int]{

        override def apply(v2: Int): Int = v1 + v2

        } 

    }

    val superDuperAdder = (x: Int) => (y: Int) => x + y // Curried lambda function
    println(superDuperAdder(2)(3))
  
}
