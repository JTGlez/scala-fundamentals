abstract class MyGenericList[+A] {

    /** Single linked list which holds any data type The methods will be:
        *   1. head = first element of the list 2. tail = remainder of the list 3.
        *      isEmpty = is this list empty 4. add(int) = new List with the element
        *      added 5. override toString = a string representation of the list
        */

    // 2. Transform MyPredicate and MyTransformer into function types


    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]
    def printElements: String
    // Polymorphic call
    override def toString: String =
        "[ " + printElements + " ]" // Method on AnyRef class
    
    // * Higher order functions
    // Replace myTransform and myPredicate with arrow notation
    def map[B](transformer: A => B): MyGenericList[B]  // [1,3,3].map(n*2) = [2, 4, 6]
    def filter(predicate: A => Boolean): MyGenericList[A]  // [1,2,3,4].filter(n % 2) = [2, 4] Receives a predicate
    def flatMap[B](transformer: A => MyGenericList[B]): MyGenericList[B] // [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4] Receives a transformer from A to MyGenericList[B]

    // B supertype of A, which consumes something to concat
    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

    //* HOFs

    // For each method
    def foreach(f: A => Unit): Unit

    // Sort method
    def sort(compare: (A, A) => Int): MyGenericList[A]

    def zipwith[B, C](list: MyGenericList[B], zip:(A, B) => C): MyGenericList[C]

    def fold[B](start: B)(operator: (B, A) => B): B


}

//* ??? means returning nothing

case object Empty extends MyGenericList[Nothing] {

    def head: Nothing = throw new NoSuchElementException
    def tail: MyGenericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyGenericList[B] = new Cons(element, Empty)
    def printElements: String = "Im empty!"
    
    def map[B](transformer: Nothing => B): MyGenericList[B] = Empty

    def flatMap[B](transformer: Nothing => MyGenericList[B]): MyGenericList[B] = Empty

    def filter(predicate: Nothing => Boolean): MyGenericList[Nothing] = Empty

    def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list

    //* HOFs

    override def foreach(f: Nothing => Unit): Unit = () // Returns nothing

    override def sort(compare: (Nothing, Nothing) => Int): MyGenericList[Nothing] = Empty // Empty is already sorted

    def zipwith[B, C](list: MyGenericList[B], zip: (Nothing, B) => C): MyGenericList[C] = 
        if(!list.isEmpty) throw new RuntimeException("List do not have the same length")
        else Empty

    override def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

// As the abstract class is covariant, so the class too
case class Cons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
    def head: A = h
    def tail: MyGenericList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyGenericList[B] = new Cons(element, this)

    def printElements: String =
        if (t.isEmpty) "" + h
        else h + " " + t.printElements

    def filter(predicate: A => Boolean): MyGenericList[A] = 
        if(predicate(h)) new Cons(h, t.filter(predicate)) // Include the head
        else t.filter(predicate) // Else, filter the tail`

    def map[B](transformer: A => B): MyGenericList[B] = 
        new Cons(transformer(h), t.map(transformer) ) // .apply implicit

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = new Cons(h, t ++ list)

    def flatMap[B](transformer: A => MyGenericList[B]): MyGenericList[B] =
        transformer(h) ++ t.flatMap(transformer)

    /**
      * [1, 2].flatMap(n => [n, n+1])
      * = [1, 2] ++ [2].flatmap(n => [n, n+1])
      * = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [b, n+1])
      * = [1, 2, 2, 3]
      */
    
    /** Concat
      * [1,2] ++ [3,4,5]
      * = new Cons(1, [2] ++ [3, 4, 5])
      * = new Cons(1, new Cons(2, [Empty] ++ [3, 4, 5])) 
      * = new Cons(1, new Cons(2, [3, 4, 5]) = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
      */

      //* HOFs

    def foreach(f: A => Unit): Unit = {
        f(h)
        t.foreach(f)
    }

    def sort(compare: (A, A) => Int): MyGenericList[A] = {

        def insert(x: A, sortedList: MyGenericList[A]): MyGenericList[A] = 
            if (sortedList.isEmpty) new Cons(x, Empty)
            else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList) // X is smaller
            else new Cons(sortedList.head, insert(x, sortedList.tail)) // The head is the smallest, 

        val sortedTail = t.sort(compare)
        insert(h, sortedTail)
    }

    def zipwith[B, C](list: MyGenericList[B], zip: (A, B) => C): MyGenericList[C] = 
        if(list.isEmpty) throw new RuntimeException("List do not have the same length")
        else new Cons(zip(h, list.head), t.zipwith(list.tail, zip))

    def fold[B](start: B)(operator: (B, A) => B): B = {
        val newStart = operator(start, h)
        t.fold(newStart)(operator)
    }

    /**
      * [1,2,3].fold(0)(+)
      * = [2, 3].fold(1)(+)
      * = [3].fold(3)(+)
      * = [].fold(6)(+)
      * = 6
      */
        
}

    /**
      * How does map works?
      * We start with the next expression [1,2,3].map(n*2)
      * = new Cons(2, [2, 3].map(n * 2))
      * = new Cons(2, new Cons(4, [3].map(n * 2)))
      * = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      * = new Cons(2, new Cons(4, new Cons(6, Empty)))
      *
      */

      /**
        * How does filter works?
        * We start with the next expression [1,2,3].filter(n % 2 == 0)
        * = [2,3].filter(n%2==0)
        * = new Cons(2, [3].filter(n%2==0))
        * = new Cons(2, Empty.filter(n%2==0))
        * = new Cons(2, Empty)
        * 
        */

/* trait MyPredicate[-T] { // T => Boolean
    def test(element: T): Boolean
}


trait MyTransformer[-A, B] { // A => B
    def transform(element: A): B
} */


/* 

class EvenPredicate extends MyPredicate[Int] {

    def test(element: Int): Boolean = element % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int]{
    def transform(element: String): Int = element.toInt
}
 */

object ListTest2 extends App {
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val cloneList = list.copy()
    val list2 = new Cons("Hello", new Cons("Scala", Empty))

    println(list.toString)
    println(list2.toString)

    val myTransformer = new Function1[Int, Int] {
        override def apply(v1: Int): Int = v1 * 2
    }

    val myTransformer2: Int => Int = _ * 2

    val myPredicate = new Function1[Int, Boolean] {
        override def apply(v1: Int): Boolean = v1 % 2 == 0
    }

    val myPredicate2: Int => Boolean = _ % 2 ==0 // (elem => elem % 2 == 0)

    val mySecondTransformer = new Function1[Int, MyGenericList[Int]] {
        override def apply(v1: Int): MyGenericList[Int] = new Cons(v1, new Cons(v1 + 1, Empty))

    }

    // (elem => new Cons(elem, new Cons(elem + 1, Empty)))
    val myThirdTransformer: Int => MyGenericList[Int] = (v1: Int) => new Cons(v1, new Cons(v1 + 1, Empty))

    println(list.map(myTransformer2))

    println(list.filter(myPredicate2))

    val anotherList = new Cons(4, new Cons(5, Empty))

    println((list ++ anotherList).toString())

    println(list.flatMap(myThirdTransformer)) //[1, 2] sublist of 1, [2, 3] sublist of 2 and [3, 4] sublist of 3.

    println(cloneList == list) // With case classes, we don't need to check recursively if the two lists are equal

    list.foreach(println) // Foreach implementation

    println(list.sort((x, y) => y - x)) // Reversed list

    println(anotherList.zipwith[String, String](list2, _ + "-" + _))

    println(anotherList.fold(0)(_ + _)) // Reduce function

    // For comprehensions: it works because of the map, flatmap and filter signature we used
    println(for {
        n <- list
        string <- list2
    } yield n + "-" + string)

}