package Lecures.Part2OOP

object AbstractClasses extends  App {

  // Defining an abstract class

  abstract class Animal {
    val creatureType: String = "Wild" // abstract classes can have abstract and non abstract data members
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType = "Canine"
    def eat = println("Crunch crunch") // override is optional whenever we are extending abstract classes
  }

  // Traits are similar to abstract classes
  // The major benefit of Trait is that we can extend a class and a trait simultaneously

   trait Carnivore {
     def eat(animal: Animal): Unit
     val preferredMeal: String = "Fresh Meat"
   }

  trait Coldblooded {
    val animal_type: String

  }

  class Crocodile extends Animal with Carnivore with Coldblooded { // we can add multiple traits
    override val creatureType: String =  "I am a crocodile"

    val animal_type = "Most Cold Blooded"
    def eat(): Unit = println("Nomnom")

    def eat(animal: Animal): Unit = println(s"Hello my name is Croc, I'm a $animal_type  and I am eating ${animal.creatureType}")

  }

  val dog = new Dog()
  val croc = new Crocodile()

  croc.eat(dog)


  // Difference between Abstract Class and Traits

  // 1. Traits cannot have Constructor Parameters => cannot have something like trait Carnivore(name: String){}
  // 2. Can extend only 1 class but multiple traits may be inherited by same class => Multiple inheritance in Scala with help of traits like interfaces in Java
  // 3. Traits = behavior ; Abstract class = type of thing. For eg: Animals can be abstract classes but traits describe the behavior for example Carnivore.
  // This helps us to determine when to use abstract classes and traits

  /*
  SCALA TYPE HIERARCHY  (bottom classes extend upper class for example scala.null extends scala.AnyRef

              SCALA.Any  (scala.AnyRef)  => Similar to Java.Object can reference to any for example String, Set
               /       \
              /         \
       scala.null       scala.AnyVal => For (Int, Unit, Float, Boolean)
(for null objects)               /
basically the extend            /
anything    \                  /
             \                /
              \               /
                scala.Nothing   (Nothing is a subtype of anything in Scala) No instance of anything no NULL no nothing.

   */







}
