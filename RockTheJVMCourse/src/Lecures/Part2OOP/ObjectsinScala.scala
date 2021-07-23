package Lecures.Part2OOP

object ObjectsinScala {

  // SCALA DOESN'T HAVE CLASS-LEVEL FUNCTIONALITY (EXAMPLE: "static" in JAVA)


  // OBJECT CAN HAVE VAL / VAR definitions and Method definitions
  // OBJECT can be defined in Similar way as Class except OBJECT doesn't take any parameters and can be called in similar way as Class level val & methods.

  object  Person { // type + only instance

    // "static" / "class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Implementing a factory method

    def apply(mother: String, father: String) = new Person("Bobbie")
  }



  class Person(val name: String) {

    // If a class with same name as object is declared within same scope this is called Companion Pattern
    // we are basically differentiating between the
    // instance based implementation and method level implementation

    // I nstance level functionality

  }
  // Differences in OBJECT in SCALA AND CLASS LEVEL DEFINITIONS IN JAVA
  // OBJECT IN SCALA => SINGLETON INSTANCE
  // Meaning of above statement is whenever I defined an object Person I define it's type but also its only instance



  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)
    val mary = Person
    val john = Person
    println(mary == john) // true  because Mary & John point to same instance referred to which is object called Person
    // singleton instances by definition

    /*
    val mary2 = new Person
    val john2 = new Person

    println(mary2 == john2) // false because Mary & John point to 2 different instances
     */
    val mary2 = new Person("Mary")
    val john2  = new Person("John")

    val bobbie = Person("Mary", "John") // equivalent to val bobbie = Person.apply("Mary", "John")


  }


  // SCALA APPLICATIONS = SCALA OBJECT WITH   def main(args: Array[String]): Unit   equivalent to public static void main(String[] args)

  // otherwise if we don't want to write the main method use extends App


}

/*
KEY TAKEAWAYS

1) SCALA doesn't have static values / methods

2) SCALA objects
 - Are in their own class
 - Are the only instance
 - Singleton pattern in one line

3) SCALA Companions
  - Can access each others private members
  - Is more OO than Java

4) SCALA Applications
  - def main(args: Array[String]): Unit
  - extends App



 */
