package FunctionalProgramming


/*
1. Generic Trait MyPredicate[-T] with a little method test(T) => Boolean
2. Generic Trait MyTransformer[-A,B] with a method transform(A) => B
3. MyList:
    -map(transformer): MyList
    -filter(predicate): MyList
    -flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]


    [1,2,3].map(n*2) = [2,4,6]
    [1,2,3,4].filter(n%2) = [2,4]
    [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]



 */


import javax.sql.rowset.Predicate


abstract class MyListGenericwithAnonFunctions[+A] {
  /*
  Implementing own collection

  List is a Singly Linkedlist which holds integers
  head => First element of list
  tail => Remainder of List
  isEmpty => Boolean Is this List empty
  add(int) => new list with this element added
  toString => a string representation of List
   */


  def head: A
  def tail: MyListGenericwithAnonFunctions[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenericwithAnonFunctions[B]
  def printElements: String

  // Higher Order Functions
  def map[B](myTransformer: A => B) : MyListGenericwithAnonFunctions[B]
  def flatMap[B](myTransformer: A => MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B]
  def filter(predicate: A => Boolean): MyListGenericwithAnonFunctions[A]

  // Concatenation function
  def ++[B >: A](list: MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B]
  override def toString: String = "[" + printElements + ']'

}

case object EmptyListwithAnonFunctions extends MyListGenericwithAnonFunctions[Nothing]{
  def head: Nothing = throw new NoSuchElementException// ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGenericwithAnonFunctions[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenericwithAnonFunctions[B] = new ConstructorwithAnonFunctions(element, EmptyListwithAnonFunctions)
  def printElements: String = ""
  def map[B](transformer: Nothing => B) : MyListGenericwithAnonFunctions[B] = EmptyListwithAnonFunctions
  def flatMap[B](transformer: Nothing => MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B] = EmptyListwithAnonFunctions
  def filter(predicate: Nothing => Boolean): MyListGenericwithAnonFunctions[Nothing] = EmptyListwithAnonFunctions
  def ++[B >: Nothing](list: MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B] = list
}


case class ConstructorwithAnonFunctions[+A](h: A, t: MyListGenericwithAnonFunctions[A]) extends MyListGenericwithAnonFunctions[A] {
  def head: A = h  // ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGenericwithAnonFunctions[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenericwithAnonFunctions[B] = new ConstructorwithAnonFunctions(element,this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  /*
  How does .filter works
  [1,2,3].filter(n%2)
    = [2,3].filter(n%2)   // since 1 % 2 != 0
    = new ConstructorwithAnonClasses(2, [3].filter(n%2 == 0))
    = new ConstructorwithAnonClasses(2, EmptyListwithAnonClasses.filter(n%2 == 0))
    = new ConstructorwithAnonClasses(2, EmptyListwithAnonClasses)

   */
  def filter(predicate: A => Boolean): MyListGenericwithAnonFunctions[A] =
    if (predicate(h)) new ConstructorwithAnonFunctions(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  How does .map works
  [1,2,3].map(n*2)
    = new ConstructorwithAnonClasses(2, [2,3].map(n*2))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, [3].map(n*2)))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(6, EmptyListwithAnonClasses.map(n*2))))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(6, EmptyListwithAnonClasses)))

   */
  def map[B](tranformer: A => B) : MyListGenericwithAnonFunctions[B] =
    new ConstructorwithAnonFunctions(tranformer(h), t.map(tranformer))



  /*
  How does ++ method work

  [1,2]  ++ [3,4,5]
  = new ConstructorwithAnonClasses(1, [2] ++ [3,4,5])
  = new ConstructorwithAnonClassses(1, new ConstructorwithAnonClasses(2, EmptyListwithAnonClasses++ [3,4,5]))
  = new ConstructorwithAnonClasses(1, new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(3, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(5)))))


   */
  def ++[B >: A](list: MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B] = new ConstructorwithAnonFunctions(h, t ++ list)


  /*
  How does flatMap works

  [1,2].flatMap(n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyListwithAnonClasses.flatMap(n=> [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyListwithAnonClasses
  = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyListGenericwithAnonFunctions[B]): MyListGenericwithAnonFunctions[B] ={
    transformer(h) ++ t.flatMap(transformer)
  }

}

/*
trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}


 */

object CheckListTestwithAnonFunctions extends App {
  val listOfInt: MyListGenericwithAnonFunctions[Int] = new ConstructorwithAnonFunctions(1, new ConstructorwithAnonFunctions(2, new ConstructorwithAnonFunctions(3, EmptyListwithAnonFunctions)))
  val clonelistOfInt: MyListGenericwithAnonFunctions[Int] = new ConstructorwithAnonFunctions(1, new ConstructorwithAnonFunctions(2, new ConstructorwithAnonFunctions(3, EmptyListwithAnonFunctions)))
  val anotherListOfInt: MyListGenericwithAnonFunctions[Int] = new ConstructorwithAnonFunctions[Int](4, new ConstructorwithAnonFunctions(5, EmptyListwithAnonFunctions))

  val listOfString: MyListGenericwithAnonFunctions[String] = new ConstructorwithAnonFunctions("Hello", new ConstructorwithAnonFunctions("Scala", EmptyListwithAnonFunctions))

  println(listOfString.toString)
  println(listOfInt.toString)

  /*
  println(listOfInt.map(new ((Int) => Int){
    override def apply(elem: Int): Int = elem * 2
  }).toString)


  */
  println(listOfInt.map(elem => elem * 2).toString) // Equivalent to above way of writing .map function but more functional

  // Same as above but with '_' notation

  println(listOfInt.map(_ * 2).toString)


  /*
  println(listOfInt.filter(new ((Int) => Boolean) {
    override def apply(elem: Int): Boolean =
      if(elem % 2 == 0) true
      else false
  }).toString)

   */

  println(listOfInt.filter(elem => elem % 2 == 0).toString) // Equivalent way of writing .filter function but more functional

  // Same as above but with '_' notation
  println(listOfInt.filter(_ % 2 == 0).toString)



  println((listOfInt ++ anotherListOfInt).toString)

  /*
  println(listOfInt.flatMap(new ((Int) => MyListGenericwithAnonFunctions[Int]){
    override def apply(elem: Int): MyListGenericwithAnonFunctions[Int] = new ConstructorwithAnonFunctions(elem, new ConstructorwithAnonFunctions(elem + 1, EmptyListwithAnonFunctions))
  }).toString)

   */

  // We cannot use '_' notation for this as '_' cannot be used for multiple times
  println(listOfInt.flatMap(elem => new ConstructorwithAnonFunctions(elem, new ConstructorwithAnonFunctions(elem + 1, EmptyListwithAnonFunctions))).toString)

  println(clonelistOfInt == listOfInt) // This will return true as we have set case keyword before EmptyListwithAnonClasses and ConstructorwithAnonClasses. See CaseClasses.scala for more info
  // This is because i have implemented equals and hashcode out of the box and list can be added to collections class
  // Otherwise I had to write recursive functions for comparing each and every element in list






}




