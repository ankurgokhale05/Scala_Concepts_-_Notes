package Lecures.Part2OOP

object Generics extends App{
  /*class MyList[A]{ // [A] denotes a generic type

  }
   */
  /*
  // This Line 9 to Line 11 throws an error because of the HARD Question (Line 57) that we mention in the COVARIANCE LIST
  class MyList[+A]{
    def add(element: A): MyList[A] = ???
  }
   */
  // How to solve this issue.
  class MyList[+A]{
    def add[B >: A](element: B):MyList[B] = ???
    /*
    What Line 16 does is we are adding an element of Type B which is a superclass of Type A
    Then the add method will return a List of Type[B] since it is a Generic Class
    For example
    A: Cat
    B: Animal. We are trying to add Animal to a List of Cat. This will return a list of Animal (more generic)
     */

  }




  class MyMap[Key, Value] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic objects

  object MyList { // you cannot set generic type in object
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int] // Generic.MyList[Int]



  // Variance Problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Does List of Cat extends List of Animal => Answer is YES this is called as COVARIANCE
  // List[Cat] extends List[Animal]
  class CovariantList[+A]
  val animal: Animal = new Cat()
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(Dog) ??? HARD Question
  // Above what we are trying to do is add Dog element to a List of Cat. This will pollute the specific
  // nature of List and make the list more Generic





  // 2. NO => INVARIANCE
  // Each Type is in its own World
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]


  // 3 Hell No => Counterintuitive => CONTRAVARIANCE
  // This seems Counterintuitive at First as How a return type which is a List of Cat can take object
  // of list of Animal
  // But Lets change the method naming convention in order to understand better
  /*
  class ContraVarianceList[-A]
  val contraVarianceList: ContraVarianceList[Cat] = new ContraVarianceList[Animal]
  */

  // The trainer expression which is used to train Cat (Specific animal) returns Trainer[Cat]
  // which can be trained by Trainer[Animal] (More Generic Object)
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // Bounded Types : These are used to check what type of Object Parameters are
  // accepted

  class Cage[A <: Animal](animal: A) // This means that class Cage accepts
  // objects of Generic Type A which are subclasses of Animal (<:) notation

  val dog_animal = new Cage(new Dog) // This is correct as Dog class extends Animal

  // val car_animal = new Cage(new Car) // This will not be accepted as Car does not extend Animal


  // (>:) notation can also be used to accept object that Superclass of Particular Class






}
