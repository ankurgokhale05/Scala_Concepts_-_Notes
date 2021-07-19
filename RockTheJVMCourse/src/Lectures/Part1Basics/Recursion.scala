package Lectures.Part1Basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {


  def factorialFunction(n: Int): Int = {
    if(n<=1) 1
    else {
      println("Computing factorial of - " + n + " - I first need factorial of " + (n-1))
      val result = n * factorialFunction(n-1)
      println("Computed factorial of " + n)
      result
    }

  }
   // println(factorialFunction(10)) // WORKS
   // println(factorialFunction(5000)) // STACKOVERFLOW ERROR

  def anotherFactorialFunction(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x < 1) accumulator
      else factHelper(x-1, x * accumulator)

    factHelper(n,1)
  }


  /*
  anotherFactorialFunction(10) = factHelper(10,1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ....

  = factHelper(1, 2 * 3 * 4 * 5 .. * 10 * 1)
  = 1*2*3*4*5*6*7*8*9*10
   */

  //println(anotherFactorialFunction(5000))  => Returns 0
  println(anotherFactorialFunction(5000))


  /*
  This anotherFactorialFunction works with Big Numbers why?
  Because For Each Recursive Call the 1st Factorial Function Used 1 Stack Frame

  But in anotherFactorialFunction() Each Recursive Call used the same Stack Frame. So it didn't store
  any intermediate results in separate stack frame but it updated the current stack frame with intermediary
  result

  This is called as TAIL RECURSION

   */

  // WHEN YOU NEED LOOPS : USE TAIL RECURSION




  /*
  Exercises
   */

  // 1) Concatenate a string N times Using TAIL RECURSION
  @tailrec
  def concatenateFunctions(aString: String, n: Int, accumulator:String):String = {
      if(n<=0) accumulator
      else concatenateFunctions(aString, n-1, aString + accumulator)
  }
 println(concatenateFunctions("Hello", 3, ""))


  // 2) Check Prime Number
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(x: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if(x <= 1) true
      else isPrimeUntil(x-1, n % x != 0 && isStillPrime)
    }
    isPrimeUntil(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(17*37))



  // 3) Fibonacci Number

  def isFibonacci(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, previous_to_last: Int): Int = {
      if(i >= n) last
      else fiboTailRec(i+1, last + previous_to_last, last)
    }
    if(n<=2) 1
    else fiboTailRec(2,1,1)
  }

  println(isFibonacci(8))














}
