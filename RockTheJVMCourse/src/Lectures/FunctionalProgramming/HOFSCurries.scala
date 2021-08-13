package FunctionalProgramming

object HOFSCurries extends App {

  val superFunction: (Int , (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // Higher Order Function (HOF) => A function which takes either function as a parameter or returns function as a result
  // HOF examples include: map, flatMap, filter in myList



  // A function that applies function n times over a given value x

  // nTimes(f, n, x)
  // nTimes(f,3,x) => f(f(f(x)))



  // nTimes(f,3,x) => f(f(f(x))) => nTimes(f, 2, f(x)) => f(f(f(x)))

  // In a more generalized manner

  // nTimes(f,n,x) => f(f(f(....f(x)))))  => nTimes(f, n-1, f(x))
  def nTimes(f:(Int => Int), n: Int, x: Int):Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }
  val plusOne = (x : Int) => x + 1

  println(nTimes(plusOne, 10, 1))


  /*
  There is another way to write this

  nTimesBetter(f, n)   : This is a function which will take function as an argument and n which is number of times to apply that function but instead of passing x which is value on which function is to be applied
  we can simply return a lambda which takes (x: Int) => Int for reusability purpose


  nTimesBetter(f,n) = x => f(f(f...f(x)))
  increment10 = nTimesBetter(plusOne, 10) = x =>  plusOne(plusOne(plusOne(x))))  -> This will apply plusOne function 10 times to x
  val y = increment10(1)
   */

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  // CURRIED FUNCTIONS
  /*

  SuperAdder Functions
   */

  val superAdder: Int => Int => Int = (x: Int) => (y:Int) => x + y

  val addThree = superAdder(3)  // Equivalent to  y => 3 + y
  println(addThree(10))
  println(superAdder(3)(10))

  // FUNCTIONS WITH MULTIPLE PARAMETER LISTS

  def curriedFormatter(c: String)(x: Double): String = c.format(x) // We can pass in multiple parameter lists c: String => 1 parameter list and x: Double => 2 parameter list
  val standardFormatter:(Double => String) = curriedFormatter("%4.2f") // One caveat is the type for example Double => String should be specified for smaller functions
  val preciseFormatter:(Double => String) = curriedFormatter("%10.8f")



  println(standardFormatter(Math.PI))  // VALUE OF PI upto 2 decimal places
  println(preciseFormatter(Math.PI)) // Value of PI upto 8 decimal places




  /*
  Exercises

  1. Expand MyList
    - foreach method A => Unit
     [1,2,3].foreach(x => println(x))

    - sort function ((A,A) => Int) => MyList
    [1,2,3].sort((x,y) => y - x)   => [3,2,1]

    - zipWith(list, (A,A) => B) => MyList[B]
     [1,2,3].zipWith([4,5,6], x*y) => [1*4, 2*5, 3*6] => [4,10,18]

    - fold(start)(function) => a value
      [1,2,3].fold(0)(x+y) = 6     Basically it start at index 0 take its value and apply function which is adding the next value to current value and ultimately returning the last value

  2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
     fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int


  3. compose(f,g) => x => f(g(x))
     andThen(f,g) => x => g(f(x))

   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y => f(x, y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x,y) => f(x)(y)
  }
  // Compose

  // Function X
  def compose(f: Int => Int, g: Int => Int): Int => Int = {
    x => f(g(x))
  }

  def andThen(f: Int => Int, g: Int => Int): Int => Int = {
    x => g(f(x))
  }


  // Compose & andThen using Generics

  def composeGeneric[A,B,T](f:A => B , g: T => A ): T => B = {
    x => f(g(x))
  }

  def andThenGeneric[A,B,C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }


  // Testing out functions

  // toCurry
  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  val add4 = superAdder2(4)

  println(add4(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(7,11))

  val add2 = (x: Int) => x + 2
  val multiply3 = (x: Int) => x * 3


  val composed = compose(add2, multiply3)

  val ordered = andThen(add2, multiply3)

  println(composed(4)) // compose(add2,multiply3) = f= add2, g = multiply3 => f(g(x)) => add2(4*3) => 4*3+2 = 14
  println(ordered(4)) // andThen(add2, multiply3) = f = add2, g = multiply3 => g(f(x)) => multiply3(4 + 2) => 3*6 = 18








}
