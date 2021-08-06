package Lecures.Part2OOP

object Exceptions extends App{

  val x: String = null
  // println(x.length)
  // This ^^ will throw a NullPointerException

  // Throwing and Catching Exceptions

  // 1. Throwing Exceptions
  // val a_weird_value: String = throw new NullPointerException

  // throwable classes extend the Throwable class


  // Exception and Error are the major throwable subtypes
  // Exception means Something wrong happened with the program => Eg: NullPointerException
  // Error means Something happened wrong with the system  => Eg: Stackoverflow Error


  // 2. Catching exceptions
  def getInt(withExceptions: Boolean): Int = {
     if(withExceptions) throw new RuntimeException("No int for you")
     else 42
  }

  val potentialFail = try {
    // Code that might throw
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("Caught a Runtime Exception")
  }
  finally {
    // This will be executed NO MATTER WHAT
    // Finally is optional
    // Finally doesn't affect the return type of the expression
    // Use Finally only for side effects
    println("Finally")
  }

  println(potentialFail) // This returns unit because it has a type of Any Val


  // 3. Creating our own Exception
  class MyException extends Exception
  val exception = new Exception
  throw exception

  /*
  Exercises
  1. Crash your program with OutOfMemory Error
  2. Crash with StackOverFlow Error
  3. Create a Pocket Calculator
      - add(x,y)
      - multiply(x,y)
      - divide(x,y)
      - subtract(x,y)

      Throw Custom Exception
       -Overflow Exception if add(x,y) exceeds Int.Max_value
       -Underflow Exception if subtract(x,y) exceeds Int.MIN_VALUE
       -MathCalculationException for division by 0


   */
}
