
/** Variance
  * 
  */



object VariancePositions extends App {

    // We know that generics are used in classes to reuse same logic for different types, for example, when creating lists
    val list: List[Int] = List(1,2,3)
    val strlist: List[String] = List("Hello", "Scala", "!")

    class Animal
    class Dog(name: String) extends Animal

    //* Variance Question: if Dog <: (Extends) Animal, does List[Dog] <: (is a subtype) List[Animal]?
    
    // TODO: Case 1. If we answer yes, then Dog and Animal are Covariant types [+A]
    val lassie = new Dog("Lassie")
    val hachi = new Dog("Hachi")
    val laika = new Dog("Laika")

    //* Covariance allows to harness polymorphism, as we can create type Animal variables using Dogs, or treat dog lists as animal lists
    //* Covariance principle: if A is a subtype of B, then List[A] is a subtype of [B]
    //* As a result, if a part of the code expects a instance of [Animal], we can send instead a list of [Dogs] (Los perros, por extensión, son animales)
    val anAnymal: Animal = lassie // Dog.
    val myDogs: List[Animal] = List(lassie, hachi, laika) // List of dogs which is, in fact, a list of Animals.



    // TODO: Case 2. If we answer no, then Dog and Animal are unrelated types and, by definition, are Invariant types [A]. 
    // Type T is invariant and it has not any relationship with another type
    class MyInvariantList[T]

    //* As MyInvariantList is invariant, a list of dogs is not considered to be, by extension, a list of Animals; like they were complete separated entities
    // val myInvariantDogs: MyInvariantList[Animal] = new MyInvariantList[Dog]
    val myAnimals: MyInvariantList[Animal] = new MyInvariantList[Animal] // The type must match both on the return type and the instance creation







    // TODO: Case 3. If we answer no, but quite the opposite insted, we say the types are Contravariant types
    //* This means that a list of animals could be treated as a list of dogs, which is the opposite of the variance (treat a list of dogs as a list of animals)
    //* So, if a part of the code expects a instance of [Dog], we can use a instance of [Animal] instead. (Los animales, por extensión, son perros) ¿?

    class MyContravariantList[-T]

    val myDogs2: MyContravariantList[Dog] = new MyContravariantList[Animal] // ?!

    //* Why contravariance exists? And how can we use it?

    // Imagine a vet which can heal animals. As he can heal animals, he can also heals dogs, cat, parrots,...
    trait Vet[-T] {
        def heal(animal: T): Boolean
    }

    val myDog3 = new Dog("Buddy") // He is sick :(

    // So, using contravariance, we can return a Vet of Dogs by creating a vet of Animals
    //* With this, if we need a instance of Vet[Dogs], we can use a instance of Vet[Animal] (Los veterinarios de animales, por extensión, son veterinarios de perros)
    val myVet: Vet[Dog] = new Vet[Animal] { // Vet of Animals which is, in fact, a vet of dogs
        override def heal(animal: Animal): Boolean = {
             println("You will be fine doggy")
             true
        }
    }

    myVet.heal(myDog3)

    /** Productors: particular to general
      * Covariant. If the generic type contains or create elements of type T, it should be +T
      * Example: a cage(that can contain animals), a garage(which can contain cars), a factory(which produce elements), and any collection of elements (like a List)
      * 
      * Consumers: general to particular
      * Contravariant. If the generic type acts on or consume elements of type T, it should be -T
      * Example: a vet(heal animals), mechanic(fix cars), garbage pit(consume garbabe), or a function
      * 
      * 1. En pocas palabras, la covarianza se usa cuando se desea aplicar polimorfismo sobre subtipos, es decir, se busca que los subtipos de A sean válidos como substitutos de A.
      * 2. La contravarianza, en cambio, se usa cuando se busca aplicar acciones sobre un tipo de dato específico tal que las instancias generales puedan actuar sobre un subtipo específico.
      * 3. Por último, la invarianza indica que los tipos de dato no guardan relación y, por tanto, las instancias creadas siempre deben ser del mismo tipo.
      */
  
}
