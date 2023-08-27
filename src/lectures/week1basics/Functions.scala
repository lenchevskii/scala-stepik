package lectures.week1basics

def aPerson(name: String, surname: String): String =
  s"$name $surname"

def callByValue(x: Long): Unit = {
  println(s"call by value: x1 = $x")
  println(s"call by value: x2 = $x")
}

def callByName(x: => Long): Unit = {
  println(s"call by name: x1 = $x")
  println(s"call by name: x2 = $x")
}

def someFunc(x: => Int, y: => Int): Int = x * 2

object Functions extends App {
  // callByValue(System.nanoTime())
  // callByName(System.nanoTime())

  println(someFunc(3, 4))
}
