package Part1Basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)


  // WHEN YOU NEED LOOPS, USE RECURSION
  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello ", 4))


  // COMPILER CAN INFER THE RETURN TYPES OF FUNCTIONS AS WELL EXCEPT WHEN IT INVOLVES RECURSION
  // BEST PRACTICE MENTION RETURN TYPES OF FUNCTIONS

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def bigFunction(n: Int): Int = {
    def smallFunction(a: Int, b: Int): Int = a + b

    smallFunction(n, n-1)
  }

  /*
  Exercise
  1) A greeting function (name, age) => Returns "Hi, my name is $name and I am $age years old"
   */

  def greetingFunction(name: String, age: Int): Unit = println("Hi, my name is " + name + " and I am " + age + " years old")

  println(greetingFunction("Ankur", 24))

  /*
  Exercise
  2) Factorial Function
   */

  def calculateFactorial(n: Int): Int = {
    if(n == 1) 1
    else n * calculateFactorial(n-1)
  }
  println(calculateFactorial(6))

  /*
  Exercise
  3) Fibonacci Function
   */

  def fibonacciCalculation(n: Int): Int = {
    if(n<=2) 1
    else fibonacciCalculation(n-1) + fibonacciCalculation(n-2)
  }
  println(fibonacciCalculation(5))


  /*
  Exercise
  4) Testing if a number is Prime or not
  */

  def isPrime(n: Int): Boolean = {
      def isPrimeUntil(t: Int): Boolean =
        if(t <= 1) true
        else n % t != 0 && isPrimeUntil(t-1)
      isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(17*37))
  println(isPrime(2003))















}
