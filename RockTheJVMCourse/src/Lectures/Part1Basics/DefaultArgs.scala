package Lectures.Part1Basics

import scala.jdk.Accumulator

object DefaultArgs extends App{

  def factorial(n:Int, accumulator: Int = 1): Int = {
    if(n<=1) accumulator
    else factorial(n-1, n * accumulator)
  }

  println(factorial(10))


  // Updating the default arguments during runtime. The original default arguments get overriden
  val fact_10 = {
    println(factorial(10,2))
  }

  def savingPicture(format: String = "jpg", height: Int = 400, width: Int = 800): Unit = {
    println("Saving Picture")
  }



   // savingPicture(800, 400) This throws an error as compiler is confused on what arguments to map to as we
  // cannot omit leading arguments

   // 2 ways to deal with this.
   /*
    1) Pass in every Leading argument
    2) Specify the argument with its name
   */

  savingPicture("bmp")  // This will work
  savingPicture(height = 600, width = 400, format =  "bmp") // This will work







}
