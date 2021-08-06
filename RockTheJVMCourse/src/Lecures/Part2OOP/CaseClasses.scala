package Lecures.Part2OOP

object CaseClasses extends  App{

  /*
  equals, hashcode, toString
   */


  // 1. Class Parameters as Fields
  case class Person(name: String, age: Int){

  }


  val jim = new Person("Jim", 34)
  println(jim.name) // This returns Jim because it is a case class if it was a normal class the name parameter will not be accessible since it is not a field


  // 2. Sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. Equals and HashCode implemented OutOfTheBox

  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // This returns true because it is a case class. If it was a normal class then it would had returned false. The reason is jim and jim2 are 2 separate
  // instances of Person class but equals method is not implemented so it take from Any.Ref


  // 4. Case Classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case Classes have companion objects
  val thePerson = Person // Person is companion object of Case Classes
  val mary = Person("Mary", 23) // Companion objects have some factory methods like apply method discussed in previous sections. No "new" keyword to instantiate an object

  // 6. Case Classes are serializable
  // Particularly useful for distributed systems
  // Useful for Akka

  // 7. Case Classes have Extractor Patterns => Case Classes can be used in Pattern Matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand Case Classes and Case Objects in MyList
   */


}
