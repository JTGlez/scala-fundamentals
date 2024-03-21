object TuplesAndMaps extends App{

    //* Tuples = finite ordered "lists"
    val aTuple = (2, "Hello Scala") // Tuple2[Int, String] = (Int, String). We can create them with new, with companion apply, or simply with ()

    println(aTuple._1)
    println(aTuple._2)

    println(aTuple.copy(_2 = "GoodBye Java"))
    println(aTuple.swap) // ("Hello Scala", 2)

    //* Maps - Keys => Values
    val aMap: Map[String, Int] = Map()

    val phonebook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1) // Populate maps with tuples
    val phonebooksweeter = Map( "Jim" -> 555, "Daniel" -> 789 ) // Syntatic sugar to use K -> V notation instead of tuples

    println(phonebook)

    //* Basic map operations
    println(phonebook.contains("Jim")) // Returns true
    println(phonebook("Jim")) // Apply returns the value associated to the passed key
    // println(phonebooksweeter("Mary")) // TODO: Causes a crash if we don't add .withDefaultValue(-1) when creating the map
    println(phonebook("Mary"))

    val newPairing = "Mary" -> 678
    val newPhoneBook = phonebook + newPairing // Maps are inmutable, so we need to create a new map
    println(newPhoneBook)

    //* Map, flatMap and Filter
    
    // Map
    println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2)) // Shows the keys in lowercase

    // Filter
    println(phonebook.filterKeys(x => x.startsWith("J")).toMap) // toMap used to convert mapView to a static map (Views are lazy collections)

    // MapValues
    println(phonebook.mapValues(number => number * 10 + "LAMBDA").toMap) // Multiply values by 10

    // Conversions
    println(phonebook.toList)
    println(List(("Daniel", 555)).toMap)

    // Group by functionality
    val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
    println(names.groupBy(name => name.charAt(0))) // Groups key-values by using a discriminate function (in this case, grouping by the first letter)

    /**
      * 1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
      * 2. Overly simplified social network based on maps
      * Person = String
      * - add a person to the network
      * - remove a person
      * - friend (mutual)
      * - unfriend
      * - number of friends of a person
      * - person with most friends
      * - How many people have NO friends
      * - If there is a social connection between two people (direct or not)
      */

    // 1.
    val fakeJim = "JIM" -> 900
    val phonebook2 = phonebook + fakeJim
    println("This is the copy ", phonebook2)
    println(phonebook2.map(pair => pair._1.toLowerCase() -> pair._2)) // ! The fake JIM is discarded! They overlap, and as a result, we lose data

    // 2. Uses sets to avoid repeated values
    def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = 
        network + (person -> Set())

    def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
        val friendsA = network(a)
        val friendsB = network(b)
        network + (a -> (friendsA + b)) + (b -> (friendsB + a)) // Appending a and b to their respective friends
    }

    def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
        val friendsA = network(a)
        val friendsB = network(b)
        network + (a -> (friendsA - b)) + (b -> (friendsB - a)) // Appending a and b to their respective friends
    }

    def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

        // First, remove friendships if they existe
        def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
            if(friends.isEmpty) networkAcc
            else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

        val unfriended = removeAux(network(person), network)
        unfriended - person
    }

    val empty: Map[String, Set[String]] = Map()
    val network = add(add(empty, "Bob"), "Mary")
    println(network)

    println(friend(network, "Bob", "Mary"))

    println(unfriend(friend(network, "Bob", "Mary"), "Mary", "Bob"))

    // Remove Bob
    println(remove(friend(network, "Bob", "Mary"), "Bob"))

    // Jim, Bob, Mary
    val people = add(add(add(empty, "Bob"), "Mary"), "Jim")

    val jimBob = friend(people, "Bob", "Jim")
    val testNet = friend(jimBob, "Bob", "Mary")

    println(testNet)

    def nFriends(network: Map[String, Set[String]], person: String): Int = {
        if(!network.contains(person)) 0
        else network(person).size
    }

    println(nFriends(testNet, "Bob")) // Bob has two friends

    def mostFriends(network: Map[String, Set[String]]): String = 
        network.maxBy(pair => pair._2.size)._1 // Returns the key with the most friends

    println(mostFriends(testNet))

    def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = 
        network.filterKeys(k => network(k).isEmpty).size // Returns the number of people with no friends
        // Filter pairings: network.filter(pair => pair._2.isEmpty).size
        // Another way even shorter: network.count(_._2.isEmpty)

    println(nPeopleWithNoFriends(testNet))

    // This is pretty hard to grasp!
    def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
        @scala.annotation.tailrec
        def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
            if(discoveredPeople.isEmpty) false
            else {
                val person = discoveredPeople.head
                if(person == target) true // Found the target
                else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail) // Skip the person
                else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person)) // Add the person's friends to the discovered people
            }
        }

        bfs(b, Set(), network(a) + a)
    }

    println(socialConnection(testNet, "Mary", "Jim")) // True
    println(socialConnection(network, "Mary", "Bob")) // False

}
