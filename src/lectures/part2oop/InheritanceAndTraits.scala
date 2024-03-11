
object InheritanceAndTraits extends App{

    //* Single-class inheritance: you can only extends one class at a time
    // Superclass
    class Animal { // * If we add the keyword "final class Animal", then we won't be able to extend from Animal. We use "sealed" if we don't want extends from another file
        val creatureType = "wild" // class properties

        def eat = s"The animal says: ñomñom"
        private def privateEat = s"This is private!"
        def protectedEat = s"Only available to animals and, emm, other cats" //protected

        final def eatNotOverridable = println("You can't override me!") //* Override protection with final
    }

    // Subclass

    // Cat inherites the eat method, and also inherites all non-private attributes and methods
    class Cat extends Animal{

        def crunch = {
            println(protectedEat)
            println("Crunch crunch")
        }

    } 

    val cat = new Cat
    println(cat.eat)
    cat.crunch
    // println(cat.privateEat) // This won't works as privateDef isn't inherited
    // println(cat.protectedEat) This also won't work, because a protected method can only be used inside the subclasses methods, not outside as eat

    // TODO: We have three access modifiers: private, protected and public (which is the access modifier by default)

    //* Constructors
    class Person(name: String, age: Int) {

        // Overloaded constructor with just a name as a parameter
        def this(name: String) = this(name, 0)
    }
    // class Adult(name: String, age: Int, idCard: String) extends Person This won't work, because we re creating another constructor, we need to call the "super" constructor
    class Adult(name: String, age: Int, idCard: String) extends Person(name) // Extending a class with parameters

    //* Overriding: methods, fields and properties

    // TODO: Both implementations of override are valid
    /* class Dog(override val creatureType: String) extends Animal {

        // override val creatureType: String = "domestic" // We can also override class-properties
        override def protectedEat = s"The dog says: crunch crunch"
    } */

    class Dog(dogType: String) extends Animal {
        override val creatureType: String = dogType
        override def protectedEat = {
            println(super.eat) //* Super Allows access to the eat method defined on Animal
            s"The dog says: crunch crunch"
        }

        // override def eatNotOverridable = "" Operation not allowed

    }

    val dog = new Dog("French Pool")
    println(dog.protectedEat) // Now it allows to call protectedEat as now its a public method
    println(dog.creatureType) // Now it is K9 on the property creatureType

    //* Type substitution (polymorphism): every derived instance will prefer to use the overriden methods an properties defined in their subclasses
    // Polymorphism means that the unknownAnimal could act as a dog, even when it's an Animal based on the return type
    val unknownAnimal: Animal = new Dog("K9")
    println(unknownAnimal.protectedEat) // Uses the overriden implementation of protectedEat for Dogs, if its not protected

    //* Preventing overrides

    /**
      * 1. Use final on member
      * 2. Use final on the entire class
      * 3. Seal the class = allows extend in the current file, but preventing the extension in others. Used to control the only legal types for, example, Animals
      */
    

}
