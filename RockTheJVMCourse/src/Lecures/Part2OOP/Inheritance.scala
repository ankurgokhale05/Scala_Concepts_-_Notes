package Lecures.Part2OOP

object Inheritance extends  App {


  // Single Class Inheritance. Only inherits one class at a time
  sealed class Animal { // can use sealed class Animal

    val creatureType = "Wild"
    // ACCESS MODIFIERS IN SCALA ARE Private, Protected and No modifier (means Public ie anyone can access)
    def eat = println("Nomnom nom")


  }

  class Cat extends Animal { // Example of inheritance Cat is a subclass and Animal is a superclass.

    def crunch() = {
      eat // here it is accessible since Cat is a subclass of animal
      println("Crunch crunch")
    }
  }

  val cat = new Cat
  // cat.eat  // if eat method is marked as private then the method can be accessed within the scope of that class
  // if method is marked as protected then that method is accessible within the class and the subclasses only

  cat.crunch()

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: Int) extends Person(name) // JVM needs to call constructor of Person before calling constructor of adult
  // that is a JVM rule
  // If we use Auxillary constructor like def this(name: String) then you can define Auxillary constructor as well in extends class


  // Overriding
  class Dog extends Animal {

    override val creatureType: String =  "Domestic" // Override can be used for both val / var and method definitions

    override def eat = { // Cannot be overriden if method is final
      super.eat
      println("Crunch, crunch")
    } // Method overriding
  }

  val dog = new Dog
  dog.eat // This will print out Crunch, crunch as we have overriden the method
  println(dog.creatureType) //  This will print out Domestic as we have overriden val creatureType as well



  // We can override creatureType in the constructor as well

  class DogType(override val creatureType: String) extends Animal {

  }

  val dog2 = new DogType("K9")

  println(dog2.creatureType) // This will print out as K9

  /*
  This is exactly equivalent to

  class DogType2(dogType: String) extends Animal {
    override val creatureType = dogType
  }

  val dog3 = new DogType2("Labrador")
  println(dog3.creatureType)


   */


  // Type Substitution (broadly called as Polymorphism)

  val unknownAnimal: Animal = new Dog()

  unknownAnimal.eat // This will give out Crunch, Crunch and not Nomnom nom as Method call will call the most overriden method implementation

  // For example the methode is Overriden by Dog Class and unknownAnimal is an instance of Dog Class Constructor. The unknownAnimal takes many forms which is polymorphism



  // OVERRIDING => Different implementations in derived classes
  // OVERLOADING => Supplying multiple methods with different method signature with same name in same class



  // SUPER
  // WHENEVER WE WANT TO REFERENCE TO METHOD IN PARENT CLASS


  // Preventing overrides

  // 1) Use keyword final

  // i) final method will prevent subclasses from overriding that method.  For eg: If "eat" method is declared as final then other "eat" methods cannot override it
  // ii) Declare entire classes as final so there can be no inheritance possible. If Animal class is final Dog and Cat Classes cannot extend it (No inheritance)


  // 2) Seal the class: allows extension of classes for this FILE only but prevents extension in other FILES. Used when we want to be exhaustive in type
  // hierarchy











}





