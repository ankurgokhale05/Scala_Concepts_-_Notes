package Lectures.Part1Basics

object StringOperations extends App {

  val example_string: String = "Hello, I am learning Scala"

  println(example_string.charAt(2))
  println(example_string.substring(7,11))

  println(example_string.startsWith("Hello"))
  println(example_string.replace(" ", "-"))
  println(example_string.toLowerCase())
  println(example_string.length)


  val a_number_string = "2"
  val a_number = a_number_string.toInt
  println('a' +: a_number_string :+ 'z')
  println(example_string.reverse)
  println(example_string.take(2))


  // Scala Specific String Interpolators

  // S-Interpolators
  // S-interpolators are defined by s"" . They allow us to inject expressions and variable values within

  val name = "Ankur"
  val age = 24
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)

  val another_greeting = s"Hello, my name is $name and I am ${age + 1} years old"

  // We can inject expressions within the code as well
  println(another_greeting)


  // F-Interpolators
 // Represented by f""
  val speed = 1.2f

  val myth = f"$name can eat $speed%2.2f burgers per minute"
  // Here we have done something like printf in C++ where in we have defined speed value to be 1.2f but while printing
  // we have specified the precision 2.2 meaning 2 characters minimum and precision upto 2 places.
  // Type mismatch are also checked by the compiler.
  println(myth)


  // raw-Interpolators

  println(raw"This is a \n newline") // Here it is printed as "This is a \n newline" and \n which represents new line will
  // not be escaped.
  val escaped = "This is a \n newline"
  println(raw"$escaped") // Here the \n will be escaped as the variable is injected and printed as a raw string



  /*
  KEY TAKEAWAYS



   */














}
