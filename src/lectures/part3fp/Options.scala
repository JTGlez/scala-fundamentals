import java.util.Random
object Options extends App {

    val myFirstOption: Option[Int] = Some(4)
    val noOption: Option[Int] = None

    println(myFirstOption)
    println(noOption)

    // Options were designed to work with unsafe APIs
    def unsafeMethod(): String = null // Imagine this method returns a string from a third party API and we don't know if it will return a null or a string

    val result = Some(unsafeMethod()) //! Wrong! Some(null)

    // Use Options to avoid nulls
    val result2 = Option(unsafeMethod()) //* The companion will build a Some or a None based on the result of the unsafeMethod

    println(result2)

    // Chained methods to use alternative routes
    def backupMethod(): String = "A valid result"
    val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod())) //* If the first Option is None, then the second Option will be used
  
    // Design better APIs
    def betterUnsafeMethod(): Option[String] = None // Never return null!
    def betterBackupMethod(): Option[String] = Some("A valid result")

    val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod() //* This is a better way to chain methods

    // Functions on Options
    println(myFirstOption.isEmpty) // False: it has a value
    println(myFirstOption.get) // ! Unsafe: it will throw an exception if the Option is None

    // Map, flatMap, filter
    println(myFirstOption.map(_ * 2)) // Some(8)
    println(myFirstOption.filter(_ > 10)) // None
    println(myFirstOption.flatMap(x => Option(x * 10))) // Some(40)

    // For comprehensions

    /**
      * 1. We have a dummy API that connects to a server and returns a connection
      */

    val config: Map[String, String] = Map(
        // Fetched from somewhere, and values from host and port might be null
        "host" -> "176.45.36.1"
    )

    class Connection {
        def connect = "Connected" // Connect to some server
    }

    object Connection {
        val random = new Random(System.nanoTime())

        def apply(host: String, port: String): Option[Connection] = 
            if (random.nextBoolean()) Some(new Connection)
            else None
    }

    // Stablishing a safe connection
    /**
      * Option(config.get("port")) returns a Option(None)
      * Some(None) 
      * Flatten will return a None
      * And the getOrElse will return a default value
      */

    // Avoid a null pointer exception
    val conn = Connection(config("host"), Option(config.get("port")).flatten.getOrElse("80")) // This is a safe way to connect to a server
    // val connection = host.flatMap(h => port.flatMap(p => Connection(h, p))) // This is the same as the line above

    /** FlatMap is the same as the following:
      * if (h != null)
      *     if (p != null)
      *         return Connection.apply(h, p)
      * return null
      */
    
    println(Option(config.get("port")))
    val connStatus = conn.map(c => c.connect)

    /** Map is the same as the following: 
      * if (conn != null)
      *     return conn.connect
      * return null
      */

    println(connStatus)

    // If we have a connection, we can call the connect method
    connStatus.foreach(println)

    // Another possible solution with chained calls
    config.get("host")
        .flatMap(host => config.get("port")
            .flatMap(port => Connection(host, port))
            .map(conn => conn.connect))
        .foreach(println)

    // For-comprehensions: a more readable way to write chained calls
    val forConnStatus = for {
        host <- config.get("host")
        port <- config.get("port")
        conn <- Connection(host, port)
    } yield conn.connect


}
