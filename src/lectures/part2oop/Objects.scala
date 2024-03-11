
object Objects extends App {

    // TODO: Scala doesn't have class-level functionality! "Static" concept doesn't exist strictly in Scala
    //* "Object" is a separate concept in Scala. We tipically use objects to refer to instances, but in Scala
    //* the term "object" also denotes a singleton instance of a class.

    // Normal instances
    class Person(val name: String) {
        // Instance-level functionality
    }

    //* Scala objects are singleton instances by definition: we define it's type and it's only instance
    // Objects can't receive parameters
    object Person {
        // Class-level functionality
        val N_EYES = 2
        def canFly: Boolean = false

        //* Factory method: its purpose is to construct persons given certain parameters, and it's tipically invoked using apply "()" syntax
        // TODO: Is widely used!
        def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    //* We call this pattern "Companion Objects": they are defined in the same scope and have the same name

    println(Person.N_EYES)
    println(Person.canFly)

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // True, as the two vals are pointing to the singleton Person instance

    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) // Actually it returns false as they are now different instances

    val bobbie = Person(mary, john) //* We can call the singleton object as a function to create new instances of Persons!

    //* Scala Applications
    // A scala app is just an object with a particular method called def main(args: Array[String]): Unit
    // The easiest way is to just extends from App, but also we can define the main method inside our code and omit the extends at all.
  
}
