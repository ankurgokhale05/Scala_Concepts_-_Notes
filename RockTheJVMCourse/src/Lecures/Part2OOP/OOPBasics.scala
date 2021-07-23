package Lecures.Part2OOP

// constructor
// {} braces are delimiter to Class's body which defines implementation of class. Within body it can have anything from val and var definitions, function definitions, expressions, etc...
class Person(name: String, val age: Int = 0) {
  val x = 2 // val and var definitions within body are Fields

  println(1 + 3)
 /*
 Even though we passed println(person.x) we can also see 4 in console. As for every instantiation of class all the body within class implementation will be evaluated.
  */

  // def greet(name: String):Unit = println(s"$name says, Hi $name")
  // The greet method will print Daniel says, Hi Daniel but we want John says Hi Daniel. $name are based on Name passed in method but we want Person class name use this..
  def greet(name: String):Unit = println(s"${this.name} says, Hi $name") // this.name refers to "name" parameter of Class whether it is a Class Field or not.


  //overloading
  def greet(): Unit = println(s"Hi I am $name") // Default constructor will take $name as ${this.name} we don't need to specify separately. The confusion arises when we have class Parameter and method Parameter
  // with same name


   // def greet(): Int = 42 This is not overloading as method name is same but return types are different.

  // Multiple Constructor

  def this(name: String) = this(name, 0) // this is irrelevant as it is just omitting the age and we can pass default constructor
  def this() = this("John Doe")

}



// KEY TAKEAWAYS
/*
// Defining Classes

eg=>  class Person(name: String, age: Int)


// Instantiating classes
val bob = new Person("bob", 25)

// Parameters vs fields
eg=> class Person(val name: String, age: Int)

// Defining methods

eg=> def greet(): String =  {...}



// Calling methods

val bobSayHi = bob.greet

bob.greet is allowed method call for Parameterless methods








 */



