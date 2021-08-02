package Exercises

abstract class MyListGeneric[+A] {
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
  def tail: MyListGeneric[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGeneric[B]
  def printElements: String
  override def toString: String = "[" + printElements + ']'

}

object EmptyList extends MyListGeneric[Nothing]{
  def head: Nothing = throw new NoSuchElementException// ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = new Constructor(element, EmptyList)
  def printElements: String = ""
}


class Constructor[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A = h  // ??? Returns Nothing class in Scala ??? represented
  def tail: MyListGeneric[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGeneric[B] = new Constructor(element,this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object CheckListTest extends App {
  val listOfInt: MyListGeneric[Int] = new Constructor(1, new Constructor(2, new Constructor(3, EmptyList)))

  val listOfString: MyListGeneric[String] = new Constructor("Hello", new Constructor("Scala", EmptyList))

  println(listOfString.toString)
  println(listOfInt.toString)
}


