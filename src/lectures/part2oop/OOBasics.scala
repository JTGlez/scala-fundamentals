package lectures.part2oop

object OOBasics extends App {

    // Instance of Person
    val person = new Person("Jorge", 25)
    println(person.age) // Class field
    println(person.x)

    person.greet("Noreen")
    person.greet()

    val writer = new Writer("Jorge", "Gonzalez", 1998)
    writer.fullname()

    val sus = new Writer("Jorge", "Gonzalez", 1998) // This one is not the original novel writer

    val myNovel = new Novel("Pepita", 2015, writer)
    myNovel.authorAge()
    myNovel.isWrittenBy(writer) // If we send sus as parameter, it will return false

    val revisitedNovel = myNovel.copy(2018)
    revisitedNovel.authorAge()

    val counter = new Counter()
    counter.current()
    val newCounter = counter.increment(10)
    newCounter.current

    val anotherCounter = newCounter.decrement(8)
    anotherCounter.current

}

// Class constructor
class Person(name: String, val age: Int = 0) {
    // Class body: it can contain expressions, var/val definitions,..., like a code block
    // TODO: The whole code block will be evaluated at every instantiation

    val x = 2 // x is treated as a class field
    println(1+3) // Side effects are evaluated at first

    // Class Method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // Overloaded methods
    def greet(): Unit = println(s"Hi, I am ${this.name}") // As we are not using another param called name, we can use both this.name or name. 

    // Multiple constructors: this one calls the constructor with age as 0, but default parameters are prefered over aux constructors
    def this(name: String) = this(name, 0)

}

class Writer(firstName: String, surname: String, val yearBirth: Int) {

    def fullname(): Unit = println(s"${this.firstName} ${this.surname}.")
}

class Novel(name: String, releaseYear: Int, author: Writer) {

    def authorAge(): Unit = println(releaseYear - author.yearBirth)

    def isWrittenBy(author: Writer) = println(author == this.author)

    def copy(releaseYear: Int): Novel = new Novel(this.name, releaseYear, this.author)

}

// With val, we can use a "get" operation to return a field value (like a getter)
class Counter(val count: Int = 0) {

    def current(): Unit = println(s"Current value is: $count")

    // Inmutability principles applied to objects and classes
    def increment(): Counter = new Counter(this.count + 1)
    // def increment(value: Int): Counter = new Counter(this.count + value)
    def increment(value: Int): Counter = {
        if(value <= 0) this // Doesn't need increments, so we return a new counter with the increment value
        else increment.increment(value - 1) // Calls increment in the context of the overloaded method
    }

    def decrement(): Counter = new Counter(this.count - 1)
    //def decrement(value: Int): Counter = new Counter(this.count - value)
    def decrement(value: Int): Counter = {
        if(value <= 0) this // Doesn't need increments, so we return a new counter with the increment value
        else decrement.decrement(value - 1) // Calls increment in the context of the overloaded method
    }
}

/** Every recursive call increments the count value, so it's like 0 + 1 = 1, 1 + 1 = 2, 2 + 1 = 3, ...
  * increment(3)
 -> increment(2)
    -> increment(1)
      -> increment(0)
        -> retorna el objeto Counter actualizado con count = 3
  */

//* Class parameters are not fields! To use them as fields, add the val keyword before the paramater