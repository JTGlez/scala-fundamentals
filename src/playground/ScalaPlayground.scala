package playground;

// Extends App makes ScalaPlayground executable as an application
// Also, we can define the main method as follows:

object ScalaPlaygroundMain {
    def main(args: Array[String]): Unit = {
        println("Hello, Main Scala!")
    }
}

object ScalaPlayground extends App {
    println("Hello, App Scala!")
}