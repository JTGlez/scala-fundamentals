
object AnonymousClasses extends App {

    abstract class Animal {
        def eat: Unit
    }

    //* Anonymous class: class AnonymousClasses$$anon$1 extends Animal {
                            //*override def eat: Unit = println("ahahahahah")
    //*                  }
    //*                  val funnyAnimal: Animal = new AnonymousClasses$$anon$1

    // The compiler creates a brand new class with the expressions declared inside the brackets
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("ahahahahah")
    }

    println(funnyAnimal.getClass)

    class Person(name: String) {
        def sayHi: Unit = println(s"Hi, my name is $name, How can i help?")
    }

    //* We can also create anonymous classes even from non-abstract data types
    val jim = new Person("Jim") {
        override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
    }

    //* Instatiating from a trait and overriding fields and methods on the spot
    trait AnimalTrait {
        def eat: Unit
    }

    val predator = new AnimalTrait {
        override def eat: Unit = println("Rawr!")
    }

    predator.eat


}
// Rules to create anonymous classes and instances
/*  1. Pass al the required arguments to the constructor if needed
    2. Implement all abstract fields/methods
 */
