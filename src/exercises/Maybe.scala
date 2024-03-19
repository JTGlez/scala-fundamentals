abstract class Maybe[+T] {

    def map[B](f: T => B): Maybe[B]
    def flatMap[B](f: T => Maybe[B]): Maybe[B]
    def filter(p: T => Boolean): Maybe[T]
  
}

// Singleton companion objects: intended to absense
case object MaybeNot extends Maybe[Nothing] {

    // Everything returns an empty collection
    def map[B](f: Nothing => B): Maybe[B] = MaybeNot
    def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
    def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot

}

// Case class that holds just one value
case class Just[+T](value: T) extends Maybe[T] {

    def map[B](f: T => B): Maybe[B] = Just(f(value))
    def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
    def filter(p: T => Boolean): Maybe[T] = 
        if (p(value)) this
        else MaybeNot 

}

object MaybeTest extends App {

    val just3 = Just(3)
    println(just3)

    println(just3.map(_ * 2))
    println(just3.flatMap( x => Just(x % 2 == 0) ))
    println(just3.filter(_ % 2 == 0))

    //* The point here is to denote the possible absense of a value to work with

}

