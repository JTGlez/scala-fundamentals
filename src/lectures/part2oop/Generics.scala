object Generics extends App {

    //* Generics: used to define a "general" type and use the same code with, for example, Int, Floats, Strings,...
    class MyList[+A] {

        // B is a supertype of A: This means that, if we add a B element inside of a list of A, then the list will turn into a List of B
        def add[B >: A] (element: B): MyList[B] = ???
        /**
          * A = Cat
          * B = Animal
          * If we add Animals(like dogs) to a list of cats, then the list will be now a list of Animals
          */
    }

    class MyMap[Key, Value]

    val listOfIntegers  = new MyList[Int]
    val listOfStrings   = new MyList[String]

    //* Generic methods
    object MyList {

        def empty[A]: MyList[A] = ???

    }

    val emptyListOfIntegers = MyList.empty[Int]

    //* Variance problem: we have 3 scenarios that arise problems between types equivalency

    class Animal
    class Cat extends Animal
    class Dog extends Animal

    //* 1. List[Cat] extends List[Animal] = Covariance; that means that a List of Cat is also a List of Animals

    class CovariantList[+A] // [+A] means it uses covariance

    // We can use a sort of "polymorphism"
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    // But can we do animalList.add(new Dog)? Even when the list of animals is, in fact, a list of dogs
    // TODO: Answer is that, if we add the dog, then the List will turn into a List of Animals, which is more generic

    //* 2. List[Cat] != List[Animal] = Invariance; so the two lists are not interchangeable

    class InvariantList[A]
    // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] This won't work!

    //* 3. Contravariance: the opposite relationship between animals and cat shown in the first case
    class ContravariantList[-A]
    val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal] // How can you replace a list of cats with a list of animals?

    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal] // But, in this case, to provide a trainer of cats, we can use a trainer of animals (can trains cats, dogs, ...)


    //* Bounded Types: restrictions to the generics
    class Cage[A <: Animal](animal: A) // Class cage only accepts A types which are subtypes of Animal
    val cage = new Cage(new Dog)

    class Car
    // val newCage = new Cage(new Car) This won't compile, as a Car is not a subtype of Animal

}
