abstract class MyGenericList[+A] {

    /** Single linked list which holds any data type The methods will be:
        *   1. head = first element of the list 2. tail = remainder of the list 3.
        *      isEmpty = is this list empty 4. add(int) = new List with the element
        *      added 5. override toString = a string representation of the list
        */

    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]
    def printElements: String
    // Polymorphic call
    override def toString: String =
        "[ " + printElements + " ]" // Method on AnyRef class
    
    def map[B](transformer: MyTransformer[A, B]): MyGenericList[B]  // [1,3,3].map(n*2) = [2, 4, 6]
    def filter(predicate: MyPredicate[A]): MyGenericList[A]  // [1,2,3,4].filter(n % 2) = [2, 4] Receives a predicate
    def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] // [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4] Receives a transformer from A to MyGenericList[B]

    // B supertype of A, which consumes something to concat
    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

}

//* ??? means returning nothing

case object Empty extends MyGenericList[Nothing] {

    override def flatMap[B](transformer: MyTransformer[Nothing,MyGenericList[B]]): MyGenericList[B] = Empty


    def head: Nothing = throw new NoSuchElementException
    def tail: MyGenericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyGenericList[B] = new Cons(element, Empty)
    def printElements: String = "Im empty!"
    
    def map[B](transformer: MyTransformer[Nothing, B]): MyGenericList[B] = Empty

    // def flatMap[B](transformer: MyTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = Empty

    def filter(predicate: MyPredicate[Nothing]): MyGenericList[Nothing] = Empty

    def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list


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

    def filter(predicate: MyPredicate[A]): MyGenericList[A] = 
        if(predicate.test(h)) new Cons(h, t.filter(predicate)) // Include the head
        else t.filter(predicate) // Else, filter the tail`

    def map[B](transformer: MyTransformer[A,B]): MyGenericList[B] = 
        new Cons(transformer.transform(h), t.map(transformer) )

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = new Cons(h, t ++ list)

    def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] =
        transformer.transform(h) ++ t.flatMap(transformer)

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

trait MyPredicate[-T] {
    def test(element: T): Boolean
}


trait MyTransformer[-A, B] {
    def transform(element: A): B
}

class EvenPredicate extends MyPredicate[Int] {

    def test(element: Int): Boolean = element % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int]{
    def transform(element: String): Int = element.toInt
}

object ListTest2 extends App {
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val cloneList = list.copy()
    val list2 = new Cons("Hello", new Cons("Scala", Empty))

    println(list.toString)
    println(list2.toString)

    println(list.map(new MyTransformer[Int, Int] {
        override def transform(element: Int): Int = element * 2
    }))

    println(list.filter(new MyPredicate[Int] {
        override def test(elem: Int): Boolean = elem % 2 == 0
    }).toString())

    val anotherList = new Cons(4, new Cons(5, Empty))

    println((list ++ anotherList).toString())

    println(list.flatMap(new MyTransformer[Int, MyGenericList[Int]] {
        override def transform(element: Int): MyGenericList[Int] = new Cons(element, new Cons(element + 1, Empty))
    }).toString()) //[1, 2] sublist of 1, [2, 3] sublist of 2 and [3, 4] sublist of 3.

    println(cloneList == list) // With case classes, we don't need to check recursively if the two lists are equal

}
