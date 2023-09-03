package lectures.week3fp

import scala.util.Success

object ExceptionsFP extends App {
  val someVal = Success(3)

  println(someVal.filter(_ > 5))
}
