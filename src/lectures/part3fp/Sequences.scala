import java.util.Random
object Sequences extends App {

    //* Sequences
    val aSequence = Seq(1, 3, 2, 4) // Seq companion creates subclasses extended from List
    println(aSequence)
    println(aSequence.reverse)
    println(aSequence(2)) // Returns the value at the 2 index
    println(aSequence ++ Seq(7, 6, 5)) // Appends another sequence
    println(aSequence.sorted) // Sort method

    //* Ranges
    val aRange: Seq[Int] = 1 to 10 // Collection that is transformed into a sequence (1 until 10 excludes 10 from the foreach)
    aRange.foreach(println)

    (1 to 10).foreach(x => println(x + 1)) // Do 10 times something without recursion!

    //* Lists
    val aList = List(1, 2, 3)

    val prepended = 42 +: aList :+ 89 //Prepend a 42 and appends a 89
    println(prepended) //42 as head

    val apples5 = List.fill(5)("apple") //Curried function which fills a list with apple 5 times
    println(apples5)

    println(aList.mkString("-|-")) // Concats 1-2-3

    //* Arrays (Mutable)

    val numbers = Array(1,2,3,4)
    val threeElements = Array.ofDim[Int](3) // Allocates memory for an array of three elements
    println(threeElements)
    threeElements.foreach(println) // Default values: 0, false or null(Strings)

    // Mutations
    numbers(2) = 0 //numbers.update(2, 0) used only for mutable collections (in contrast with apply)
    println(numbers.mkString(" "))

    // Arrays and Seq
    val numbersSeq: Seq[Int] = numbers // Implicit convertion of an array to a sequence: wrapped array
    println(numbersSeq)

    // Vectors: inmutable sequences. 32 elements for level. High performance
    val vector: Vector[Int] = Vector(1, 2, 3)
    println(vector)

    // Vectors vs lists
    val maxRuns = 1000
    val maxCapacity = 1000000
    def getWriteTime(collection: Seq[Int]): Double = {
        val r = new Random
        val times = for {
            it <- 1 to maxRuns
        } yield {
            val currentTime = System.nanoTime()
            collection.updated(r.nextInt(maxCapacity), 0)
            System.nanoTime() - currentTime
        }

        return times.sum * 1.0 / maxRuns
    }

    val numbersList = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector

    println(getWriteTime(numbersList)) // Saves the reference to tails, but for middle elements it is O(n) and updating takes long time
    println(getWriteTime(numbersVector)) // Depth of the tree is small, but needs to replace an entire 32-element chunk

    // Arounds 3ms, and 1ns. Vector is the default implementation of sequences because this performance advantage
    

}
