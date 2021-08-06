package Exercises

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

// Out of Memory Error an array having Dimensions equivalent to Integer.MaxValue


class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division By Zero")

object PocketCalculator extends App{

  //val array = Array.ofDim(Int.MaxValue)

  /*
  def calculateFactorial(n: Int): Int = {
    if(n == 1) 1
    else n * calculateFactorial(n-1)
  }
  println(calculateFactorial(1000000))


   */
  def add(x: Int, y: Int): Int = {
    val result = x + y
    if(x < 0 && y < 0 && result > 0) throw new UnderflowException
    else if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else result
  }

  def subtract(x: Int, y: Int): Int = {
    val result = x - y
    if(x > 0 && y < 0 && result > Int.MaxValue) throw new OverflowException
    else if (x < 0 && y > 0 && result < Int.MinValue) throw new UnderflowException
    else result
  }

  def multiply(x: Int, y: Int): Int = {
    val result = x * y
    if(x > 0 && y > 0 && result < 0) throw new OverflowException
    else if(x < 0 && y < 0 && result < 0) throw new OverflowException
    else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
    else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
    else result
  }

  def divide(x: Int, y: Int): Int = {
    if(y == 0) throw new MathCalculationException
    else x / y
  }

  // println(PocketCalculator.add(Int.MaxValue,10))
  // println(PocketCalculator.divide(100, 0))


}


