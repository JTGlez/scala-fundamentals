
object StringOps extends App{
  
    val str: String = "Hello, I am learning Scala"

    // We can use Java string related functions to manipulate strings
    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(" ").toList) // Returns an array, and cast it to a List
    println(str.startsWith("Hello")) // Returns true as the strings starts with "Hello"
    println(str.replace(" ", "-"))
    println(str.toLowerCase)
    println(str.length)

    // Scala has it's own utilities, for example, for casting or appending
    val aNumberString = "45"
    val aNumber = aNumberString.toInt
    println('a' +: aNumberString :+ 'z') //Prepending and appending characters: it will return a45z
    println(str.reverse)
    println(str.take(2)) // Return de the first two elements from the string

    // Scala-specific: String interpolators

    //* S-Interpolators: can be used to calculate expressing
    val name = "David"
    val age = 12
    val greeting = s"Hello, my name is $name and I am $age years old"
    val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
    println(anotherGreeting)

    //* F-Interpolators: they can receive printf-like formats and print float-point numbers, enforcing the data type
    val speed = 1.2f
    val myth = f"$name%s cant eat $speed%2.2f burgers per minute"
    println(myth)

    //* Raw-interpolator: it can print characters literally
    println(raw"This is a \n newline")
    val escaped = "This is a \n newline"
    println(raw"$escaped") // Won't escape the \n from the val.
}
