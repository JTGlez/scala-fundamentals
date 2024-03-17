package lectures.part2oop

import lectures.part2oop.sayHello
import lectures.part2oop.SPEED_OF_LIGHT

// import playground._ // Only if you actually need all, import everything
import playground.{PrinceCharming, Cinderella => Princess} // We can rename classes with arrows

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  
    val write = new Writer("Daniel", "RockTheJVM", 2018)

    val princess = new Princess

    // Package Object: Universal objects to access them
    sayHello
    println(SPEED_OF_LIGHT)

    // Imports
    val prince = new PrinceCharming

    //* Aliases for libraries
    val date = new Date
    val sqlDate = new SqlDate(2018, 5, 4)

    //* Default imports: java.lang(String, Object, Exception), scala (Int, Nothing, Function), scala.Predef(println, ???)

}
