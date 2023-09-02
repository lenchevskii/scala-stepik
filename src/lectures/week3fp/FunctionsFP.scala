package lectures.week3fp

trait Multiplication[A, B] {
  def apply(x: A): B
}

val res = new Multiplication[Int, Int] {
  override def apply(x: Int): Int = x * 2
}

def someFunc: Int => Function1[Int, Int] =
  new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

val result = someFunc(1)

object FunctionsFP extends App {
  
  def add(x: Int, y: => Int) = x + y
  
  def multiply(f: () => Int) = f() * 2
  
  def four: Int = 4
  
  def two(): Int = 2

  add(1, (() => 2)())
  // multiply(four) // error
  // add(1, () => 2) // error
  multiply(two _)
  add(1, four)
  multiply(() => 4)
  add(1, 2)
  add(two(), four)
  // multiply(12) // error
  multiply(two)
  // add(1, two _) // error

}
