package Lectures.Part1Basics

object ValuesVariablesTypes extends App {
  val x: Int = 42

  println(x)
  /*
  val x = 42
  println(x)
  */
  /*
  x = 2
  VALs are immutable. Once assigned to a particular value their value cannot be changed.


  Data Types of Val are optional. Therefore something like

  val x = 42

  will also work and will not throw any error. Since Compile can infer the value assigned to this variable during compile time

  */
  // Semicolons are optional. However if you are writing multiple expressions on same line then ';' are mandatory.
  // Not a good practice


  val a_string = "Hello"
  val  b_string = "World"

  /*
  Data Types in Scala
   */

  //1) String
  val example_string: String = "Hello World"

  // 2) Integer (4 Bytes)

  val example_int: Int = 43

  // 3) Boolean

  val example_boolean: Boolean = false

  // 4) Character

  val example_character: Char = 'a'

  // 5) Short (Half of Integer Representation = 2 bytes)

  val example_short: Short = 4316

  // 6) Long  (Double of Integer Representation = 8 bytes)

  val example_long: Long = 32423894293482394L
  // L is necessary at the end to mark it as Long

  // 7) Float

  val example_float: Float = 3.14f
  // f at the end is necessary to mark it as float

  // 8) Double

  val example_double: Double = 3.14


  /*
  // Variables

  Variable are mutable unlike Vals.
   */

  var example_variable: Int = 42

  example_variable = 43
  // Compiler doesn't complain



  /*
  Key Takeaways from this lesson
  1) Prefer Vals over Vars
  2) All Vals and Vars have types
  3) Compiler automatically infers the types when omitted
  4) Learnt basic data types
   */



}
