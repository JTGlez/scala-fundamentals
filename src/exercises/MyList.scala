package exercises

abstract class MyList {

    /**
      * Single linked list which holds integers
      * The methods will be:
      * 1. head = first element of the list
      * 2. tail = remainder of the list
      * 3. isEmpty = is this list empty 
      * 4. add(int) = new List with the element added
      * 5. override toString = a string representation of the list
      */

    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Int): MyList
    def printElements: String
    // Polymorphic call
    override def toString: String = "[ " + printElements + " ]" // Method on AnyRef

}

//* ??? means returning nothing

object Empty extends MyList {

    def head: Int = throw new NoSuchElementException
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): MyList = new Cons(element, Empty)

    def printElements: String = "Im empty!"

}


class Cons(h: Int, t: MyList) extends MyList {

    def head: Int = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    def add(element: Int): MyList = new Cons(element, this)

    def printElements: String = 
        if (t.isEmpty) "" + h
        else h + " " + t.printElements

}

object ListTest extends App {
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.tail.head) // 2
    println(list.add(4).head) // 4
    println(list.toString()) // toString is called in the abstract class, and then using polymorphism it invokes the correct method for printElements

    val emptyList = Empty
    println(emptyList.toString())
}
