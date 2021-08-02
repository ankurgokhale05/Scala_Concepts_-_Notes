package Exercises

abstract class MyList {
  /*
  Implementing own collection

  List is a Singly Linkedlist which holds integers
  head => First element of list
  tail => Remainder of List
  isEmpty => Boolean Is this List empty
  add(int) => new list with this element added
  toString => a string representation of List
   */


  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + ']'

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException// ??? Returns Nothing class in Scala ??? represented
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}


class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h  // ??? Returns Nothing class in Scala ??? represented
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element,this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  val list2  = new Cons(1, new Cons(2, new Cons(3,Empty)))

  println(list2.tail.head) // This will print 2 as list2.tail is new Cons Object with 2 as head

  println(list2.isEmpty)

  println(list.head)

  println(list.add(2).head)

  println(list2.toString)


}

