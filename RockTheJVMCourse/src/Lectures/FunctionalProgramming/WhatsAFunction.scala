package FunctionalProgramming

object WhatsAFunction extends App {

  // Use functions as First Class elements
  // The major problem is OOD Paradigm used by JVM

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // The main advantage of Scala over JAVA Is that we can use doubler which is an instance of function liked class can be called like a function
  // Scala supports function types out of the box and these function types
  // function types = Function1[A,B] upto Function22  that is SCALA support these function types upto 22 parameters

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(element: String): Int = element.toInt
  }


  val adder = new ((Int, Int) => Int) { // This is syntactic sugar
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  // Other way of writing this
  /*
   val adder = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
   }
   */
  /*
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]
  */

  // Function types Function2[A,B,R]  === (A,B) => R
  // A,B are parameter types and R is Return type
  // ALL SCALA FUNCTIONS ARE OBJECTS


  /*
  Exercises
  1. A function which takes 2 strings and concatenates them
  2. Transform the MyPredicate and MyTransformer into function types
  3. Define a function which takes an Int and returns another function which takes an Int and returns an int
   - what's type of this function
   - How to do it.
 */
  // 1st solution
  val stringConcatenator = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + " " +  v2
  }


   // This is called curried function. Curried function can be called with multiple parameter list. Function can be passed as a parameter
  // This is because 3 is passed as Int and 4 is passed as Function1[Int, Int]
  val superAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  val adder3 = superAdder(3)


  println(doubler(2))
  println(stringToIntConverter("3") + 4)
  println(adder(2,3))
  println(stringConcatenator("Hello", "World"))
  println(adder3(4))


  println(superAdder(3)(4)) // This is called curried function. Curried function can be called with multiple parameter list. Function can be passed as a parameter
  // This is because 3 is passed as Int and 4 is passed as Function1[Int, Int]
}

trait MyFunction[A,B] {
  def apply(element: A): B
}


