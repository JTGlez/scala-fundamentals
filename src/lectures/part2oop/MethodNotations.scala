import scala.language.postfixOps // Postfix notation is rarely used, and it needs to be enabled first

object MethodNotations extends App {

    class Person(val name: String, favoriteMovie: String, age: Int = 25) {

        def likes(movie: String): Boolean = movie == favoriteMovie

        def age(): Unit = println(s"My age is ${this.age} years old") 

        def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

        def +(nickname: String): Person = new Person(s"${this.name} ${nickname}", this.favoriteMovie)

        def unary_! : String = s"$name, what the heck!?" // The space between the name and the type is important!

        def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

        def isAlive: Boolean = true

        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie" // Syntatic sugar for applying a certain method with () notation

        def apply(n: Int): String = s"Mary watched ${this.favoriteMovie} $n times!"

        def learns(subject: String): String = s"Mary learns $subject"

        def learnScala() = this learns "Scala"  //this.learns("Scala") 

    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception")) // True

    // * Infix notation is an example of syntatic sugar: a way to simplify writing code and make it "prettier". Only works with methods with just one parameter
    println(mary likes "Inception") // Infix notation: only works with methods with just one parameter

    //* "Operators" in Scala: every operator like +, -, /, ... are actually methods with one parameter
    // TODO: Scala is permissive with the methods' name, so we can create method like + 
    // For example, akka actors uses ! ? to denote async actors
    val tom = new Person("Tom", "Fight Club")
    println(mary + tom) // Acts as an operator between mary and tom, which yields a new string
    println(mary.+(tom)) // Equivalent with the one above

    println(1 + 2)
    println(1.+(2))

    //* Prefix notation: !mary
    val x = -1 // Equivalent with 1.unary_-
    val y = 1.unary_- // Only works with - + ~ !

    // Syntatic sugar to implement unary_!
    println(!mary)
    println(mary.unary_!)

    //* Postfix notation: only available to methods with no parameters (another syntatic sugar)
    // TODO: This way of writing code is discouraged, as it can make code harder to read
    println(mary.isAlive)
    println(mary isAlive)

    //* Apply method: syntatic sugar to define a method "apply" in the class definition and call it with ()
    //* It's used to invoke objects as if they were functions
    // It's like a bridge between OOP and FP in Scala
    println(mary.apply()) 
    println(mary())

    // 1. Overload the plus operator with another signature: mary + "the rockstar" => new Person "Mary (the rockstar)"
    val maryRockstar = mary + "the rockstar"
    println(maryRockstar())

    // 2. Add an age to the persona class, and a unary which will increment the age of the personal and it will return
    // a new Person with age + 1. Ex. +mary => mary with age incremented
    val agedMary = +mary
    (+mary).age; // Equivalent
    agedMary age;

    // 3. Add a "learns"" method in the Person class => "Mary learns Scala"
    // Add a learnsScala method, calls learns method with "Scala"
    // Use it in postfix notation

    println(mary learnScala)

    // 4. Overload the apply method: mary.apply(2) => "Mary watched Inception 2 times"
    println(mary(3))
  
}
