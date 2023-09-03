package lectures.week3fp

object Options extends App {
  println(None.isInstanceOf)
  val someVal = Some(2)
  println(someVal.map(_ * 2))
}
