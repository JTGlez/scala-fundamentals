package lectures.part1basics

object Expressions extends App {

    // TODO: Expressions: reduced and evaluated to a certain value. Everything in Scala is an expression!
    val x = 1 + 2
    println(x)

    // Common expressions are math operations: +, -, *, /, &, |, ^, <<, >>, >>>, %, etc.
    println(2 + 3 * 4)

    println(1 == x) // Boolean expression: it returns false.

    println(!(1 == x)) // Boolean expression with a NOT: it returns true.

    var aVariable = 2
    aVariable += 3 // Adds 3 to aVariable = 5. It's a side effect!
    println(aVariable)

    // Instructions (DO) vs Expressions (VALUE)
    // Instructions: something you tell the computer to do
    // Expressions: something that is computed and, as a result, returns a value and/or a type.
    
    val aCondition = true

    // If expression
    val aConditionedValue = if (aCondition) 5 else 3 // If true, assign 5 to aConditionedValue. Otherwise, assign 3. 
    println(aConditionedValue)

    // TODO: Loops! They are discouraged because they are imperative and not functional, as they don't return a value.
    // NEVER USE LOOPS IN SCALA! 
    var i = 0
    val aWhile = while (i < 10) {
        print(i)
        i += 1
    }
    println(s"What value does aWhile return? ${aWhile}")

    // An assignment returns an Unit data type, which is loosely equivalent to void in other languages. 
    // It means that the expression doesn't return anything meaningful.
    val aWeirdValue = (aVariable = 3)
    println(aWeirdValue)

    // TODO: Every instruction/statement in Scala is represented as an expression which returns a Unit value.

    // Examples of side effects: println(), whiles, reassigning, etc. And in general, every imperative statement

    // Code Blocks: they are expressions, and the value of the block is the value of the last expression evaluated inside it.
    // The vals declared inside it are only scooped inside the block, and they are not accessible from the outside.
    val aCodeBlock = {
        val y = 2
        val z = y + 1
        if (z > 2) "hello" else "goodbye"
    }
    println(aCodeBlock)

    // In general, as we look at the previous examples, instructions are executed, while expressions are evaluated; which is what Scala does.

    // TODO: Questions

    // 1. What's the difference between "hello world" vs println("hello world")? 
    // ! "hello world" is a string, which is also an expression which returns the string value
    // ! and the second one is an statement which prints "hello world" on the console and returns a Unit type

    // 2. Look at the code blocks and determine the return result
    val someValue = {
        2 < 3
    } // true

    val someOtherValue = {
        if (someValue) 239 else 986
        42
    } // 42

    println(someValue, someOtherValue)

}
