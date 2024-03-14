
object CaseClasses extends App {

    //* Case classes allows us to write less boilerplate code when we implement classes and their companion objects, and they come with nice utilities

    /**
      * 1. Class parameters are fields by default
      * 2. Sensible toString method
      * 3. Equals and hashCode implemented out of the box (relevant to collections)
      * 4. Case classes come with handy copy methods
      * 5. CCs have companion objects, and the compiler creates thes automatically (we don't need anymore the new keyword)
      * 6. CCs are Serializable: we cand send them through HTTP Requests o JSONs
      * 7. CCs have extractor patters = CCs can be used in Pattern Matching
      */

    case class Person(name: String, age: Int)

    // Properties are accessible by default
    val jim = new Person("Jim", 34)
    println(jim.name)

    // We can get a readable toString representation of the object, intead of the cryptic Person@28c98d...
    println(jim.toString)
    println(jim) // Syntatic sugar to call toString

    // With equals and hashCode, now jim and jim2 are considered equal (in a normal class this would return false)
    val jim2 = new Person("Jim", 34)
    println(jim == jim2)

    // Returns a copy of jim with a different age
    val jim3 = jim.copy(age = 45)
    println(jim3)

    // Companion objects
    val thePerson = Person
    val mary = Person("Mary", 23) // Factory method set by default with apply (makes it callable like a function)
    println(mary)

    //* Case objects: they are their own companion objects
    case object UnitedKingdon {
        def name: String = "The UK of GB and NI"
    }
  
}
