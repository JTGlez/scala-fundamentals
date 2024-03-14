

    /**
     * Generics:
     * In comparison with other languages, Scala uses a Strong-Static type strategy to declare and parse types. For example, in JS or Python
     * the interpreter doesn't actually know the type of a variable until it is evaluated. In contrast, the Scala compiler already knows
     * the type of every variable before the code actually runs.
     * 
     * This allows us to delegate to the compiler the task to verify the correctness of the declared types.
     * 
     */





object GentleGenerics extends App {

    val aNumber = 42 // Scala already knows it's an Int
    val aMul = aNumber * 10 // Also, it knows that, as aNumber is an int, this op is valid

    val aBoolean = false
    // val anotherMul = aBoolean * 10 // Compiler detects this is not a valid expression for a boolean, before the code runs

    val aList: List[Int] = List(1, 2, 3) // Compiler shows it's a list of ints
    val secondElement = aList(1) // We can assume the any element is, in fact, an integer

    //* Generics allows us to make assumptions about the types we work with, and also, reuse logic on potentially unrelated types.

    trait MyList {
        def head: Int
        def tail: MyList
    }

    object Empty extends MyList {
        override def head = throw new NoSuchElementException()
        override def tail = throw new NoSuchElementException()
    }

    case class NonEmpty(h: Int, t: MyList) extends MyList {

        override def head: Int = h
        override def tail: MyList = t

    }

    val someNumbers: MyList = NonEmpty(1, NonEmpty(2, NonEmpty(3, Empty)))

    //* But what happens if we want to extend our class to use any data type?
    // TODO: We lost type safety! We can't make assumptions anymore of the elements' data type inside the list
    trait MyListAny {
        def head: Any
        def tail: MyListAny
    }

    object EmptyAny extends MyListAny {
        override def head = throw new NoSuchElementException()
        override def tail = throw new NoSuchElementException()
    }

    case class NonEmptyAny(h: Any, t: MyListAny) extends MyListAny {
        override def head: Any = h
        override def tail: MyListAny = t
    }

    //* Generics exists to adress this problem, guaranteeing both type safety and type compatibilty by reusing the same code logic

    //Type Argument [A]: Usually named with capital letters
    trait GoodList[A] {

        def head: A
        def tail: GoodList[A]

    }

    case class GoodEmpty[A]() extends GoodList[A] {
        override def head = throw new NoSuchElementException()
        override def tail = throw new NoSuchElementException()
    }

    case class GoodNEmpty[A](h: A, t: GoodList[A]) extends GoodList[A] {
        override def head: A = h
        override def tail: GoodList[A] = t
    }

    // The Int type replaces the generic type argument A over the whole code
    val goodNumbers: GoodList[Int] = GoodNEmpty(1, GoodNEmpty(2, GoodNEmpty(3, GoodEmpty())))
    val firstNumber = goodNumbers.head // Now we can assume that firstNumber is, in fact, an Int

    println(firstNumber)

    //* We can also use multiple type args
    trait MyMap[K, V] {
        def put(key: K, value: V): MyMap[K, V]
        def get(key: K): V
    }

    // Def generic methods: type safety now is guaranteed
    def lastElement[A](list: GoodList[A]): A =
        if (list == GoodEmpty()) throw new NoSuchElementException()
        else if (list.tail == GoodEmpty[A]()) list.head
        else lastElement(list.tail)
  
}
