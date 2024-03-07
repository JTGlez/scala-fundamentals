package lectures.part1basics;

object ValuesVariablesTypes extends App {

    // TODO: Val is an immutable value with a datatype. It's like a constant.
    // They are meant to be used in intermediate computations, not reusing them throughout the program.
    // The compiler can infer the type of the value, so it's not necessary to specify it if it's clear enough.

    // val x: Int = 42
    val x = 42
    println(x)

    // Multiline expressions are discouraged, but they are possible using the semicolon:
    // val y: Int = 42; val z: String = "Hello, Scala!";

    // We don't need to use semicolons in most cases, as the compiler can infer the end of the line.
    val aStrings = "Hello"

    // Booleans on Scala are strict: a 0 or 1 can't replace true or false.
    val aBoolean = true
    val aChar = 'a' // For chars, we only use single quotes.

    // Numeric types: Byte, Short, Int, Long, Float, Double
    val anInt: Int = x
    val aShort: Short = 4613 // 16-bit integer (2-bytes integer).
    val aLong: Long = 4613948123123123239L // 64-bit integer (8-bytes integer).
    val aFloat: Float = 2.0f // 32-bit floating point number (4-bytes floating point number).
    val aDouble: Double = 3.14 // 64-bit floating point number (8-bytes floating point number).

    // TODO: Var is a mutable value with a datatype. That means that their value can be reassigned.
    // Variables are used primarily for side effects: changing the state of the program, display something on the screen, reassing a value, etc.
    // Prefer vals over vars, as they are less error-prone and easier to reason about.
    var aVariable: Int = 4
    aVariable = 5 // Side effect

    // ! In Scala, Types are actually classes! So, we can apply methods to every val or var as if they were objects.

}
