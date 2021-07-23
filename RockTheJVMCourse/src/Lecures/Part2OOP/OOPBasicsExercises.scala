package Lecures.Part2OOP


/*
// Novel & Writer
Writer: first name, surname, year
  - return full name

Novel: name, year of release, author
-authorAge
-isWrittenBy(author)
- copy(new year of release) = new instance of novel
 */


object OOPBasicsExercises extends App{

  val writer1  = new Writer("Ankur", "Gokhale", 1997)
  val imposter1  = new Writer("Ankur", "Gokhale", 1997)
  writer1.giveName()

  val novel1 = new Novel("Madmen", 2021, writer1)

  println(novel1.authorAge())
  println(novel1.isWrittenBy(writer1))
  println(novel1.isWrittenBy(imposter1)) // this returns False as we have 2 objects with identical data but we have specified author = this.author


  val counter1 = new Counter
  counter1.incrementCount().print
  counter1.incrementCount().incrementCount().incrementCount().print
  counter1.incrementCount(10).print




}

class Writer(val first_name: String, val surname: String, val year_of_birth: Int) {

  def giveName(): Unit = println("The author name is " + first_name + " " +  surname)


}


class Novel(novel_name: String, year_of_release: Int, author: Writer){

  def authorAge(): Int =  year_of_release - author.year_of_birth

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int) = new Novel(novel_name, newYear, author)
}

/*
Counter Class
 - Receives an int value
 - Method current count
 - Method to increment or decrement = new Counter
 - overload inc/dec to receive an amount

 */

class Counter( val num: Int = 0){

  def incrementCount() : Counter = {
    println("Incrementing")
    new Counter(num + 1)
  }

  def decrementCount() : Counter = {
    println("Decrementing")
    new Counter(num - 1)
  }

  def incrementCount(amount: Int): Counter = {
    if(amount<=0) this
    else incrementCount.incrementCount(amount - 1)
  }

  def decrementCount(amount: Int): Counter = {
    if(amount<=0) this
    else decrementCount.decrementCount(amount - 1)
  }

  def print = println(num)

}






