package Part1Basics

object Expressions extends App {

  val x = 1 + 2 // Expressions
  println(x)
  println(2 + 3 * 4)


  /*
  Operators
  + , - , * , /         => Normal operators

  &, |, ^, <<, >>, >>> (right shift with zero extension specific to Scala) => Bitwise Operators

  == , >=, <= , > , < , !=    => Relational Operators


  &&, ||, !  =>    Logical Operators
  */
  println(1 == x)  // Returns boolean as 1 is not 3 this returns False

  println(!(1 == x))

  var a_variable = 2
  a_variable += 2 // This causes side effects therefore use Var
  println(a_variable)

  // Instructions (DO) Vs Expressions (VALUE)

  // IF Expression

  val a_condition = true

  val a_conditioned_value = if(a_condition) 5 else 3  // Here IF is an expression and not a instruction
  println(a_conditioned_value)  // 5  since a_condition is True
  println(if(a_condition) 5 else 3) // The compiler doesn't throw us any error as IF is an expression and not a condition.


  // Imperative While Loop in Scala
  var  i = 0
  while(i < 10){
    println(i)
    i += 1
  }


  // PLEASE NEVER WRITE SUCH IMPERATIVE INSTRUCTIONS LIKE WHILE LOOP OR FOR LOOP USING SCALA. It is meant for Imperative
  // Programming languages like Python, Java, C++


  // EVERYTHING IN SCALA IS AN EXPRESSION

  val a_weird_variable = (a_variable = 2) // Unit Variable == Void
  println(a_weird_variable) // Returns ()
 // Reassigning a variable is a side effect. Side effects in Scala are actually returning a Unit.

  /*
  val a_while = while(i < 10){
    println(i)
    i += 1
  }
  println(a_while)

  Here a_while also is a Unit Variable
  */


  // Side Effects :  println, Reassigning of Vars, while
  // Side Effects in Scala are Treated as an expression which return a Unit Variable


  // Code Blocks

  // Code Block is an expression
  val example_code_block = {
    val x = 2
    val z = x + 2

    if(z > 2) "Hello" else "GoodBye"
  }

  // The value of example_code_block will depend on IF Expression resulting in the example_code_block value = "Goodbye"

  // The scope of val declared inside code block will remain visible within the code_block

  // For Example
  // val another_variable = z + 2 // This will result in an error as the value of z is not resolved or visible



  /*
  KEY TAKEAWAYS

  1) Learnt about operators
  2) EVERYTHING IN SCALA IS AN EXPRESSION
  3) INSTRUCTIONS VS EXPRESSIONS
  INSTRUCTIONS => Think about imperative programming languages like Java. As in to DO Something
  EXPRESSIONS => This is functional. As in to EVALUATE SOMETHING

   */

  /*
  EXERCISES
   */

  // 1) Difference between "Hello World" and println("Hello World")

  // The "Hello World" is a String whereas println("Hello World") is of type Unit since this is an expression with side
  // effects


  // 2)
  val some_value = {
    2 < 3
  }
  println(some_value)

  val some_other_value = {
    if(some_value) 234 else 456  // if expression is irrelevant
    42 // Since this is last expression the some_other_value = 42
  }
  println(some_other_value)









}
