
object AbstractDataTypes extends App {

    //* Abstract classes: defines a class without implementations (not supplying properties and methods)
    // They can't be instantiated
    // And also abstract classes can have some members implemented already
    abstract class Animal {
        val creatureType: String = "Wild"
    
        def eat: Unit
    }

    class Dog extends Animal {

        // When defining propierties and methods, we can omit the "override" keyword as the compiler will understand that we re implementing them
        override val creatureType: String = "Canine"

        def eat: Unit = println("Crunch crunch")

    }

    //* Traits: 

    trait Carnivore { //Carnivore(name: String) is not allowed

        val preferredMeal: String = "Fresh meat"

        def eat(animal: Animal): Unit

    }

    trait ColdBlooded 

    // Inherits members from Animal, and also from Carnivore. We can inherit from multiple traits
    class Crocodile extends Animal with Carnivore with ColdBlooded {

        override val creatureType: String = "Croc"

        def eat: Unit = println("Nom nom croc")

        def eat(animal: Animal): Unit = println(s"Im a $creatureType and I'm eating ${animal.creatureType}")

    }

    val dog = new Dog
    val croc = new Crocodile

    croc.eat
    croc.eat(dog)

    /** Abstract vs Traits
      * 
      * 1. Both can have partial implementation of its members.
      * 2. Traits don't have constructor parameters
      * 3. We can only extend from one class, but we can extend from multiple traits (multiple inheritance)
      * 4. Traits are behaviors
      * 5. Abstract class are type of things
      */

      // For example, Animals describe what they are (some kind of animal), and Carnivore describe what they do (they are carnivore and eat other animals)

}
