package Lecures.Part2OOP

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  val funny_animal: Animal = new Animal {
    override def eat: Unit = println("HAHAHAHA")
  }

  // This is an anonymous class. When we define new Animal with on the spot implementation then compiler does is

  /*
  Equivalent to

  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("HAHAHAHA")
  }
  val funny_animal: Animal = new AnonymousClasses$$anon$1

  */
  println(funny_animal.getClass)

  class Person(name: String){
    def sayHi : Unit = println(s"Hello my name is $name, How can I be of service")
  }
  // Here you have to pass the same number of parameters of the class you are extending even anonymously
  val Jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hello my name is Jim, How can I be of service")
  }

  // KEY TAKEAWAYS

  /*
  We can instantiate types and override fields or methods on the spot
  for example

  trait Animal {
    def eat: Unit
  }
  val predator = new Animal{
    override def eat: Unit = println("RAWR")
  }

  Rules
  1) Pass in the necessary constructor arguments needed
  2) Implement all abstract fields and methods
   */
  // This can be done for all traits and classes (abstract or not)




}
