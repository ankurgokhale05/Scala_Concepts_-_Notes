package FunctionalProgramming

object AnonymousFunctions extends App {
  /*
  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

   */

  // Anonymous Functions called as LAMBDA
  // val doubler = (x: Int) => x * 2
  // -- can be written as


  // val doubler: Int => Int = x => x * 2

  // What if we have multiple parameters in a LAMBDA

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b


  // No parameters in a LAMBDA

  val noparams: () => Int = () => 3


  println(noparams)  // This returns an instance of a class
  println(noparams())  // This returns 3 which returns value of function. When calling lambda function use brackets


  // Curly braces with syntactic sugar

  val stringtoInt = { (s: String) =>
    s.toInt
  }

  // MOAR SYNTACTIC SUGAR
  /*
  val nice_incrementer: Int => Int = x => x + 1
  println(nice_incrementer(3))

   */
  // Equivalent way to write the above statement is

  val nice_incrementer: Int => Int = _ + 1  // '_' represents x => x + 1 since _ can represent any value passed

  println(nice_incrementer(8))
  // NOTE: Clear distinction needs to be made regarding the type that '_' represents

  val nice_adder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  println(nice_adder(5,6))


  /*
  Exercises
  1. Replace MyList FunctionX calls with anonymous functions
  2. Replace special adder function (the curried one) with anonymous functions
   */

  // Solution to 1 is MyListWithAnonFunctions

  // Solution to 2 is

  /*
  val superAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

   */
  val superAdder = (x: Int) => (y: Int) => x + y

  println(superAdder(3)(4))




  /*
  KEY TAKEAWAYS

  Instead of passing Anonymous Functions X instances every time
   - cumbersome
   - still object oriented

   (x, y) => x + y  // LAMBDA

   (name: String, age: Int) =>  name + "and I am" + age + "years old"


   return types are always inferred
   () parameter brackets are mandatory for multiple parameters
   return types are optional

  More SYNTACTIC SUGAR
  Use  '_' notation

   */




}
