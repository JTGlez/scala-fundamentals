object MapFlatmapFilterFor extends App{

    //* Standard library implementation
    val list = List(1, 2, 3)
    println(list)
    println(list.head)
    println(list.tail)

    // Map
    println(list.map(_ + 1))

    // Filter
    println(list.filter(_ % 2 ==0))

    // FlatMap
    val toPair = (x: Int) => List(x, x + 1) // Element to a list: (1, 2), (2, 3), (3, 4)
    println(list.flatMap(toPair)) // Concat every list produced with toPair

    // Print all combinations between two lists
    val numbers = List(1, 2, 3, 4)
    val chars = List('a', 'b', 'c', 'd')
    val colors = List("black", "white")

    // Double for-loops "iterations"
    val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
    println(combinations)

    println(numbers.flatMap( n => chars.flatMap( c => colors.map(color => "" + c + n + color))))

    // Foreach: for side effects
    list.foreach(println)

    //* For-comprehensions: a more readable way to write chained maps and flatmaps. We can also add filters using if guards

    val forCombinations = for {
        n <- numbers if n % 2 == 0 //Guard conditions
        c <- chars
        color <- colors
    } yield "" + c + n + "-" + color

    println(forCombinations)

    for { // Identical to foreach
        n <- numbers
        
    } println(n)


    // Syntax overload
    println(list.map{ x =>
        x * 2
    })

    // Maybe: optional values



  
}
