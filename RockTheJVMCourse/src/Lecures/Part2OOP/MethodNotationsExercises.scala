package Lecures.Part2OOP

import scala.language.postfixOps

object MethodNotationsExercises extends App {
  class Person(val name: String, favorite_movie: String, val age: Int = 0) {

    def movieLike(movie: String): Boolean = movie == favorite_movie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // 1st solution implementation
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favorite_movie, age)


    // 2nd solution implementation
    def unary_+() : Person = new Person(name, favorite_movie, age + 1)

    def print(): Unit = println(age)

    def unary_! : String = s"$name, What the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hello  my name is $name and my favorite move is $favorite_movie"


    // 3rd solution implementation
    def learns(skill: String): String = s"$name learns $skill"

    def learnsScala() = this learns "Scala"

    // 4th solution implementation
    def apply(number_of_times: Int): String = s"$name watched $favorite_movie $number_of_times times"


  }

  val mary = new Person("Mary", "Inception", 20)


  // 1st solution execution
  println((mary + "the rockstar")())
  // 2nd solution
  //mary.unary_+.print
  println((+mary).age)


  // 3rd solution
  println(mary.learns("Scala"))


  println(mary learnsScala)


  // 4th Solution

  println(mary.apply(2))
  println(mary(2))






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
