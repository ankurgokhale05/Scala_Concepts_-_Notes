package Lecures.Part2OOP

import Playground.{PrinceCharming, Test => Princess} // Grouping for multiple imports

// For importing all classes within Playground Package you can use "_"
// import Playground._    => Use _ if you actually need
// Use above or on line 10


import java.util.Date
import java.sql.{Date => SQLDate}

object Packages extends App{

  val writer = new Writer("Daniel", "RockTheJVM", 2017)

  // val test = new Test // Need to be in same Package or import the class From Package
  // val test = new Playground.Test

  val princess = new Princess
  // Packages are in Hierarchy
  // Matching Folder Structure

  // Specific to Scala

  // Package Object

  // These methods and variables could be called because of Package Objects
  sayHello
  println(SPEED_OF_LIGHT)


  // Imports

  val PrinceCharming = new PrinceCharming


  // If we want to use both util.Date and sql.Date in same file then we have 2 options
  // 1. Use FQ Names
  val date = new Date
  val sqlDate = new SQLDate(2018, 5, 4)
  // 2. Use Aliasing


  // Default Imports
  // Packages that are automatically imported

  // For eg: java.lang => Object, String, Exception
  // In scala => Int, Nothing, Function
  // scala.Predef => println, ???

}
