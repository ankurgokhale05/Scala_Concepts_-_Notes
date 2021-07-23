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

}

object Empty extends MyList {
  def head: Int = ???
  def tail: MyList = ???
  def isEmpty: Boolean = ???
  def add(element: Int): MyList = ???
}
