package Lecures.Part2OOP

object MethodNotations extends App {

  class Person(val name: String, favorite_movie: String) {

    def movieLike(movie: String): Boolean = movie == favorite_movie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, What the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hello  my name is $name and my favorite move is $favorite_movie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.movieLike("Inception"))

  val tom = new Person("Tom", "Fight Club")


  // Methods with single parameters can be written something like this


  // INFIX NOTATION
  // The below statement is an infix notation is also called = operator notation
  // This is used for methods with 1 parameter.

  // OBJECT + METHOD + PARAMETER
  println(mary movieLike "Inception") // equivalent to println(mary.movieLike("Inception"))


  // Writing in this kind of method is called SYNTACTIC SUGAR method calling like natural language.
  println(mary + tom) // same as println(mary.+(tom))
  // In SCALA We can define anything as a method name. '+' can be a method name. This is a huge advantage of Scala over other languages

  // "Operators" in Scala

  println(1 + 2)
  println(1.+(2)) // same as println(1 + 2)


  // AKKA Actors have !, ?


  // PREFIX Notation
  // Unary Prefix Notation only works with !, - , + , ~
  val x = -1 // equivalent to 1.unary_-

  println(mary.unary_!) // Regular approach
  println(!mary) // Same as println(mary.unary_!) but with Syntactic Sugar

  // POSTFIX NOTATION
  // Can be used only for PARAMETERLESS FUNCTIONS (0 PARAMETERS)

  println(mary.isAlive)

  //println(mary isAlive) POSTFIX NOTATION for println(mary.isAlive)


  // APPLY NOTATION
  // Need to define "apply" method in the class implementation. This breaks the boundaries between OOP and Functional Programmingl
  println(mary.apply())
  println(mary()) // equivalent to mary.apply()


  /*
  Exercises

  1. Overload the + operator
    mary + "the rockstar" => new Person "Mary (the rockstar)"

  2. Add an age to the Person class
     Add a unary + operator => new person with the age + 1
     +mary => mary with the age incrementer

  3. Add a "learns method in the Person class => "Mary learns Scala"
     Add a learnsScala method, calls learns method with "Scala".
     Use it in postfix notation

  4. Overload the apply method
     mary.apply(2) => "Mary watched inception 2 times"
   */










}



