package FunctionalProgramming

object MapFlatMapFilter extends App {

  val list = List(1,2,3)

  println(list)

  println(list.head)

  println(list.tail)


  // Usage of Map
  println(list.map(_ + 1)) // adds 1 to each element

  println(list.map(_ + "is a number"))

   // filter
  println(list.filter(_ % 2 == 0)) // prints even elements


  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair)) // concatenation of pairs (1,2,2,3,3,4)

  // Exercise
  // 1. Print all combination between 2 list

  // Output: a1, a2,a3,a4

  val numbers = List(1,2,3,4,5)

  val chars = List('a','b', 'c','d')


   // val cross = chars.flatMap(n => numbers.map(c => c + "" + n))    -- This will give 1a, 2a, 3a, ...

  // println(cross)

  val combination = numbers.flatMap(n => chars.map(c => "" + c + n))
 // traverse the outer loop (for example i loop) by using a flatMap since we want to return a list and inner loop (j loop) will be the map one where we iterate over each chars and do the mapping with respective numbers
  println(combination)

  // For example if there was color field as well and we want to print all possible combinations of numbers chars and color then we will do something like this

  val colors = List("black", "white")

// Key Point:  for outer loop use flatMap for list  and for inner loop use map for list

  // Iterations
  val combination2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))

  println(combination2)



  // foreach

  list.foreach(println) // This prints all elements of list on new line


  // For Comprehensions

  // Line 52 becomes difficult to read when we have multiple iterations and for someone with no background in functional programming

  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations) // same as line 52 but more readable


  val forCombinationsWithEvenNumber = for {
    n <- numbers if(n % 2 == 0)
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color


  // Equivalent expression
  val combination2WithEvenNumbers = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))


  println(forCombinationsWithEvenNumber)
  println(combination2WithEvenNumbers)







}
