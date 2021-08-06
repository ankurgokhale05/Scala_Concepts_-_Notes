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


abstract class MyListGenericwithAnonClasses[+A] {
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
  def tail: MyListGenericwithAnonClasses[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenericwithAnonClasses[B]
  def printElements: String

  // Higher Order Functions
  def map[B](myTransformer: A => B) : MyListGenericwithAnonClasses[B]
  def flatMap[B](myTransformer: A => MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B]
  def filter(predicate: A => Boolean): MyListGenericwithAnonClasses[A]

  // Concatenation function
  def ++[B >: A](list: MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B]
  override def toString: String = "[" + printElements + ']'

}

case object EmptyListwithAnonClasses extends MyListGenericwithAnonClasses[Nothing]{
  def head: Nothing = throw new NoSuchElementException// ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGenericwithAnonClasses[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenericwithAnonClasses[B] = new ConstructorwithAnonClasses(element, EmptyListwithAnonClasses)
  def printElements: String = ""
  def map[B](transformer: Nothing => B) : MyListGenericwithAnonClasses[B] = EmptyListwithAnonClasses
  def flatMap[B](transformer: Nothing => MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B] = EmptyListwithAnonClasses
  def filter(predicate: Nothing => Boolean): MyListGenericwithAnonClasses[Nothing] = EmptyListwithAnonClasses
  def ++[B >: Nothing](list: MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B] = list
}


case class ConstructorwithAnonClasses[+A](h: A, t: MyListGenericwithAnonClasses[A]) extends MyListGenericwithAnonClasses[A] {
  def head: A = h  // ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGenericwithAnonClasses[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenericwithAnonClasses[B] = new ConstructorwithAnonClasses(element,this)
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
  def filter(predicate: A => Boolean): MyListGenericwithAnonClasses[A] =
    if (predicate(h)) new ConstructorwithAnonClasses(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  How does .map works
  [1,2,3].map(n*2)
    = new ConstructorwithAnonClasses(2, [2,3].map(n*2))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, [3].map(n*2)))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(6, EmptyListwithAnonClasses.map(n*2))))
    = new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(6, EmptyListwithAnonClasses)))

   */
  def map[B](tranformer: A => B) : MyListGenericwithAnonClasses[B] =
    new ConstructorwithAnonClasses(tranformer(h), t.map(tranformer))



  /*
  How does ++ method work

  [1,2]  ++ [3,4,5]
  = new ConstructorwithAnonClasses(1, [2] ++ [3,4,5])
  = new ConstructorwithAnonClassses(1, new ConstructorwithAnonClasses(2, EmptyListwithAnonClasses++ [3,4,5]))
  = new ConstructorwithAnonClasses(1, new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(3, new ConstructorwithAnonClasses(4, new ConstructorwithAnonClasses(5)))))


   */
  def ++[B >: A](list: MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B] = new ConstructorwithAnonClasses(h, t ++ list)


  /*
  How does flatMap works

  [1,2].flatMap(n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyListwithAnonClasses.flatMap(n=> [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyListwithAnonClasses
  = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyListGenericwithAnonClasses[B]): MyListGenericwithAnonClasses[B] ={
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

object CheckListTestwithAnonClasses extends App {
  val listOfInt: MyListGenericwithAnonClasses[Int] = new ConstructorwithAnonClasses(1, new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(3, EmptyListwithAnonClasses)))
  val clonelistOfInt: MyListGenericwithAnonClasses[Int] = new ConstructorwithAnonClasses(1, new ConstructorwithAnonClasses(2, new ConstructorwithAnonClasses(3, EmptyListwithAnonClasses)))
  val anotherListOfInt: MyListGenericwithAnonClasses[Int] = new ConstructorwithAnonClasses[Int](4, new ConstructorwithAnonClasses(5, EmptyListwithAnonClasses))

  val listOfString: MyListGenericwithAnonClasses[String] = new ConstructorwithAnonClasses("Hello", new ConstructorwithAnonClasses("Scala", EmptyListwithAnonClasses))

  println(listOfString.toString)
  println(listOfInt.toString)

  println(listOfInt.map(new Function1[Int, Int]{
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInt.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean =
      if(elem % 2 == 0) true
      else false
  }).toString)

  println((listOfInt ++ anotherListOfInt).toString)

  println(listOfInt.flatMap(new Function1[Int, MyListGenericwithAnonClasses[Int]]{
    override def apply(elem: Int): MyListGenericwithAnonClasses[Int] = new ConstructorwithAnonClasses(elem, new ConstructorwithAnonClasses(elem + 1, EmptyListwithAnonClasses))
  }).toString)


  println(clonelistOfInt == listOfInt) // This will return true as we have set case keyword before EmptyListwithAnonClasses and ConstructorwithAnonClasses. See CaseClasses.scala for more info
  // This is because i have implemented equals and hashcode out of the box and list can be added to collections class
  // Otherwise I had to write recursive functions for comparing each and every element in list






}




