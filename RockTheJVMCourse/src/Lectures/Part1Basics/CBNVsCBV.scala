package Part1Basics

object CBNVsCBV extends App {

  // In callByValue the Nanotime returned is same. This is because Function precomputes the value which is
  // System.nanotime and returns the same value depending on number of calls.
  def callByValue(x: Long): Unit = {
    println("Call by Value " + x) // Call by Value 30576717448752
    println("Call by Value " + x) // Call by Value 30576717448752
  }

  // In callByName the System.nanotime is computed separately for each call and therefore
  // the values are different for each call.
  // => is used for callByName. This is particularly useful for lazy evaluation / lazy streams
  def callByName(x: => Long): Unit = {
    println("Call by Name " + x) // Call by Name 30576816311732
    println("Call by Name " + x) // Call by Name 30576816349094
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())


  def infiniteRecursive(): Int =  1 + infiniteRecursive()
  def printFirst(x: Int, y: => Int) = println(x)


  /*
  printFirst(infiniteRecursive(), 34)

  This results in a StackOverflow Error since infiniteRecursive is return which results in an
  infinite loop.

  However if we do something like

  printFirst(34, infiniteRecursive)
  */
  // This provides us with 34 as the second parameter which is y is called by name
  // infiniteRecursive() which is y is called by name. Hence CallbyName parameters are lazy
  // evaluated which results in them being delayed until they are required.
  printFirst(34, infiniteRecursive)

  /*
  KEY TAKEAWAYS

  1) CALL BY VALUE
   - Value is computed before call
   - Same value used everywhere

  2) CALL BY NAME
  - Expression is passed literally
  - Expression is evaluated at every use within
  - Used '=>' sign
   */




}
